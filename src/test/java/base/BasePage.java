package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.Elements.*;
import pages.Forms.PracticeFormPage;

import java.io.IOException;
import java.time.Duration;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wdwait;
    public HomePage homePage;
    public TextBoxPage textBoxPage;
    public CheckboxPage checkboxPage;
    public RadioButtonPage radioButtonPage;
    public WebTablesPage webTablesPage;
    public ButtonsPage buttonsPage;
    public LinksPage linksPage;
    public BrokenLinksPage brokenLinksPage;
    public UploadAndDownloadFile uploadAndDownloadFile;
    public DynamicPropertiesPage dynamicPropertiesPage;
    public PracticeFormPage practiceFormPage;
    public ExcelReader excelReader;
    public String homeURL;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(15));
        homePage = new HomePage(driver, wdwait);
        textBoxPage = new TextBoxPage(driver, wdwait);
        checkboxPage = new CheckboxPage(driver, wdwait);
        radioButtonPage = new RadioButtonPage(driver, wdwait);
        webTablesPage = new WebTablesPage(driver, wdwait);
        buttonsPage = new ButtonsPage(driver, wdwait);
        linksPage = new LinksPage(driver,wdwait);
        brokenLinksPage = new BrokenLinksPage(driver,wdwait);
        uploadAndDownloadFile = new UploadAndDownloadFile(driver,wdwait);
        dynamicPropertiesPage = new DynamicPropertiesPage(driver,wdwait);
        practiceFormPage = new PracticeFormPage(driver,wdwait);
        excelReader = new ExcelReader("D:\\Projects\\Java\\DemoQA\\src\\test\\java\\base\\demoQA.xlsx");
        homeURL = excelReader.getStringData("URL",1,1);
    }

    public void scroll (WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",element);
    }
    public void assertMainHeader(int rowNumber,int cellNumber){
        String actualMainHeader = driver.findElement(By.className("main-header")).getText();
        String expectedMainHeader = excelReader.getStringData("ElementNames",rowNumber,cellNumber);

        Assert.assertEquals(actualMainHeader, expectedMainHeader);
    }
    public void assertURL (int rowNuber, int cellNumber){
        String actualURl = driver.getCurrentUrl();
        String expecetdURL = excelReader.getStringData("URL",rowNuber,cellNumber);

        Assert.assertEquals(actualURl,expecetdURL);
    }

    @AfterClass
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
    }
}
