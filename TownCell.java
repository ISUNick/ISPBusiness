package edu.iastate.cs2280.hw1;

/**
 * @author Nick Bafia
 */

public abstract class TownCell
{
    protected Town plain;
    protected int row;
    protected int col;

    protected static final int RESELLER = 0;
    protected static final int EMPTY = 1;
    protected static final int CASUAL = 2;
    protected static final int OUTAGE = 3;
    protected static final int STREAMER = 4;

    public static final int NUM_CELL_TYPE = 5;

    public static final int[] nCensus = new int[NUM_CELL_TYPE];

    public TownCell(Town p, int r, int c)
    {
        plain = p;
        row = r;
        col = c;
    }

    public void census(int nCensus[])
    {
        for(int i = 0; i < NUM_CELL_TYPE; i++)
        {
            nCensus[i] = 0;
        }

        for(int r = row - 1; r <= row + 1; r++)
        {
            for(int c = col - 1; c <= col + 1; c++)
            {
                if(r == row && c == col)
                {
                    continue;
                }

                if(r >= 0 && r < plain.getLength()
                        && c >= 0 && c < plain.getWidth())
                {
                    State s = plain.grid[r][c].who();

                    switch(s)
                    {
                        case RESELLER: nCensus[RESELLER]++; break;
                        case EMPTY: nCensus[EMPTY]++; break;
                        case CASUAL: nCensus[CASUAL]++; break;
                        case OUTAGE: nCensus[OUTAGE]++; break;
                        case STREAMER: nCensus[STREAMER]++; break;
                    }
                }
            }
        }
    }

    public abstract State who();

    public abstract TownCell next(Town tNew);
}

