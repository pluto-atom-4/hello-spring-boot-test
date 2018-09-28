package internal.example.spring.customer.data;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository repository;

    @Test
    void findsByName() {
        Customer customer = Customer.builder()
                .name("Hurley")
                .build();

        repository.save(customer);

        List<Customer> foundCustomers = repository.findByName("Hurley");
        assertThat(foundCustomers).hasSize(1);
    }
}
