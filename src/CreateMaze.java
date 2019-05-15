import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 *  Author - Ian McManus
 *  Date - 14th May 2019
 *  Title - Maze Solver
 */

public class CreateMaze {
	
	  char [][] maze;
	  int width;
	  int height;
	  public int startX, startY, endX, endY;
		 
	  /**
	   * method for importing and creating the maze
	   * @param filename the filename of the maze to be imported
	   * @throws FileNotFoundException if file not found
	   * @throws IOException if invalid input or output
	   */
	  public void MazeInput (String filename) throws FileNotFoundException, IOException {
			 
		  //reads in the text file
		  BufferedReader br = new BufferedReader(new FileReader(filename));
		 
		  int heightCounter = 1;
	
		  //reads first line and splits to extract the height and width
		  //2 added to the height and width to create a larger array to enable maze wrapping
		  String line = br.readLine();
		  String[] tokens = line.split("\\s");
		  width = Integer.parseInt(tokens[0]) + 2;
		  height = Integer.parseInt(tokens[1]) + 2;
		  
		  //reads second line and splits to extract the start position
		  //1 added to each axis to cater for the larger array needed for maze wrapping
		  line = br.readLine();
		  tokens = line.split("\\s");
		  startX = Integer.parseInt(tokens[0]) + 1;
		  startY = Integer.parseInt(tokens[1]) + 1;
			 
		  //reads third line and splits to extract the end position
		  //1 added to each axis to cater for the larger array needed for maze wrapping
		  line = br.readLine();
		  tokens = line.split("\\s");
		  endX = Integer.parseInt(tokens[0]) + 1;
		  endY = Integer.parseInt(tokens[1]) + 1;
			 
		  //creates 2d array
		  maze = new char[height][width];
		  
		  //for loop for adding left and right markers for maze wrapping
		  for(int j = 1; j < height - 1; j++) {
			  
			  maze[j][0] = 'L';
			  maze[j][width - 1] = 'R';
		  }//end for loop
		  
		  //for loop for adding top and bottom markers for maze wrapping
		  for(int j = 1; j < width - 1; j++) {
			  
			  maze[0][j] = 'T';
			  maze[height - 1][j] = 'B';
		  }//end for loop
			 
		  //while loop for reading through the remaining lines to read into the array
		  while((line = br.readLine()) != null) {
		
			  int widthCounter = 1;

			  //for loop for updating the maze array with the data from the maze in the text file
			  for(int i = 0; i < line.length(); i++) {
				  if(line.charAt(i) != ' ') {
					  
					  maze[heightCounter][widthCounter] = line.charAt(i);
					  
					  //if statement for changing the original walls to # symbol
					  if(maze[heightCounter][widthCounter] == '1') {
						  
						  maze[heightCounter][widthCounter] = '#';
	                  }//end if
	            
					  //if statement for changing the original path markers to a space
					  if(maze[heightCounter][widthCounter] == '0') {
	                   
						  maze[heightCounter][widthCounter] = ' ';
	                  }//end if
					  
					  widthCounter++;
				  }
	       				 
	       	 }//end for loop
	  		 heightCounter++;
		  }//end while loop
			 
		  //closes buffered reader input
		  br.close();	 
	  }//end maze input method
	  
	  /**
	   * print the maze upon completion
	   */
	  public String toString() {
			String print = "";
			for (int x=0; x < height; x++) {
			
				for (int y=0; y < width; y++) {
				
					//if statement for converting the maze wrapper markers to blank spaces
					if(maze[x][y] == 'T' || maze[x][y] == 'L' || maze[x][y] == 'R' || maze[x][y] == 'B')
					{
						maze[x][y] = ' ';
					}//end if
					print += maze[x][y];
				}
				print += "\n";
			}//end for loop
			return print;
		}
}//end class
