package com.orquest.turnticket;

public class TicketDispenser {

    private final TurnNumberSequenceProvider turnNumberSequence;

    public TicketDispenser() {
        this(new InMemoryTurnProvider());
    }

    public TicketDispenser(TurnNumberSequenceProvider turnNumberSequence) {
        this.turnNumberSequence = turnNumberSequence;
    }

    public TurnTicket getTurnTicket() {
        return new TurnTicket(turnNumberSequence.getNextTurn());
    }
}
