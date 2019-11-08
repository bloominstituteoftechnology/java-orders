package com.stepasha.javaorders.services;

import com.stepasha.javaorders.models.Agents;
import com.stepasha.javaorders.models.Customers;
import com.stepasha.javaorders.models.Orders;
import com.stepasha.javaorders.models.Payments;
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
  //  @Autowired
//    private PaymentService paymentService;
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

    @Transactional
    @Override
    public Customers update(Customers customers, long id) {
        Customers currentCustomer = findCustomerById(id);
        if(customers.getCustname() != null) {
            currentCustomer.setCustname(customers.getCustname());
        }
        if(customers.getCustcity() != null) {
            currentCustomer.setCustcity(customers.getCustcity());
        }
        if(customers.getWorkingarea() != null) {
            currentCustomer.setWorkingarea(customers.getWorkingarea());
        }
        if(customers.getCustcountry() != null) {
            currentCustomer.setCustcountry(customers.getCustcountry());
        }
        if(customers.getGrade() != null) {
            currentCustomer.setGrade(customers.getGrade());
        }
        if(customers.hasvalueforopeningatm) {
            currentCustomer.setOpeningamt(customers.getOpeningamt());
        }
        if (customers.hasvalueforreceiveatm) {
            currentCustomer.setReceiveamt(customers.getReceiveamt());
        }
        if (customers.hasvalueforpaymentatm) {
            currentCustomer.setPaymentamt(customers.getPaymentamt());
        }
        if (customers.hasvalueforoutstandingatm) {
            currentCustomer.setOutstandingamt(customers.getOutstandingamt());
        }
        if (customers.getPhone() != null) {
            currentCustomer.setPhone(customers.getPhone());
        }
        if (customers.getAgent() != null) {
            currentCustomer.setAgent(customers.getAgent());
        }
            //currentCustomer.setOrders(customers.getOrders());
//    if (restaurant.getMenus().size() >0) {
        if (customers.getOrders().size() > 0) {
            for (Orders o : customers.getOrders()) {
                Orders newOrder = new Orders(o.getOrdamount(), o.getAdvanceamount(), currentCustomer, o.getOrderdescription());
                currentCustomer.getOrders().add(newOrder);
            }
        }
        return custRepo.save(currentCustomer);
    }

    @Override
    public void delete(long id) {

    }
}
