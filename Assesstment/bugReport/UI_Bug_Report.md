# PL Benefits Login – UI Bug Report

## Bug ID: UI-001  
**Title:** Login page miss the 'Forgot password' link 
**Scenario:** 1 Add Employee

**Severity:** Low  
**Environment:** https://wmxrwq14uc.execute-api.us-east-1.amazonaws.com/Prod/Account/Login  
**System and Version** Windows 11 - 64bits - Chrome 142.0.7444.60
**Reported by:** Ernesto Martínez  
**Date:** 2025-11-04  

### Steps to Reproduce:
1. Navigate to the login page
2. Enter the valid user
3. Enter wrong password
4. Click on the 'Log In' button


### Actual Result:
- The system does not have 'Forgot password' link

### Expected Result:
- The system should have a 'Forgot password' link for user who forgot their credentials

### Notes:
- This bug is going forward than the provided scenarios but is an scential feature for development


## Bug ID: UI-002  
**Title:** Login page miss the 'Create Account' link 
**Scenario:** 1 Add Employee

**Severity:** Low  
**Environment:** https://wmxrwq14uc.execute-api.us-east-1.amazonaws.com/Prod/Account/Login  
**System and Version** Windows 11 - 64bits - Chrome 142.0.7444.60
**Reported by:** Ernesto Martínez  
**Date:** 2025-11-04  

### Steps to Reproduce:
1. Navigate to the login page


### Actual Result:
- The system does not have 'Create account' link

### Expected Result:
- The system should have a 'Create account' link for user who want to use the system but does not have an account

### Notes:
- This bug is going forward than the provided scenarios but is an scential feature for development


## Bug ID: UI-003  
**Title:** Login button unresponsive, returns HTTP 405 instead of authenticating 
**Scenario:** 1 Add Employee

**Severity:** High  
**Environment:** https://wmxrwq14uc.execute-api.us-east-1.amazonaws.com/Prod/Account/Login  
**Reported by:** Ernesto Martínez  
**Date:** 2025-11-04  

### Steps to Reproduce:
1. Navigate to the login page
2. Enter the invalid user
3. Enter any password
4. Click on the 'Log In' button


### Actual Result:
- The system returns HTTP 405 'Method Not Allowed' and prevents access to the Benefits Dashboard.

### Expected Result:
- The system should have a 'Forgot password' link for user who forgot their credentials

### Notes:
- This bug is going forward than the provided scenarios but is an scential feature for development
- Dev Tool > Console > Network report > 405 Method Not Allowed > Response Header > Allow > GET
- Endpoint `/Account/Login` only accepts GET requests.
- This prevents users from logging in, effectively blocking the UI flow.


## Bug ID: UI-004 
**Title:** Alert text is visible on html dom tree withou trigger
**Scenario:** 1 Add Employee

**Severity:** Low  
**Environment:** https://wmxrwq14uc.execute-api.us-east-1.amazonaws.com/Prod/Account/Login  
**Reported by:** Ernesto Martínez  
**Date:** 2025-11-04  

### Steps to Reproduce:
1. Navigate to the login page
2. Open developer tools
3. Dev Tool > Element > 'Div container' 


### Actual Result:
- The html dom tree show the alert container without a trigger

### Expected Result:
- The system should not any text that is not triggered

### Notes:
- This bug is going forward than the provided scenarios but is an scential feature for development


## Bug ID: UI-005 
**Title:** Add Employee template does not have validations message
**Scenario:** 1 Add Employee

**Severity:** Medium  
**Environment:** https://wmxrwq14uc.execute-api.us-east-1.amazonaws.com/Prod/Account/Login  
**Reported by:** Ernesto Martínez  
**Date:** 2025-11-04  

### Steps to Reproduce:
1. Navigate to the login page
2. Enter valid credentials
3. Click on 'Add Employee' button
4. Enter 'First Name' and 'Last Name' with only one character or numbers
5. Enter number of dependents
6. Click on 'Add' button


### Actual Result:
- User is able to save employees with only one character or number as first name or last name
- User is able to have up to 32 dependents

### Expected Result:
- User should be able to save only valid first and last names
- Dependents should have a reasonable number of dependents

### Notes:
- Validations should be defined either in functional requeried document, jira story, or a place where development team can verify the requeriments


## Bug ID: UI-006 
**Title:** Add Employee template does not show errors
**Scenario:** 1 Add Employee

**Severity:** Medium  
**Environment:** https://wmxrwq14uc.execute-api.us-east-1.amazonaws.com/Prod/Account/Login  
**Reported by:** Ernesto Martínez  
**Date:** 2025-11-04  

