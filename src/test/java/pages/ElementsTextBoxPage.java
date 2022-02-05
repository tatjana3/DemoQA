package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class ElementsTextBoxPage {
    public WebDriver driver;
    public WebDriverWait wdwait;
    WebElement fullnameTextBox;
    WebElement emailTextBox;
    WebElement currentAddressTextBox;
    WebElement permanentAddressTextBox;
    WebElement submitButton;

    public ElementsTextBoxPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getFullnameTextBox() {
        return driver.findElement(By.id("userName"));
    }

    public WebElement getEmailTextBox() {
        return driver.findElement(By.id("userEmail")) ;
    }

    public WebElement getCurrentAddressTextBox() {
        return driver.findElement(By.id("currentAddress"));
    }

    public WebElement getPermanentAddressTextBox() {
        return driver.findElement(By.id("permanentAddress"));
    }

    public  WebElement getSubmitButton(){
        return driver.findElement(By.id("submit"));
    }

    //------------------------------------------------------------------------

    public void sendKeysFullnameTextBox(String fullname){
        this.getFullnameTextBox().clear();
        this.getFullnameTextBox().sendKeys(fullname);
    }
    public void sendKeysEmailTextBox(String email){
        this.getEmailTextBox().clear();
        this.getEmailTextBox().sendKeys(email);
    }
    public void sendKeysCurrentAddressTextbox (String currentAddress){
        this.getCurrentAddressTextBox().clear();
        this.getCurrentAddressTextBox().sendKeys(currentAddress);
    }
    public void sendKeysPermanentAddressTextBox (String permanentAddress){
        this.getPermanentAddressTextBox().clear();
        this.getPermanentAddressTextBox().sendKeys(permanentAddress);
    }
    public void clickSubmitButtonTextbox(){
        this.getSubmitButton().click();
    }


}
