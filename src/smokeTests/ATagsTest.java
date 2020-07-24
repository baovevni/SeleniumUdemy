package smokeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ATagsTest {
    WebDriver driver;

    @Test
    public void loginElementsPresentTest() {
        System.out.println("Running Test");
        boolean signInPresent = false;

        List<WebElement> aElements = driver.findElements(By.tagName("a"));

        int numberOfAElements = aElements.size();
        System.out.println("There are " + numberOfAElements + " a tags on the page");

        for (WebElement aElement : aElements) {
            System.out.println(aElement.getText());
            if (aElement.getText().equals("Sign in")) {
                signInPresent = true;
                break;
            }
        }
        Assert.assertTrue(signInPresent);
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
