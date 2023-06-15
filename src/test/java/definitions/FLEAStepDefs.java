package definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
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
}
