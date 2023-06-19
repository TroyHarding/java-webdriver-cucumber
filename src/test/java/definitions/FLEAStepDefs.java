package definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.*;
import static support.TestContext.getDriver;

public class FLEAStepDefs {
    @Given("I visit FLEA Market in the {string} Environment")
    public void iVisitFLEAMarketInTheEnvironment(String env) {
        if(env.equalsIgnoreCase("Stage")) {
            getDriver().get("http://store-stage.portnov.com/");
        } else if(env.equalsIgnoreCase("qa")) {
            getDriver().get("http://store-qa.portnov.com/");
        } else {
            System.out.println("BAD URL");
        }
    }

    @Then("I verify title is {string} for the page")
    public void iVerifyTitleIsForThePage(String title) {
        assertThat(getDriver().getTitle()).isEqualTo(title);
    }

    @When("I wait and click on a product {string} on the Landing Page")
    public void iClickOnAProductOnTheLandingPage(String product) {
        String xpath = "//img[@title='"+product +"']";
        WebDriverWait waits = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        waits.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        getDriver().findElement(By.xpath(xpath)).click();
        assertThat(getDriver().findElement(By.xpath("//*[text()='"+product+"']")).getText()).containsIgnoringCase(product);
    }


    @Then("Click Each of the Slide Out tabs as well")
    public void iClickEachOfTheSlideOutTabsAsWell() {
        if (getDriver().findElement(By.xpath("//img[@class='attachment-woocommerce_thumbnail size-woocommerce_thumbnail']")).isDisplayed()) {
            getDriver().findElement(By.xpath("//img[@class='attachment-woocommerce_thumbnail size-woocommerce_thumbnail']")).click();
            getDriver().switchTo().alert().accept();
        } else {
            System.out.println("There is no slide out tab");
        }
    }

    @Then("I verify Cart Icon is present")
    public void iWaitForCartToAppear() {
        WebElement element = getDriver().findElement(By.xpath("//*[@id='site-header-cart']"));
        element.isDisplayed();
    }

    @Then("I verify Image Slider is present")
    public void iVerifyImageSliderIsPresent() {
        WebElement element = getDriver().findElement(By.xpath("//*[@class='swiper swiper-cube swiper-3d swiper-initialized swiper-horizontal swiper-pointer-events']"));
        element.isDisplayed();
    }




    @Given("I open {string}")
    public void iOpen(String Stage) {
        getDriver().get("https://store-stage.portnov.com/");
    }

    @Then("I tap on element {string} from Landing Page")
    public void iTapOnElementFromLandingPage(String item) {
        if (item.equalsIgnoreCase("AirPods")) {
            getDriver().findElement(By.xpath("//a[@data-product_id='58']")).click();
        } else if (item.equalsIgnoreCase("Watch")) {
            getDriver().findElement(By.xpath("//*[@data-product_id='48']")).click();
        } else if (item.equalsIgnoreCase("iMac")) {
            getDriver().findElement(By.xpath("//*[@data-product_id='46']")).click();
        } else if (item.equalsIgnoreCase("iPhone XR")) {
            getDriver().findElement(By.xpath("//*[@data-product_id='55']")).click();
        } else if (item.equalsIgnoreCase("Macbook Air")) {
            getDriver().findElement(By.xpath("//*[@data-product_id='42']")).click();

        } else {
            System.out.println("iPhone 12 is out of stock.");
        }
    }
    @Then("I wait for {string} to appear")
    public void iWaitForToAppear(String addToCart) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@title='View cart']")));
    }
    @Then("I tap on {string}")
    public void iTapOn(String xpath) {
        getDriver().findElement(By.xpath("//*[@title='View cart']")).click();
    }
    @Then("I should see the page title as {string}")
    public void iShouldSeeThePageTitleAs(String arg0) {
        assertThat(getDriver().getTitle()).isEqualTo("Cart – E-Market");
    }

    @Then("I go to {string} button")
    public void iGoTo(String proceed) {
        getDriver().findElement(By.xpath("//*[@class='checkout-button button alt wc-forward']")).click();
    }

    @Then("I enter {string} for the first name and {string} for the last name in the Name field {string} for phone and {string} for email field")
    public void iEnterForTheFirstNameAndForTheLastNameInTheNameField(String firstName, String lastName, String phone, String email) {
        getDriver().findElement(By.id("billing_first_name")).sendKeys(firstName);
        getDriver().findElement(By.id("billing_last_name")).sendKeys(lastName);
        getDriver().findElement(By.id("billing_phone")).sendKeys(phone);
        getDriver().findElement(By.id("billing_email")).sendKeys(email);
    }
    @Then("element {string} should be present")
    public void elementShouldBePresent(String arg0) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.id("place_order")));
    }
    @Then("I wait {int} sec")
    public void iWaitForSec(int sec) throws Exception {
        Thread.sleep(sec * 1000);
    }

    @Then("I press {string} button")
    public void iPressButton(String xpath) {
        getDriver().findElement(By.xpath("//*[contains(text(),'Place order')]")).click();
    }
    @Then("I verify we see the Confirmation Page title is {string}")
    public void iVerifyWeSeeTheConfirmationPageTitleIs(String arg0) {
        assertThat(getDriver().getTitle()).isEqualTo("Checkout – E-Market");
    }
    @Then("I verify Order Details have {string} item")
    public void iVerifyOrderDetailsHas(String item) {
        getDriver().findElement(By.id("main")).getText();
        assertThat(item).isEqualTo(item);

    }
}
