package internal.example.spring.flight;

import internal.example.spring.flight.data.FlightService;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootConfiguration
@EnableAutoConfiguration
@EnableScheduling
@ComponentScan
public class FlightConfiguration {

    @Bean
    public FlightService flightService() {
        return new FlightService();
    }
}
