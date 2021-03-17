package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.models.Order;
import com.lambdaschool.orders.repositories.CustomersRepository;
import com.lambdaschool.orders.repositories.OrdersRepository;
import com.lambdaschool.orders.views.OrdersCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "customerService")
public class CustomerServicesImpl implements CustomerServices{

    @Autowired
    private CustomersRepository customersRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public List<Customer> findAllCustomers() {
        List<Customer> customerList = new ArrayList<>();
        customersRepository.findAll().iterator().forEachRemaining(customerList::add);
        return customerList;
    }

    @Override
    public Customer findCustomerById(long custcode) {
        Customer customer = customersRepository.findById(custcode)
                .orElseThrow(()->new EntityNotFoundException("Customer "+custcode+" Not Found"));
        return customer;
    }

    @Override
    public List<Customer> findCustomerByNameLike(String subname) {
        List<Customer> customerList = customersRepository.findByCustnameContainingIgnoringCase(subname);
        return customerList;
    }

    @Override
    public List<OrdersCount> getOrdersCount() {
        List<OrdersCount> ordersCounts = customersRepository.getOrdersCount();
        return ordersCounts;
    }

    @Transactional
    @Override
    public Customer save(Customer customer) {
        Customer newCustomer = new Customer();
        if (customer.getCustcode() != 0){
            customersRepository.findById(customer.getCustcode())
                    .orElseThrow(()->new EntityNotFoundException("Customer "+customer.getCustcode() + " not found."));
            newCustomer.setCustcode(customer.getCustcode());
        }

        newCustomer.setCustname(customer.getCustname());
        newCustomer.setCustcity(customer.getCustcity());
        newCustomer.setCustCountry(customer.getCustCountry());
        newCustomer.setGrade(customer.getGrade());
        newCustomer.setOpeningamt(customer.getOpeningamt());
        newCustomer.setOutstandingamt(customer.getOutstandingamt());
        newCustomer.setPaymentamt(customer.getPaymentamt());
        newCustomer.setPhone(customer.getPhone());
        newCustomer.setReceiveamt(customer.getReceiveamt());
        newCustomer.setWorkingarea(customer.getWorkingarea());
        newCustomer.setAgent(customer.getAgent());

        newCustomer.getOrders().clear();
        for(Order o : customer.getOrders()){
            Order newOrder = ordersRepository.findOrderByOrdnum(o.getOrdnum());
//                    .orElseThrow
            newCustomer.getOrders().add(newOrder);
        }
        return customersRepository.save(newCustomer);
    }

    @Override
    public Customer update(long custcode, Customer customer) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void deleteAll() {

    }
}
