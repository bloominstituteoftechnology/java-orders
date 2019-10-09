# java-orders

A student that completes this project shows that they can:
* perform CRUD operations on an RDBMS using JPA and Hibernate.

## Introduction

This is a basic database scheme with customers, orders, and sales agents.

## Instructions

Create a REST api server to store and read data from an in memory H2 database. 

The table layouts are as follows

* AGENTS
  * AGENTCODE primary key, not null Long
  * AGENTNAME string
  * WORKINGAREA string
  * COMMISSION double
  * PHONE string
  * COUNTRY string

* CUSTOMERS
  * CUSTCODE primary key, not null Long
  * CUSTNAME String, not null
  * CUSTCITY String
  * WORKINGAREA String
  * CUSTCOUNTRY String
  * GRADE String
  * OPENINGAMT double
  * RECEIVEAMT double
  * PAYMENTAMT double
  * OUTSTANDINGAMT double
  * PHONE String
  * AGENTCODE Long foreign key (one agent to many customers) not null

* ORDERS
  * ORDNUM primary key, not null Long
  * ORDAMOUNT double
  * ADVANCEAMOUNT double
  * CUSTCODE Long foreign key (one customer to many orders) not null
  * ORDDESCRIPTION String

* Customers has a foreign key to Agents (AGENTCODE) this means:
  * Customers has a Many to One relationship to Agents and
  * Agents has a One to Many relationship to Customers

* Orders has a foreign key to Customers (CUSTCODE) 
  * Orders has a Many to One relationship to Customers and
  * Customers has a One to Many relationship to Orders

* Create the entities needed to store this data
* A Java class called SeedData has been provided with seed data. You can use this class directly or modify it to fit your models. However, the data found in the class is the seed data to use!
 
Expose the following endpoints

* GET /customer/order - Returns all customers with their orders

* POST /customer/new - Adds a new customer including any new orders
  * You can use the following as test data
  
```
{
    "custname": "John",
    "custcity": "Port Angeles",
    "workingarea": "Washington",
    "custcountry": "USA",
    "grade": "1",
    "openingamt": 70000,
    "receiveamt": 7000,
    "paymentamt": 777,
    "outstandingamt": 0,
    "phone": "5555555555",
    "agent": {
        "agentcode": 8
    },
    "orders": [
        {
            "ordamount": 7777,
            "advanceamount": 777,
            "orddescription": "SOD"
        }
    ]
}
```

* PUT /customer/update/{custcode} - Updates the customer based off of custcode. Does not have to do anything with Orders!

You can use this data to test changing any customer's phone number

```
{
    "phone": "5551234567"
}
```

* DELETE /customer/delete/{custcode} - Deletes the customer based off of custcode
  * this should also delete the orders of that customer

Stretch goals
* DELETE /agent/{agentcode} - Deletes an agent if they are not assigned to a customer
* PUT /data/customer/update/{custcode} - update this endpoint to add any orders sent to the endpoint
