# PL Benefits Login – API Bug Report

## Bug ID: API-001  
**Title:** API accepts invalid field names in POST /api/Employees  
**Scenario:** 1 Add Employee

**Severity:** Low  
**Endpoint:** https://wmxrwq14uc.execute-api.us-east-1.amazonaws.com/Prod/api/Employees
**Method:** POST
**Auth:** Basic Auth Header
**Reported by:** Ernesto Martínez  
**Date:** 2025-11-04  

**Description:**  
The API should validate the payload against the Employee schema. However, it accepts an invalid field name (“dependants” instead of “dependents”) and still processes the record.

**Steps to Reproduce:**
1. Send a POST request to `/api/Employees`
2. Use the following body:
   raw-JSON
   {
       "username": "TestUser",
       "firstName": "John",
       "lastName": "Doe",
       "dependants": 5
   }

### Actual Result:
- The API returns 200 OK and creates the record.

### Expected Result:
- The API should return a 400 Bad Request response with an error message indicating where the error is located.

### Notes:
- None


## Bug ID: API-002  
**Title:** PUT /api/Employees creates a new record when the provided ID does not exist and allows salary = 0, resulting in negative net pay  
**Scenario:** 2 Edit Employee

**Severity:** Medium    
**Endpoint:** https://wmxrwq14uc.execute-api.us-east-1.amazonaws.com/Prod/api/Employees
**Method:** PUT
**Auth:** Basic Auth Header
**Reported by:** Ernesto Martínez  
**Date:** 2025-11-11  

**Description:**  
When sending a PUT request to edit an employee using an ID that has been deleted or never existed, the API creates a new employee (upsert behavior), ignoring the provided ID.  
Additionally, the API set a salary 0, which got into to invalid payroll calculations, a positive Benefits Cost and a negative Net Pay shown in the UI.  

This violates both RESTful conventions (PUT should be idempotent and only update existing resources) and business rules (Net Pay should never be negative).

### **Preconditions:**  
- Have an existing employee created via POST.  
- Delete that employee using DELETE /api/Employees/{id}.

**Steps to Reproduce:**
1. Create an employee with POST /api/Employees and save the returned id.  
2. Delete that employee with DELETE /api/Employees/{id}.  
3. Send a PUT request to /api/Employees using the deleted id, with the following body:  
   json
   {
     "id": "{{employeeId}}",
     "username": "someUser",
     "firstName": "Edited",
     "lastName": "Name",
     "dependants": 17
   }
4. Refresh the Benefits Dashboard or perform a GET /api/Employees.

### Actual Result:
- The API responds with 200 OK instead of 404.  
- A new employee record is created with a different id.  
- The UI displays:
  - Salary: 0.00  
  - Gross Pay: 0.00  
  - Benefits Cost: > 0 (example 365.38)  
  - Net Pay: Negative (example -365.38)  

### Expected Result:
- The API should return a 400 Bad Request response with an error message indicating where the error is located.

### Notes:
- None
