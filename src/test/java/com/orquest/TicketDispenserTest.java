package com.orquest;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
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

    @Test
    void should_retrieve_two_different_tickets_from_two_dispensers() {
        // Given
        var dispenserOne = new TicketDispenser();
        var dispenserTwo = new TicketDispenser();

        // When
        var ticketOne = dispenserOne.getTurnTicket();
        var ticketTwo = dispenserTwo.getTurnTicket();

        // Then
        assertNotEquals(ticketOne.getTurnNumber(), ticketTwo.getTurnNumber());
    }
}
