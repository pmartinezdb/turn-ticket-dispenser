package com.orquest.turnticket;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

class InMemoryTurnProviderTest {

    @Test
    void should_respect_turns_when_retrieved_from_multiple_threads() {
        // Given
        var provider = new InMemoryTurnProvider();

        // When
        var tickets = IntStream.range(0, 1000)
                .parallel()
                .mapToObj(i -> provider.getNextTurn())
                .toList();

        // Then
        assertTrue(tickets.stream().allMatch(turn -> turn.turn() >= 0));
        assertEquals(tickets.stream().map(Turn::turn).distinct().count(), tickets.size());
    }
}
