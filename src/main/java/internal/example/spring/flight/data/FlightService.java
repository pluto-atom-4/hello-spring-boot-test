package internal.example.spring.flight.data;

import java.util.Optional;

public class FlightService {

    public Optional<Flight> findFlight(String flightNumber) {
        return Optional.of(Flight.builder()
                .airLine("Ocenanic")
                .flightNumber("815")
                .build());
    }
}
