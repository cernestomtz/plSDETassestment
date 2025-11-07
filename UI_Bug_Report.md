# PL Benefits Login – UI Bug Report

## Bug ID: UI-001  
**Title:** Login page miss the 'Forgot password' link 

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
**Title:** User is able to get into benefit dashboard without login

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


## Bug ID: UI-005 
**Title:** Alert text is visible on html dom tree withou trigger

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


## Bug ID: UI-006 
**Title:** Add Employee template does not have validations

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


## Bug ID: UI-007 
**Title:** Add Employee template does not show errors

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


## Bug ID: UI-008 
**Title:** User could not enter identifier to person who has the same first name and last name

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


## Bug ID: UI-009 
**Title:** New Employeers does not get into the table in an logical order

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
- New entries does not follow logical order

### Expected Result:
- New entries should follow logical order (for example: from first to last, from last to first, alphabetical order, and others)

