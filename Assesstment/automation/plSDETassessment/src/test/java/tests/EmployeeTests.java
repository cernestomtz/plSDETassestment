package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DashboardPage;
import pages.EmployeeFormPage;
import pages.LoginPage;

import java.time.Duration;

public class EmployeeTests extends BaseTest {

    @Test
    public void addEmployee_withValidData_employeeAppearsInTable() {

        //  Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.loginAs("TestUser827", "]tn{?7A(*HA1");

        //  Dashboard
        DashboardPage dashboard = new DashboardPage(driver);
        int initialCount = dashboard.getEmployeesCount();

        String suffix = String.valueOf(System.currentTimeMillis());
        String lastName  = "autoLast_" + suffix;
        String firstName = "autoFirst_" + suffix;
        int dependents   = 2;

        System.out.println("[DEBUG] Generated names:");
        System.out.println("[DEBUG] firstName = " + firstName);
        System.out.println("[DEBUG] lastName  = " + lastName);

        // Open template and create employee
        dashboard.clickAddEmployee();
        EmployeeFormPage form = new EmployeeFormPage(driver);
        form.fillEmployee(firstName, lastName, dependents);
        form.submit();

        // Wait until one more row is added
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> dashboard.getEmployeesCount() == initialCount + 1);

        boolean found = dashboard.isEmployeeInTable(lastName, firstName);
        System.out.println("[DEBUG] Final found = " + found);

        Assertions.assertTrue(
                found,
                "The new employee with name " + firstName + " " + lastName +
                        " should be visible in the employees table"
        );
    }

    @Test
    public void editEmployee_withValidData_rowIsUpdated() {

        //  Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.loginAs("TestUser827", "]tn{?7A(*HA1");

        DashboardPage dashboard = new DashboardPage(driver);

        // Create an employee to be edited
        int initialCount = dashboard.getEmployeesCount();

        String suffix = String.valueOf(System.currentTimeMillis());
        String originalLastName  = "editLast_" + suffix;
        String originalFirstName = "editFirst_" + suffix;
        int originalDependents   = 1;

        System.out.println("[DEBUG][EDIT] Creating the employee: "
                + originalLastName + " / " + originalFirstName);

        dashboard.clickAddEmployee();
        EmployeeFormPage form = new EmployeeFormPage(driver);
        form.fillEmployee(originalFirstName, originalLastName, originalDependents);
        form.submit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until one more row is added
        wait.until(d -> dashboard.getEmployeesCount() == initialCount + 1);

        Assertions.assertTrue(
                dashboard.isEmployeeInTable(originalLastName, originalFirstName),
                "[EDIT] Created employee should be on the table before editing:"
        );

        // Creating new data for editing
        String newLastName  = originalLastName  + "_UPDATED";
        String newFirstName = originalFirstName + "_UPDATED";
        int newDependents   = 3;

        System.out.println("[DEBUG][EDIT] Editing employee: "
                + originalLastName + " / " + originalFirstName +
                "  ->  " + newLastName + " / " + newFirstName);

        // Click on the respective row to edit the employee
        dashboard.clickEditForEmployee(originalLastName, originalFirstName);

        // On the template, overwrite data and save
        EmployeeFormPage editForm = new EmployeeFormPage(driver);
        editForm.fillEmployee(newFirstName, newLastName, newDependents);
        editForm.update();

        // Wait for the updated data
        wait.until(d -> dashboard.isEmployeeInTable(newLastName, newFirstName));

        // Verify that old data is no longer present and new is found
        boolean oldStillThere = dashboard.isEmployeeInTable(originalLastName, originalFirstName);
        boolean newExists     = dashboard.isEmployeeInTable(newLastName, newFirstName);

        System.out.println("[DEBUG][EDIT] oldStillThere = " + oldStillThere);
        System.out.println("[DEBUG][EDIT] newExists     = " + newExists);

        Assertions.assertFalse(
                oldStillThere,
                "Old employee name should not be present after edit"
        );

        Assertions.assertTrue(
                newExists,
                "Updated employee with name " + newFirstName + " " + newLastName +
                        " should be visible in the employees table"
        );
    }

    @Test
    public void deleteEmployee_employeeShouldDisappear() {

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.loginAs("TestUser827", "]tn{?7A(*HA1");

        DashboardPage dashboard = new DashboardPage(driver);

        // Creating new employee
        int initialCount = dashboard.getEmployeesCount();
        String suffix = String.valueOf(System.currentTimeMillis());
        String originalLastName = "deleteLast_" + suffix;
        String originalFirstName = "deleteFirst_" + suffix;
        int originalDependents = 1;

        dashboard.clickAddEmployee();
        EmployeeFormPage form = new EmployeeFormPage(driver);
        form.fillEmployee(originalFirstName, originalLastName, originalDependents);
        form.submit();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> dashboard.getEmployeesCount() == initialCount + 1);

        Assertions.assertTrue(
                dashboard.isEmployeeInTable(originalLastName, originalFirstName),
                "[DELETE] New employee should exist on table before deleting"
        );

        // Click on delete employee
        dashboard.clickDeleteForEmployee(originalLastName, originalFirstName);

        // Confirm delete
        EmployeeFormPage editForm = new EmployeeFormPage(driver);
        editForm.deleteButton();

        // Wait to elimination of the employee
        wait.until(d -> !dashboard.isEmployeeInTable(originalLastName, originalFirstName));

        boolean stillExists = dashboard.isEmployeeInTable(originalLastName, originalFirstName);

        Assertions.assertFalse(
                stillExists,
                "[DELETE] Employee should not exist after deleting"
        );
    }

}