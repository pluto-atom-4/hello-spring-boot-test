package internal.example.spring.booking.data;

import internal.example.spring.customer.data.Customer;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Builder
public class Booking {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Customer customer;

    @Column
    private String flightNumber;
}
