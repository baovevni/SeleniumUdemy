package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Expedia {
    WebDriver driver;
    String browserType = "Chrome";
    String city = "New York";
    String checkIn = "Sep 7";

    @Test
    public void hotelReservation() {

        // 1. Search
        driver.findElement(By.cssSelector(".has-no-placeholder > button:nth-child(3)")).click();
        driver.findElement(By.id("location-field-destination")).sendKeys(city);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#app > div:nth-child(1) > div.uitk-dialog-layer.uitk-dialog-layer-responsive.layer-overlay-active > div.uitk-dialog.uitk-dialog-fullscreen.uitk-dialog-fullscreen-bg-canvas.uitk-typeahead-dialog > div > div > ul > li:nth-child(1) > button ")).click();

        // 2. Modify search criteria
        // 3. Analyse the results and make selection

        // 4. Book the reservation

        // 5. Fill out contact billing

        // 6. Get the confirmation

    }

    @BeforeMethod
    public void setUp(){
        driver = utilities.DriverFactory.open(browserType);
        driver.get("https://www.expedia.com/?pwaLob=wizard-hotel-pwa-v2");
    }

//    @AfterMethod
//    public void tearDown(){
//        driver.quit();
//    }

}
