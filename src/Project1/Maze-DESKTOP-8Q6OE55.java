/* Class: CS1302-03
 * Name: Ethan Nguyen, Joseph Nguyen, Alex Day
 * Project 1
 * Instructor: Monisha Verma
 */

package Project1;



public class Maze 
{
	//private char direction;
    
	// x position of the mouse
	private int column;  
		
    //y position of the mouse
	private int row;  
	    
	private boolean exitFound;
	 
	
	private int [][] myMaze;

	

	  
	
	public Maze(int[][] arrMaze) 
	{
		//imports maze
		this.myMaze = arrMaze;
		this.row = 0;
		this.column = 0;
		
			 
		 
    }

    

	//Prints out the maze without solution
    public void displayMaze() 
	{
    	 
	      System.out.println();

	      for (int row=0; row < myMaze.length; row++) {
	         for (int column=0; column < myMaze[row].length; column++)
	            System.out.print (myMaze[row][column]);
	         System.out.println();
	      }

	      System.out.println();
    }

    

	//displays the Maze with the if the path is taken
   	public void displayPath(int row, int column) 
	{
   		//path taken is marked with int "7"
   		myMaze[row][column] = 7;
   		
    }


    

	public boolean takeStep(int row, int column) 
	{
		
		
		if (isAnExit(row, column))
	      {
			myMaze[row][column] = 0;  // cell has been tried --> mark myMaze[y][x] with int "3" if already visited

	         if (row == myMaze.length-1 && column == myMaze[0].length-1)
	         {
	        	 exitFound = true;  // maze is solved
	         }
	         
	         findExit(row - 1, column + 1);
	       }
		       
		return isAnExit(column, row);
    
	}

    

	private boolean moveNorth(int row, int column) 
	{
		
		return findExit(row - 1, column);  
	}

    

	private boolean moveSouth(int row, int column) 
	{
        
		return findExit(row + 1, column);

    
	}

    

	private boolean moveEast(int row, int column) 
	{
        
		return findExit(row, column + 1);
    
	}

    

	private boolean moveWest(int row, int column) 
	{
        
		return findExit(row, column - 1);
    
	}


    
	//checks to see if the current myMaze[y][x] is blocked, visited, or is a wall or "valid"
	 boolean isAnExit(int row, int column) 
	{
       
		boolean result = false;
		 
	      // check if cell is in the bounds of the array
	      if (row >= 0 && row < myMaze.length &&
	       column >= 0 && column < myMaze[0].length)

	         //  check if cell is not blocked and not previously tried
	         if (myMaze[row][column] == 1)
	            {
	        	 result = true;
	            }
	      
	     // displayMaze();
	      return result;
	      
	      

	    
    
	}

    

	//finds the path without stopping at every step
    public boolean findExit(int row, int column) 
	{
    	    //row = this.row;
    	    //column = this.column;
    	    
		   exitFound = false;
		    
		     
		      if (isAnExit(row, column))
		      {

		         
		         myMaze[row][column] = 0;  // cell has been tried --> mark myMaze[y][x] with int "3" if already visited
		         
		         
		         if (row == myMaze.length-1 && column == myMaze[0].length-1)
		         {
		        	 exitFound = true;  // maze is solved
		        	 
		         }
		         
		         
		         		      
		         else 
		         {
		    	  //combines all direction methods 
		    	    exitFound = moveNorth(row, column);  // north
		            if (!exitFound)
		            {
		               exitFound = moveEast(row, column);  // east
		            }
		            if (!exitFound)
		            {
		            	exitFound = moveSouth(row, column);  // south
		            }
		            if (!exitFound)
		            {
		            	exitFound = moveWest(row, column);  // west
		            }
		            
		         }
		         if (exitFound)  // part of the final path
		         {
		        	 displayPath(row, column);
		        	 //displayMaze();
		         }		
		      
		      		      
		     }
		      return exitFound;
	}
      
   //getters for the rows and columns
   public int getX()
   {
	   return column;
   }
   
   public int getY()
   {
	   return row;
   }
}
