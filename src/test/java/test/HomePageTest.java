package test;

import base.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.ArrayList;


public class HomePageTest extends BasePage {
    @BeforeMethod
    public void setUpPage(){
        driver.manage().window().maximize();
        driver.navigate().to(homeURL);
    }

    @Test
    public void verifyThatJoinNowImageLeadsToSeleniumTrainingPage(){
        homePage.clickJoinNow();
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));

        String expectedURL = "https://www.toolsqa.com/selenium-training/";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(actualURL,expectedURL);

        String expectedHeading = "Selenium Certification Training | Enroll Now | Study Online";
        String actualHeading = driver.findElement(By.className("enroll__heading")).getText();

        Assert.assertEquals(actualHeading, expectedHeading);
    }

    @Test
    public void verifyThatElementsCardLeadsToElementsPage() throws InterruptedException {

        try {
            homePage.clickCard("Elements");
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex){
            homePage.clickCard("Elements");

        }
        String expectedMainHeader = "Elements";
        String actualMainHeader =  driver.findElement(By.className("main-header")).getText();

        Assert.assertEquals(actualMainHeader,expectedMainHeader);

        String expectedURL = "https://demoqa.com/elements";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
    }
    @Test
    public void verifyThatFormsCardLeadsToFormsPage(){
        try {
            homePage.clickCard("Forms");
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex){
            homePage.clickCard("Forms");

        }
        String expectedMainHeader = "Forms";
        String actualMainHeader =  driver.findElement(By.className("main-header")).getText();

        Assert.assertEquals(actualMainHeader,expectedMainHeader);

        String actualURL = "https://demoqa.com/forms";
        String expectedURL = driver.getCurrentUrl();

        Assert.assertEquals(actualURL,expectedURL);
    }
    @Test
    public void verifyThatAlertsFrameAndWindowsCardLeadsToAlertsFrameAndWindowsPage(){
        try {
            homePage.clickCard("Alerts, Frame & Windows");
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex){
            homePage.clickCard("Alerts, Frame & Windows");

        }
        String expectedMainHeader = "Alerts, Frame & Windows";
        String actualMainHeader =  driver.findElement(By.className("main-header")).getText();

        Assert.assertEquals(actualMainHeader,expectedMainHeader);

        String expectedURL = "https://demoqa.com/alertsWindows";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(actualURL,expectedURL);
    }

    @Test
    public void verifyThatWidgetsCardLeadsToWidgetsPage(){
        try {
            homePage.clickCard("Widgets");
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex){
            homePage.clickCard("Widgets");

        }
        String expectedMainHeader = "Widgets";
        String actualMainHeader =  driver.findElement(By.className("main-header")).getText();

        Assert.assertEquals(actualMainHeader,expectedMainHeader);

        String expectedURL = "https://demoqa.com/widgets";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(actualURL, expectedURL);
    }
    @Test
    public void verifyThatInteractionsCardLeadsToInteractionsPage(){
        try {
            homePage.clickCard("Interactions");
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex){
            homePage.clickCard("Interactions");

        }
        String expectedMainHeader = "Interactions";
        String actualMainHeader =  driver.findElement(By.className("main-header")).getText();

        Assert.assertEquals(actualMainHeader,expectedMainHeader);

        String actualURL = "https://demoqa.com/interaction";
        String expectedURL = driver.getCurrentUrl();

        Assert.assertEquals(actualURL, expectedURL);
    }
    @Test
    public void verifyThatBookStoreApplicationLeadsToBookStore(){
        scroll(homePage.getCards().get(5));
        try {
            homePage.clickCard("Book Store Application");
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex){
            homePage.clickCard("Book Store Application");

        }
        String expectedMainHeader = "Book Store";
        String actualMainHeader =  driver.findElement(By.className("main-header")).getText();

        Assert.assertEquals(actualMainHeader,expectedMainHeader);

        String expectedURL = "https://demoqa.com/books";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(actualURL,expectedURL);
    }
}
