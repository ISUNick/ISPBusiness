package edu.iastate.cs2280.hw1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * @author Nick Bafia
 */

public class EmptyTest
{
    @Test
    void testWhoEmpty()
    {
        Town t = new Town(3, 3);
        Empty e = new Empty(t, 1, 1);

        assertEquals(State.EMPTY, e.who());
    }

    @Test
    void testNextEmpty()
    {
        Town t = new Town(3, 3);
        t.randomInit(7);

        Empty e = new Empty(t, 1, 1);

        Town nextTown = new Town(3, 3);
        nextTown.randomInit(8);

        assertNotNull(e.next(nextTown));
    }
}


