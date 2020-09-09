package tech.gebel.javaorders.models;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "payments")
public class Payment {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "paymentid", nullable = false)
  private long paymentId;

  @Column(nullable = false, unique = true)
  private String type;

  @ManyToMany(mappedBy = "payments")
  Set<Order> orders = new HashSet<>();

  public Payment() {}

  public Payment(String type) {
    this.type = type;
  }

  public long getPaymentId() {
    return paymentId;
  }

  public void setPaymentId(long paymentId) {
    this.paymentId = paymentId;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
