package tech.gebel.javaorders.models;

import javax.persistence.*;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "paymentid")
    private long paymentId;

    @Column(nullable = false, unique = true)
    private String type;

    public Payment() {
    }

    public Payment(String type) {
        this.type = type;
    }
}
