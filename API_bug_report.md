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

### Actual Result:
- The API returns 200 OK and creates the record.

### Expected Result:
- The API should return a 400 Bad Request response with an error message indicating where the error is located.

### Notes:
- This bug is going forward than the provided scenarios but is an scential feature for development
