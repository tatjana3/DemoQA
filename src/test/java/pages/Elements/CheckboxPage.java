package pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckboxPage {
    public WebDriver driver;
    public WebDriverWait wdwait;

    public CheckboxPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getHomeCheckbox() {
        return driver.findElement(By.className("rct-checkbox"));
    }

    public WebElement getExpandAllButton() {
        return driver.findElement(By.cssSelector(".rct-option.rct-option-expand-all"));
    }

    public WebElement getCollapseAllButton() {
        return driver.findElement(By.cssSelector(".rct-option.rct-option-collapse-all"));
    }
    //------------------------------------------------------------------------------------------

    public void clickHomeCheckbox (){
        this.getHomeCheckbox().click();
    }
    public void clickExpandAllButton(){
        this.getExpandAllButton().click();
    }
    public void clickCollapseAllButton(){
        this.getCollapseAllButton().click();
    }
}
