package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
    WebDriver driver;

    // Define Web Elements at Class level
    @FindBy(id = "email")
    WebElement userNameBox;

    @FindBy(id = "passwd")
    WebElement passwordBox;

    @FindBy(id = "SubmitLogin")
    WebElement loginButton;

    // Steps
    public void setUserName(String username) {
        userNameBox.sendKeys(username);
    }

    public void setPassword(String password) {
        passwordBox.sendKeys(password);
    }

    public void clickSubmit() {
        loginButton.click();
    }

    // Actions
    public void login(String username, String password){
        setUserName(username);
        setPassword(password);
        clickSubmit();
    }

    // Constructor initializes the state of the driver
    public LoginPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
