package com.orquest.turnticket;

import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryTurnProvider implements TurnNumberSequenceProvider {
    private static final AtomicInteger turnNumber = new AtomicInteger(0);

    @Override
    public Turn getNextTurn() {
        return new Turn(turnNumber.incrementAndGet());
    }
}
