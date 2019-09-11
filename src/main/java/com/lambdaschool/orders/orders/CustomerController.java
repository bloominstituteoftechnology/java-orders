package com.lambdaschool.orders.orders;


import com.lambdaschool.orders.orders.models.Customer;
import com.lambdaschool.orders.orders.repository.AgentsRepository;
import com.lambdaschool.orders.orders.repository.CustomerRepository;
import com.lambdaschool.orders.orders.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = {}, produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {
    //create the field populate and we will be able to use it
    @Autowired
    CustomerRepository custrepos;

    @Autowired
    AgentsRepository agentrepos;

    @Autowired
    OrdersRepository orderrepos;

    @GetMapping("/city/{city}")
    public List<Customer> findByCity(@PathVariable String city) {
        return custrepos.findByCity(city);
    }

    @GetMapping("/customer/order")
    public List<Object[]> findAllOrder() {
        return custrepos.findAllOrder();
    }

    @GetMapping("/name/{custname}")
    public  List<Object[]> findOrderForCustomer(@PathVariable String custname) {
        return custrepos.findAllOrderForCustomer(custname.toLowerCase());
    }

    @GetMapping("/order/{custcode}")
    public  List<Object[]> findOrderbYCustomerId(@PathVariable Long custcode) {
        return custrepos.findAllOrderByCustomerId(custcode);
    }

    @GetMapping("/agents")
    public List<Object[]> findAgentWithCustomer() {
        return custrepos.listAllAgentsWithCustomers();
    }

    @DeleteMapping("/customer/{custcode}")
    public void deleteCustomer(@PathVariable long custcode) {
        custrepos.deleteById(custcode);
    }


}