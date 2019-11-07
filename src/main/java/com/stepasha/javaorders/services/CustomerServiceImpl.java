package com.stepasha.javaorders.services;

import com.stepasha.javaorders.models.Agents;
import com.stepasha.javaorders.models.Customers;
import com.stepasha.javaorders.models.Orders;
import com.stepasha.javaorders.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Transactional
@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private OrderService orderService;
    @Autowired
    private CustomersRepository custRepo;


    @Override
    public List<Customers> findAll() {
        List<Customers> list = new ArrayList<>();
        custRepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Customers findCustomerById(long id) {
        return custRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not save a costumer"));
    }

    @Override
    public List<Customers> getCustomerByNameLike(String likename) {
        return custRepo.findByCustnameContaining(likename);
    }
@Transactional
    @Override
    public Customers save(Customers customers) {
       Customers newCustomer = new Customers();
       newCustomer.setCustname(customers.getCustname());
       newCustomer.setCustcity(customers.getCustcity());
       newCustomer.setWorkingarea(customers.getWorkingarea());
       newCustomer.setCustcountry(customers.getCustcountry());
       newCustomer.setGrade(customers.getGrade());
       newCustomer.setOpeningamt(customers.getOpeningamt());
       newCustomer.setReceiveamt(customers.getReceiveamt());
       newCustomer.setPaymentamt(customers.getPaymentamt());
       newCustomer.setOutstandingamt(customers.getOutstandingamt());
       newCustomer.setPhone(customers.getPhone());
       newCustomer.setAgent(customers.getAgent());
       //newCustomer.setOrders(customers.getOrders());

       for (Orders o: customers.getOrders()){
           Orders newOrder = new Orders(o.getOrdamount(), o.getAdvanceamount(), newCustomer, o.getOrderdescription());
           newCustomer.getOrders().add(newOrder);
       }

    return custRepo.save(newCustomer);
    }

    @Override
    public Customers update(Customers customers, long id) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
