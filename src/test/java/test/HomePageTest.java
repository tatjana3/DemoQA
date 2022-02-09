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
        ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));

        assertURL(2,1);

        String expectedHeading = excelReader.getStringData("ElementNames",1,14);
        String actualHeading = driver.findElement(By.className("enroll__heading")).getText();

        Assert.assertEquals(actualHeading, expectedHeading);
    }

    @Test
    public void verifyThatElementsCardLeadsToElementsPage() {

        try {
            homePage.clickCard("Elements");
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex){
            homePage.clickCard("Elements");

        }

        assertMainHeader(1,0);
        assertURL(3,1);
    }
    @Test
    public void verifyThatFormsCardLeadsToFormsPage(){
        try {
            homePage.clickCard("Forms");
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex){
            homePage.clickCard("Forms");

        }
        assertMainHeader(2,0);
        assertURL(4,1);
    }
    @Test
    public void verifyThatAlertsFrameAndWindowsCardLeadsToAlertsFrameAndWindowsPage(){
        try {
            homePage.clickCard("Alerts, Frame & Windows");
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex){
            homePage.clickCard("Alerts, Frame & Windows");

        }
        assertMainHeader(3,0);
        assertURL(5,1);
    }

    @Test
    public void verifyThatWidgetsCardLeadsToWidgetsPage(){
        try {
            homePage.clickCard("Widgets");
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex){
            homePage.clickCard("Widgets");
        }
        assertMainHeader(4,0);
        assertURL(6,1);
    }
    @Test
    public void verifyThatInteractionsCardLeadsToInteractionsPage(){
        try {
            homePage.clickCard("Interactions");
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex){
            homePage.clickCard("Interactions");
        }
        assertMainHeader(5,0);
        assertURL(7,1);
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
        assertMainHeader(2,12);
        assertURL(8,1);
    }
}
