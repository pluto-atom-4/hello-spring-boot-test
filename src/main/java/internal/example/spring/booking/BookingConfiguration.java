package internal.example.spring.booking;

import internal.example.spring.booking.business.BookingService;
import internal.example.spring.booking.data.BookingRepository;
import internal.example.spring.customer.CustomerConfiguration;
import internal.example.spring.customer.data.CustomerRepository;
import internal.example.spring.flight.FlightConfiguration;
import internal.example.spring.flight.data.FlightService;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootConfiguration
@Import({CustomerConfiguration.class, FlightConfiguration.class})
@EnableAutoConfiguration
@ComponentScan
public class BookingConfiguration {

    @Bean
    public BookingService bookingService(
            BookingRepository bookingRepository,
            CustomerRepository customerRepository,
            FlightService flightService) {
        return new BookingService(bookingRepository, customerRepository, flightService);
    }
}
