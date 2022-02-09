package pages.Forms;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import static org.openqa.selenium.Keys.ENTER;

public class PracticeFormPage {
    public WebDriver driver;
    public WebDriverWait wdwait;

    public PracticeFormPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getFirstnameTextbox() {
        return driver.findElement(By.id("firstName"));
    }

    public WebElement getLastnameTextbox() {
        return driver.findElement(By.id("lastName"));
    }

    public WebElement getEmail() {
        return driver.findElement(By.id("userEmail"));
    }

    public List<WebElement> getGenderRadioButton() {
        return driver.findElements(By.name("gender"));
    }

    public WebElement getMobileTextbox() {
        return driver.findElement(By.id("userNumber"));
    }

    public WebElement getDateOfBirthCalendar() {
        return driver.findElement(By.id("dateOfBirthInput"));
    }

    public WebElement getSubjectRecommendationBox() {
        return driver.findElement(By.id("subjectsInput"));
    }
    public List<WebElement> getHobbiesCheckbox() {
        WebElement wb = driver.findElement(By.id("hobbiesWrapper"));

        return wb.findElements(By.className("custom-control-label"));
    }
    public WebElement getUploadPicture() {
        return driver.findElement(By.className("form-control-file"));
    }

    public WebElement getCurrentAddressTextbox() {
        return driver.findElement(By.id("currentAddress"));
    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.id("submit"));
    }
    public WebElement getCloseButton(){
       return driver.findElement(By.id("closeLargeModal"));
    }
    //------------------------------------------------------------

    public void sendKeysFirstname(String firstname) {
        WebElement el = this.getFirstnameTextbox();
        el.clear();
        //wdwait.until(ExpectedConditions.textToBePresentInElementValue(By.id("firstName"), ""));
        el.sendKeys(firstname);
        //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        wdwait.until(ExpectedConditions.textToBePresentInElementValue(By.id("firstName"), firstname));
    }

    public void sendKeysLastname(String lastname){
        WebElement el = this.getLastnameTextbox();
        el.clear();
        el.sendKeys(lastname);
    }
    public void sendKeysEmail(String email){
        this.getEmail().clear();
        this.getEmail().sendKeys(email);
    }
    public void clickGender(String value){
        for (WebElement el : getGenderRadioButton()) {
            if (el.getAttribute("value").equals(value)){
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
            }
        }
    }
    public void sendKeysMobile(String mobile) {
        WebElement el = this.getMobileTextbox();
        el.clear();
        el.sendKeys(mobile);
        wdwait.until(ExpectedConditions.textToBePresentInElementValue(By.id("userNumber"), mobile));
    }
    public void sendKeysCalendar(String date){
        this.getDateOfBirthCalendar().clear();
        this.getDateOfBirthCalendar().sendKeys(date);
        this.getDateOfBirthCalendar().sendKeys(ENTER);
    }
    public void sendKeysSubjects(String subject){
        ((JavascriptExecutor) driver).executeScript(subject, getSubjectRecommendationBox());
        this.getSubjectRecommendationBox().sendKeys(subject);
        this.getSubjectRecommendationBox().sendKeys(ENTER);
    }
    public void clickHobbies(String value) {
        String id = "hobbies-checkbox-" + value;

        for (WebElement el : getHobbiesCheckbox()){
            if (el.getAttribute("for").equals(id)) {
                el.click();
                return;
            }
        }
    }
    public void uploadPicture(String imagePath){

        this.getUploadPicture().sendKeys(imagePath);
    }
    public void sendKeysCurrentAddress(String currentAddress){
        this.getCurrentAddressTextbox().clear();
        this.getCurrentAddressTextbox().sendKeys(currentAddress);
    }
    public void clickSubmitButton(){
        getSubmitButton().click();
    }
    public void clickCloseButton(){
        this.getCloseButton().click();
        wdwait.until(ExpectedConditions.invisibilityOf(this.getCloseButton()));
    }
}
