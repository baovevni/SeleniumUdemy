package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {
    public static void main(String[] args) throws InterruptedException {
        // 1. Create WebDriver
        System.setProperty("webdriver.gecko.driver", "C:\\seleniumDrivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        // 2. Navigate to Create Account page, click on Create Account
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        driver.findElement(By.xpath("//*[@id=\"email_create\"]")).sendKeys("afs2@abc.com");
        driver.findElement(By.cssSelector(".icon-user")).click();
        Thread.sleep(1500);

        // 3. Fill out the form
//        driver.findElement(By.xpath("//*[@id=\"id_gender1\"]")).click();
//        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.cssSelector("input[name='id_gender'][value='1']")).click();
        driver.findElement(By.xpath("//*[@id=\"customer_firstname\"]")).sendKeys("Evgheni");
        driver.findElement(By.id("customer_lastname")).sendKeys("Barducov");
        driver.findElement(By.cssSelector("input[id='passwd']")).sendKeys("Qwerty123!");
//        driver.findElement(By.name("passwd")).sendKeys("Qwerty123!");
//        Select days = new Select(driver.findElement(By.id("days")));
//        days.selectByValue("21");
        new Select(driver.findElement(By.id("days"))).selectByValue("21");
//        Select months = new Select(driver.findElement(By.id("months")));
//        months.selectByValue("12");
        new Select(driver.findElement(By.id("months"))).selectByValue("12");
//        Select years = new Select(driver.findElement(By.id("years")));
//        years.selectByValue("1987");
        new Select(driver.findElement(By.id("years"))).selectByValue("1987");
        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();
//        driver.findElement(By.id("firstname")).sendKeys("Evgheni");
//        driver.findElement(By.id("lastname")).sendKeys("Barducov");
        driver.findElement(By.id("company")).sendKeys("Agile");
        driver.findElement(By.id("address1")).sendKeys("135, Stefan Cel Mare str.");
        driver.findElement(By.id("address2")).sendKeys("office 2");
        driver.findElement(By.id("city")).sendKeys("Chisinau");
        Select state = new Select(driver.findElement(By.id("id_state")));
        state.selectByVisibleText("California");
        driver.findElement(By.id("postcode")).sendKeys("12345");
        Select country = new Select(driver.findElement(By.id("id_country")));
        country.selectByValue("21");
        driver.findElement(By.id("other")).sendKeys("Lorem ipsum dolor sit amet");
        driver.findElement(By.id("phone_mobile")).sendKeys("132456789");
        driver.findElement(By.id("alias")).sendKeys("Alias1");
        driver.findElement(By.id("submitAccount")).click();

        // 4. Get Confirmation
        String confirmation = driver.findElement(By.cssSelector(".page-heading")).getText();
        System.out.println("Confirmation " + confirmation);
        Thread.sleep(2000);

        // 5. Close the browser
        driver.close();
    }
}
