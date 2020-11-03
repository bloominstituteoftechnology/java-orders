package com.lambdaschool.orders.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
@Table(name ="payments")
public class Payment {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long paymentid;

   @Column(nullable = false, unique = true)
    private String type;

   @ManyToMany(mappedBy = "payments")
    private Set<Customer> customers = new HashSet<>();

    public Payment() {
    }

    public Payment(String type) {
        this.type = type;
    }

    public long getPaymentid()
    {
        return paymentid;
    }

    public void setPaymentid(long paymentid)
    {
        this.paymentid = paymentid;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public Set<Customer> getCustomers()
    {
        return customers;
    }

    public void setCustomers(Set<Customer> customers)
    {
        this.customers = customers;
    }
}

