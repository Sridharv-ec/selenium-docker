package com.searchmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name="q")
    private WebElement searchTextBox;

    @FindBy(xpath="//div[@class='searchbox_iconWrapper__suWUe']/button[@aria-label='Search']")
    private WebElement searchButton;

    @FindBy(linkText="Videos")
    private WebElement vedios;

    @FindBy(className = "tile--vid")
    private List<WebElement> allVideos;

    public SearchPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void goTo(){
        this.driver.get("https://duckduckgo.com/");
        this.driver.manage().window().maximize();
    }

    public void doSearch(String keyword){
        this.wait.until(ExpectedConditions.visibilityOf(this.searchTextBox));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.searchTextBox.sendKeys(keyword);
        this.searchButton.click();
    }

    public void goToVideos(){
        this.wait.until(ExpectedConditions.visibilityOf(this.vedios));
        this.vedios.click();
    }

    public int getResults(){
        By by = By.className("tile--vid");
        this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by,0));
        return this.allVideos.size();
    }

}
