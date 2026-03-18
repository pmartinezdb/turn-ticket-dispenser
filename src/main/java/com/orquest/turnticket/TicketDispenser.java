package com.orquest.turnticket;

public class TicketDispenser {
    private static final InMemoryTurnProvider DEFAULT_TURN_PROVIDER = new InMemoryTurnProvider();

    private final TurnProvider turnNumberSequence;

    public TicketDispenser() {
        this(DEFAULT_TURN_PROVIDER);
    }

    public TicketDispenser(TurnProvider turnNumberSequence) {
        this.turnNumberSequence = turnNumberSequence;
    }

    public TurnTicket getTurnTicket() {
        return new TurnTicket(turnNumberSequence.getNextTurn());
    }
}
