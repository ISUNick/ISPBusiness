package edu.iastate.cs2280.hw1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class OutageTest {

    @Test
    void testWho() {
        Town t = new Town(3, 3);
        // fill grid with Empty so neighbors exist
        for(int r=0; r<3; r++) {
            for(int c=0; c<3; c++) {
                t.grid[r][c] = new Empty(t, r, c);
            }
        }

        Outage o = new Outage(t, 1, 1);
        t.grid[1][1] = o;

        assertEquals(State.OUTAGE, o.who());
    }

    @Test
    void testNext() {
        Town t = new Town(3, 3);
        for(int r=0; r<3; r++) {
            for(int c=0; c<3; c++) {
                t.grid[r][c] = new Empty(t, r, c);
            }
        }

        Outage o = new Outage(t, 1, 1);
        t.grid[1][1] = o;

        Town nextTown = new Town(3, 3);
        for(int r=0; r<3; r++) {
            for(int c=0; c<3; c++) {
                nextTown.grid[r][c] = new Empty(nextTown, r, c);
            }
        }

        TownCell nextCell = o.next(nextTown);
        assertEquals(State.EMPTY, nextCell.who());
    }
}



