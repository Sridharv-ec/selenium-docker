package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name="firstName")
    private WebElement firstName;

    @FindBy(name="lastName")
    private WebElement lastName;

    @FindBy(name="phone")
    private WebElement phone;

    @FindBy(name="userName")
    private WebElement email;

    @FindBy(name="email")
    private WebElement userName;

    @FindBy(name="password")
    private WebElement password;

    @FindBy(name="confirmPassword")
    private WebElement confirmPassword;

    @FindBy(name="register")
    private WebElement registerButton;

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void goTo(){
        this.driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html");
        this.wait.until(ExpectedConditions.visibilityOf(this.firstName));
    }

    public void enterUserDetails(String firstName, String lastName){
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
    }

    public void enterUserCredentials(String userName, String password){
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        this.confirmPassword.sendKeys(password);
    }

    public void submit(){
        registerButton.click();

    }

}
