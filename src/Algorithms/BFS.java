package Algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


class Pair{
    int x;
    int y;
    StringBuilder psf;
    Pair(int x, int y, StringBuilder psf){
        this.x=x;
        this.y=y;
        this.psf=psf;
    }
}
public class BFS {
    public static String[] bfSearch(int[][] maze, int x, int y, StringBuilder fnlpsf,  ArrayList<Integer> possiblepath)  {

        //1 -->path //2 --> block //3 -->visited //9 --> start point //22 --> end point
        Queue<Pair> q=new LinkedList<>();
        StringBuilder subpsf=new StringBuilder();
        q.add(new Pair(x,y,subpsf.append(""+x+" "+y+" ")));
        while(q.size()!=0){
            //step 1 removing
            Pair remv=q.remove();
            x=remv.x;
            y=remv.y;
            possiblepath.add(x);
            possiblepath.add(y);
            StringBuilder psf=remv.psf;
            //step 2 marking visited
            if(maze[x][y]==3)continue;
            maze[x][y]=3;
            //step 3 visting unvisited neighbours
            // k=0 -> right k=1 -> down k=2 ->left k=3 ->up
            int dir[]={0 ,1, 0, -1, 0};
            for (int k = 0; k < 4; k++) {
                int row = x + dir[k];
                int col = y + dir[k + 1];
                if (row >= 0 && row < maze.length && col >= 0 && col < maze[0].length && (maze[row][col] == 1 || maze[row][col] == 22)) {
                    possiblepath.add(row);
                    possiblepath.add(col);
                    StringBuilder subpath = new StringBuilder();
                    subpath.append(psf);
                    if (maze[row][col] == 22) {
                        subpath.append("" + row + " " + col + " ");
                        fnlpsf = subpath;
                        System.out.println(fnlpsf.toString());
                        String fnl = fnlpsf.toString();
                        String array[] = fnl.split(" ");
                        return array;
                    }
                    q.add(new Pair(row, col, subpath.append("" + row + " " + col + " ")));
                }
            }
        }
        String fnl=fnlpsf.toString();
        String array[]=fnl.split(" ");
        return array;
    }
}


