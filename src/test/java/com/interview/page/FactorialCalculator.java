package com.interview.page;

import com.interview.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FactorialCalculator {

    public FactorialCalculator() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//input[@class='form-control input-lg']")
    public WebElement inputBox;


    @FindBy(xpath = "//button[@type='submit']")
    public WebElement calculateButton;

    @FindBy(xpath = "//p[@id='resultDiv' and @style='color: rgb(255, 0, 0);']")
    public WebElement errorMessage;

    @FindBy(xpath = "//p[@id='resultDiv' and @style='color: rgb(0, 0, 0);']")
    public WebElement resultMessage;

    @FindBy(xpath = "//a[@href='/terms']")
    public WebElement privacyLink;

    @FindBy(xpath = "//a[@href='/privacy']")
    public WebElement termsLink;

    @FindBy(xpath = "/html/body")
    public WebElement documentMessage;
}
