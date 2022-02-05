package test;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElementsPageTest extends BasePage {
    @BeforeMethod
    public void setUpElementsPage(){
        driver.manage().window().maximize();
        String elementsURL = excelReader.getStringData("URL",1,1);
        driver.navigate().to(elementsURL);
    }

    @Test
    public void verifyThatUserCanSubmitCredentialsInTextbox() {

       homePage.clickOnMenuList("item-0");

       String actualMainHeader = driver.findElement(By.className("main-header")).getText();
       String expectedMainHeader = excelReader.getStringData("ElementNames",1,1);

       Assert.assertEquals(actualMainHeader, expectedMainHeader);

        for (int i = 2; i <= excelReader.getLastRow("ValidCredentials"); i++){
           String name = excelReader.getStringData("ValidCredentials", i,0);
           elementsTextBoxPage.sendKeysFullnameTextBox(name);
           String email = excelReader.getStringData("ValidCredentials",i,1);
           elementsTextBoxPage.sendKeysEmailTextBox(email);
           String  currentAddress = excelReader.getStringData("ValidCredentials",i,2);
           elementsTextBoxPage.sendKeysCurrentAddressTextbox(currentAddress);
           String permanentAddress = excelReader.getStringData("ValidCredentials", i, 3);
           elementsTextBoxPage.sendKeysPermanentAddressTextBox(permanentAddress);
           elementsTextBoxPage.clickSubmitButtonTextbox();

           WebElement textboxDisplayed = driver.findElement(By.id("output"));

           String actualTextboxName = textboxDisplayed.findElement(By.id("name")).getText();
           String expectedTextboxName = "Name:" + name;

           Assert.assertEquals(actualTextboxName,expectedTextboxName);

           String actualTextboxEmail = textboxDisplayed.findElement(By.id("email")).getText();
           String expectedTextboxEmail = "Email:" + email;

           Assert.assertEquals(actualTextboxEmail, expectedTextboxEmail);

           String actualTextboxCurrentAddress = textboxDisplayed.findElement(By.id("currentAddress")).getText();
           String expectedTextboxCurrentAddress = "Current Address :" + currentAddress;

           Assert.assertEquals(actualTextboxCurrentAddress,expectedTextboxCurrentAddress);

           String actualTextboxPermanentAddress = textboxDisplayed.findElement(By.id("permanentAddress")).getText();
           String expectedTexboxPermanenetAddress = "Permananet Address :" + permanentAddress;

           Assert.assertEquals(actualTextboxPermanentAddress, expectedTexboxPermanenetAddress);
        }
    }

    @Test
    public void verifyThatUsercanExpandCheckAndCollapseAllCheckboxes(){
        homePage.clickOnMenuList("item-1");

        String actualMainHeader = driver.findElement(By.className("main-header")).getText();
        String expectedMainHeader = excelReader.getStringData("ElementNames", 2,1);

        Assert.assertEquals(actualMainHeader,expectedMainHeader);

        elementsCheckboxPage.clickExpandAllButton();

        WebElement expandAll = driver.findElement(By.cssSelector(".rct-node.rct-node-parent.rct-node-expanded"));

        boolean isExpan = expandAll.isDisplayed();

        Assert.assertTrue(isExpan);

        elementsCheckboxPage.clickHomeCheckbox();

        WebElement checkboxChecked = driver.findElement(By.cssSelector(".rct-icon.rct-icon-check"));
        boolean isChecked = checkboxChecked.isDisplayed();

        Assert.assertTrue(isChecked);

        elementsCheckboxPage.clickCollapseAllButton();

        WebElement collapseAll = driver.findElement(By.cssSelector(".rct-icon.rct-icon-parent-close"));
        boolean isCollapsed = collapseAll.isDisplayed();

        Assert.assertTrue(isCollapsed);

        elementsCheckboxPage.clickHomeCheckbox();

        WebElement uncheckCheckbox = driver.findElement(By.cssSelector(".rct-icon.rct-icon-uncheck"));
        boolean isUnchecked = uncheckCheckbox.isDisplayed();

        Assert.assertTrue(isChecked);
    }

    @Test
    public void verifyThatUserCanClickOnAllRadioButtons() throws InterruptedException {

        homePage.clickOnMenuList("item-2");

        String actualMainHeader = driver.findElement(By.className("main-header")).getText();
        String expectedMainHeader = excelReader.getStringData("ElementNames", 3,1);

        Assert.assertEquals(actualMainHeader, expectedMainHeader);

        elementsRadioButtonPage.clickYesRadioButton();

        assertDisplayedMessage(1,0);

        elementsRadioButtonPage.clickImpressiveRadioButton();

        assertDisplayedMessage(2,0);

        elementsRadioButtonPage.clickNoRadioButton();

        assertDisplayedMessage(3, 0);
    }


    private void assertDisplayedMessage(int rowNumber, int cellNumber) {
        String actualMessage = driver.findElement(By.className("mt-3")).getText();
        String expectedMessage = excelReader.getStringData("Messages", rowNumber,cellNumber);

        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test
    public void verifyThatUserCanAddNewEmployeeToWebTable(){

    }
}
