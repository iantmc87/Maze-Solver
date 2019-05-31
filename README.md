# Maze Solver
Java Implementation of a simple maze solver

This program will solve simple mazes, by reading in a maze file, solving the maze then outputting the solution.

<hr>

<b>Maze Input/Output</b>
<br>The input is a maze description file in plain text
<br>1 - wall
<br>0 - passage way

(Width)(Height) - size of the maze
<br>(Start_X)(Start_Y) - Location of the start (0,0) is upper left
<br>(End_X)(End_Y) - Location of the end

Example File:
<br> 10 10
<br>1 1
<br>8 8
<br>1 1 1 1 1 1 1 1 1 1
<br>1 0 0 0 0 0 0 0 0 1
<br>1 0 1 0 1 1 1 1 1 1
<br>1 0 1 0 0 0 0 0 0 1
<br>1 0 1 1 0 1 0 1 1 1
<br>1 0 1 0 0 1 0 1 0 1
<br>1 0 1 0 0 0 0 0 0 1
<br>1 0 1 1 1 0 1 1 1 1
<br>1 0 1 0 0 0 0 0 0 1
<br>1 1 1 1 1 1 1 1 1 1

Example Output:
<br>The maze will show a path from start to finish
<br># - Wall
<br>' ' - Passage
<br>X - Path taken
<br>S/E - Start/End

<p>##########
<br>#SXX     #
<br># #X######
<br># #XX    #
<br># ##X# ###
<br># # X# # #
<br># # XX   #
<br># ###X####
<br># #  XXXE#
<br>##########</p>

<hr>

<b>Movement</b>
<br>Valid moves are N, S, E W only, no diagonal movements are allowed.
<br>The edges are not considered walls unless specified, and allow for maze wrapping.

Example of horizontal wrapping:

10 10
<br>1 1
<br>8 8
<br>1 1 1 1 1 1 1 1 1 1 
<br>0 0 1 0 0 0 0 0 0 0 
<br>0 0 1 0 0 1 1 1 1 1 
<br>1 0 1 0 0 0 0 0 0 1 
<br>1 0 1 1 0 1 0 1 1 1 
<br>1 0 1 0 0 1 0 1 0 1 
<br>1 0 1 0 0 0 0 0 0 1 
<br>1 0 1 0 0 0 1 1 1 1 
<br>1 0 1 0 0 0 0 0 0 1 
<br>1 1 1 1 1 1 1 1 1 1 

<p>##########<br>
XS#&nbsp;XXXXXX<br>
&nbsp;&nbsp;#&nbsp;X#####<br>
#&nbsp;#&nbsp;X&nbsp;&nbsp;&nbsp;&nbsp;#<br>
#&nbsp;##X#&nbsp;###<br>
#&nbsp;#&nbsp;X#&nbsp;#&nbsp;#<br>
#&nbsp;#&nbsp;X&nbsp;&nbsp;&nbsp;&nbsp;#<br>
#&nbsp;#&nbsp;X&nbsp;####<br>
#&nbsp;#&nbsp;XXXXE#<br>
##########</p>

Example of vertical wrapping:

10 10
<br>1 1
<br>8 8
<br>1 0 1 1 1 1 1 1 1 1 
<br>1 0 1 0 0 0 0 0 0 0 
<br>1 0 1 0 1 1 1 1 1 1 
<br>1 1 1 0 0 0 0 0 0 1 
<br>1 0 1 1 0 1 0 1 1 1 
<br>1 0 1 0 0 1 0 1 0 1 
<br>1 0 1 0 0 0 0 0 0 1 
<br>1 0 1 1 1 0 1 1 1 1 
<br>1 0 0 0 0 0 0 0 0 1 
<br>1 0 1 1 1 1 1 1 1 1 

<p>#X########<br>
#S#&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>       
#&nbsp;#&nbsp;######<br>
###&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;#<br>
#&nbsp;##&nbsp;#&nbsp;###<br>
#&nbsp;#&nbsp;&nbsp;#&nbsp;#&nbsp;#<br>
#&nbsp;#&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;#<br>
#&nbsp;###&nbsp;####<br>
#XXXXXXXE#<br>
#X########</p>

<hr>

<h3> How to Run </h3>
<ul><li>Clone or download the repository</li>
<li>Open the programme in an IDE (Eclipse was used to implement this solution)</li>
<li>Run the Maze.java file</li>
<li>A number of default mazes can be used, which can be loaded from the file chooser on first start</li> <li>Custom mazes can added, using the maze format shown above and saved in the same folder as the default mazes</li></ul>

