package Algorithms;

import java.awt.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

import static User_Interface.GPanel.panelmat;


class PairD {
    int x;
    int y;
    String psf;
    int wsf;

    PairD(int x, int y, String psf, int wsf) {
        this.x = x;
        this.y = y;
        this.psf = psf;
        this.wsf = wsf;
    }
}
public class Dijkstra {
    public static String[] DijkstraSearch(int[][] maze, int x, int y, ArrayList<Integer> dijkstraExploredPath) {
        // declaring the priority queue to automatically find the shortest path to every other point
        PriorityQueue<PairD> pq = new PriorityQueue<>((a, b) -> a.wsf - b.wsf);
        pq.add(new PairD(x, y, x + " " + y+ " ", maze[x][y]));
        boolean vis[][] = new boolean[maze.length][maze[0].length];
        int dir[] = {0, 1, 0, -1, 0};

        // getting the paths by removing
        while (!pq.isEmpty()) {
            // step 1: remove
            PairD remv = pq.remove();
            if (vis[remv.x][remv.y]) continue;

            // step 2: mark
            vis[remv.x][remv.y] = true;
            maze[remv.x][remv.y] = 3; // Marking the cell as visited (for visualization)
            dijkstraExploredPath.add(x);
            dijkstraExploredPath.add(y);

            // step 3: visiting / adding unvisited neighbors
            for (int k = 0; k < 4; k++) {
                int row = remv.x + dir[k];
                int col = remv.y + dir[k + 1];
                if (row >= 0 && row < maze.length && col >= 0 && col < maze[0].length && !vis[row][col] && (maze[row][col] == 1 || maze[row][col] == 22)) {
                    dijkstraExploredPath.add(row);
                    dijkstraExploredPath.add(col);
                    if (maze[row][col] == 22) {
                        String fnl = remv.psf + row + " " + col + " ";
                        return fnl.split(" ");
                    }
                    pq.add(new PairD(row, col, remv.psf + row + " " + col + " ", remv.wsf + maze[row][col]));
                }
            }
        }
        return new String[]{""}; // No path found
    }
}



