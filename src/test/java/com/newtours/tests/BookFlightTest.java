package com.newtours.tests;

import com.newtours.pages.*;
import com.tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class BookFlightTest extends BaseTest {

    private String noOfPassengers;
    private String expectedPrice;

    @BeforeTest
    @Parameters({"noOfPassenger","expectedPrice"})
    public void setupParameter(String noOfPassengers, String expectedPrice){
        this.noOfPassengers =noOfPassengers;
        this.expectedPrice = expectedPrice;
    }

    @Test
    public void registrationPage(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.goTo();
        registrationPage.enterUserDetails("selenium","docker");
        registrationPage.enterUserCredentials("selenium","docker");
        registrationPage.submit();

    }

    @Test(dependsOnMethods = "registrationPage")
    public void registrationConfirmationPage(){
        RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
        registrationConfirmationPage.goToFlightDetailsPage();
    }

    @Test(dependsOnMethods = "registrationConfirmationPage")
    public void flightDetailsPage(){
        FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
        flightDetailsPage.selectPassengers(noOfPassengers);
        flightDetailsPage.goToFindFlightDetails();
    }

    @Test(dependsOnMethods = "flightDetailsPage")
    public void findFlightPage(){
        FindFlightPage findFlightPage = new FindFlightPage(driver);
        findFlightPage.submitFindFlightPage();
    }

    @Test(dependsOnMethods = "findFlightPage")
    public void billingAddressPage(){
        BillingAddressPage billingAddressPage = new BillingAddressPage(driver);
        billingAddressPage.submitBillingAddressPage();
    }

    @Test(dependsOnMethods = "billingAddressPage")
    public void flightConfirmationPage(){
        FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver);
        String actualPrice = flightConfirmationPage.getPrice();
        Assert.assertEquals(actualPrice,expectedPrice);
    }


}
