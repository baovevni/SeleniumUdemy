package smokeTests;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPresentTestNG {
    WebDriver driver;


    @Test
    public void loginElementsPresentTest() {
        System.out.println("Running Test");
        boolean loginEmailBox = driver.findElement(By.id("email_create")).isDisplayed();
        boolean buttonCreatePresent = driver.findElement(By.id("SubmitCreate")).isDisplayed();

        Assert.assertTrue(loginEmailBox);
        Assert.assertTrue(buttonCreatePresent);
    }

    @BeforeMethod
    public void setUp(){
        System.out.println("Starting Test");
        String webUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

        driver = utilities.DriverFactory.open("chrome");
        driver.get(webUrl);
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Closing Test");
        driver.close();
    }
}
