package pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LinksPage {
    public WebDriver driver;
    public WebDriverWait wdwait;

    public LinksPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public List<WebElement> getLinks() {
        return driver.findElements(By.tagName("a"));
    }
    //-------------------------------------------------------------------------

    public void clickLink (String id){
        WebElement link = driver.findElement(By.id(id));
        for (WebElement el : getLinks()){
            if (el.equals(link)){
                el.click();
            }
        }
    }
}
