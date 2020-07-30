package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDDT {
    WebDriver driver;
    @Test(dataProvider = "getData")
    public void loginTest(String email, String password) {

        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("passwd")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]")).click();

        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.equals("My account - My Store"));

        System.out.println(pageTitle);
        if (pageTitle.equals("My account - My Store")) {
            System.out.println("Title Correct");
        }
    }

    @BeforeMethod
    public void setUp() {
        driver = utilities.DriverFactory.open("Firefox");
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @DataProvider
    public String[][] getData() {
        return utilities.Excel.get("C:\\seleniumDrivers\\SelenimUdemy\\UserLogin.xls");
    }
}
