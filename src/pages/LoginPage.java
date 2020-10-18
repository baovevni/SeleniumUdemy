package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public void setUserName(String username) {
        driver.findElement(By.id("email")).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(By.id("passwd")).sendKeys(password);
    }

    public void clickSubmit() {
        driver.findElement(By.id("SubmitLogin")).click();
    }

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

}
