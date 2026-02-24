package edu.iastate.cs2280.hw1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * @author Nick Bafia
 */

public class ResellerTest
{
    @Test
    void testWhoReseller()
    {
        Town t = new Town(3, 3);
        Reseller r = new Reseller(t, 1, 1);

        assertEquals(State.RESELLER, r.who());
    }

    @Test
    void testNextReseller()
    {
        Town t = new Town(3, 3);
        t.randomInit(5);

        Reseller r = new Reseller(t, 1, 1);

        Town nextTown = new Town(3, 3);
        nextTown.randomInit(6);

        assertNotNull(r.next(nextTown));
    }
}



