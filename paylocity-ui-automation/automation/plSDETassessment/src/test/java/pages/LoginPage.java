package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By usernameInput = By.xpath("//input[@id='Username']");
    private By passwordInput = By.xpath("//input[@id='Password']");
    private By loginButton   = By.xpath("//button[normalize-space()='Log In']");
    private By errorMessage  = By.cssSelector(".validation-summary-errors, .alert-danger");

    private String url = "https://wmxrwq14uc.execute-api.us-east-1.amazonaws.com/Prod/Account/Login";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(url);
    }

    public void typeUsername(String username) {
        driver.findElement(usernameInput).clear();
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void typePassword(String password) {
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void loginAs(String username, String password) {
        typeUsername(username);
        typePassword(password);
        clickLogin();
    }

    public String getErrorMessage() {
        try {
            return driver.findElement(errorMessage).getText();
        } catch (Exception e) {
            return "";
        }
    }
}
