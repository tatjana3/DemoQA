package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementsRadioButtonPage {
    public WebDriver driver;
    public WebDriverWait wdwait;
    WebElement yesRadioButton;
    WebElement impressiveRadioButton;
    WebElement noRadioButton;

    public ElementsRadioButtonPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getYesRadioButton() {
        return driver.findElement(By.id("yesRadio"));
    }

    public WebElement getImpressiveRadioButton() {
        return driver.findElement(By.id("impressiveRadio"));
    }

    public WebElement getNoRadioButton() {
        return driver.findElement(By.id("noRadio"));
    }
    //---------------------------------------------------------------------

    public void clickYesRadioButton(){
        //this.getYesRadioButton()
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getYesRadioButton());
    }

    public void clickImpressiveRadioButton(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getImpressiveRadioButton());
    }
    public void clickNoRadioButton(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getNoRadioButton());
    }
}
