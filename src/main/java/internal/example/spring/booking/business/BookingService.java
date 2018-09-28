package internal.example.spring.booking.business;

import internal.example.spring.booking.data.Booking;
import internal.example.spring.booking.data.BookingRepository;
import internal.example.spring.customer.data.Customer;
import internal.example.spring.customer.data.CustomerRepository;
import internal.example.spring.flight.data.Flight;
import internal.example.spring.flight.data.FlightService;

import java.util.Optional;

public class BookingService {

    private BookingRepository bookingRepository;
    private CustomerRepository customerRepository;
    FlightService flightService;

    public BookingService(BookingRepository bookingRepository, CustomerRepository customerConfiguration, FlightService flightService) {
        this.bookingRepository = bookingRepository;
        this.customerRepository = customerConfiguration;
        this.flightService = flightService;
    }

    public Booking bookFlight(long customerId, String flightNumber) throws CustomerDoesNotExistException, FlightDoesNotExistException {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (!customer.isPresent()) {
            throw new CustomerDoesNotExistException(customerId);
        }
        Optional<Flight> flight = flightService.findFlight(flightNumber);
        if (!flight.isPresent()) {
            throw new FlightDoesNotExistException(flightNumber);
        }
        Booking booking = Booking.builder()
                .customer(customer.get())
                .flightNumber(flight.get().getFlightNumber())
                .build();

        return this.bookingRepository.save(booking);
    }
}
