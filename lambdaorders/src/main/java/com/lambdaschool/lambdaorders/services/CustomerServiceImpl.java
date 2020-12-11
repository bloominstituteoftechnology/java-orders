package com.lambdaschool.lambdaorders.services;

import com.lambdaschool.lambdaorders.models.Customer;
import com.lambdaschool.lambdaorders.models.Order;
import com.lambdaschool.lambdaorders.repositories.CustomerRepository;
import com.lambdaschool.lambdaorders.repositories.OrderRepository;
import com.lambdaschool.lambdaorders.repositories.PaymentRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService
    {
        @Autowired
        private CustomerRepository custrepos;

        @Autowired
        private PaymentRepository paymentRepository;

        @Autowired
        private OrderRepository orderRepository;

        @Override
        public List<Customer> findAllCustomers()
        {
            List<Customer> tempList = new ArrayList<>();
            custrepos.findAll().iterator().forEachRemaining(tempList::add);
            return tempList;
        }

        @Override
        public List<Customer> findByCustomername(String custname)
        {
            return custrepos.findByCustnameContainingIgnoringCase(custname);
        }

        @Override
        public Customer findCustomersById(long id) throws EntityNotFoundException
        {
            return custrepos.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer " + id + " Not Found"));
        }

        @Transactional
        @Override
        public Customer save(Customer customer)
        {
            Customer newCustomer = new Customer();
            if(customer.getCustcode() != 0)
            {
                custrepos.findById(customer.getCustcode()).orElseThrow(() -> new EntityNotFoundException("Customer " + customer.getCustcode() + " Not Found"));
                newCustomer.setCustcode(customer.getCustcode());
            }

            newCustomer.setCustname(customer.getCustname());
            newCustomer.setCustcity(customer.getCustcity());
            newCustomer.setWorkingarea(customer.getWorkingarea());
            newCustomer.setCustcountry(customer.getCustcountry());
            newCustomer.setGrade(customer.getGrade());
            newCustomer.setOpeningamt(customer.getOpeningamt());
            newCustomer.setReceiveamt(customer.getReceiveamt());
            newCustomer.setPaymentamt(customer.getPaymentamt());
            newCustomer.setOutstandingamt(customer.getOutstandingamt());
            newCustomer.setPhone(customer.getPhone());

            newCustomer.getOrders().clear();
            for (Order o : customer.getOrders())
            {
                Order newOrder = new Order();
                newOrder.setAdvanceamount(o.getAdvanceamount());
                newOrder.setOrdamount(o.getOrdamount());
                newOrder.setOrderdescription(o.getOrderdescription());
                newOrder.setCustomer(newCustomer);
                newCustomer.getOrders().add(newOrder);
            }
            return custrepos.save(newCustomer);
        }

        @Transactional
        @Override
        public Customer update(Customer customer, long custcode)
        {
            Customer updateCustomer = custrepos.findById(custcode).orElseThrow(()-> new EntityNotFoundException("Customer " + custcode));
            if (customer.getCustname() != null)
            {
                updateCustomer.setCustname(customer.getCustname());

            }
            if (customer.getCustcity() != null)
            {
                updateCustomer.setCustcity(customer.getCustcity());

            }
            if (customer.getWorkingarea() != null)
            {
                updateCustomer.setWorkingarea(customer.getWorkingarea());

            }
            if (customer.getCustcountry() != null)
            {
                updateCustomer.setCustcountry(customer.getCustcountry());

            }
            if (customer.getGrade() != null)
            {
                updateCustomer.setGrade(customer.getGrade());

            }
            if (customer.getOpeningamt() != 0.00)
            {
                updateCustomer.setOpeningamt(customer.getOpeningamt());

            }
            if (customer.getReceiveamt() != 0.00)
            {
                updateCustomer.setReceiveamt(customer.getReceiveamt());

            }
            if (customer.getPaymentamt() != 0.00)
            {
                updateCustomer.setPaymentamt(customer.getPaymentamt());

            }
            if (customer.getOutstandingamt() != 0.00)
            {
                updateCustomer.setOutstandingamt(customer.getOutstandingamt());

            }
            if (customer.getPhone() != null)
            {
                updateCustomer.setPhone(customer.getPhone());
            }

            if(customer.getOrders().size() > 0)
            {
                updateCustomer.getOrders().clear();
                for(Order o : customer.getOrders())
                {
                    Order newOrder = new Order();
                    newOrder.setAdvanceamount(o.getAdvanceamount());
                    newOrder.setOrdamount(o.getOrdamount());
                    newOrder.setOrderdescription(o.getOrderdescription());
                    Customer newCustomer = new Customer();
                    newOrder.setCustomer(newCustomer);
                    newCustomer.getOrders().add(newOrder);
                }
            }
            return custrepos.save(updateCustomer);
        }

        @Transactional
        @Override
        public void deleteAll()
        {
            custrepos.deleteAll();
        }

        @Override
        public void delete(long custcode) {
            custrepos.delete();
        }
    }

