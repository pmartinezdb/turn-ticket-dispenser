package com.orquest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TicketDispenserTest {

    @Test
    void should_retrieve_new_ticket() {
        // Given
        var dispenser = new TicketDispenser();

        // When
        var ticket = dispenser.getTurnTicket();

        // Then
        assertTrue(ticket.getTurnNumber() >= 0);
    }
}
