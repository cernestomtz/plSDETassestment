**Bug ID:** API_01  
**Title:** API accepts invalid field names in POST /api/Employees  
**Description:**  
The API should validate the payload against the Employee schema. However, it accepts an invalid field name (“dependants” instead of “dependents”) and still processes the record.

**Steps to Reproduce:**
1. Send a POST request to `/api/Employees`
2. Use the following body:
   ```json
   {
       "username": "TestUser",
       "firstName": "John",
       "lastName": "Doe",
       "dependants": 5
   }

