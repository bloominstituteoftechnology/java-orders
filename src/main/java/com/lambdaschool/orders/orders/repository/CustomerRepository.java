package com.lambdaschool.orders.orders.repository;

import com.lambdaschool.orders.orders.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository <Customer, Long> {

}
