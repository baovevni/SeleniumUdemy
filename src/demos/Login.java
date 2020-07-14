package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    public static void main(String[] args) {
        // 1. Define the web driver
        System.setProperty("webdriver.chrome.driver", "C:\\seleniumDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // 2. Open web browser and navigate to application
        // https://boo2.test.payall.com/login
        driver.get("https://boo2.test.payall.com/login");

        // 3. Enter email
        driver.findElement(By.name("email")).sendKeys("evgheni.barducov@agilepartners.eu");

        // 4. Enter password
        driver.findElement(By.name("password")).sendKeys("Qwerty123!@#");

        // 5. Click Login
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/form/button/span/div/div")).click();

        // 6. Get confirmation

        String pageTitle = driver.getTitle();
//        System.out.println(pageTitle);
        if (pageTitle.equals("Payall - Backoffice")) {
            System.out.println("Title Correct");
        }

        // 7. Close the browser
        driver.close();

    }
}
