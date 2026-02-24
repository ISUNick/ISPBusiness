package edu.iastate.cs2280.hw1;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Nick Bafia
 */

public class ISPBusiness
{
    public static Town updatePlain(Town tOld)
    {
        Town tNew = new Town(tOld.getLength(), tOld.getWidth());

        for(int i = 0; i < tOld.getLength(); i++)
        {
            for(int j = 0; j < tOld.getWidth(); j++)
            {
                tNew.grid[i][j] = tOld.grid[i][j].next(tNew);
            }
        }

        return tNew;
    }

    public static int getProfit(Town town)
    {
        int profit = 0;

        for(int i = 0; i < town.getLength(); i++)
        {
            for(int j = 0; j < town.getWidth(); j++)
            {
                if(town.grid[i][j].who() == State.CASUAL)
                {
                    profit++;
                }
            }
        }

        return profit;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Town town = null;

        try
        {
            System.out.println(
                "How to populate grid (type 1 or 2): 1: from a file. 2: randomly with seed"
            );

            int choice = sc.nextInt();

            if(choice == 1)
            {
                System.out.println("Please enter file path:");
                String file = sc.next();
                town = new Town(file);
            }
            else if(choice == 2)
            {
                System.out.println(
                    "Provide rows, cols and seed integer separated by spaces:"
                );

                int rows = sc.nextInt();
                int cols = sc.nextInt();
                int seed = sc.nextInt();

                town = new Town(rows, cols);
                town.randomInit(seed);
            }
            else
            {
                System.out.println("Invalid choice.");
                sc.close();
                return;
            }

            int totalProfit = 0;
            int maxProfitPerCycle =
                town.getLength() * town.getWidth();

            for(int cycle = 0; cycle < 12; cycle++)
            {
                totalProfit += getProfit(town);
                town = updatePlain(town);
            }

            double utilization =
                (double) totalProfit /
                (12 * maxProfitPerCycle) * 100.0;

            System.out.printf("%.2f%%\n", utilization);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found.");
        }
        catch(Exception e)
        {
            System.out.println("Input error.");
        }

        sc.close();
    }
}



