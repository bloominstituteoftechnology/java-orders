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

* PAYMENTS
  PAYMENTID primary key, not null long
  TYPE String not null
  
* ORDERSPAYMENTS (join table)
  * ORDERNUM foreign key to ORDERS
  * PAYMENTID foreign key to PAYMENTS. 

* Customers has a foreign key to Agents (AGENTCODE) this means:
  * Customers has a Many to One relationship to Agents and
  * Agents has a One to Many relationship to Customers

* Orders has a foreign key to Customers (CUSTCODE) 
  * Orders has a Many to One relationship to Customers and
  * Customers has a One to Many relationship to Orders

* Orders has a many to many relationship with payments
  * multiple orders can use the same payment type and an order can have multiple payment types.
  * For example you can use both gift card and credit card to pay for an order.

* Create the entities needed to store this data
* A data.sql file has been provided with seed data. You can use this class directly or modify it to fit your models. However, the data found in the file is the seed data to use!
 
Expose the following endpoints

* GET /customers/orders - Returns all customers with their orders
* GET /customers/customer/{id} - Returns the customer and their orders with the given customer id
* GET /customers/namelike/{likename} - Returns all customers and their orders with a customer name containing the given substring
* GET /agents/agent/{id} - Returns the agent and their customers with the given agent id
* GET /orders/order/{id} - Returns the order and its customer with the given order number
* GET /orders/advanceamount - returns all orders with their customers that have an advanceamount greater than 0.
