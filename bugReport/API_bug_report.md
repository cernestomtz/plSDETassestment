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
**Title:** PUT /api/Employees creates a new record when the provided ID was previously deleted and set salary = 0, resulting in negative net pay  
**Scenario:** 2 Edit Employee

**Severity:** Medium    
**Endpoint:** https://wmxrwq14uc.execute-api.us-east-1.amazonaws.com/Prod/api/Employees
**Method:** PUT
**Auth:** Basic Auth Header
**Reported by:** Ernesto Martínez  
**Date:** 2025-11-11  

**Description:**  
When sending a PUT request to edit an employee using an ID that has been deleted, the API creates a new employee (upsert behavior), ignoring the provided ID.  
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


## Bug ID: API-003  
**Title:** POST /api/Employees creates a new employee without verify that a valid user is who create the record   
**Scenario:** 1 Add Employee

**Severity:** Medium    
**Endpoint:** https://wmxrwq14uc.execute-api.us-east-1.amazonaws.com/Prod/api/Employees
**Method:** POST
**Auth:** Basic Auth Header
**Reported by:** Ernesto Martínez  
**Date:** 2025-11-12  

**Description:**  
When sending a POST request with a non existing user name, the call is still reponse with status 200 and employee is added  

**Steps to Reproduce:**
1. Send a POST request to `/api/Employees`
2. Use the following body:
   raw-JSON
   {
       "username": "T",
       "firstName": "John",
       "lastName": "Doe",
       "dependants": 5
   }

### Actual Result:
- The API responds with 200 OK instead of 400 code.  
- A new employee record is created with an invalid user name  

### Expected Result:
- The API should return a 400 Bad Request response with an error message indicating where the error is located.


## Bug ID: API-004  
**Title:** DELETE /api/Employees returns 405 instead of 404 when deleting non-existing employee    
**Scenario:** 3 Delete Employee

**Severity:** Medium     
**Endpoint:** https://wmxrwq14uc.execute-api.us-east-1.amazonaws.com/Prod/api/Employees
**Method:** DELETE 
**Auth:** Basic Auth Header
**Reported by:** Ernesto Martínez  
**Date:** 2025-11-12  

**Description:**  
When attempting to delete a non-existent employee using a valid DELETE request and an invalid ID, the API incorrectly returns status 405 Method Not Allowed instead of 404 Not Found  

**Steps to Reproduce:**
1. Send a DELETE request to `/api/Employees/00000000-0000-0000-0000-000000000000`  
2. Observe the status code in the response

### Actual Result:
- The API returns 405 Method Not Allowed

### Expected Result:
- The API should return 404 Not Found, indicating the employee record does not exist.

**Notes:**  
- Behavior consistent across multiple invalid IDs.


## Bug ID: API-005  
**Title:** Second DELETE request on `/api/Employees/{justDeletedId}` returns 200 instead of 404 or 400    
**Scenario:** 3 Delete Employee

**Severity:** Low     
**Endpoint:** https://wmxrwq14uc.execute-api.us-east-1.amazonaws.com/Prod/api/Employees
**Method:** DELETE 
**Auth:** Basic Auth Header
**Reported by:** Ernesto Martínez  
**Date:** 2025-11-12  

**Description:**  
When performing a second DELETE request on the same employee ID, the API returns status 200 OK instead of 404 Not Found or 400 Bad Request. 

**Steps to Reproduce:**
1. Send a POST request to `/api/Employees` to create a new employee.  
2. Capture the `id` returned in the response.  
3. Send a DELETE request to `/api/Employees/{id}`.  
4. Send the same DELETE request again with the same `id`.

### Actual Result:
- The API returns 200 OK for both delete attempts.

### Expected Result:
- The first DELETE should return 200 OK (successful deletion).  
- The second DELETE should return 404 Not Found or 400 Bad Request, indicating that the resource no longer exists.

**Notes:**  
- This issue is functionally harmless but semantically incorrect per RESTful standards.  
- Test case reference: `DELETE Employee again (expected 404/400 Known issue)`


## Bug ID: API-006  
**Title:** When API input mixed numeric/string dependants returns incorrect status code (Same behavior with empty first name or last name, and inexisting ID)  
**Scenario:** 1 Add Employee

**Severity:** Medium     
**Endpoint:** https://wmxrwq14uc.execute-api.us-east-1.amazonaws.com/Prod/api/Employees
**Method:** DELETE 
**Auth:** Basic Auth Header
**Reported by:** Ernesto Martínez  
**Date:** 2025-11-12  

**Description:**  
When sending a dependants value that begins with valid digits (0–32) but includes additional invalid characters (letters, symbols, mixed string), the API returns 405 Method Not Allowed.

**Steps to Reproduce:**
1. Send a POST request to `/api/Employees` to create a new employee.
2. Use a payload where dependants begins with valid digits (0–32) but has invalid trailing characters:
{
  "username": "TestUserXYZ",
  "firstName": "John",
  "lastName": "Doe",
  "dependants": "07abK"   // Valid prefix + invalid suffix
}

### Actual Result:
- API returns 405 Method Not Allowed
- Response body is empty
- No validation error is provided

### Expected Result:
- API should return 400 Bad Request  
- Response should include a meaningful validation message such as:

**Notes:**  
- UI trims string values and only keeps leading digits before submitting to API. Example: "07abK" → UI sends "7"  
- API currently does not perform input sanitation or trimming.
- This inconsistency can cause unexpected values when calling the API directly.



