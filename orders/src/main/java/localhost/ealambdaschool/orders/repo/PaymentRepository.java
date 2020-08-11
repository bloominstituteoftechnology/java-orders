package localhost.ealambdaschool.orders.repo;

import localhost.ealambdaschool.orders.models.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
}
