package edu.iastate.cs2280.hw1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * @author Nick Bafia
 */

public class TownCellTest
{
    @Test
    void testWhoNotNull()
    {
        Town t = new Town(2, 2);
        t.randomInit(1);

        TownCell cell = t.grid[0][0];

        assertNotNull(cell.who());
    }

    @Test
    void testCensusNeighborLimit()
    {
        Town t = new Town(3, 3);
        t.randomInit(2);

        TownCell center = t.grid[1][1];
        int[] counts = new int[TownCell.NUM_CELL_TYPE];

        center.census(counts);

        int sum = 0;

        for(int c : counts)
        {
            sum += c;
        }

        assertTrue(sum <= 8);
    }

    @Test
    void testNextReturnsValidCell()
    {
        Town t = new Town(3, 3);
        t.randomInit(3);

        TownCell cell = t.grid[1][1];

        Town nextTown = new Town(3, 3);
        nextTown.randomInit(4);

        TownCell next = cell.next(nextTown);

        assertNotNull(next);
    }
}
