package pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class HomePage {
    public WebDriver driver;
    public WebDriverWait wdwait;

    public HomePage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public List<WebElement> getCards() {
        return driver.findElements(By.cssSelector(".card.mt-4.top-card"));

    }
    public WebElement getJoinNow() {
        return driver.findElement(By.className("banner-image"));
    }

    public WebElement getMenuList() {
        return driver.findElement(By.className("menu-list"));
    }

    //-----------------------------------------------------------------------------

    public void clickCard (String cardname) {
        for (WebElement el : getCards()){
            String elText = el.getText();
            if (elText.equals(cardname)){
                el.click();
                break;
            }
        }
    }

    public void clickJoinNow (){
        this.getJoinNow().click();
    }
    public void clickOnMenuList(String text){
        List <WebElement> menuList = getMenuList().findElements(By.tagName("li"));
        for (WebElement el : menuList){
            String elText = el.getAttribute("id");
            if(elText.equals(text)){
                el.click();
                break;
            }
        }
    }
}
