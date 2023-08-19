package User_Interface;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static User_Interface.GPanel.panelmat;
import static User_Interface.UI.*;

public class BlockCreator extends MouseAdapter {

    public static int spx = 11;
    public static int spy = 11;
    public static int epx = 0;
    public static int epy = n-1;


    @Override
    public void mouseClicked(MouseEvent e) {
        if (s == 2) { //to create blocks
            super.mouseClicked(e);
            int x = (e.getX()) / (500 / m);
            int y = (e.getY()) / (500 / n);
            if (x >= 0 && x < m && y >= 0 && y < n) {
                if (maze[y][x] == 1) {
                    maze[y][x] = 2;
                    panelmat[y][x].setBackground(Color.decode("#1560bd"));
                } else if (maze[y][x] == 2) {
                    maze[y][x] = 1;
                    panelmat[y][x].setBackground(Color.white);
                }
            }
            System.out.println("Mouse Clicked" + " " + x + " " + y);
        } else if (s == 0) { // to position starting point
            super.mouseClicked(e);
            int x = (e.getX()) / (500 / m);
            int y = (e.getY()) / (500 / n);
            if (x >= 0 && x < m && y >= 0 && y < n) {
                if (maze[y][x] == 1) {
                    maze[spx][spy] = 1;
                    panelmat[spx][spy].setBackground(Color.white);
                    maze[y][x] = 9;
                    spx = y;
                    spy = x;
                    panelmat[y][x].setBackground(Color.decode("#70706F"));
                }
            }
            System.out.println("Mouse Clicked" + " " + x + " " + y);
        } else if (s == 1) {// to position ending point
            super.mouseClicked(e);
            int x = (e.getX()) / (500 / m);
            int y = (e.getY()) / (500 / n);
            if (x >= 0 && x < m && y >= 0 && y < n) {
                if (maze[y][x] == 1) {
                    maze[epx][epy] = 1;
                    panelmat[epx][epy].setBackground(Color.white);
                    maze[y][x] = 22;
                    epx = y;
                    epy = x;
                    panelmat[y][x].setBackground(Color.red);
                }
            }
            System.out.println("Mouse Clicked" + " " + x + " " + y);
        }
    }
}

