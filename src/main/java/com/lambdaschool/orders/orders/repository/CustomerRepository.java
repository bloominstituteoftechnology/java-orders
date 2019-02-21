package com.lambdaschool.orders.orders.repository;

import com.lambdaschool.orders.orders.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CustomerRepository extends JpaRepository <Customer, Long> {
    @Query(value = "SELECT * FROM customer WHERE CUSTOMER.CUSTCITY = :city", nativeQuery = true)
    List<Customer> findByCity(@Param("city") String city);

    @Query(value = "SELECT CUSTOMER.CUSTNAME, ORDERS.ORDDESCRIPTION, ORDERS.ORDAMOUNT FROM ORDERS INNER JOIN CUSTOMER ON ORDERS.CUSTCODE=CUSTOMER.CUSTCODE;", nativeQuery = true)
    List<Object[]> findAllOrder();

    @Query(value = "SELECT CUSTOMER.CUSTNAME, ORDERS.ORDAMOUNT FROM ORDERS INNER JOIN CUSTOMER ON ORDERS.CUSTCODE = CUSTOMER.CUSTCODE WHERE lower(CUSTNAME)= :custname", nativeQuery = true)
    List<Object[]> findAllOrderForCustomer(@Param("custname") String custname);

    @Query(value = "SELECT CUSTOMER.CUSTCODE, ORDERS.ORDAMOUNT FROM ORDERS INNER JOIN CUSTOMER ON ORDERS.CUSTCODE = CUSTOMER.CUSTCODE WHERE CUSTOMER.CUSTCODE=:custcode", nativeQuery = true)
    List<Object[]> findAllOrderByCustomerId(@Param("custcode") Long custcode);

    @Query(value = "SELECT AGENTS.AGENTNAME, CUSTOMER.CUSTNAME FROM AGENTS INNER JOIN CUSTOMER ON AGENTS.AGENTCODE=CUSTOMER.AGENTCODE ORDER BY AGENTS.AGENTNAME", nativeQuery = true)
    List<Object[]> listAllAgentsWithCustomers();


}
