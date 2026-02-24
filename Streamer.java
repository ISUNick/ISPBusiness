package edu.iastate.cs2280.hw1;

/**
 * @author Nick Bafia
 */

public class Streamer extends TownCell
{
    public Streamer(Town p, int r, int c)
    {
        super(p, r, c);
    }

    public State who()
    {
        return State.STREAMER;
    }

    public TownCell next(Town tNew)
    {
        census(nCensus);

        if(nCensus[EMPTY] + nCensus[OUTAGE] <= 1)
        {
            return new Reseller(tNew, row, col);
        }

        if(nCensus[RESELLER] > 0)
        {
            return new Outage(tNew, row, col);
        }

        if(nCensus[OUTAGE] > 0)
        {
            return new Empty(tNew, row, col);
        }

        if(nCensus[CASUAL] >= 5)
        {
            return new Streamer(tNew, row, col);
        }

        return new Streamer(tNew, row, col);
    }
}


