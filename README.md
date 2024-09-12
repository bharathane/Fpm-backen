
# Financial Portfolio Management Spring Boot Application
<table>
<tr>
<td>

  
A Financial Portfolio Management application built with Spring Boot allows users to create accounts, log in, and manage their financial transactions securely.
The app includes user validation features such as authentication and authorization to ensure that only authorized users can access or modify their data.
Users can create, update, and delete transactions, which are tracked within the application. Additionally, the app provides weekly reports and an overview of the user's financial activity, offering insights into spending patterns and financial health.
This robust system is designed to manage personal finances efficiently and securely.
</td>
</tr>
</table>




## User Registration 
<u>POST   **/register**</u>
 **Sample Request**
 <br />
 
   ```sample response
    {
        "username": "BHARATH",
        "password": "Bharath@123",
        "email": "bharath@gmail.com",
       
    }
   ```
 <br />
 **Sample Response**
 <br />
 
   ```sample response
    {
    "access_token": "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJCaGFyYXRoIiwiaWF0IjoxNzI2MTIwMzYwLCJleHAiOjE3MjYyMDY3NjB9.-sdorNulfXpd0LbrHNaWaojjan0j0nDK9-afhc6bES2CkEnDHrfrP_bWwfRlfP_j",
    "refresh_token": "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJCaGFyYXRoIiwiaWF0IjoxNzI2MTIwMzYxLCJleHAiOjE3MjYyOTMxNjF9.bSQ2EZtAUQF0-5A5WUaRkR0_PwLvxOEp_lIrqHhWcCJXoJRUuNqVTQF_l8nHxB0M",
    "message": "User registration was successful",
    "username": "Bharath"
}
   ```


## User Login 
<u>POST   **/login**</u>
 **Sample Request**
 <br />
 
   ```sample response
    {
        "username": "BHARATH",
        "password": "Bharath@123"
       
    }
   ```
 <br />
 **Sample Response**
 <br />
 
   ```sample response
    {
    "access_token": "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJCaGFyYXRoIiwiaWF0IjoxNzI2MTIwMzYwLCJleHAiOjE3MjYyMDY3NjB9.-sdorNulfXpd0LbrHNaWaojjan0j0nDK9-afhc6bES2CkEnDHrfrP_bWwfRlfP_j",
    "refresh_token": "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJCaGFyYXRoIiwiaWF0IjoxNzI2MTIwMzYxLCJleHAiOjE3MjYyOTMxNjF9.bSQ2EZtAUQF0-5A5WUaRkR0_PwLvxOEp_lIrqHhWcCJXoJRUuNqVTQF_l8nHxB0M",
    "message": "User registration was successful",
    "username": "Bharath"
}
   ```

## Get All Transactions
  <u>GET   **/transactions?username=BHARATH** </u>
- <u>Sample Response</u>
 ```sample response
        [
        {
           "id":"550e8400-e29b-41d4-a716-446655477700",
            "username":"BHARATH",
            "transactionName":"Salaries",
            "category":"Expenses",
            "transactionDate":"2024-08-11 14:30:00",
            "debit":50000,
            "credit":0,
            "type":"DEBIT"
        },
      ...
      ]
   
   ```


## Add Transaction
<u>POST   **/transactions/addTransaction**</u>

  ``` Sample Request body
        {
          "username":"BHARATH",
          "transactionName":"Salaries",
          "category":"Expenses",
          "debit":50000,
          "credit":0,
          "type":"DEBIT"
      }
  ```

- <u>Sample Response</u>
 
   ```sample response
        {
           "id":"550e8400-e29b-41d4-a716-446655477700",
            "username":"BHARATH",
            "transactionName":"Salaries",
            "category":"Expenses",
            "transactionDate":"2024-08-11 14:30:00",
            "debit":50000,
            "credit":0,
            "type":"DEBIT"
        }
   
   ```
   
   ## Update Transaction
  <u>PUT   **/transactions/updateTransactions**</u>

  ``` Sample Request body
        {
          "id":"550e8400-e29b-41d4-a716-446655477700",
          "transactionName":"Salaries to EMP",
      }
  ```

- <u>Sample Response</u>
 
   ```sample response
         {
          "id":"550e8400-e29b-41d4-a716-446655477700",
          "username":"BHARATH",
          "transactionName":"Salaries to EMP",
          "category":"Expenses",
          "debit":50000,
          "credit":0,
          "type":"DEBIT"
      }
   
   ```
  
 ## delete Transaction
  <u>DELETE   **/transactions/deleteTransactions/550e8400-e29b-41d4-a716-446655477700** </u>
- <u>Sample Response</u>
```"Transaction deleted successfully"```

## Total Debits
  <u>GET   **/transactions/debits?username=BHARATH** </u>
- <u>Sample Response</u>
```39000```

## Total Credits
  <u>GET   **/transactions/credits?username=BHARATH** </u>
- <u>Sample Response</u>
```3000```


## Overview
  <u>GET   **/transactions/overview?username=BHARATH** </u>
- <u>Sample Response</u>
```[
  {
    "transactionDate":"2024-08-11",
    "totalDebits":60000
    "totalCredits":30000
  },
....
]

```

## Recent Transactions
  <u>GET   **/transactions/recent?username=BHARATH** </u>
- <u>Sample Response</u>
```[
        {
           "id":"550e8400-e29b-41d4-a716-446655477700",
            "username":"BHARATH",
            "transactionName":"Salaries",
            "category":"Expenses",
            "transactionDate":"2024-08-11 14:30:00",
            "debit":50000,
            "credit":0,
            "type":"DEBIT"
        },
      ...
      ]
```

<br/>

## Demo
Here is a working live demo :  Will  add


## [Usage](will add) 

### Development
Want to contribute? Great!

To fix a bug or enhance an existing module, follow these steps:

- Fork the repo
- Create a new branch (`git checkout -b improve-feature`)
- Make the appropriate changes in the files
- Add changes to reflect the changes made
- Commit your changes (`git commit -am 'Improve feature'`)
- Push to the branch (`git push origin improve-feature`)
- Create a Pull Request 
