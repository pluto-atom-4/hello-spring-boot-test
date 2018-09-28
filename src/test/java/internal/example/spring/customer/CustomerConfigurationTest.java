package internal.example.spring.customer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CustomerConfiguration.class)
public class CustomerConfigurationTest {

    @Test
    void bookingConfigurationLoads() {
    }
}
