package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.ElementsCheckboxPage;
import pages.ElementsRadioButtonPage;
import pages.ElementsTextBoxPage;
import pages.HomePage;

import java.io.IOException;
import java.time.Duration;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wdwait;
    public HomePage homePage;
    public ElementsTextBoxPage elementsTextBoxPage;
    public ElementsCheckboxPage elementsCheckboxPage;
    public ElementsRadioButtonPage elementsRadioButtonPage;
    public ExcelReader excelReader;
    public String homeURL;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(15));
        homePage = new HomePage(driver, wdwait);
        elementsTextBoxPage = new ElementsTextBoxPage(driver, wdwait);
        elementsCheckboxPage = new ElementsCheckboxPage(driver, wdwait);
        elementsRadioButtonPage = new ElementsRadioButtonPage(driver, wdwait);
        excelReader = new ExcelReader("D:\\Projects\\Java\\DemoQA\\src\\test\\java\\base\\demoQA.xlsx");
        homeURL = excelReader.getStringData("URL",7,1);
    }

    public void scroll (WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",element);
    }

    @AfterClass
    public void tearDown(){
        //driver.manage().deleteAllCookies();
        //driver.close();
        //driver.quit();
    }
}
