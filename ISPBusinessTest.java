package edu.iastate.cs2280.hw1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * @author Nick Bafia
 */

public class ISPBusinessTest
{
    private Town makeTown()
    {
        Town t = new Town(4, 4);
        t.randomInit(5);
        return t;
    }

    @Test
    void testUpdatePlainSize()
    {
        Town t = makeTown();

        Town updated = ISPBusiness.updatePlain(t);

        assertEquals(t.getLength(), updated.getLength());
        assertEquals(t.getWidth(), updated.getWidth());
    }

    @Test
    void testProfitNonNegative()
    {
        Town t = makeTown();

        int profit = ISPBusiness.getProfit(t);

        assertTrue(profit >= 0);
    }
}


