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

    @Transactional
    @Override
    public Customer update(long custcode, Customer customer) {
        Customer updateCustomer = customersRepository.findById(custcode)
                .orElseThrow(()-> new EntityNotFoundException("Customer " + custcode + " not found."));
        if(customer.getCustcity() != null) updateCustomer.setCustcity(customer.getCustcity());
        if(customer.getCustCountry() != null) updateCustomer.setCustCountry(customer.getCustCountry());
        if(customer.getCustname() != null) updateCustomer.setCustname(customer.getCustname());
        if(customer.getGrade() != null) updateCustomer.setGrade(customer.getGrade());
        if(customer.hasvalueopeningamt) updateCustomer.setOpeningamt(customer.getOpeningamt());
        if(customer.hasvalueoutstandingamt) updateCustomer.setOutstandingamt(customer.getOutstandingamt());
        if(customer.hasvaluepaymentamt) updateCustomer.setPaymentamt(customer.getPaymentamt());
        if(customer.getPhone() != null) updateCustomer.setPhone(customer.getPhone());
        if(customer.hasvaluereceiveamt) updateCustomer.setReceiveamt(customer.getReceiveamt());
        if(customer.getWorkingarea() != null) updateCustomer.setWorkingarea(customer.getWorkingarea());
        if(customer.getAgent() != null) updateCustomer.setAgent(customer.getAgent());

        if(customer.getOrders().size()>0){
            updateCustomer.getOrders().clear();
            for(Order o : customer.getOrders()){
                Order newOrder = new Order();
                newOrder.setAdvanceamount(o.getAdvanceamount());
                newOrder.setOrdamount(o.getOrdamount());
                newOrder.setOrderdescription(o.getOrderdescription());

                newOrder.setCustomer(updateCustomer);
                updateCustomer.getOrders().add(newOrder);
            }
        }
        return customersRepository.save(updateCustomer);
    }

    @Override
    public void delete(long id) {
        customersRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Customer "+ id + " not found."));
        customersRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        customersRepository.deleteAll();
    }
}
