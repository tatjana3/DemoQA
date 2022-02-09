package test;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Iterator;
import java.util.Set;

public class ElementsPageTest extends BasePage {
    @BeforeMethod
    public void setUpElementsPage(){
        driver.manage().window().maximize();
        String elementsURL = excelReader.getStringData("URL",3,1);
        driver.navigate().to(elementsURL);
    }

    @Test
    public void positiveTextboxTest() {

        homePage.clickOnMenuList("item-0");

        assertMainHeader(1,2);
        assertURL(1,4);

        int lastRow = excelReader.getLastRow("ValidCredentials");
        for (int i = 2; i <= lastRow; i++){
           String name = excelReader.getStringData("ValidCredentials", i,0);
           textBoxPage.sendKeysFullnameTextBox(name);
           String email = excelReader.getStringData("ValidCredentials",i,1);
           textBoxPage.sendKeysEmailTextBox(email);
           String  currentAddress = excelReader.getStringData("ValidCredentials",i,2);
           textBoxPage.sendKeysCurrentAddressTextbox(currentAddress);
           String permanentAddress = excelReader.getStringData("ValidCredentials", i, 3);
           textBoxPage.sendKeysPermanentAddressTextBox(permanentAddress);
           textBoxPage.clickSubmitButtonTextbox();

           WebElement textboxDisplayed = driver.findElement(By.id("output"));

           assertTextboxFields("name", textboxDisplayed, "Name:" + name);
           assertTextboxFields("email", textboxDisplayed, "Email:" + email);
           assertTextboxFields("currentAddress", textboxDisplayed, "Current Address :" + currentAddress);
           assertTextboxFields("permanentAddress", textboxDisplayed, "Permananet Address :" + permanentAddress);
        }
    }

    @Test
    public void verifyThatUsercanExpandCheckAndCollapseAllCheckboxes(){
        homePage.clickOnMenuList("item-1");
        assertMainHeader(2,2);

        checkboxPage.clickExpandAllButton();
        assertIsDisplayed(SelectorEnum.CSS, ".rct-node.rct-node-parent.rct-node-expanded");

        checkboxPage.clickHomeCheckbox();
        assertIsDisplayed(SelectorEnum.CSS, ".rct-icon.rct-icon-check");

        checkboxPage.clickCollapseAllButton();
        assertIsDisplayed(SelectorEnum.CSS, ".rct-icon.rct-icon-parent-close");

        checkboxPage.clickHomeCheckbox();
        assertIsDisplayed(SelectorEnum.CSS, ".rct-icon.rct-icon-uncheck");
    }

    @Test
    public void verifyThatUserCanClickOnAllRadioButtons() {

        homePage.clickOnMenuList("item-2");
        assertMainHeader(3,2);

        radioButtonPage.clickYesRadioButton();
        assertDisplayedMessage("mt-3",1,0);

        radioButtonPage.clickImpressiveRadioButton();
        assertDisplayedMessage("mt-3",2,0);

        radioButtonPage.clickNoRadioButton();
        assertDisplayedMessage("mt-3",3, 0);
    }
    @Test
    public void positiveWebTablesTast(){
        homePage.clickOnMenuList("item-3");

        assertMainHeader(1,2);

        webTablesPage.clickDeleteButton("delete-record-1");

        String parentWindowHandler = driver.getWindowHandle();
        String subWindowHandler = null;

        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            subWindowHandler = handle;
        }
            String validFirstname = "";
            String validLastname = "";
            String validEmail = "";
            String validAge = "";
            String validSalary = "";
            String validDepartment = "";

        for (int i = 2; i < excelReader.getLastRow("ValidCredentials")-2;i++) {
            validFirstname = excelReader.getStringData("ValidCredentials", i, 4);
            validLastname = excelReader.getStringData("ValidCredentials", i, 5);
            validEmail = excelReader.getStringData("ValidCredentials", i, 6);
            validAge = excelReader.getStringData("ValidCredentials", i, 7);
            validSalary = excelReader.getStringData("ValidCredentials", i, 8);
            validDepartment = excelReader.getStringData("ValidCredentials", i, 9);

            webTablesPage.clickAddButton();
            driver.switchTo().window(subWindowHandler);
            webTablesPage.sendKeysEdit(validFirstname, validLastname, validEmail, validAge, validSalary, validDepartment);
            webTablesPage.clickEditSubmitButton();
        }
        driver.switchTo().window(parentWindowHandler);

        webTablesPage.clickNextButton();
        webTablesPage.clickPreviousButton();

