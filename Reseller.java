package edu.iastate.cs2280.hw1;

/**
 * @author Nick Bafia
 */

public class Reseller extends TownCell
{
    public Reseller(Town p, int r, int c)
    {
        super(p, r, c);
    }

    public State who()
    {
        return State.RESELLER;
    }

    public TownCell next(Town tNew)
    {
        census(nCensus);

        if(nCensus[CASUAL] <= 3 || nCensus[EMPTY] >= 3)
        {
            return new Empty(tNew, row, col);
        }

        return new Reseller(tNew, row, col);
    }
}

