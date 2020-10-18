package stepImplementations;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BDDLoginTest {

    WebDriver driver;

    @Given("^user is on the login page$")
    public void user_is_on_the_login_page() {
        System.out.println("User is on the login page");
        driver = utilities.DriverFactory.open("Firefox");
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }

    @When("^user enters correct username and correct password$")
    public void user_enters_correct_username_and_correct_password() {
        System.out.println("User enters username and password");
        driver.findElement(By.id("email")).sendKeys("awcdf@abc.co");
        driver.findElement(By.id("passwd")).sendKeys("Qwerty123!");
        driver.findElement(By.id("SubmitLogin")).click();
    }

    @When("^user enters email (.*))$")
    public void user_enters_username(String username) {
        System.out.println("Testing " + username);
        driver.findElement(By.id("email")).sendKeys(username);
    }

    @And("^user enters password (.*)$")
    public void user_enters_password(String password) {
        driver.findElement(By.id("passwd")).sendKeys(password);
    }

    @And("^user clicks login button$")
    public void user_clicks_login_button() {
        driver.findElement(By.id("SubmitLogin")).click();
    }

    @Then("^user gets confirmation$")
    public void user_gets_confirmation() {
        System.out.println("User gets confimation");
        Assert.assertTrue(driver.findElement(By.cssSelector(".page-heading")).getText().contains("Account"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
