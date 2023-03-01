package com.interview.step_definitions;

import com.interview.page.FactorialCalculator;
import com.interview.utilities.ConfigurationReader;
import com.interview.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;


public class FactorialCalculator_StepDefinition {


    FactorialCalculator factorialCalculator = new FactorialCalculator();

    @Given("User is on the specified web page")
    public void userIsOnTheSpecifiedWebPage() {
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);
    }


    @When("user is on the page")
    public void userIsOnThePage() {
        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = "https://qainterview.pythonanywhere.com/";
        Assert.assertEquals(expectedUrl, actualUrl);
    }


    @Then("user sees {string} in the title")
    public void userSeesInTheTitle(String string) {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(string, actualTitle);

    }


    @When("user enters {string} into the input box")
    public void user_enters_into_the_input_box(String string) {
        factorialCalculator.inputBox.sendKeys(string);
    }

    @When("user clicks Calculate")
    public void user_clicks_calculate() {
        factorialCalculator.calculateButton.click();
    }


    @Then("user should be able to see the result displayed")
    public void userShouldBeAbleToSeeTheResultDisplayed() {

            Assert.assertTrue(factorialCalculator.resultMessage.isDisplayed());
    }

    @Then("user should be able to see {string} displayed")
    public void userShouldBeAbleToSeeDisplayed(String string) {
        String actual = factorialCalculator.resultMessage.getText();
        Assert.assertEquals(string, actual);
    }


    @And("user hits enter key on keyboard")
    public void userHitsEnterKeyOnKeyboard() {
        factorialCalculator.inputBox.sendKeys(Keys.ENTER);
    }

    @When("user enters a character")
    public void userEntersACharacter() {
        factorialCalculator.inputBox.sendKeys("A");
    }

    @Then("user should be able to see the error message displayed")
    public void userShouldBeAbleToSeeTheErrorMessageDisplayed() {

        String expectedError = "Please enter an integer";
        String actualError = factorialCalculator.errorMessage.getText();
        Assert.assertEquals(expectedError, actualError);
    }


    @When("user enters four digit integer")
    public void userEntersFourDigitInteger() {
        factorialCalculator.inputBox.sendKeys("1234");
    }

    @When("user clicks on Privacy link")
    public void userClicksOnPrivacyLink() {
        factorialCalculator.privacyLink.click();
    }

    @Then("user should be taken to the Privacy page")
    public void userShouldBeTakenToThePrivacyPage() {
        String url = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains("privacy"));
    }

    @When("user clicks on Terms and Conditions link")
    public void userClicksOnTermsAndConditionsLink() {
        factorialCalculator.termsLink.click();
    }

    @Then("user should be taken to the Terms and Conditions page")
    public void userShouldBeTakenToTheTermsAndConditionsPage() {
        String url = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(url.contains("terms"));
    }


}


