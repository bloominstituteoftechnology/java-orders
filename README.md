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
  * ORDDESCRIPTION


* Create the entities needed to store this data
* Load in the data. A file called data.sql would load the data using SQL. You need to modify it to load using a SeedData approach loading the data by creating objects.
 
Expose the following end points

* /customer/order - Returns all customers with their orders
* /customer/name/{custname} - Returns all orders for a particular based on name
* /customer/order/{custcode} - Returns all orders for a particular customer based on custcode
* /agents - Returns all agents with their customers
* /agents/orders - Return a list with the agents name and associated order number and order description
* /customer/{custcode} - Deletes a customer based off of their custcode and deletes all their associated orders
* /agents/{agentcode} - Deletes an agent if they are not assigned to a customer or order (Stretch Goal)

Stretch goals
* Add appropriate error exception handling
* Add appropriate logging for Tomcat, Spring, and custom logging for your project
