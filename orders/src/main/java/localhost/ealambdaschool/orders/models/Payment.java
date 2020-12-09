package localhost.ealambdaschool.orders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "payments")
public class Payment {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private long paymentID;
 @Column(nullable = false,
            unique = true)
    private String type;

 @ManyToMany(mappedBy ="payments")
    @JsonIgnoreProperties("payment")
    private Set<Order> orders = new HashSet<>();

    public Payment() {
    }

    public Payment(String type) {
        this.type = type;
    }

    public long getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(long paymentID) {
        this.paymentID = paymentID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentID=" + paymentID +
                ", type='" + type + '\'' +
                ", orders=" + orders +
                '}';
    }
}
