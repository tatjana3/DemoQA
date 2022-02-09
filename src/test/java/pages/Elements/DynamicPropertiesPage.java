package pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DynamicPropertiesPage {
    public WebDriver driver;
    public WebDriverWait wdwait;

    public DynamicPropertiesPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getInFiveSecButton() {
        return driver.findElement(By.id("enableAfter"));
    }

    public WebElement getVisibleAfterFiveSecButton() {
        return driver.findElement(By.id("visibleAfter"));
    }
    //-------------------------------------------------------------------

}
