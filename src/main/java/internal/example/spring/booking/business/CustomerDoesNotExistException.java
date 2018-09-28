package internal.example.spring.booking.business;

public class CustomerDoesNotExistException extends Throwable {
    public CustomerDoesNotExistException(long customerId) {
        super(String.format("A customer with ID '%d' doesn't exist!", customerId));
    }
}
