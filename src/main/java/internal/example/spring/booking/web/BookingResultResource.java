package internal.example.spring.booking.web;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookingResultResource {

    private boolean success;
}
