package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DashboardPage {

    private WebDriver driver;

    private By addEmployeeButton  = By.id("add");
    private By employeesTableRows = By.cssSelector("#employeesTable tbody tr");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    // Basic Actions
    public void clickAddEmployee() {
        driver.findElement(addEmployeeButton).click();
    }

    public int getEmployeesCount() {
        List<WebElement> rows = driver.findElements(employeesTableRows);
        System.out.println("[DEBUG][getEmployeesCount] Rows in table: " + rows.size());
        return rows.size();
    }

    // Rows reading

    private boolean rowMatches(WebElement row, String lastName, String firstName) {
        List<WebElement> cells = row.findElements(By.tagName("td"));
        if (cells.size() < 3) {
            return false;
        }

        /* Table order:
         0 = Id
         1 = First Name
         2 = Last Name
         Table is showing data backwards, in form when user input first and last name it goes saved swapped
         */

        String rowLast  = cells.get(2).getText().trim();
        String rowFirst = cells.get(1).getText().trim();

        System.out.println("[DEBUG][rowMatches] Raw -> last='" +
                rowLast + "', first='" + rowFirst + "'");

        return rowLast.equals(lastName) && rowFirst.equals(firstName);
    }

    public boolean isEmployeeInTable(String lastName, String firstName) {
        System.out.println("[DEBUG][isEmployeeInTable] Searching in table: "
                + lastName + " / " + firstName);

        List<WebElement> rows = driver.findElements(employeesTableRows);
        System.out.println("[DEBUG][isEmployeeInTable] Total rows: " + rows.size());

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.size() < 3) {
                continue;
            }

            String rowLast  = cells.get(2).getText().trim();
            String rowFirst = cells.get(1).getText().trim();

            System.out.println("[DEBUG][isEmployeeInTable] Row -> last='"
                    + rowLast + "', first='" + rowFirst + "'");

            if (rowLast.equals(lastName) && rowFirst.equals(firstName)) {
                System.out.println("[DEBUG][isEmployeeInTable] Employee found");
                return true;
            }
        }

        System.out.println("[DEBUG][isEmployeeInTable] Employee NOT found");
        return false;
    }

    // Search location in table

    private int findEmployeeRowIndex(String lastName, String firstName) {
        List<WebElement> rows = driver.findElements(employeesTableRows);
        System.out.println("[DEBUG][findEmployeeRowIndex] Total rows = " + rows.size());

        for (int i = 0; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.size() < 3) {
                continue;
            }

            String rowLast  = cells.get(2).getText().trim();
            String rowFirst = cells.get(1).getText().trim();

            System.out.println("[DEBUG][findEmployeeRowIndex] Row " + i +
                    " -> last='" + rowLast + "', first='" + rowFirst + "'");

            if (rowLast.equals(lastName) && rowFirst.equals(firstName)) {
                System.out.println("[DEBUG][findEmployeeRowIndex] *** Match on row " + i);
                return i;
            }
        }

        System.out.println("[DEBUG][findEmployeeRowIndex] Employee NOT found");
        return -1;
    }

    // Clickin edit on the row where the employee was found

    public void clickEditForEmployee(String lastName, String firstName) {
        System.out.println("[DEBUG][clickEditForEmployee] Searching for employee to be edited: "
                + lastName + " / " + firstName);

        int rowIndex = findEmployeeRowIndex(lastName, firstName);
        if (rowIndex == -1) {
            throw new RuntimeException(
                    "Employee is not located on this row: "
                            + lastName + " / " + firstName);
        }

        List<WebElement> rows = driver.findElements(employeesTableRows);
        WebElement row = rows.get(rowIndex);
        List<WebElement> cells = row.findElements(By.tagName("td"));

        if (cells.isEmpty()) {
            throw new RuntimeException(
                    "The row " + rowIndex + " does not have any action button");
        }

        // Using the last cell as the container for the action buttons
        WebElement actionsCell = cells.get(cells.size() - 1);

        // Searching for any clickable element in the cell
        List<WebElement> clickable =
                actionsCell.findElements(By.cssSelector("a, button, span, i"));

        if (clickable.isEmpty()) {
            System.out.println("[DEBUG][clickEditForEmployee] NO action, directly clicking on<td> (row "
                    + rowIndex + ")");
            actionsCell.click();
        } else {
            WebElement target = clickable.get(0);
            System.out.println("[DEBUG][clickEditForEmployee] Click on the action elements (row "
                    + rowIndex + "), tag=" + target.getTagName());
            target.click();
        }
    }

    public void clickDeleteForEmployee(String lastName, String firstName) {
        System.out.println("[DEBUG][clickDeleteForEmployee] Searching for the employee to be deleted: "
                + lastName + " / " + firstName);

        List<WebElement> rows = driver.findElements(employeesTableRows);

        for (WebElement row : rows) {

            if (rowMatches(row, lastName, firstName)) {

                List<WebElement> cells = row.findElements(By.tagName("td"));
                WebElement actionsCell = cells.get(cells.size() - 1);

                // Second action button = Delete
                WebElement deleteButton =
                        actionsCell.findElement(By.cssSelector(".fas.fa-times"));

                System.out.println("[DEBUG][clickDeleteForEmployee] Click on Delete");
                deleteButton.click();
                return;
            }
        }

        throw new RuntimeException(
                "Employee to be deleted NOT FOUND: "
                        + lastName + " / " + firstName);
    }

}