### Steps to Reproduce:
1. Navigate to the login page
2. Enter valid credentials
3. Click on 'Add Employee' button
4. Leave template in blank
5. Click on 'Add' button
6. Enter 'First Name' and 'Last Name' with only one character or numbers
7. Enter a negative number of dependents
8. Click on 'Add' button
9. Delete number of dependents and enter a character on the field
10. Click on 'Add' button
11. Enter a invalid number of dependents (33 or above)
12. Click on 'Add' button
13. Enter a valid number of dependents (0 to 32)
14. Delete 'First Name'
15. Click on 'Add' button
16. Enter a 'First Name' and delete 'Last Name'
17. Click on 'Add' button


### Actual Result:
- User could not verify why when 'Add' is clicked, no action is performed

### Expected Result:
- User should be able to know why when it is clicked 'Add' button, no action is performed

### Notes:
- Dev Tool > Network report > 405 Method not allowed 
- Dev Tool > Console > Failed to load resource: the server responded with a status of 405
- Validation should apply for: short entries, long entries, wrong format (only numbers), and others.


## Bug ID: UI-007 
**Title:** User could not enter identifier to person who has the same first name and last name
**Scenario:** 1 Add Employee

**Severity:** Low  
**Environment:** https://wmxrwq14uc.execute-api.us-east-1.amazonaws.com/Prod/Account/Login  
**Reported by:** Ernesto Martínez  
**Date:** 2025-11-04  

### Steps to Reproduce:
1. Navigate to the login page
2. Enter valid credentials
3. Click on 'Add Employee' button
4. Enter 'First Name' and 'Last Name' 
5. Enter number of dependents
6. Click on 'Add' button
7. Repeat step 3 - 5 with same data


### Actual Result:
- User is able to save employees with same first name and last name

### Expected Result:
- Table should have an extra column to have any other identifier data (like social secure number or tax Id)

### Notes:
- Will be useful to have an extra column to have any other identifier data for employees who share first name and last name


## Bug ID: UI-008 
**Title:** New Employeers does not get into the table in an logical order
**Scenario:** 1 Add Employee

**Severity:** Low  
**Environment:** https://wmxrwq14uc.execute-api.us-east-1.amazonaws.com/Prod/Account/Login  
**Reported by:** Ernesto Martínez  
**Date:** 2025-11-04  

### Steps to Reproduce:
1. Navigate to the login page
2. Enter valid credentials
3. Click on 'Add Employee' button
4. Enter 'First Name' and 'Last Name' 
5. Enter number of dependents
6. Click on 'Add' button
7. Repeat step 3 - 6 multiple times


### Actual Result:
- New entries get in order for ID, which not make business sense

### Expected Result:
- New entries should follow logical order (for example: from first to last, from last to first, alphabetical order, and others)


## Bug ID: UI-009 
**Title:** Text boxes accept HTML injection
**Scenario:** 1 Add Employee

**Severity:** Ultra high  
**Environment:** https://wmxrwq14uc.execute-api.us-east-1.amazonaws.com/Prod/Account/Login  
**Reported by:** Ernesto Martínez  
**Date:** 2025-11-04  

### Steps to Reproduce:
1. Navigate to the login page
2. Enter valid credentials
3. Click on 'Add Employee' button
4. Enter 'First Name' and 'Last Name' with html injection
5. Enter number of dependents
6. Click on 'Add' button
7. Verify how table is reading the html injection


### Actual Result:
- New entries accept html injections

### Expected Result:
- New entries should not accept html injection, or should clean the tags
- When edit entry applies, template clear the tags, some similar behavior for add employee will be useful


## Bug ID: UI-010 
**Title:** Double click on add create a duplicate entry
**Scenario:** 1 Add Employee

**Severity:** Low  
**Environment:** https://wmxrwq14uc.execute-api.us-east-1.amazonaws.com/Prod/Account/Login  
**Reported by:** Ernesto Martínez  
**Date:** 2025-11-04  

### Steps to Reproduce:
1. Navigate to the login page
2. Enter valid credentials
3. Click on 'Add Employee' button
4. Enter 'First Name' and 'Last Name' 
5. Enter number of dependents
6. Click on 'Add' button twice (fast)
7. Verify how table got two entries with same info


### Actual Result:
- Double click create a duplicate entries

### Expected Result:
- Doble click should create a single record


## Bug ID: UI-011 
**Title:** User is able to get into benefit dashboard without login
**Scenario:** 1 Add Employee

**Severity:** High  
**Environment:** https://wmxrwq14uc.execute-api.us-east-1.amazonaws.com/Prod/Account/Login  
**Reported by:** Ernesto Martínez  
**Date:** 2025-11-04  

### Steps to Reproduce:
1. Navigate to the login page
2. Click on the 'Paylocity Benefit Dashboard' button
3. Click on 'Add Employee'
4. Fill the template
5. Click on 'Add' button


