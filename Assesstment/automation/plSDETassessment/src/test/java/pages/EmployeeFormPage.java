package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeeFormPage {

    private WebDriver driver;

    private By firstNameInput    = By.xpath("//input[@id='firstName']");
    private By lastNameInput     = By.xpath("//input[@id='lastName']");
    private By dependentsInput   = By.xpath("//input[@id='dependants']");
    private By addButton         = By.xpath("//button[@id='addEmployee']");
    private By updateButton      = By.xpath("//button[@id='updateEmployee']");
    private By deleteButton      = By.xpath("//button[@id='deleteEmployee']");

    public EmployeeFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillEmployee(String firstName, String lastName, int dependents) {
        driver.findElement(firstNameInput).clear();
        driver.findElement(firstNameInput).sendKeys(firstName);

        driver.findElement(lastNameInput).clear();
        driver.findElement(lastNameInput).sendKeys(lastName);

        driver.findElement(dependentsInput).clear();
        driver.findElement(dependentsInput).sendKeys(String.valueOf(dependents));
    }

    public void submit() {
        driver.findElement(addButton).click();
    }

    public void update() {
        driver.findElement(updateButton).click();
    }

    public void deleteButton() {
        driver.findElement(deleteButton).click();
    }
}
