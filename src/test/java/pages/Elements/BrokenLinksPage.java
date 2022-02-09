package pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrokenLinksPage {
    public WebDriver driver;
    public WebDriverWait wdwait;

    public BrokenLinksPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getValidLink() {
        return driver.findElement(By.linkText("Click Here for Valid Link"));
    }
    public WebElement getBrokenLink(){
        return driver.findElement(By.linkText("Click Here for Broken Link"));
    }
    //------------------------------------------------------------------------------------

    public void clickValidLink(){
        this.getValidLink().click();
    }
    public void clickBrokenLink(){
        this.getBrokenLink().click();
    }
}
