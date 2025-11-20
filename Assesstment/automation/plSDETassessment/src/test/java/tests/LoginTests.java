package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class   LoginTests extends BaseTest {

    @Test
    public void loginWithValidCredentials_opensDashboard() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.open();
        loginPage.loginAs("TestUser827", "]tn{?7A(*HA1");

        String title = driver.getTitle();
        System.out.println("Page title is: " + title);

        Assertions.assertTrue(
                title.contains("Paylocity Benefits Dashboard"),
                "The user should land on the dashboard after login"
        );
    }

    @Test
    public void loginWithInvalidCredentials_showsError() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.open();
        loginPage.loginAs("TestUser827", "]tn{?7A(*HA");

        String error = loginPage.getErrorMessage();
        System.out.println("Error message: " + error);

        Assertions.assertTrue(
                error.toLowerCase().contains("invalid")
                        || error.toLowerCase().contains("incorrect")
                        || error.toLowerCase().contains("failed"),
                "An error message should be displayed for invalid credentials"
        );
    }
}
