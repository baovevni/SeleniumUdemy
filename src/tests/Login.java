package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;

public class Login {

    @Test
    public void loginTestPOM(){
        // 1. Initialize the driver
        WebDriver driver = utilities.DriverFactory.open("Firefox");
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

        // 2. Enter login information (Login Page)
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("awcdf@abc.com");
        loginPage.setPassword("Qwerty123!");
        loginPage.clickSubmit();

        // 3. Get Confirmation (Dashboard)
        DashboardPage dashboardage = new DashboardPage(driver);
        String confirmation = dashboardage.confirmationMessage();
        String title = dashboardage.title();

        // 4. Assertions
        Assert.assertTrue(confirmation.contains("ACCOUNT"));
        Assert.assertTrue(title.contains("Store"));

        // 5. Close the driver
//        driver.quit();
    }



}
