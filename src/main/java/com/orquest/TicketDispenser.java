package com.orquest;

public class TicketDispenser {

    private final TurnNumberSequenceProvider turnNumberSequence;

    public TicketDispenser() {
        this(new TurnNumberSequence());
    }

    public TicketDispenser(TurnNumberSequenceProvider turnNumberSequence) {
        this.turnNumberSequence = turnNumberSequence;
    }

    public TurnTicket getTurnTicket() {
        int newTurnNumber = turnNumberSequence.getNextTurnNumber();
        return new TurnTicket(newTurnNumber);
    }
}
