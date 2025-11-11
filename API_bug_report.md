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
