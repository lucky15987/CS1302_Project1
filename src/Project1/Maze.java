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



public class Maze 
{
	//private char direction;
    
	// x position of the mouse
	private int column;  
		
    //y position of the mouse
	private int row;  
	    
	private boolean exitFound; 	//boolean for knowing if exit is reached
	 
	
	private int [][] myMaze;  //user array

	

	  
	
	public Maze(int[][] arrMaze) //takes in an array
	{
		//assigns maze to myMaze[][]
		this.myMaze = arrMaze;
		
		//set starting position
		//this.row = (myMaze.length-1);
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


    
// takes one step forward (starting north) if condition is met (myMaze[row][column] == 1) it will mark the cell with "7" then repeat back again.
	public boolean takeStep(int row, int column) 
	{
		this.column = column;
		this.row = row;
		
		if (isAnExit(row, column)) 
	      {
			myMaze[row][column] = 0;  // cell has been tried --> mark myMaze[y][x] with int "0" if already visited

	         if (row == myMaze.length-1 && column == myMaze[0].length-1)	//if row and column equals the dimensions of the array
	         {
	        	 exitFound = true;  // maze is solved
	         }
	         
	         else if(isAnExit(row - 1, column))  //takes 1 step north, then test for an exit
	         {
	        	 	
	        	 displayPath(row, column);
	        	 this.row = (row-1);			 //sets new row
	        	 try {
	        	 if (myMaze[this.row-1][column] == 0)
	        	 {
	        		findExit(0, 0); 
	        	 }
	        	 }
	        	 catch(ArrayIndexOutOfBoundsException ex)
		        	{
		        		findExit(0, 0); 
		        		displayMaze();
		        	}
	        	 
	        	
	         }
	         else if(isAnExit(row, column + 1))  //takes 1 step east, then test for an exit
        	 {
        	 	
	        	 displayPath(row, column);
	     		this.column = (column+1);		 //sets new column
	     		try {
	     		if (myMaze[row][this.column+1] == 0)
	        	 {
	        		findExit(0, 0); 
	        	 }
	     		}
	     		catch(ArrayIndexOutOfBoundsException ex)
	        	{
	        		findExit(0, 0); 
	        		displayMaze();
	        	}
	        	 
        	 }
	         else if(isAnExit(row + 1, column))  //takes 1 step south, then test for an exit
        	 {
        	 	
	        	 displayPath(row, column);
	        	this.row = (row+1);				 //sets new row
	        	try {
	        	if (myMaze[this.row+1][column] == 0)
	        	 {
	        		findExit(0, 0); 
	        		displayMaze();
	        	 }
	        	}
	        	catch(ArrayIndexOutOfBoundsException ex)
	        	{
	        		findExit(0, 0); 
	        		displayMaze();
	        	}
	        	
        	 }
	         else if(isAnExit(row, column - 1))  //takes 1 step west, then test for an exit
        	 {
        	 	
	        	 displayPath(row, column);
	        	this.column = (column-1);		//sets new column
	        	try {
	        	if (myMaze[row][this.column-1] == 0)
	        	 {
	        		findExit(0, 0); 
	        		
	        	 }
	        	}
	        	catch(ArrayIndexOutOfBoundsException ex)
	        	{
	        		findExit(0, 0); 
	        		displayMaze();
	        	}
	        	
	        	
        	 }
	       }
		       
		return isAnExit(row, column);			//resets the takeAStep() method
    
	}

    
	//moves north
	private boolean moveNorth(int row, int column) 
	{
		
		return findExit(row - 1, column);  
	}

    
	//moves south
	private boolean moveSouth(int row, int column) 
	{
        
		return findExit(row + 1, column);

    
	}

    
	//moves east
	private boolean moveEast(int row, int column) 
	{
        
		return findExit(row, column + 1);
    
	}

    
	//moves west
	private boolean moveWest(int row, int column) 
	{
        
		return findExit(row, column - 1);
    
	}


    
	//checks to see if the current myMaze[y][x] is blocked, visited, or is a wall
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

    

	//finds the path without stopping at every step (solves the Array)
    public boolean findExit(int row, int column) 
	{
    	   
    	    
		   exitFound = false;
		    
		     
		      if (isAnExit(row, column))
		      {

		         
		         myMaze[row][column] = 0;  // cell has been tried --> mark myMaze[y][x] with int "0" if already visited
		         
		         
		         if (row == myMaze.length-1 && column == myMaze[0].length-1) //test to see if myMaze[row][column] is at the end of the array
		         {
		        	 exitFound = true;  // maze is solved
		        	 
		         }
		         
		         
		         		      
		         else 
		         {
		    	  //combines all direction methods and completely solves the array
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
		        	 displayPath(row, column); //diplay "7" for the correct path
		        	 
		         }		
		      
		      		      
		     }
		      return exitFound;
	}
      
   //getters and setters for the rows and columns
   public int getX()
   {
	   return column;
   }
   
   public int getY()
   {
	   return row;
   }
   
   public int setX(int column)
   {
	   return this.column = column;
   }
   
   public int setY(int row)
   {
	   return this.row = row;
   }
}
