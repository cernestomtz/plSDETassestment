# Paylocity UI Automation – SDET Assessment

This directory contains the **UI Automation Project** developed for the **Paylocity SDET Assessment**.

The project is built with:

- **Java 17**
- **Maven**
- **Selenium WebDriver**
- **JUnit 5**
- **Page Object Model (POM) Architecture**
- **WebDriverManager** (no manual driver setup required)

---

##  1. Requirements

Before running the project, please ensure the following are installed:

###  Java JDK 17+
Verify with:

java -version

###  Maven 3.8+

###  IntelliJ IDEA

###  Google Chrome (latest stable)


##  2. Downloading the Project
Clone the repository and navigate to the UI automation folder
Alternatively, you may download the ZIP from GitHub and open this folder.


##  3. Opening the Project in IntelliJ
- Open IntelliJ IDEA
- Click File > Open
- Select the folder:
- Wait until "Indexing…" and "Importing Maven projects…" finish.


## 4. Project Structure
      src
      └─ test
         └─ java
            ├─ base
            │   └─ BaseTest.java
            ├─ pages
            │   ├─ LoginPage.java
            │   ├─ DashboardPage.java
            │   └─ EmployeeFormPage.java
            └─ tests
                ├─ LoginTests.java
                ├─ EmployeeTests.java
                └─ SmokeOpenLoginTest.java


## 5. Running Tests in IntelliJ (Recommended)
        1. Go to: src/test/java/tests
        2. Right-click any test class: LoginTests; EmployeeTests and SmokeOpenLoginTest
        3. Click Run 'ClassName'.
        4. Run all tests together: Right-click the tests package > Run 'Tests in tests'.

If you need additional instructions, enhancements, or formatting changes, I’ll gladly help.

