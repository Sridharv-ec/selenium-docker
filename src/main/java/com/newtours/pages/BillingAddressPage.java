package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BillingAddressPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name="buyFlights")
    private WebElement submit;

    public BillingAddressPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void submitBillingAddressPage(){
        this.wait.until(ExpectedConditions.elementToBeClickable(this.submit));
        this.submit.click();
    }
}
