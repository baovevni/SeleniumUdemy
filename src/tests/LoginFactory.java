package tests;

import org.openqa.selenium.WebDriver;
import pages.LoginPageFactory;

public class LoginFactory {

    String username = "awcdf@abc.com";
    String password = "Qwerty123!";

    public void loginTestPageFactory() {
        // 1. Initialize the driver
        WebDriver driver = utilities.DriverFactory.open("Firefox");
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

        // 2. Enter Login
        LoginPageFactory loginPage = new LoginPageFactory(driver);
        loginPage.login(username, password);

    }
}
