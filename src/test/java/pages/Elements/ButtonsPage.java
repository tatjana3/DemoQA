package pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ButtonsPage {
    public WebDriver driver;
    public WebDriverWait wdwait;

    public ButtonsPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getDoubleClickButton() {
        return driver.findElement(By.id("doubleClickBtn"));
    }

    public WebElement getRightClickButton() {
        return driver.findElement(By.id("rightClickBtn"));
    }

    public WebElement getClickButton() {
        return driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[1]/div[3]/button"));
    }
    //----------------------------------------------------------------------------

    public void clickDoubleClickButton(){
        Actions act = new Actions(driver);
        act.doubleClick(this.getDoubleClickButton()).perform();
    }

    public void clickRightClickButton(){
        Actions act = new Actions(driver);
        act.contextClick(getRightClickButton()).perform();
    }
    public void clickCLickButton(){
        this.getClickButton().click();
    }
}
