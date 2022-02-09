package pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UploadAndDownloadFile {
    public WebDriver driver;
    public WebDriverWait wdwait;

    public UploadAndDownloadFile(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getDownloadButton() {
        return driver.findElement(By.id("downloadButton"));
    }

    public WebElement getUploadImageButton() {
        return driver.findElement(By.id("uploadFile"));
    }
    //------------------------------------------------------------------------

    public void clickDownloadButton(){
        this.getDownloadButton().click();
    }
    public void uploadImage(String path){
        this.getUploadImageButton().sendKeys(path);
    }
}
