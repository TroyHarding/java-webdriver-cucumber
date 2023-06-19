package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.*;
import static support.TestContext.getDriver;

public class QuoteStepDefs {
    @Given("I visit Quote Page in the {string} Environment")
    public void iVisitQuotePageInTheEnvironment(String env) {
        if(env.equalsIgnoreCase("Stage")) {
            getDriver().get("http://quote-stage.portnov.com/");
        } else if(env.equalsIgnoreCase("qa")) {
            getDriver().get("http://quote-qa.portnov.com/");
        } else {
            System.out.println("BAD URL");
        }
    }

    @When("I enter {string} for the Username field")
    public void iEnterForTheUsernameField(String username) {
        getDriver().findElement(By.name("username")).sendKeys(username);

    }

    @And("I enter {string} for first name and {string} for the last name in the Name field")
    public void iEnterForFirstNameAndForTheLastNameInTheNameField(String fname, String lname) {
        getDriver().findElement(By.xpath("//input[@id='name']")).click();
        getDriver().findElement(By.xpath("//input[@id='firstName']")).sendKeys(fname);
        getDriver().findElement(By.xpath("//input[@id='lastName']")).sendKeys(lname);
        getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();
    }

    @And("I enter {string} for the Email field")
    public void iEnterForTheEmailField(String email) {
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys(email);
    }

    @When("I enter {string} for the Password field")
    public void iEnterForThePasswordField(String pass) {
        getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys(pass);

    }

    @And("I enter {string} for the Confirm Password field")
    public void iEnterForTheConfirmPasswordField(String confPass) {
        getDriver().findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys(confPass);
    }

    @Then("I {string} the Privacy Policy Policy checkbox")
    public void iThePrivacyPolicyPolicyCheckbox(String check) {
        getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();
    }

    @When("I click on the {string} button at the bottom of the page")
    public void iClickOnTheButtonAtTheBottomOfThePage(String button) {
        if (button.equalsIgnoreCase("submit")) {
            getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();
        } else if(button.equalsIgnoreCase("reset")) {
            getDriver().findElement(By.xpath("//button[@id='formReset']")).click();
        } else if(button.equalsIgnoreCase("refresh")){
            getDriver().findElement(By.xpath("//button[@id='formRefresh']")).click();
        } else {
            System.out.println("Choose the button");
        }
    }
    @Then("I verify we see the Submitted Application Page")
    public void iVerifyWeSeeTheSubmittedApplicationPage() {
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//legend[@class='applicationResult']")));
        assertThat(getDriver().findElement(By.xpath("//legend[@class='applicationResult']")).getText()).isEqualToIgnoringCase("Submitted Application");
    }

    @Then("I verify username is {string}, first name is {string}, last name is {string}, email is {string}, and password is {string}")
    public void iVerifyUsernameIsFirstNameIsLastNameIsEmailIsAndPasswordIs(String username, String fname, String lname, String email, String pass) {
        assertThat(getDriver().findElement(By.xpath("//b[@name='username']")).getText()).isEqualToIgnoringCase(username);
        assertThat(getDriver().findElement(By.xpath("//b[@name='firstName']")).getText()).isEqualToIgnoringCase(fname);
        assertThat(getDriver().findElement(By.xpath("//b[@name='lastName']")).getText()).isEqualToIgnoringCase(lname);
        assertThat(getDriver().findElement(By.xpath("//b[@name='email']")).getText()).isEqualToIgnoringCase(email);
        assertThat(getDriver().findElement(By.xpath("//b[@name='confirmPassword']")).getText()).isEqualTo(pass);
    }
}
