package internal.example.spring.booking;

import internal.example.spring.booking.business.BookingService;
import internal.example.spring.booking.business.CustomerDoesNotExistException;
import internal.example.spring.booking.business.FlightDoesNotExistException;
import internal.example.spring.booking.data.Booking;
import internal.example.spring.booking.data.BookingRepository;
import internal.example.spring.customer.data.Customer;
import internal.example.spring.customer.data.CustomerRepository;
import internal.example.spring.flight.data.Flight;
import internal.example.spring.flight.data.FlightService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BookingServiceTest {

    private CustomerRepository customerRepository = Mockito.mock(CustomerRepository.class);

    private FlightService flightService = Mockito.mock(FlightService.class);

    private BookingRepository bookingRepository = Mockito.mock(BookingRepository.class);

    private BookingService bookingService;

    @BeforeEach
    void setup() {
        this.bookingService = new BookingService(bookingRepository, customerRepository, flightService);
    }

    @Test
    void bookFlightReturnsBooking() throws CustomerDoesNotExistException, FlightDoesNotExistException {
        when(customerRepository.findById(42L)).thenReturn(customer());
        when(flightService.findFlight("Oceanic 815")).thenReturn(flight());
        when(bookingRepository.save(eq(booking()))).thenReturn(booking());

        Booking booking = bookingService.bookFlight(42L, "Oceanic 815");

        assertThat(booking).isNotNull();
        verify(bookingRepository).save(eq(booking));

    }

    private Optional<Flight> flight() {
        return Optional.of(Flight.builder()
        .flightNumber("Oceanic 815")
        .airLine("Oceanic")
        .build());
    }

    private Booking booking() {
        return Booking.builder()
                .flightNumber("Oceanic 815")
                .customer(customer().get())
                .build();
    }

    private Optional<Customer> customer() {
        return Optional.of(Customer.builder()
                .id(42L)
                .name("Hurley")
                .build());
    }
}
