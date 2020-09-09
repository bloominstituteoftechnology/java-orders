package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Customer;
import com.lambdaschool.javaorders.models.Order;
import com.lambdaschool.javaorders.models.Payment;
import com.lambdaschool.javaorders.repositories.AgentsRepository;
import com.lambdaschool.javaorders.repositories.CustomersRepository;
import com.lambdaschool.javaorders.repositories.PaymentRepository;
import com.lambdaschool.javaorders.views.OrderCount;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "customerServices")
public class CustomerServicesImplementation implements CustomerServices{
    @Autowired
    CustomersRepository customerrepos;

    @Autowired
    PaymentRepository paymentrepos;

    @Override
    public List<Customer> findAllCustomerOrders() {
        List<Customer> orderList = new ArrayList<>();
        customerrepos.findAll().iterator().forEachRemaining(orderList::add);
        return orderList;
    }

    @Override
    public Customer findCustomerByID(long customerID) {
        return customerrepos.findById(customerID)
                .orElseThrow(() -> new EntityNotFoundException("Customer " + customerID + " not found"));
    }

    @Override
    public List<Customer> findCustomerByKeyword(String keyword) {
        List<Customer> list = customerrepos.findByCustnameContainingIgnoringCase(keyword);
        return list;
    }

    @Override
    public List<OrderCount> findOrderCount() {
        List<OrderCount> list = customerrepos.findOrderCount();
        return list;
    }

    // --------- save ----------
    @Transactional
    @Override
    public Customer save(Customer customer) {
        Customer newCustomer = new Customer();

        if (customer.getCustcode() != 0)
        {
            findCustomerByID(customer.getCustcode());
            newCustomer.setCustcode(customer.getCustcode());
        }

        newCustomer.setCustcity(customer.getCustcity());
        newCustomer.setCustcountry(customer.getCustcountry());
        newCustomer.setCustname(customer.getCustname());
        newCustomer.setGrade(customer.getGrade());
        newCustomer.setOpeningamt(customer.getOpeningamt());
        newCustomer.setOutstandingamt(customer.getOutstandingamt());
        newCustomer.setPaymentamt(customer.getPaymentamt());
        newCustomer.setPhone(customer.getPhone());
        newCustomer.setReceiveamt(customer.getReceiveamt());
        newCustomer.setWorkingarea(customer.getWorkingarea());
        newCustomer.setAgent(customer.getAgent());

        newCustomer.getOrders().clear();
        for (Order o : customer.getOrders())
        {
            Order newOrder = new Order(o.getOrdamount(), o.getAdvanceamount(), newCustomer, o.getOrderdescription());

            for(Payment p : o.getPayments())
            {
                Payment newPayment = paymentrepos.findById(p.getPaymentid())
                        .orElseThrow(() -> new EntityNotFoundException("Payment " + p.getPaymentid() + " not found!"));

                newOrder.getPayments().add(newPayment);
            }

            newCustomer.getOrders().add(newOrder);
        }

        return customerrepos.save(newCustomer);
    }

    // ------ update --------
    @Transactional
    @Override
    public Customer update(Customer customer, long custcode) {

        Customer updateCustomer = findCustomerByID(custcode);

        if(customer.getCustcity() != null)
        {
            updateCustomer.setCustcity(customer.getCustcity());
        }
        if(customer.getCustcountry() != null)
        {
            updateCustomer.setCustcountry(customer.getCustcountry());
        }
        if(customer.getCustname() != null)
        {
            updateCustomer.setCustname(customer.getCustname());
        }
        if(customer.getGrade() != null)
        {
            updateCustomer.setGrade(customer.getGrade());
        }
        if(customer.hasvalueforopeningamt)
        {
            updateCustomer.setOpeningamt(customer.getOpeningamt());
        }
        if(customer.hasvalueforoutstandingamt)
        {
            updateCustomer.setOutstandingamt(customer.getOutstandingamt());
        }
        if(customer.hasvalueforpaymentamt)
        {
            updateCustomer.setPaymentamt(customer.getPaymentamt());
        }
        if(customer.hasvalueforreceiveamt)
        {
            updateCustomer.setReceiveamt(customer.getReceiveamt());
        }
        if(customer.getPhone() != null)
        {
            updateCustomer.setPhone(customer.getPhone());
        }
        if(customer.getWorkingarea() != null)
        {
            updateCustomer.setWorkingarea(customer.getWorkingarea());
        }
        if(customer.getAgent() != null)
        {
            updateCustomer.setAgent(customer.getAgent());
        }

        if(customer.getOrders().size() > 0) {
            updateCustomer.getOrders().clear();
            for (Order o : customer.getOrders()) {
                Order newOrder = new Order(o.getOrdamount(), o.getAdvanceamount(), updateCustomer, o.getOrderdescription());
                if(o.getPayments().size() > 0) {
                    for (Payment p : o.getPayments()) {
                        Payment newPayment = paymentrepos.findById(p.getPaymentid())
                                .orElseThrow(() -> new EntityNotFoundException("Payment " + p.getPaymentid() + " not found!"));

                        newOrder.getPayments().add(newPayment);
                    }
                }
                updateCustomer.getOrders().add(newOrder);
            }
        }

        return customerrepos.save(updateCustomer);
    }

    // ------ delete -------
    @Transactional
    @Override
    public void delete(long custcode) {
        if(customerrepos.findById(custcode).isPresent())
        {
            customerrepos.deleteById((custcode));
        } else {
            throw new EntityNotFoundException("Customer " + custcode + " not found!");
        }
    }
}
