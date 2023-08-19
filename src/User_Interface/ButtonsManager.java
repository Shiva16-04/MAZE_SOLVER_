package User_Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static Algorithms.BFS.bfSearch;
import static Algorithms.DFS.dfSearch;
import static Algorithms.Dijkstra.DijkstraSearch;
import static User_Interface.BlockCreator.*;
import static User_Interface.GPanel.panelmat;
import static User_Interface.UI.*;

public class ButtonsManager implements ActionListener {
    private Color spColor=Color.decode("#70706F");
    private Color epColor=Color.red; //red
    private Color pathColor=Color.yellow;
    private Color blockColor=Color.decode("#1560bd");
    static int time = timeloop;
    private int currentIndex;
    private ArrayList<Integer> exploredPathDFS;

    @Override
    public void actionPerformed(ActionEvent e) {

        // DFS, Painting explored path
        if (e.getSource() == start && option == 1) {
            ArrayList<Integer> dfspath = new ArrayList<>();
            exploredPathDFS = new ArrayList<>();
            dfSearch(maze, spx, spy, dfspath, exploredPathDFS);

            // Initialize the currentIndex for animation
            currentIndex = 0;

            // Starting a Timer for animation
            Timer animationTimer = new Timer(timeloop, new AnimationListener());
            animationTimer.start();
        } else if (e.getSource() == start && option == 2) {
            StringBuilder psf = new StringBuilder();
            String bfspath[] = new String[0];
            ArrayList<Integer> exploredPath = new ArrayList<>();
            bfspath = bfSearch(maze, spx, spy, psf, exploredPath);
            int k = 0;
            // Timer for delayed coloring from the possiblepath list
            String[] finalBfspath = bfspath;
            Timer timer = new Timer(timeloop, new ActionListener() {
                private int currentIndex = k; // Store the current index in the listener

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (currentIndex < exploredPath.size() - 1) {
                        int x = exploredPath.get(currentIndex);
                        int y = exploredPath.get(currentIndex + 1);
                        if (x == spx && y == spy) panelmat[x][y].setBackground(spColor);
                        else panelmat[x][y].setBackground(Color.green);
                        currentIndex += 2;
                    } else {
                        // All cells have been colored, stop the timer
                        ((Timer) e.getSource()).stop();

                        // Now, color cells from bfspath
                        for (int j = 0; j < finalBfspath.length; j += 2) {
                            int x = Integer.valueOf(finalBfspath[j]);
                            int y = Integer.valueOf(finalBfspath[j + 1]);
                            if (x == spx && y == spy) panelmat[x][y].setBackground(spColor);
                            else if (maze[x][y] == 3) panelmat[x][y].setBackground(pathColor);
                            else if (maze[x][y] == 22) panelmat[x][y].setBackground(epColor);
                        }
                    }
                }
            });
            timer.setInitialDelay(0);
            timer.start();
        } else if (e.getSource() == start && option == 3) {
            ArrayList<Integer> DijkstraExploredPath = new ArrayList<>();
            String dijkstrapath[] = DijkstraSearch(maze, spx, spy, DijkstraExploredPath);
            int k = 0;
            // Timer for delayed coloring from the possiblepath list

            Timer timer3 = new Timer(timeloop, new ActionListener() {
                private int currentIndex = k; // Store the current index in the listener

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (currentIndex < DijkstraExploredPath.size() - 1) {
                        int x = DijkstraExploredPath.get(currentIndex);
                        int y = DijkstraExploredPath.get(currentIndex + 1);
                        if (x == spx && y == spy) panelmat[x][y].setBackground(spColor);
                        else panelmat[x][y].setBackground(Color.green);
                        currentIndex += 2;
                    } else {
                        // All cells have been colored, stop the timer
                        ((Timer) e.getSource()).stop();

                        // Now, color cells from bfspath
                        for (int j = 0; j < dijkstrapath.length; j += 2) {
                            int x = Integer.valueOf(dijkstrapath[j]);
                            int y = Integer.valueOf(dijkstrapath[j + 1]);
                            if (x == spx && y == spy) panelmat[x][y].setBackground(spColor);
                            else if (maze[x][y] == 3) panelmat[x][y].setBackground(pathColor);
                            else if (maze[x][y] == 22) panelmat[x][y].setBackground(epColor);
                        }
                    }
                }
            });
            timer3.setInitialDelay(0);
            timer3.start();
        }
        if (e.getSource() == reset) {
            for (int i = 0; i < maze.length; i++) {
                for (int j = 0; j < maze[0].length; j++) {

                    if (i == 11 && j == 11) {
                        maze[i][j] = 9;
                        panelmat[i][j].setBackground(spColor);
                    } else if (i == 0 && j == n - 1) {
                        maze[i][j] = 22;
                        panelmat[i][j].setBackground(epColor);
                    } else {
                        maze[i][j] = 1;
                        panelmat[i][j].setBackground(Color.white);
                    }

                }
            }
            maze[0][0]=2;
            maze[0][1]=2;
            maze[0][2]=2;
            maze[1][2]=2;
            maze[2][2]=2;
            maze[3][2]=2;
            maze[4][2]=2;
            maze[5][2]=2;
            maze[6][2]=2;
            maze[7][2]=2;
            maze[8][2]=2;
            maze[9][2]=2;
            maze[9][3]=2;
            maze[9][4]=2;
            maze[9][5]=2;
            maze[8][5]=2;
            maze[7][5]=2;
            maze[6][5]=2;
            maze[6][4]=2;
            maze[6][0]=2;
            maze[7][0]=2;
            maze[8][0]=2;
            maze[9][0]=2;
            maze[10][0]=2;
            maze[11][0]=2;
            maze[12][0]=2;
            maze[12][1]=2;
            maze[12][2]=2;
            maze[13][2]=2;
            maze[14][2]=2;
            maze[15][2]=2;
            maze[16][2]=2;
            maze[17][2]=2;
            maze[17][1]=2;
            maze[20][1]=2;
            maze[21][1]=2;
            maze[22][1]=2;
            maze[20][2]=2;
            maze[22][2]=2;
            maze[20][3]=2;
            maze[21][3]=2;
            maze[22][3]=2;
            maze[0][5]=2;
            maze[2][5]=2;
            maze[3][5]=2;
            maze[0][6]=2;
            maze[0][7]=2;
            maze[0][8]=2;
            maze[1][8]=2;
            maze[3][6]=2;
            maze[3][7]=2;
            maze[3][8]=2;
            maze[3][9]=2;
            maze[3][10]=2;
            maze[2][10]=2;
            maze[1][10]=2;
            maze[1][11]=2;
            maze[1][12]=2;
            maze[1][13]=2;
            maze[1][15]=2;
            maze[2][15]=2;
            maze[2][16]=2;
            maze[2][17]=2;
            maze[2][18]=2;
            maze[1][18]=2;
            maze[0][18]=2;
            maze[24][0]=2;
            maze[24][1]=2;
            maze[24][2]=2;
            maze[24][3]=2;
            maze[24][19]=2;
            maze[24][20]=2;
            maze[23][0]=2;
            maze[22][0]=2;
            maze[21][0]=2;
            maze[1][21]=2;
            maze[2][21]=2;
            maze[3][21]=2;
            maze[4][21]=2;
            maze[4][23]=2;
            maze[4][24]=2;
            maze[5][24]=2;
            maze[6][24]=2;
            maze[7][24]=2;
            maze[8][24]=2;
            maze[9][24]=2;
            maze[9][23]=2;
            maze[9][22]=2;
            maze[9][21]=2;
            maze[10][21]=2;
            maze[11][21]=2;
            maze[12][21]=2;
            maze[13][21]=2;
            maze[14][21]=2;
            maze[15][21]=2;
            maze[15][20]=2;
            maze[12][23]=2;
            maze[13][23]=2;
            maze[14][23]=2;
            maze[15][23]=2;
            maze[16][23]=2;
            maze[16][24]=2;
            maze[18][24]=2;
            maze[18][23]=2;
            maze[18][22]=2;
            maze[18][21]=2;
            maze[19][21]=2;
            maze[20][21]=2;
            maze[21][21]=2;
            maze[22][21]=2;
            maze[24][21]=2;
            maze[19][24]=2;
            maze[20][24]=2;
            maze[21][24]=2;
            maze[22][24]=2;
            maze[22][23]=2;
            maze[5][15]=2;
            maze[5][16]=2;
            maze[5][17]=2;
            maze[5][18]=2;
            maze[6][18]=2;
            maze[7][18]=2;
            maze[8][18]=2;
            maze[9][18]=2;
            maze[10][18]=2;
            maze[11][18]=2;
            maze[12][18]=2;
            maze[12][17]=2;
            maze[14][17]=2;
            maze[14][18]=2;
            maze[15][18]=2;
            maze[16][18]=2;
            maze[17][18]=2;
            maze[17][17]=2;
            maze[17][16]=2;
            maze[17][15]=2;
            maze[17][14]=2;
            maze[17][13]=2;
            maze[17][12]=2;
            maze[17][11]=2;
            maze[17][10]=2;
            maze[17][9]=2;
            maze[18][9]=2;
            maze[19][18]=2;
            maze[19][17]=2;
            maze[19][16]=2;
            maze[19][15]=2;
            maze[20][18]=2;
            maze[21][18]=2;
            maze[22][18]=2;
            maze[23][18]=2;
            maze[24][18]=2;
            maze[22][17]=2;
            maze[22][16]=2;
            maze[22][15]=2;
            maze[21][15]=2;
            maze[21][14]=2;
            maze[21][13]=2;
            maze[20][13]=2;
            maze[19][13]=2;
            maze[23][13]=2;
            maze[23][12]=2;
            maze[23][11]=2;
            maze[22][11]=2;
            maze[21][11]=2;
            maze[20][11]=2;
            maze[20][10]=2;
            maze[20][9]=2;
            maze[20][8]=2;
            maze[20][7]=2;
            maze[20][6]=2;
            maze[20][5]=2;
            maze[21][5]=2;
            maze[22][5]=2;
            maze[24][5]=2;
            maze[24][6]=2;
            maze[24][7]=2;
            maze[24][8]=2;
            maze[23][8]=2;
            maze[18][4]=2;
            maze[17][4]=2;
            maze[17][5]=2;
            maze[17][6]=2;
            maze[17][7]=2;
            maze[18][7]=2;
            maze[4][13]=2;
            maze[4][12]=2;
            maze[5][12]=2;
            maze[6][12]=2;
            maze[7][12]=2;
            maze[7][13]=2;
            maze[7][14]=2;
            maze[7][15]=2;
            maze[8][15]=2;
            maze[9][15]=2;
            maze[10][15]=2;
            maze[11][15]=2;
            maze[12][15]=2;
            maze[14][15]=2;
            maze[15][15]=2;
            maze[15][14]=2;
            maze[15][13]=2;
            maze[11][13]=2;
            maze[12][13]=2;
            maze[13][13]=2;
            maze[13][12]=2;
            maze[13][11]=2;
            maze[9][12]=2;
            maze[9][11]=2;
            maze[9][10]=2;
            maze[9][9]=2;
            maze[10][9]=2;
            maze[11][9]=2;
            maze[7][9]=2;
            maze[6][9]=2;
            maze[5][9]=2;
            maze[5][7]=2;
            maze[6][7]=2;
            maze[7][7]=2;
            maze[7][8]=2;
            maze[8][7]=2;
            maze[9][7]=2;
            maze[11][7]=2;
            maze[11][6]=2;
            maze[11][5]=2;
            maze[11][4]=2;
            maze[12][4]=2;
            maze[13][4]=2;
            maze[14][4]=2;
            maze[15][4]=2;
            maze[15][5]=2;
            maze[12][7]=2;
            maze[13][7]=2;
            maze[14][7]=2;
            maze[15][7]=2;
            maze[15][8]=2;
            maze[15][9]=2;
            maze[15][10]=2;
            maze[19][19]=2;
            maze[15][19]=2;
            maze[13][18]=2;
            maze[4][18]=2;
            maze[4][19]=2;
            maze[0][21]=2;
            maze[24][22]=2;
            maze[24][23]=2;
            maze[24][24]=2;
            maze[23][24]=2;
            maze[22][8]=2;
            maze[24][11]=2;
            maze[24][13]=2;
            maze[0][13]=2;
            maze[7][21]=2;
            maze[8][21]=2;
            maze[6][20]=2;
            maze[7][20]=2;
            maze[0][4]=2;
            panelmat[7][21].setBackground(blockColor);
            panelmat[8][21].setBackground(blockColor);
            panelmat[6][20].setBackground(blockColor);
            panelmat[7][20].setBackground(blockColor);
            panelmat[0][4].setBackground(blockColor);
            panelmat[0][13].setBackground(blockColor);
            panelmat[24][11].setBackground(blockColor);
            panelmat[24][13].setBackground(blockColor);
            panelmat[22][8].setBackground(blockColor);
            panelmat[24][22].setBackground(blockColor);
            panelmat[24][23].setBackground(blockColor);
            panelmat[24][24].setBackground(blockColor);
            panelmat[23][24].setBackground(blockColor);
            panelmat[0][21].setBackground(blockColor);
            panelmat[4][18].setBackground(blockColor);
            panelmat[4][19].setBackground(blockColor);
            panelmat[13][18].setBackground(blockColor);
            panelmat[15][19].setBackground(blockColor);
            panelmat[0][0].setBackground(blockColor);
            panelmat[0][1].setBackground(blockColor);
            panelmat[0][2].setBackground(blockColor);
            panelmat[1][2].setBackground(blockColor);
            panelmat[2][2].setBackground(blockColor);
            panelmat[3][2].setBackground(blockColor);
            panelmat[4][2].setBackground(blockColor);
            panelmat[5][2].setBackground(blockColor);
            panelmat[6][2].setBackground(blockColor);
            panelmat[7][2].setBackground(blockColor);
            panelmat[8][2].setBackground(blockColor);
            panelmat[9][2].setBackground(blockColor);
            panelmat[9][3].setBackground(blockColor);
            panelmat[9][4].setBackground(blockColor);
            panelmat[9][5].setBackground(blockColor);
            panelmat[8][5].setBackground(blockColor);
            panelmat[7][5].setBackground(blockColor);
            panelmat[6][5].setBackground(blockColor);
            panelmat[6][4].setBackground(blockColor);
            panelmat[6][0].setBackground(blockColor);
            panelmat[7][0].setBackground(blockColor);
            panelmat[8][0].setBackground(blockColor);
            panelmat[9][0].setBackground(blockColor);
            panelmat[10][0].setBackground(blockColor);
            panelmat[11][0].setBackground(blockColor);
            panelmat[12][0].setBackground(blockColor);
            panelmat[12][1].setBackground(blockColor);
            panelmat[12][2].setBackground(blockColor);
            panelmat[13][2].setBackground(blockColor);
            panelmat[14][2].setBackground(blockColor);
            panelmat[15][2].setBackground(blockColor);
            panelmat[16][2].setBackground(blockColor);
            panelmat[17][2].setBackground(blockColor);
            panelmat[17][1].setBackground(blockColor);
            panelmat[20][1].setBackground(blockColor);
            panelmat[21][1].setBackground(blockColor);
            panelmat[22][1].setBackground(blockColor);
            panelmat[20][2].setBackground(blockColor);
            panelmat[22][2].setBackground(blockColor);
            panelmat[20][3].setBackground(blockColor);
            panelmat[21][3].setBackground(blockColor);
            panelmat[22][3].setBackground(blockColor);
            panelmat[0][5].setBackground(blockColor);
            panelmat[2][5].setBackground(blockColor);
            panelmat[3][5].setBackground(blockColor);
            panelmat[0][6].setBackground(blockColor);
            panelmat[0][7].setBackground(blockColor);
            panelmat[0][8].setBackground(blockColor);
            panelmat[1][8].setBackground(blockColor);
            panelmat[3][6].setBackground(blockColor);
            panelmat[3][7].setBackground(blockColor);
            panelmat[3][8].setBackground(blockColor);
            panelmat[3][9].setBackground(blockColor);
            panelmat[3][10].setBackground(blockColor);
            panelmat[2][10].setBackground(blockColor);
            panelmat[1][10].setBackground(blockColor);
            panelmat[1][11].setBackground(blockColor);
            panelmat[1][12].setBackground(blockColor);
            panelmat[1][13].setBackground(blockColor);
            panelmat[1][15].setBackground(blockColor);
            panelmat[2][15].setBackground(blockColor);
            panelmat[2][16].setBackground(blockColor);
            panelmat[2][17].setBackground(blockColor);
            panelmat[2][18].setBackground(blockColor);
            panelmat[1][18].setBackground(blockColor);
            panelmat[0][18].setBackground(blockColor);
            panelmat[24][0].setBackground(blockColor);
            panelmat[24][1].setBackground(blockColor);
            panelmat[24][2].setBackground(blockColor);
            panelmat[24][3].setBackground(blockColor);
            panelmat[24][19].setBackground(blockColor);
            panelmat[24][20].setBackground(blockColor);
            panelmat[23][0].setBackground(blockColor);
            panelmat[22][0].setBackground(blockColor);
            panelmat[21][0].setBackground(blockColor);
            panelmat[1][21].setBackground(blockColor);
            panelmat[2][21].setBackground(blockColor);
            panelmat[3][21].setBackground(blockColor);
            panelmat[4][21].setBackground(blockColor);
            panelmat[4][23].setBackground(blockColor);
            panelmat[4][24].setBackground(blockColor);
            panelmat[5][24].setBackground(blockColor);
            panelmat[6][24].setBackground(blockColor);
            panelmat[7][24].setBackground(blockColor);
            panelmat[8][24].setBackground(blockColor);
            panelmat[9][24].setBackground(blockColor);
            panelmat[9][23].setBackground(blockColor);
            panelmat[9][22].setBackground(blockColor);
            panelmat[9][21].setBackground(blockColor);
            panelmat[10][21].setBackground(blockColor);
            panelmat[11][21].setBackground(blockColor);
            panelmat[12][21].setBackground(blockColor);
            panelmat[13][21].setBackground(blockColor);
            panelmat[14][21].setBackground(blockColor);
            panelmat[15][21].setBackground(blockColor);
            panelmat[15][20].setBackground(blockColor);
            panelmat[12][23].setBackground(blockColor);
            panelmat[13][23].setBackground(blockColor);
            panelmat[14][23].setBackground(blockColor);
            panelmat[15][23].setBackground(blockColor);
            panelmat[16][23].setBackground(blockColor);
            panelmat[16][24].setBackground(blockColor);
            panelmat[18][24].setBackground(blockColor);
            panelmat[18][23].setBackground(blockColor);
            panelmat[18][22].setBackground(blockColor);
            panelmat[18][21].setBackground(blockColor);
            panelmat[19][21].setBackground(blockColor);
            panelmat[20][21].setBackground(blockColor);
            panelmat[21][21].setBackground(blockColor);
            panelmat[22][21].setBackground(blockColor);
            panelmat[24][21].setBackground(blockColor);
            panelmat[19][24].setBackground(blockColor);
            panelmat[20][24].setBackground(blockColor);
            panelmat[21][24].setBackground(blockColor);
            panelmat[22][24].setBackground(blockColor);
            panelmat[22][23].setBackground(blockColor);
            panelmat[5][15].setBackground(blockColor);
            panelmat[5][16].setBackground(blockColor);
            panelmat[5][17].setBackground(blockColor);
            panelmat[5][18].setBackground(blockColor);
            panelmat[6][18].setBackground(blockColor);
            panelmat[7][18].setBackground(blockColor);
            panelmat[8][18].setBackground(blockColor);
            panelmat[9][18].setBackground(blockColor);
            panelmat[10][18].setBackground(blockColor);
            panelmat[11][18].setBackground(blockColor);
            panelmat[12][18].setBackground(blockColor);
            panelmat[12][17].setBackground(blockColor);
            panelmat[14][17].setBackground(blockColor);
            panelmat[14][18].setBackground(blockColor);
            panelmat[15][18].setBackground(blockColor);
            panelmat[16][18].setBackground(blockColor);
            panelmat[17][18].setBackground(blockColor);
            panelmat[17][17].setBackground(blockColor);
            panelmat[17][16].setBackground(blockColor);
            panelmat[17][15].setBackground(blockColor);
            panelmat[17][14].setBackground(blockColor);
            panelmat[17][13].setBackground(blockColor);
            panelmat[17][12].setBackground(blockColor);
            panelmat[17][11].setBackground(blockColor);
            panelmat[17][10].setBackground(blockColor);
            panelmat[17][9].setBackground(blockColor);
            panelmat[18][9].setBackground(blockColor);
            panelmat[19][18].setBackground(blockColor);
            panelmat[19][17].setBackground(blockColor);
            panelmat[19][16].setBackground(blockColor);
            panelmat[19][15].setBackground(blockColor);
            panelmat[20][18].setBackground(blockColor);
            panelmat[21][18].setBackground(blockColor);
            panelmat[22][18].setBackground(blockColor);
            panelmat[23][18].setBackground(blockColor);
            panelmat[24][18].setBackground(blockColor);
            panelmat[22][17].setBackground(blockColor);
            panelmat[22][16].setBackground(blockColor);
            panelmat[22][15].setBackground(blockColor);
            panelmat[21][15].setBackground(blockColor);
            panelmat[21][14].setBackground(blockColor);
            panelmat[21][13].setBackground(blockColor);
            panelmat[20][13].setBackground(blockColor);
            panelmat[19][13].setBackground(blockColor);
            panelmat[23][13].setBackground(blockColor);
            panelmat[23][12].setBackground(blockColor);
            panelmat[23][11].setBackground(blockColor);
            panelmat[22][11].setBackground(blockColor);
            panelmat[21][11].setBackground(blockColor);
            panelmat[20][11].setBackground(blockColor);
            panelmat[20][10].setBackground(blockColor);
            panelmat[20][9].setBackground(blockColor);
            panelmat[20][8].setBackground(blockColor);
            panelmat[20][7].setBackground(blockColor);
            panelmat[20][6].setBackground(blockColor);
            panelmat[20][5].setBackground(blockColor);
            panelmat[21][5].setBackground(blockColor);
            panelmat[22][5].setBackground(blockColor);
            panelmat[24][5].setBackground(blockColor);
            panelmat[24][6].setBackground(blockColor);
            panelmat[24][7].setBackground(blockColor);
            panelmat[24][8].setBackground(blockColor);
            panelmat[23][8].setBackground(blockColor);
            panelmat[18][4].setBackground(blockColor);
            panelmat[17][4].setBackground(blockColor);
            panelmat[17][5].setBackground(blockColor);
            panelmat[17][6].setBackground(blockColor);
            panelmat[17][7].setBackground(blockColor);
            panelmat[18][7].setBackground(blockColor);
            panelmat[4][13].setBackground(blockColor);
            panelmat[4][12].setBackground(blockColor);
            panelmat[5][12].setBackground(blockColor);
            panelmat[6][12].setBackground(blockColor);
            panelmat[7][12].setBackground(blockColor);
            panelmat[7][13].setBackground(blockColor);
            panelmat[7][14].setBackground(blockColor);
            panelmat[7][15].setBackground(blockColor);
            panelmat[8][15].setBackground(blockColor);
            panelmat[9][15].setBackground(blockColor);
            panelmat[10][15].setBackground(blockColor);
            panelmat[11][15].setBackground(blockColor);
            panelmat[12][15].setBackground(blockColor);
            panelmat[14][15].setBackground(blockColor);
            panelmat[15][15].setBackground(blockColor);
            panelmat[15][14].setBackground(blockColor);
            panelmat[15][13].setBackground(blockColor);
            panelmat[11][13].setBackground(blockColor);
            panelmat[12][13].setBackground(blockColor);
            panelmat[13][13].setBackground(blockColor);
            panelmat[13][12].setBackground(blockColor);
            panelmat[13][11].setBackground(blockColor);
            panelmat[9][12].setBackground(blockColor);
            panelmat[9][11].setBackground(blockColor);
            panelmat[9][10].setBackground(blockColor);
            panelmat[9][9].setBackground(blockColor);
            panelmat[10][9].setBackground(blockColor);
            panelmat[11][9].setBackground(blockColor);
            panelmat[7][9].setBackground(blockColor);
            panelmat[6][9].setBackground(blockColor);
            panelmat[5][9].setBackground(blockColor);
            panelmat[5][7].setBackground(blockColor);
            panelmat[6][7].setBackground(blockColor);
            panelmat[7][7].setBackground(blockColor);
            panelmat[7][8].setBackground(blockColor);
            panelmat[8][7].setBackground(blockColor);
            panelmat[9][7].setBackground(blockColor);
            panelmat[11][7].setBackground(blockColor);
            panelmat[11][6].setBackground(blockColor);
            panelmat[11][5].setBackground(blockColor);
            panelmat[11][4].setBackground(blockColor);
            panelmat[12][4].setBackground(blockColor);
            panelmat[13][4].setBackground(blockColor);
            panelmat[14][4].setBackground(blockColor);
            panelmat[15][4].setBackground(blockColor);
            panelmat[15][5].setBackground(blockColor);
            panelmat[12][7].setBackground(blockColor);
            panelmat[13][7].setBackground(blockColor);
            panelmat[14][7].setBackground(blockColor);
            panelmat[15][7].setBackground(blockColor);
            panelmat[15][8].setBackground(blockColor);
            panelmat[15][9].setBackground(blockColor);
            panelmat[15][10].setBackground(blockColor);
            panelmat[19][19].setBackground(blockColor);
            spx = 11; spy = 11; epx = 0; epy = n-1;
            for (int i = 0; i < maze.length; i++) {
                for (int j = 0; j < maze[0].length; j++) {
                    System.out.print(maze[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    private class AnimationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (currentIndex < exploredPathDFS.size()) {
                int x = exploredPathDFS.get(currentIndex);
                int y = exploredPathDFS.get(currentIndex + 1);
                if (x == spx && y == spy) panelmat[x][y].setBackground(spColor);
                panelmat[x][y].setBackground(Color.green);

                currentIndex += 2;
            } else {
                // All cells have been colored, stop the timer
                ((Timer) e.getSource()).stop();

                // Update dfspath after animation
                for (int k = 0; k < exploredPathDFS.size(); k += 2) {
                    int x = exploredPathDFS.get(k);
                    int y = exploredPathDFS.get(k + 1);
                    if (x == spx && y == spy) panelmat[x][y].setBackground(spColor);
                    else if (maze[x][y] == 3) panelmat[x][y].setBackground(pathColor);
                    else if (maze[x][y] == 22) panelmat[x][y].setBackground(epColor);
                }
            }
        }
    }
}


