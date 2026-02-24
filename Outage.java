package edu.iastate.cs2280.hw1;

/**
 * @author Nick Bafia
 */

public class Outage extends TownCell
{
    public Outage(Town p, int r, int c)
    {
        super(p, r, c);
    }

    public State who()
    {
        return State.OUTAGE;
    }

    public TownCell next(Town tNew)
    {
        return new Empty(tNew, row, col);
    }
}

