package pages.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebTablesPage {
    public WebDriver driver;
    public WebDriverWait wdwait;

    public WebTablesPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getAddButton() {
        return driver.findElement(By.id("addNewRecordButton"));
    }

    public WebElement getSearchbox() {
        return driver.findElement(By.id("searchBox"));
    }

    public WebElement getEditButton() {
        return driver.findElement(By.id("edit-record-3"));
    }

    public WebElement getDeleteButton(String id) {
        return driver.findElement(By.id(id));
    }

    public WebElement getPreviousButton() {
        return driver.findElement(By.className("-previous")).findElement(By.className("-btn"));
    }

    public WebElement getNextButon() {
        return driver.findElement(By.className("-next")).findElement(By.className("-btn"));
    }

    public Select getRowsDropdownMenu() {
        return new Select(driver.findElement(By.cssSelector(".select-wrap.-pageSizeOptions")).findElement(By.tagName("select")));
    }

    public WebElement getEditFirstname() {
        return driver.findElement(By.id("firstName"));
    }

    public WebElement getEditLastname() {
        return driver.findElement(By.id("lastName"));
    }

    public WebElement getEditEmail() {
        return driver.findElement(By.id("userEmail"));
    }

    public WebElement getEditAge() {
        return driver.findElement(By.id("age"));
    }

    public WebElement getEditSalary() {
        return driver.findElement(By.id("salary"));
    }

    public WebElement getEditDepartment() {
        return driver.findElement(By.id("department"));
    }

    public WebElement getEditSubmitButton() {
        return driver.findElement(By.id("submit"));
    }
    //---------------------------------------------------------------------------------------------

    public void clickAddButton (){
        this.getAddButton().click();
    }
    public void sendKeysSearchbox(String text){
        this.getSearchbox().clear();
        this.getSearchbox().sendKeys(text);
    }
    public void clickEditButton(){
        this.getEditButton().click();
    }
   public void sendKeysEdit(String firstname, String lastname, String email, String age, String salary, String department){
        this.getEditFirstname().clear();
        this.getEditFirstname().sendKeys(firstname);

        this.getEditLastname().clear();
        this.getEditLastname().sendKeys(lastname);

        this.getEditEmail().clear();
        this.getEditEmail().sendKeys(email);

        this.getEditAge().clear();
        this.getEditAge().sendKeys(age);

        this.getEditSalary().clear();
        this.getEditSalary().sendKeys(salary);

        this.getEditDepartment().clear();
        this.getEditDepartment().sendKeys(department);
    }
    public void clickDeleteButton(String id){
        this.getDeleteButton(id).click();
    }
    public void clickPreviousButton(){
        this.getPreviousButton().click();
    }
    public void clickNextButton(){
        this.getNextButon().click();
    }
    public void clickRowsDropdownMenu (String value){
        this.getRowsDropdownMenu().selectByValue(value);
    }
    public void clickEditSubmitButton(){
        this.getEditSubmitButton().click();
    }
}
