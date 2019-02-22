# java-orders

# Introduction

This is a basic database scheme with customers, orders, and sales agents.

# Instructions

Create a REST api server to store and read data from an in memory H2 database. The database is adapted from the sample database found at https://www.w3resource.com/sql/sql-table.php

The table layouts are as follows

- [x] AGENTS
  * AGENTCODE primary key, not null Long
  * AGENTNAME string
  * WORKINGAREA string
  * COMMISSION double
  * PHONE string
  * COUNTRY string

- [x] CUSTOMERS
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

- [x] ORDERS
  * ORDNUM primary key, not null Long
  * ORDAMOUNT double
  * ADVANCEAMOUNT double
  * CUSTCODE Long foreign key (one customer to many orders) not null
  * AGENTCODE Long foreign key (one agent to many orders) not null
  * ORDDESCRIPTION


- [ ] Create the entities needed to store this data
- [ ] and Load in the data (a prepopulated data.sql file is available for you to use)
 
- [ ] Create a generic error html page to return when error 404 happens.
- [ ] Create a different generic error html page to return when error 500 happens.
- [ ] Create a different generic error html page to return when an error other than a 404 or 500 happens.

Expose the following end points

- [ ] /customer/order - Returns all customers with their orders
- [ ] /customer/name/{custname} - Returns all orders for a particular based on name
- [ ] /customer/order/{custcode} - Returns all orders for a particular customer based on custcode
- [ ] /agents - Returns all agents with their customers
- [ ] /agents/orders - Return a list with the agents name and associated order number and order description
- [ ] /customer/{custcode} - Deletes a customer based off of their custcode and deletes all their associated orders
- [ ] /agents/{agentcode} - Deletes an agent if they are not assigned to a customer or order (Stretch Goal)

