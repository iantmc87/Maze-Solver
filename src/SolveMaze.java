/*
 *  Author - Ian McManus
 *  Date - 14th May 2019
 *  Title - Gentrack Maze Technical Test V5
 */

public class SolveMaze {
	
	public char [][] maze;
	public int height;
	public int width;
	public boolean reachedEnd = false;
	
	/**
	 * constructor for the maze class
	 * @param maze array to hold the maze
	 * @param height maze height
	 * @param width maze width
	 */
	public SolveMaze (char [][] maze, int height, int width) {
		
		this.maze = maze;
		this.height = height;
		this.width = width;
	}//end solveMaze constructor
	
	/**
	 * method for the first step and creating the start position
	 * @param x vertical axis
	 * @param y horizontal axis
	 */
	public void solve(int x, int y) {
		
		if(move(x,y)) {
			
			maze[x][y] = 'S';
		}//end if
	}//end solve method
	
	/**
	 * Method for the route through the maze
	 * @param x this is the vertical axis
	 * @param y - this is the horizontal axis
	 * @return boolean
	 */
public boolean move (int x, int y) {
				
		//if statement for if the step reaches the end of the maze
		if (maze[x][y] == 'E') {
			
			reachedEnd = true;
			return true;
		}//end if
		
		//if statement for checking if the step hits a wall or its created route
		if (maze[x][y] == '#' || maze[x][y] == 'X') {
			
			return false;
		}//end if
		
		//if statement for if the step needs to wrap around to opposite side of the maze
		if(maze[x][y] == 'T' || maze[x][y] == 'R' || maze[x][y] == 'L' || maze[x][y] == 'B') {
			
			//if statement for checking and wrapping if step needs to wrap round horizontally left to right
			if(maze[x][y] == 'L') {
				
				if((move(x, y + (width-2))) == true) {
				return true;
				}
			}//end if
			
			//if statement for checking and wrapping if step needs to wrap round horizontally right to left
			if(maze[x][y] == 'R') {
				
				if((move(x, y - (width-2))) == true) {
					return true;
				}
			}//end if
			
			//if statement for checking and wrapping if step needs to wrap round vertically top to bottom
			if(maze[x][y] == 'T') {
				
				if((move(x + (height - 2), y)) == true) {
					return true;
				}
			}//end if
			
			//if statement for checking and wrapping if step needs to wrap round vertically bottom to top
			if(maze[x][y] == 'B') {
				
				if((move(x - (height - 2), y)) == true) {
					return true;
				}
			}//end if
			
			return false;
		}
		
		maze[x][y] = 'X';
		
		     
        //if statement for moving east
        if ((move(x , y + 1)) == true) {
            
        	return true;
        }//end if
        
        //if statement for moving south
        if ((move(x + 1, y)) == true) {
            
        	return true;
        }//end if
        
        //if statement for moving north
        if ((move(x - 1 , y)) == true) {
            
        	return true;
        }//end if
        
        //if statement for moving west
        if ((move(x, y - 1)) == true) {
            
        	return true;
        }//end if

        maze[x][y] = ' ';
        
        return false;
	}//end step method

}//end class
