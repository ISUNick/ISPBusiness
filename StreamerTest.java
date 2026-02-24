package edu.iastate.cs2280.hw1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * @author Nick Bafia
 */

public class StreamerTest
{
    @Test
    void testWhoStreamer()
    {
        Town t = new Town(3, 3);
        Streamer s = new Streamer(t, 1, 1);

        assertEquals(State.STREAMER, s.who());
    }

    @Test
    void testNextStreamer()
    {
        Town t = new Town(3, 3);
        t.randomInit(3);

        Streamer s = new Streamer(t, 1, 1);

        Town nextTown = new Town(3, 3);
        nextTown.randomInit(4);

        assertNotNull(s.next(nextTown));
    }
}



