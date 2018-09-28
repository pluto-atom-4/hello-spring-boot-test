package internal.example.spring.booking.web;

import internal.example.spring.booking.business.BookingService;
import internal.example.spring.booking.business.CustomerDoesNotExistException;
import internal.example.spring.booking.business.FlightDoesNotExistException;
import internal.example.spring.booking.data.Booking;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = {BookingController.class})
public class BookingControllerTest {

    @MockBean
    private BookingService bookingService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void bookFlightReturnsHttpStatusOk() throws Exception, CustomerDoesNotExistException, FlightDoesNotExistException {
        when(bookingService.bookFlight(eq(42L), eq("Oceanic 815")))
                .thenReturn(expectedBooking());

        mockMvc.perform(post("/booking")
                .param("customerId", "42")
                .param("flightNumber", "Oceanic 815"))
                .andExpect(status().isOk());
    }

    private Booking expectedBooking() {
        return null;
    }
}
