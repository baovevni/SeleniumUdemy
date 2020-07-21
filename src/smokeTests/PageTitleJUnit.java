package smokeTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class PageTitleJUnit {

    WebDriver driver;
    String webURL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    @Test
    public void pageTitleTest(){
        System.out.println("Running the test");
        driver.get(webURL);
        String actualTitle = driver.getTitle();
        String expectedeTitle = "Login - My Store";
        Assert.assertEquals(expectedeTitle, actualTitle);

    }
    @Before
    public void setUp (){
        System.out.println("Initializing the Driver");
        driver = utilities.DriverFactory.open("chrome");
    }

    @After
    public void tearDown (){
        System.out.println("Closing the Driver");
        driver.close();
    }
}
