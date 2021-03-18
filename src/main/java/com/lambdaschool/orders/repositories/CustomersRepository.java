package com.lambdaschool.orders.repositories;

import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.views.OrdersCount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomersRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByCustnameContainingIgnoringCase(String subname);

    @Query(value = "SELECT c.custname, count(o.ordnum) as orders " +
            "FROM  orders o LEFT JOIN customers c " +
            "ON c.custcode = o.custcode " +
            "GROUP BY c.custcode", nativeQuery = true)
    List<OrdersCount> getOrdersCount();
}
