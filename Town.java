package edu.iastate.cs2280.hw1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Nick Bafia
 */

public class Town
{
    private int length, width;
    public TownCell[][] grid;

    public Town(int length, int width)
    {
        this.length = length;
        this.width = width;
        grid = new TownCell[length][width];
    }

    public Town(String inputFileName) throws FileNotFoundException
    {
        Scanner sc = new Scanner(new File(inputFileName));

        length = sc.nextInt();
        width = sc.nextInt();
        sc.nextLine();

        grid = new TownCell[length][width];

        for(int r = 0; r < length; r++)
        {
            String line = sc.nextLine().replaceAll("\\s+", "");

            for(int c = 0; c < width; c++)
            {
                char ch = line.charAt(c);

                switch(ch)
                {
                    case 'C': grid[r][c] = new Casual(this, r, c); break;
                    case 'S': grid[r][c] = new Streamer(this, r, c); break;
                    case 'R': grid[r][c] = new Reseller(this, r, c); break;
                    case 'E': grid[r][c] = new Empty(this, r, c); break;
                    case 'O': grid[r][c] = new Outage(this, r, c); break;
                }
            }
        }

        sc.close();
    }

    public int getWidth()
    {
        return width;
    }

    public int getLength()
    {
        return length;
    }

    public void randomInit(int seed)
    {
        Random rand = new Random(seed);

        for(int r = 0; r < length; r++)
        {
            for(int c = 0; c < width; c++)
            {
                int val = rand.nextInt(5);

                switch(val)
                {
                    case TownCell.RESELLER:
                        grid[r][c] = new Reseller(this, r, c);
                        break;
                    case TownCell.EMPTY:
                        grid[r][c] = new Empty(this, r, c);
                        break;
                    case TownCell.CASUAL:
                        grid[r][c] = new Casual(this, r, c);
                        break;
                    case TownCell.OUTAGE:
                        grid[r][c] = new Outage(this, r, c);
                        break;
                    case TownCell.STREAMER:
                        grid[r][c] = new Streamer(this, r, c);
                        break;
                }
            }
        }
    }

    @Override
    public String toString()
    {
        String s = "";

        for(int r = 0; r < length; r++)
        {
            for(int c = 0; c < width; c++)
            {
                s += grid[r][c].who().toString().charAt(0) + " ";
            }

            s += "\n";
        }

        return s;
    }
}


