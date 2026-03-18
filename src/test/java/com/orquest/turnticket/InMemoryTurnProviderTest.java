package com.orquest.turnticket;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

class InMemoryTurnProviderTest {

    @Test
    void should_respect_turns_when_retrieved_from_multiple_threads() {
        // Given
        var provider = new InMemoryTurnProvider();

        List<Future<Turn>> tickets;
        try (var pool = Executors.newFixedThreadPool(10)) {
            // When
            tickets = IntStream.range(0, 1000)
                    .mapToObj(i -> pool.submit(provider::getNextTurn))
                    .toList();
        }

        var turns = tickets.stream().map(this::await).toList();

        // Then
        assertTrue(turns.stream().allMatch(turn -> turn.turn() >= 0));
        assertEquals(turns.stream().map(Turn::turn).distinct().count(), tickets.size());
    }

    private Turn await(Future<Turn> future) {
        try {
            return future.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
