import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;

/*
 *  Author - Ian McManus
 *  Date - 14th May 2019
 *  Title - Gentrack Maze Technical Test V5
 */

public class Maze {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		String input = null;
		Scanner scanner = new Scanner (System.in);
		String userInput = "y";
		
		System.out.println("Welcome to Maze Solver");
		System.out.println("Choose your maze to be solved from the pop up screen that appears");
		
		//while loop for rerunning the maze solver unless specified otherwise
		while(userInput.equalsIgnoreCase("y")) {
			
			//allows the user to choose location of the maze to be imported
			JFileChooser f = new JFileChooser();
		    f.setFileSelectionMode(JFileChooser.FILES_ONLY); 
		    f.setCurrentDirectory(new java.io.File("."));
		    f.setDialogTitle("Load Maze");
		    int result = f.showOpenDialog(null);
		        
		    //if statement for if the user presses load or cancel in the pop up window
		    if(result == JFileChooser.APPROVE_OPTION) {
		        	
		    	File file = f.getSelectedFile();
		    	input = file.getAbsolutePath();
		    } else {
		    
		    	input = null;
		    }//end if       
		
		    //if statement for if a user chooses a file
		    if(input != null) {
				
		    	//creates the maze object
				CreateMaze m = new CreateMaze();
	
				m.MazeInput(input);
			
				//creates the end marker on the maze
				m.maze[m.endY][m.endX] = 'E';
		
				//creates the solve class object
				SolveMaze s = new SolveMaze(m.maze, m.height, m.width);
				s.solve(m.startX, m.startY);
		
				//if statement for printing maze and checking if the maze solvable or not
				if(!s.reachedEnd) {
					System.out.print(m);
					System.out.println("\n\n***Maze unable to be solved***\n");
				} else {
		
					System.out.print(m);
				}//end if
				
		    }//end if
			
		System.out.print("To choose another maze press Y or press any other key to exit");
		userInput = scanner.nextLine();
		}
		
		scanner.close();
		
		System.out.print("\nYou are now exiting Maze Solver........");
		
	}//end main method

}//end class
