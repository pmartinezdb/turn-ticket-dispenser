package com.orquest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TicketDispenserTest {

    @Test
    void foo() {
        TicketDispenser dispenser = new TicketDispenser();
        TurnTicket ticket = dispenser.getTurnTicket();
        assertEquals(-1, ticket.getTurnNumber());
    }

}
