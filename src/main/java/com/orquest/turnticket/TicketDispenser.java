package com.orquest.turnticket;

public class TicketDispenser {

    private final TurnProvider turnNumberSequence;

    public TicketDispenser() {
        this(new InMemoryTurnProvider());
    }

    public TicketDispenser(TurnProvider turnNumberSequence) {
        this.turnNumberSequence = turnNumberSequence;
    }

    public TurnTicket getTurnTicket() {
        return new TurnTicket(turnNumberSequence.getNextTurn());
    }
}
