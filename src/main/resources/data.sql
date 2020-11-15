DELETE
FROM orders;

DELETE
FROM customers;

DELETE
FROM agents;

INSERT INTO AGENTS (agentid, agentname, workingarea, commission, phone, country)
VALUES (1, 'Ramasundar', 'Bangalore', 0.15, '077-25814763', '');

-- INSERT INTO CUSTOMERS (customerid, custname, custcity, workingarea, custcountry, grade, openingamt, receiveamt, paymentamt, outstandingamt, phone, agent)
-- VALUES (1, 'Holmes', 'London', 'London', 'UK', '2', 6000.00, 5000.00, 7000.00, 4000.00, 'BBBBBBB', 3);

-- INSERT INTO ORDERS (orderid, ordamount, advanceamount, custcode, orderdescription)
-- VALUES (1, 1000.00, 600.00, 13, 'SOD');
--
-- INSERT INTO PAYMENTS (paymentid, type)
-- VALUES (1, 'Cash');
--
-- INSERT INTO ORDERSPAYMENTS (orderid, paymentid)
-- VALUES (1, 1);
/*
We must tell hibernate the ids that have already been used.
The number must be larger than the last used id.
50 > 25 so we are good!
 */
 alter sequence hibernate_sequence restart with 50;