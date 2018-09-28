package internal.example.spring.booking.business;

public class FlightDoesNotExistException extends Throwable {
    public FlightDoesNotExistException(String flightNumber) {
        super(String.format("A flight with ID '%d' doesn't exist!",flightNumber));
    }
}
