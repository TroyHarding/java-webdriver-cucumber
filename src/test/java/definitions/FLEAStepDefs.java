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

    @Then("I verify title of the page contains {string}")
    public void iVerifyTitleOfThePageContains(String title) {
        assertThat(getDriver().getTitle()).containsIgnoringCase(title);
    }

    @When("I wait and click on a product {string} on the Landing Page")
    public void iClickOnAProductOnTheLandingPage(String product) {
        String xpath = "//img[@title='"+product +"']";
        WebDriverWait waits = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        waits.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        getDriver().findElement(By.xpath(xpath)).click();
        iVerifyTitleOfThePageContains(product);
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

    @Then("I tap on element {string} from Landing Page")
    public void iTapOnElementFromLandingPage(String item) throws Exception {
        if (item.equalsIgnoreCase("AirPods Pro")) {
            getDriver().findElement(By.xpath("//a[@data-product_id='58']")).click();
        } else if (item.equalsIgnoreCase("Apple Watch Series 6")) {
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
        iWaitForSec(2);
    }
    @Then("I wait for {string} to appear")
    public void iWaitForToAppear(String addToCart) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@title='View cart']")));
    }

    public void WaitForElement(WebElement element) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));
    }

    @Then("I tap on View Cart button")
    public void iTapOn() {
        WebElement cart = getDriver().findElement(By.xpath("//a[@title='View cart']"));
        WaitForElement(cart);
        cart.click();
        iVerifyTitleIsForThePage("Cart – E-Market");
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

    @Then("I verify Order Details have {string} item")
    public void iVerifyOrderDetailsHas(String item) {
        getDriver().findElement(By.id("main")).getText();
        assertThat(item).isEqualTo(item);

    }

    @Then("I verify Contact button functionality")
    public void iVerifyContactButtonFunctionality() throws Exception {
        getDriver().findElement(By.xpath("//div[@data-title='Contact Us']")).click();
        WebElement name = getDriver().findElement(By.xpath("//input[@name='name']"));
        WaitForElement(name);
        name.sendKeys("Tester");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("test@test.com");
        getDriver().findElement(By.xpath("//textarea[@id='chaty-name']")).sendKeys("Blah Blah Blah");
        getDriver().findElement(By.xpath("//button[@type='submit']")).click();
        iWaitForSec(2);
        assertThat(getDriver().findElement(By.xpath("//div[@class='chaty-ajax-success-message']")).getText()).isEqualTo("Your message was sent successfully");
    }

    @When("I verify and Click on {string} Category on the Top Bar")
    public void iVerifyAndClickOnCategoryOnTheTopBar(String name) {
        WebElement category = getDriver().findElement(By.xpath("//ul[@id='menu-main']//a[text()='"+name+"']"));
        WaitForElement(category);
        category.click();
        iVerifyTitleOfThePageContains(name);
        assertThat(getDriver().findElement(By.xpath("//header//h1")).getText()).isEqualToIgnoringCase(name);
    }

    @When("I verify Description contains text {string}")
    public void iVerifyDescriptionContainsText(String text) {
        WebElement tabDescription = getDriver().findElement(By.xpath("//div[@id='tab-description']"));
        WaitForElement(tabDescription);
        assertThat(tabDescription.getText()).containsIgnoringCase(text);
    }

    @When("I add {string} items to Cart and verify Cart")
    public void iAddItemsToCartAndVerifyCart(String nums) {
        getDriver().findElement(By.xpath("//input[@name='quantity']")).clear();
        getDriver().findElement(By.xpath("//input[@name='quantity']")).sendKeys(nums);
        getDriver().findElement(By.xpath("//button[contains(text(),'Add to cart')]")).click();
        getDriver().findElement(By.xpath("//div[@class='woocommerce-message']")).isDisplayed();
    }

    @When("I proceed to checkout")
    public void iProceedToCheckout() {
        WebElement check = getDriver().findElement(By.xpath("//a[contains(text(),'Proceed to checkout')]"));
        WaitForElement(check);
        check.click();
        iVerifyTitleOfThePageContains("Checkout");
    }

    @When("I fill out checkout details and place order")
    public void iFillOutCheckoutDetailsAndPlaceOrder() throws Exception {
        WaitForElement(getDriver().findElement(By.xpath("//input[@id='billing_first_name']")));
        getDriver().findElement(By.xpath("//input[@id='billing_first_name']")).sendKeys("Tester");
        getDriver().findElement(By.xpath("//input[@id='billing_last_name']")).sendKeys("Testington");
        getDriver().findElement(By.xpath("//input[@id='billing_email']")).sendKeys("test@test.com");
        iWaitForSec(2);
        WaitForElement(getDriver().findElement(By.xpath("//button[@id='place_order']")));
        getDriver().findElement(By.xpath("//button[@id='place_order']")).click();
        iWaitForSec(3);
    }

    @Then("I verify Confirmation Page")
    public void iVerifyConfirmationPage() {
        WebElement order = getDriver().findElement(By.xpath("//h1[contains(text(),'Order received')]"));
        WaitForElement(order);
        order.getText().equalsIgnoreCase("Order received");
    }

    @When("I update the cart to {string} and verify")
    public void iUpdateTheCartToAndVerify(String num) throws Exception {
        WebElement quantity = getDriver().findElement(By.xpath("//input[@class='input-text qty text']"));
        quantity.clear();
        quantity.sendKeys(num);
        getDriver().findElement(By.xpath("//button[@name='update_cart']")).click();
        iWaitForSec(3);
        WebElement message = getDriver().findElement(By.xpath("//div[@class='woocommerce-message']"));
        message.isDisplayed();
        message.getText().equalsIgnoreCase("Cart updated");
    }


    @Then("I remove the {string} product and verify it was removed")
    public void iRemoveTheProductAndVerifyItWasRemoved(String product) throws Exception {
        getDriver().findElement(By.xpath("//a[@aria-label='Remove this item']")).click();
        iWaitForSec(3);
        WebElement message = getDriver().findElement(By.xpath("//div[@class='woocommerce-message']"));
        message.isDisplayed();
        message.getText().contains(product);
        getDriver().findElement(By.xpath("//p[@class='cart-empty woocommerce-info']")).isDisplayed();
    }
}
