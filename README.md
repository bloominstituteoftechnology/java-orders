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
  * AGENTCODE Long foreign key (one agent to many orders) not null
  * ORDDESCRIPTION String

* Customers has a foreign key to Agents (AGENTCODE) this means:
  * Customers has a Many to One relationship to Agents and
  * Agents has a One to Many relationship to Customers

* Orders has a foreign key to Agents (AGENTCODE)
  * Orders has a Many to One relationship to Agents and
  * Agents has a One to Many relationship to Orders

* Orders has a foreign key to Customers (CUSTCODE) 
  * Orders has a Many to One relationship to Customers and
  * Customers has a One to Many relationship to Orders

* Create the entities needed to store this data
* A Java class called SeedData has been provided with seed data. You can use this class directly or modify it to fit your models. However, the data found in the class is the seed data to use!
 
Expose the following end points

* /customer/order - Returns all customers with their orders
* /customer/name/{custname} - Returns all orders for a particular customer based on name

* /data/customer/new - Adds a new customer
* /data/customer/update/{custcode} - Updates the customer based off of custcode
* /data/customer/delete/{custcode} - Deletes the customer based off of custcode
  * this should also delete the orders of that customer

Stretch goals
* /agent/{agentcode} - Deletes an agent if they are not assigned to a customer or order (Stretch Goal)
