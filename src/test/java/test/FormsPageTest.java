package test;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Set;

public class FormsPageTest extends BasePage {
    @BeforeMethod
    public void setUpFormsPage(){
        driver.manage().window().maximize();
        String formsURL = excelReader.getStringData("URL",4,1);
        driver.navigate().to(formsURL);
    }

    @Test
    public void positivePracticeFormTest() {
        String practiceFormURL = excelReader.getStringData("URL",1,7);
        driver.navigate().to(practiceFormURL);
        assertMainHeader(1,4);

        for (int i = 2; i< excelReader.getLastRow("ValidCredentials")-4;i++) {
            String validFirstname = excelReader.getStringData("ValidCredentials",i,10);
            String validLastname = excelReader.getStringData("ValidCredentials",i,11);
            String validEmail = excelReader.getStringData("ValidCredentials",i,12);
            String validMobile = excelReader.getStringData("ValidCredentials",i,13);
            String validDateOFBirth = excelReader.getStringData("ValidCredentials",i,14);
            String validSubject = excelReader.getStringData("ValidCredentials",i,15);
            String validCurrentAddress = excelReader.getStringData("ValidCredentials",i,16);
            String genderValue = excelReader.getStringData("ValidCredentials",i,17);
            String hobbiesValue = excelReader.getStringData("ValidCredentials",i,18);

            practiceFormPage.sendKeysFirstname(validFirstname);
            practiceFormPage.sendKeysLastname(validLastname);
            practiceFormPage.sendKeysEmail(validEmail);
            practiceFormPage.clickGender(genderValue);
            practiceFormPage.sendKeysMobile(validMobile);
            practiceFormPage.sendKeysCalendar(validDateOFBirth);
            practiceFormPage.sendKeysSubjects(validSubject);
            practiceFormPage.clickHobbies(hobbiesValue);
            practiceFormPage.uploadPicture("C:\\Users\\Sale\\Desktop\\image.jpg");
            practiceFormPage.sendKeysCurrentAddress(validCurrentAddress);
            scroll(practiceFormPage.getSubmitButton());

            practiceFormPage.clickSubmitButton();

            String parentWindowHandler = driver.getWindowHandle();
            String subWindowHandler = null;

            Set<String> handles = driver.getWindowHandles();
            for (String handle : handles) {
                subWindowHandler = handle;
            }
            driver.switchTo().window(subWindowHandler);

            WebElement modalTitle = driver.findElement(By.cssSelector(".modal-title.h4"));
            wdwait.until(ExpectedConditions.visibilityOf(modalTitle));
            String actualMessage = modalTitle.getText();
            String expectedMessage = "Thanks for submitting the form";

            Assert.assertEquals(actualMessage,expectedMessage);

            WebElement table = driver.findElement(By.cssSelector(".table.table-dark.table-striped.table-bordered.table-hover"));
            boolean isDisplayed = table.isDisplayed();

            Assert.assertTrue(isDisplayed);
            driver.switchTo().window(parentWindowHandler);

            practiceFormPage.clickCloseButton();
        }

    }
}
