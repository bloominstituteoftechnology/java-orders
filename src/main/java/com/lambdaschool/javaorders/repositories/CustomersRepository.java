package com.lambdaschool.javaorders.repositories;

import com.lambdaschool.javaorders.models.Customer;
import com.lambdaschool.javaorders.views.OrderCount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomersRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByCustnameContainingIgnoringCase(String keyword);

    @Query(value = "SELECT c.custname name, count(o.ordnum) ordercount " +
            "FROM customers c LEFT JOIN orders o " +
            "ON c.custcode = o.custcode " +
            "GROUP BY name " +
            "ORDER BY ordercount DESC, name", nativeQuery = true)
    List<OrderCount> findOrderCount();
}