### Actual Result:
- The system returns HTTP 401 'Unauthorized' and prevents user could add employees

### Expected Result:
- The system should not allow user to get into benefit dashboard without login

### Notes:
- This bug is going forward than the provided scenarios but is an scential feature for development
- Dev Tool > Network report > 401 Unauthorized 
- Dev Tool > Console > Failed to load resource: the server responded with a status of 403


## Bug ID: UI-012 
**Title:** Update with blank template does not show validations
**Scenario:** 2 Edit Employee

**Severity:** Medium  
**Environment:** https://wmxrwq14uc.execute-api.us-east-1.amazonaws.com/Prod/Account/Login  
**Reported by:** Ernesto Martínez  
**Date:** 2025-11-04  

### Steps to Reproduce:
1. Navigate to the login page
2. Enter valid credentials
3. Click on 'Edit Employee' button
4. Leave template in blank
5. Click on 'Update' button
6. Enter 'First Name' and 'Last Name' with only one character or numbers
7. Enter a negative number of dependents
8. Click on 'Update' button
9. Delete number of dependents and enter a character on the field
10. Click on 'Update' button
11. Enter a invalid number of dependents (33 or above)
12. Click on 'Update' button
13. Enter a valid number of dependents (0 to 32)
14. Delete 'First Name'
15. Click on 'Update' button
16. Enter a 'First Name' and delete 'Last Name'
17. Click on 'Update' button


### Actual Result:
- User could not verify why when 'Update' is clicked, no action is performed

### Expected Result:
- User should be able to know why when it is clicked 'Update' button, no action is performed

### Notes:
- Dev Tool > Network report > 405 Method not allowed 
- Dev Tool > Console > Failed to load resource: the server responded with a status of 405
- Validation should apply for: short entries, long entries, wrong format (only numbers), and others.


## Bug ID: UI-013 
**Title:** Edit accept HTML injection
**Scenario:** 2 Edit Employee

**Severity:** Ultra high  
**Environment:** https://wmxrwq14uc.execute-api.us-east-1.amazonaws.com/Prod/Account/Login  
**Reported by:** Ernesto Martínez  
**Date:** 2025-11-04  

### Steps to Reproduce:
1. Navigate to the login page
2. Enter valid credentials
3. Click on 'Edit Employee' button
4. Enter 'First Name' and 'Last Name' with html injection
5. Enter number of dependents
6. Click on 'Update' button
7. Verify how table is reading the html injection
8. Click on 'Edit Employee' button
9. Verify how the tag is deleted


### Actual Result:
- Edit entries accept html injections

### Expected Result:
- Edit entries should not accept html injection, or should clean the tags as happen after edit an employee with html injection


## Bug ID: UI-014 
**Title:** Page is not properly redered
**Scenario:** 2 Edit Employee

**Severity:** Very Low  
**Environment:** https://wmxrwq14uc.execute-api.us-east-1.amazonaws.com/Prod/Account/Login  
**Reported by:** Ernesto Martínez  
**Date:** 2025-11-04  

### Steps to Reproduce:
1. Navigate to the login page
2. Enter valid credentials
3. Make the windows very small (half size or below)


### Actual Result:
- Page is not properly rendered, most of the cases left line table got middle and edit/delete button does not match with table

### Expected Result:
- Page should remain format


## Bug ID: UI-015 
**Title:** Button section will be helpful if remains
**Scenario:** 2 Edit Employee

**Severity:** Very Low  
**Environment:** https://wmxrwq14uc.execute-api.us-east-1.amazonaws.com/Prod/Account/Login  
**Reported by:** Ernesto Martínez  
**Date:** 2025-11-04  

### Steps to Reproduce:
1. Navigate to the login page
2. Enter valid credentials
3. Navigate trough a long table to find 'Add Employee' buttom


### Actual Result:
- When a long table is displayed, user needs to navigate to the bottom in order to find 'Add Employee' button

### Expected Result:
- User should not have any blocker to keep interuacting with UI 

## Bug ID: UI-016 
**Title:** First name and last name get stored backward
**Scenario:** 1 Add Employee

**Severity:** High  
**Environment:** https://wmxrwq14uc.execute-api.us-east-1.amazonaws.com/Prod/Account/Login  
**Reported by:** Ernesto Martínez  
**Date:** 2025-11-04  

### Steps to Reproduce:
1. Navigate to the login page
2. Enter valid credentials
3. Click on 'Add Employee' button
4. Enter 'First Name' and 'Last Name' 
5. Click on 'Add' button
6. Verify how first name got stored in last name column, and same with last name


### Actual Result:
- When a user input a new employee, it got store backward

### Expected Result:
- When a user input a new employee, first name and last name should be stored in the respective column
