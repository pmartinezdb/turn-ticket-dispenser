package com.orquest.turnticket;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TicketDispenserTest {

    private TurnProvider provider = Mockito.mock(TurnProvider.class);

    @BeforeEach
    void setUp() {
        Mockito.reset(provider);
    }

    @Test
    void should_retrieve_new_ticket() {
        // Given
        when(provider.getNextTurn()).thenReturn(new Turn(1));
        var dispenser = new TicketDispenser(provider);

        // When
        var ticket = dispenser.getTurnTicket();

        // Then
       assertEquals(new Turn(1), ticket.turnNumber());
    }

    @Test
    void should_retrieve_two_different_tickets_from_two_dispensers() {
        // Given
        when(provider.getNextTurn()).thenReturn(new Turn(1), new Turn(2));
        var dispenserOne = new TicketDispenser(provider);
        var dispenserTwo = new TicketDispenser(provider);

        // When
        var ticketOne = dispenserOne.getTurnTicket();
        var ticketTwo = dispenserTwo.getTurnTicket();

        // Then
        assertEquals(new Turn(1), ticketOne.turnNumber());
        assertEquals(new Turn(2), ticketTwo.turnNumber());
    }
}
