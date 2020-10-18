package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    WebDriver driver;

    public String confirmationMessage() {
        return driver.findElement(By.cssSelector(".page-heading")).getText();
    }

    public String title() {
        return driver.getTitle();
    }

    public void orderHistory() {
        driver.findElement(By.linkText("http://automationpractice.com/index.php?controller=history")).click();
    }

    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }
}
