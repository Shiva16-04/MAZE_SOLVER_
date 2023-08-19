package Algorithms;


import java.awt.*;
import java.util.ArrayList;


import static User_Interface.GPanel.panelmat;


public class DFS {
    public static boolean dfSearch(int[][] maze, int x, int y, ArrayList<Integer> path, ArrayList<Integer> exploredPath) {
        //1 -->path //2 --> block //3 -->visited //9 --> start point //22 --> end point
        //base case
        if(maze[x][y]==22){
            path.add(x);
            path.add(y);
            return true;
        }
        //creating direction array
        int dir[]={0 ,1, 0, -1, 0};
        if(maze[x][y]==9 || maze[x][y]==1){
            maze[x][y]=3;
            path.add(x);
            path.add(y);
            exploredPath.add(x);
            exploredPath.add(y);
            //iterating in all directions and visiting unvisited neighbours
            for(int k=0; k<4; k++){
                int row = x + dir[k];
                int col = y + dir[k + 1];
                if (row >= 0 && row < maze.length && col >= 0 && col < maze[0].length && (maze[row][col] == 1 || maze[row][col] == 22)) {
                    exploredPath.add(row);
                    exploredPath.add(col);
                    boolean b = dfSearch(maze, row, col, path, exploredPath);
                    if (b) return true;
                }
            }
            path.remove(path.size()-1);
            path.remove(path.size()-1);
            maze[x][y]=1;
            return false;
        }
        return false;
    }
}

