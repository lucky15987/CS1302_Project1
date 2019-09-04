/* Class: CS1302-03
 * Name: Ethan Nguyen, Joseph Nguyen, Alex Day
 * Project 1
 * Instructor: Monisha Verma
 * 
 *---------------------------------------------------------------------------------------------------------------------------
 *	Notes:
 *	sources/referance:
 *	https://www.cs.bu.edu/teaching/alg/maze/  <----this source was used to understand baccktracking, recursion, directions.
 *
 * 	This program takes in an array and either solves it completly or solves it one step at a time.
 *
 *---------------------------------------------------------------------------------------------------------------------------
 */

package Project1;

import java.util.Scanner;

public class TestMaze 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		
//*
 int[][] mazeArray = {
 
				{1,1,1,0,1,1,0,0,0,1,1,1,1},
                {1,0,1,1,1,0,1,1,1,1,0,0,1},
                {0,0,0,0,1,0,1,0,1,0,1,0,0},
                {1,1,1,0,1,1,1,0,1,0,1,1,1},
                {1,0,1,0,0,0,0,1,1,1,0,0,1},
                {1,0,1,1,1,1,1,1,0,1,1,1,1},
                {1,0,0,0,0,0,0,0,0,0,0,0,0},
                {1,1,1,1,1,1,1,1,1,1,1,1,1}
							};
/*/
/*
		int[][] mazeArray = {
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},
                {0,0,0,1,1,1,1,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,1,1,1,1,1},
                {0,0,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,1,1,1,1,1,1,0,0,0},
                {0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0},
                {1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0},
                {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
	*/	
        Maze myMaze = new Maze(mazeArray);
        boolean keepAsking = true;
        Scanner scan = new Scanner(System.in);
        String input = "";
        
        System.out.println("Maze Project---");
        

        do {
        	myMaze.displayMaze();
        	System.out.println("T = Take a step | S = Show path | Q = Quit");            
            System.out.print("Enter command: ");
            input = scan.nextLine();
            input.trim();
            input.toLowerCase();
            if(input.equals("t")) 
            {
               //if user inputs "t" do one iteration of the solve program.
            	keepAsking = !myMaze.takeStep(myMaze.getY(), myMaze.getX());
            } 
            else if(input.equals("s")) 
            {
            	//if user inputs "s", program will solve the maze entirely marking the path with "7"
                if (myMaze.findExit(myMaze.getY(), myMaze.getX()))
	         		{
                		System.out.println ("\nMaze solved!");
                		
	         		}
	      		else
	         		{
	      				System.out.println ("\nNo solution.");
	      				
	         		}

                myMaze.displayMaze();
                                  
                keepAsking = false;
            } 
            else if(input.equals("q")) 
            {
                keepAsking = false;
            }
            else 
            {
                System.out.println("ERR: Invalid input");
            }
        }
        
        while(keepAsking);
        {
        	System.out.println("Quitting program...");
        	scan.close();
        }
        
    }
	

}
