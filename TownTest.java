package edu.iastate.cs2280.hw1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * @author Nick Bafia
 */

public class TownTest
{
    @Test
    void testConstructorDimensions()
    {
        Town t = new Town(4, 5);

        assertEquals(4, t.getLength());
        assertEquals(5, t.getWidth());
    }

    @Test
    void testRandomInitCreatesCells()
    {
        Town t = new Town(3, 3);
        t.randomInit(10);

        assertNotNull(t.grid[0][0]);
    }

    @Test
    void testToStringOutput()
    {
        Town t = new Town(3, 3);
        t.randomInit(1);

        String s = t.toString();

        assertFalse(s.isEmpty());
    }

    @Test
    void testFileConstructor() throws Exception
    {
        Town t = new Town("sample.txt");

        assertNotNull(t.grid);
    }
}

