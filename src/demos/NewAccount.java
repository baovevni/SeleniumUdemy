package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class NewAccount {
    public static void main(String[] args) throws InterruptedException {

        String fname = "John";
        String lname = "Travolta";
        String email = "awcdf@abc.com";
        String password = "Qwerty123!";
        String birthDay = "21";
        String birthMonth = "12";
        String birthYear = "1987";
        String company = "Agile";
        String address = "135, Stefan Cel Mare str.";
        String address2 = "office 2";
        String city = "Chisinau";
        String state = "California";
        String zipCode = "12345";
        String country = "United States";
        String other = "Lorem ipsum dolor sit amet";
        String phone = "132456789";
        String alias = "Alias1";
        String browserType = "chrome";
        String gender = "Male";
        boolean newsletter = true;
        boolean offers = false;
        boolean information = false;

        // Define Web Driver
        WebDriver driver;
        driver = utilities.DriverFactory.open(browserType);

        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        driver.findElement(By.xpath("//*[@id=\"email_create\"]")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]")).click();
        Thread.sleep(2500);

        // Define Web elements

        WebElement maleRadio = driver.findElement(By.cssSelector("input[name='id_gender'][value='1']"));
        WebElement femaleRadio = driver.findElement(By.cssSelector("input[name='id_gender'][value='2']"));
        WebElement fnameElement = driver.findElement(By.xpath("//*[@id=\"customer_firstname\"]"));
        WebElement lnameElement = driver.findElement(By.id("customer_lastname"));
        WebElement passwordElement = driver.findElement(By.cssSelector("input[id='passwd']"));
//        WebElement passwordElement = driver.findElement(By.name("passwd"));
        WebElement daysElement = driver.findElement(By.id("days"));
        WebElement monthsElement = driver.findElement(By.id("months"));
        WebElement yearsElement = driver.findElement(By.id("years"));
        WebElement newsletterElement = driver.findElement(By.id("newsletter"));
        WebElement optionElement = driver.findElement(By.id("optin"));
        WebElement companyElement = driver.findElement(By.id("company"));
        WebElement address1Element = driver.findElement(By.id("address1"));
        WebElement address2Element = driver.findElement(By.id("address2"));
        WebElement cityElement = driver.findElement(By.id("city"));
        WebElement stateElement = driver.findElement(By.id("id_state"));
        WebElement postcodeElement = driver.findElement(By.id("postcode"));
        WebElement countryElement = driver.findElement(By.id("id_country"));
        WebElement otherElement = driver.findElement(By.id("other"));
        WebElement phoneElement = driver.findElement(By.id("phone_mobile"));
        WebElement aliasElement = driver.findElement(By.id("alias"));
        WebElement submittAccountElement = driver.findElement(By.id("submitAccount"));
//        WebElement pageHeadingElement = driver.findElement(By.cssSelector(".page-heading"));


        // 3. Fill out the form
        if (gender.equalsIgnoreCase("Male")){
            maleRadio.click();
        }
        else
        {
            femaleRadio.click();
        }

        // Checkbox algorythm
        if (newsletter) {
            if (!newsletterElement.isSelected()){
                newsletterElement.click();
            }
        }
        else {
            if (newsletterElement.isSelected()){
                newsletterElement.click();
            }
        }

        fnameElement.sendKeys(fname);
        lnameElement.sendKeys(lname);
        passwordElement.sendKeys(password);
//        passwordElement.sendKeys("Qwerty123!");
        new Select(daysElement).selectByValue(birthDay);
        new Select(monthsElement).selectByValue(birthMonth);
//        Select years = new Select(driver.findElement(By.id("years")));
//        years.selectByValue("1987");
        new Select(yearsElement).selectByValue(birthYear);
//        newsletterElement.click();
        optionElement.click();
        companyElement.sendKeys(company);
        address1Element.sendKeys(address);
        address2Element.sendKeys(address2);
        cityElement.sendKeys(city);
        new Select(stateElement).selectByVisibleText(state);
        postcodeElement.sendKeys(zipCode);
        new Select(countryElement).selectByVisibleText(country);
        otherElement.sendKeys(other);
        phoneElement.sendKeys(phone);
        aliasElement.sendKeys(alias);
        submittAccountElement.click();

        // 4. Get Confirmation
        String confirmation = driver.findElement(By.cssSelector(".page-heading")).getText();
        String expected = "MY ACCOUNT";
        if (confirmation.contains(expected)) {
            System.out.println("Confirmation " + confirmation);
        }
        else {
            System.out.println("Test FAILED");
        }


        Thread.sleep(2000);

        // 5. Close the browser
        driver.close();
    }
}
