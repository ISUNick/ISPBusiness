package edu.iastate.cs2280.hw1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * @author Nick Bafia
 */

public class CasualTest
{
    @Test
    void testNextCasual()
    {
        Town t = new Town(3, 3);
        t.randomInit(1);

        Casual c = new Casual(t, 1, 1);

        Town nextTown = new Town(3, 3);
        nextTown.randomInit(2);

        assertNotNull(c.next(nextTown));
    }

    @Test
    void testWhoCasual()
    {
        Town t = new Town(3, 3);
        Casual c = new Casual(t, 1, 1);

        assertEquals(State.CASUAL, c.who());
    }
}