        for (int i = 1; i < excelReader.getLastRow("ElementNames") - 2; i++) {
            String selectRow = excelReader.getStringData("ElementNames", i, 16);
            webTablesPage.clickRowsDropdownMenu(selectRow);
        }
        webTablesPage.clickEditButton();
        webTablesPage.sendKeysEdit(validFirstname,validLastname,validEmail,validAge,validSalary,validDepartment);
        webTablesPage.clickEditSubmitButton();
        webTablesPage.sendKeysSearchbox(validFirstname);
    }

    @Test
    public void verifyThatUseCanCLickOnButtons(){
        homePage.clickOnMenuList("item-4");
        assertMainHeader(5,2);
        assertURL(5,4);

        buttonsPage.clickDoubleClickButton();
        assertDisplayedMessage("doubleClickMessage", 1,1);

        buttonsPage.clickRightClickButton();
        assertDisplayedMessage("rightClickMessage",2,1);

        buttonsPage.clickCLickButton();
        assertDisplayedMessage("dynamicClickMessage",3,1);
    }

    @Test
    public void verifyThatUserCanClickOnAllLinks() throws InterruptedException {
        homePage.clickOnMenuList("item-5");
        assertMainHeader(6,2);
        assertURL(6,4);

        linksPage.clickLink("simpleLink");
        String parentWindowHandler = driver.getWindowHandle();
        String subWindowHandler = null;

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()){
            subWindowHandler = iterator.next();
        }
        driver.switchTo().window(subWindowHandler);

        assertURL(1,1);
        driver.close();
        driver.switchTo().window(parentWindowHandler);

        linksPage.clickLink("dynamicLink");
        subWindowHandler = null;

        handles = driver.getWindowHandles();
        iterator = handles.iterator();
        while (iterator.hasNext()){
            subWindowHandler = iterator.next();
        }
        driver.switchTo().window(subWindowHandler);
        assertURL(1,1);

        driver.close();
        driver.switchTo().window(parentWindowHandler);

        assertAndClick("created",1);
        assertAndClick("no-content",2);
        assertAndClick("moved",3);
        assertAndClick("bad-request",4);
        assertAndClick("unauthorized",5);
        assertAndClick("forbidden",6);
        assertAndClick("invalid-url",7);
    }

    @Test
    public void verifyThatBrokenLinkLeadsToBrokenPageAndValidLinkLeadsToValidPage(){
        homePage.clickOnMenuList("item-6");
        assertMainHeader(7,2);
        assertURL(7,4);

        brokenLinksPage.clickBrokenLink();
        assertDisplayedMessage("example",1,4);
        driver.navigate().back();
        brokenLinksPage.clickValidLink();
        assertURL(1,1);

        assertIsDisplayed(SelectorEnum.CLASS, "banner-image");
    }

    @Test
    public void verifyThatUserCanDownloadFileAndUploadImage(){
        homePage.clickOnMenuList("item-7");
        assertURL(8,4);
        assertMainHeader(8,2);

        uploadAndDownloadFile.clickDownloadButton();
        uploadAndDownloadFile.uploadImage("C:\\Users\\Sale\\Desktop");

        assertIsDisplayed(SelectorEnum.ID, "uploadedFilePath");
    }

    @Test
    public void verifyThatUserCanClickOnButtonAfterFiveSeconds(){
        scroll(homePage.getMenuList().findElement(By.id("item-8")));

        homePage.clickOnMenuList("item-8");
        assertMainHeader(9,2);
        assertURL(9,4);

        wdwait.until(ExpectedConditions.elementToBeClickable(dynamicPropertiesPage.getInFiveSecButton()));
        Assert.assertTrue(dynamicPropertiesPage.getInFiveSecButton().isEnabled());

        assertIsDisplayed(SelectorEnum.CSS, ".mt-4.text-danger.btn.btn-primary");

        Assert.assertTrue(dynamicPropertiesPage.getVisibleAfterFiveSecButton().isDisplayed());
    }

    private void assertDisplayedMessage(String selector,int rowNumber, int cellNumber) {
        try{
            String actualMessage = driver.findElement(By.className(selector)).getText();
            String expectedMessage = excelReader.getStringData("Messages", rowNumber,cellNumber);

            Assert.assertEquals(actualMessage, expectedMessage);
        }
        catch (org.openqa.selenium.NoSuchElementException noel) {

            String actualMessage = driver.findElement(By.id(selector)).getText();
            String expectedMessage = excelReader.getStringData("Messages", rowNumber,cellNumber);

            Assert.assertEquals(actualMessage, expectedMessage);
        }
    }

    private void assertTextboxFields(String id, WebElement element, String expected) {
        String actual = element.findElement(By.id(id)).getText();

        Assert.assertEquals(actual, expected);
    }

    private void assertIsDisplayed(SelectorEnum selectorEnum, String selector) {
        WebElement element = switch (selectorEnum) {
            case ID -> driver.findElement(By.id(selector));
            case CSS -> driver.findElement(By.cssSelector(selector));
            case CLASS -> driver.findElement(By.className(selector));
        };

        boolean isDisplayed = element.isDisplayed();
        Assert.assertTrue(isDisplayed);
    }

    private void assertAndClick(String id,int rowNumber) throws InterruptedException {
        linksPage.clickLink(id);
        Thread.sleep(2000);
       // wdwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#linkResponse")));
        assertDisplayedMessage("linkResponse",rowNumber,3);
    }
}

enum SelectorEnum {
    CSS,
    ID,
    CLASS
}
