package internal.example.spring.booking.web;

import internal.example.spring.booking.business.BookingService;
import internal.example.spring.booking.business.CustomerDoesNotExistException;
import internal.example.spring.booking.business.FlightDoesNotExistException;
import internal.example.spring.booking.data.Booking;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/booking")
    public ResponseEntity<BookingResultResource> bookFlight(
            @RequestParam("customerId") Long customerId,
            @RequestParam("flightNumber") String flightNumber) throws CustomerDoesNotExistException, FlightDoesNotExistException {

        Booking booking = bookingService.bookFlight(customerId, flightNumber);
        BookingResultResource bookingResult = BookingResultResource.builder()
                .success(true)
                .build();
        return ResponseEntity.ok(bookingResult);

    }
}
