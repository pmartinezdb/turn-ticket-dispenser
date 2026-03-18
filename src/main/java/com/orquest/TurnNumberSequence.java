package com.orquest;

import java.util.concurrent.atomic.AtomicInteger;

public class TurnNumberSequence implements TurnNumberSequenceProvider {
    private static final AtomicInteger turnNumber = new AtomicInteger(0);

    @Override
    public int getNextTurnNumber() {
        return turnNumber.incrementAndGet();
    }
}
