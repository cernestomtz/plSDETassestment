# PL Benefits Login – UI Bug Report

## Bug ID: UI-001  
**Title:** Login page miss the 'Forgot password' link 

**Severity:** High  
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

**Severity:** High  
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


