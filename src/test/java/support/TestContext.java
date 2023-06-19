// Created by Viacheslav (Slava) Skryabin 04/01/2011
package support;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestContext {

    private static WebDriver driver;

    private static Map<String, Object> testData = new HashMap<>();

    public static void setTestData(String key, Object value) {
        testData.put(key, value);
    }

    public static String getStringTestData(String key) {
        return (String) testData.get(key);
    }

    public static Integer getIntegerTestData(String key) {
        return (Integer) testData.get(key);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void initialize() {
        initialize(getConfig().getString("browser"), getConfig().getBoolean("isHeadless"));
    }
    public static void teardown() {
        driver.quit();
    }

    public static YamlMap getConfig() {
        FileInputStream stream = null;
        try {
            stream = new FileInputStream(getFile("config", "yml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new YamlMap(new Yaml().load(stream));
    }

    public static File getFile(String fileName, String extension) {
        String path = System.getProperty("user.dir") + "/src/test/resources/data/" + fileName + "." + extension;
        return new File(path);
    }

    public static void initialize(String browser, boolean isHeadless) {
        Dimension size = new Dimension(1920, 1080);
        Point position = new Point(0, 0);
        if (getConfig().getString("infrastructure").equals("grid")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(browser);
            capabilities.setPlatform(Platform.ANY);
            try {
                URL hubUrl = new URL("http://localhost:4444/wd/hub");
                driver = new RemoteWebDriver(hubUrl, capabilities);
                ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
            } catch (MalformedURLException e) {
                throw new RuntimeException(e.getMessage());
            }
        } else if (getConfig().getString("infrastructure").equals(("selenoid"))) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(browser);
            capabilities.setPlatform(Platform.LINUX);
            capabilities.setVersion(getConfig().getDouble("browserVersion").toString());
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            capabilities.setCapability("sessionTimeout", "5m");
            capabilities.setCapability("idleTimeout", "300");
            capabilities.setCapability("videoScreenSize", "1920x1080");
            capabilities.setCapability("screenResolution", "1920x1080");

            String testName = getConfig().getString("env") + " " + getStringTestData("scenarioTag") + " \"" + getStringTestData("scenarioName") + "\"";
            capabilities.setCapability("name", testName);
            String videoName = String.join("", testName.replaceAll("[^A-Za-z0-9]", "_"), "_", String.valueOf(new Date().getTime()), ".mp4");
            setTestData("videoName", videoName);
            capabilities.setCapability("videoName", videoName);
            URL hubUrl = null;
            try {
                hubUrl = new URL("http://" + getConfig().getString("hubUrl") + ":4444/wd/hub");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            driver = new RemoteWebDriver(hubUrl, capabilities);
        } else {
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    Map<String, Object> chromePreferences = new HashMap<>();
                    chromePreferences.put("profile.default_content_settings.geolocation", 2);
                    chromePreferences.put("profile.default_content_settings.popups", 0);
                    chromePreferences.put("download.prompt_for_download", false);
                    chromePreferences.put("download.directory_upgrade", true);
                    chromePreferences.put("download.default_directory", System.getProperty("user.dir") + "/src/test/resources/downloads");
                    chromePreferences.put("safebrowsing.enabled", false);
                    chromePreferences.put("plugins.always_open_pdf_externally", true);
                    chromePreferences.put("plugins.plugins_disabled", new ArrayList<String>(){{ add("Chrome PDF Viewer"); }});
                    chromePreferences.put("credentials_enable_service", false);
                    chromePreferences.put("password_manager_enabled", false);
                    // for EMEA only - disable cookies
//                    chromePreferences.put("profile.default_content_setting_values.cookies", 2);
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    chromeOptions.addArguments("--remote-allow-origins=*");
                    chromeOptions.setExperimentalOption("prefs", chromePreferences);
                    System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
                    if (isHeadless) {
                        chromeOptions.setHeadless(true);
                        chromeOptions.addArguments("--window-size=" + size.getWidth() + "," + size.getWidth());
                        chromeOptions.addArguments("--disable-gpu");
                    }
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    if (isHeadless) {
                        FirefoxBinary firefoxBinary = new FirefoxBinary();
                        firefoxBinary.addCommandLineOptions("--headless");
                        firefoxOptions.setBinary(firefoxBinary);
                    }
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                case "safari":
                    driver = new SafariDriver();
                    driver.manage().window().setPosition(position);
                    driver.manage().window().setSize(size);
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                default:
                    throw new RuntimeException("Driver is not implemented for: " + browser);
            }
        }
    }

    public static void setScenarioData(Scenario scenario) {
        TestContext.setTestData("scenarioName", scenario.getName());
        for (String tag : scenario.getSourceTagNames()) {
            Matcher matcher = Pattern.compile("@[\\w_]+\\d+").matcher(tag);
            if (matcher.find()) {
                TestContext.setTestData("scenarioTag", matcher.group(0));
                break;
            }
        }
    }
}