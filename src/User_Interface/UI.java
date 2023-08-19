package User_Interface;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;


public class UI implements ActionListener {
    static int  m=25, n=25;
    protected static int maze[][]=new int[m][n];
    protected static JButton start;
    protected static JButton reset;
    protected static JButton stop;
    protected static JRadioButton dfs;
    protected static JRadioButton bfs;
    protected static JRadioButton dijkstra;
    protected static JSlider speed;
    protected static JLabel label;
    protected static JLabel label2;
    protected static JComboBox select;
    public static JTextField display;

    protected static JPanel gamePanel;

    protected static int s;
    protected static int timeloop;
    protected static int option;

    public  JPanel contentPanel(){
        for(int rows[]:maze)Arrays.fill(rows, 1);
        maze[11][11]=9;
        maze[0][n-1]=22;
        JPanel mainPanel=new JPanel();
        mainPanel.setBackground(Color.black);
        mainPanel.setLayout(null);

        gamePanel=new GPanel();
        ((GPanel) gamePanel).panelcreation();
        gamePanel.setLayout(null);
        gamePanel.setBounds(50,30,500,500);

        //Adding Mouse Listner to the Game Panel
        gamePanel.addMouseListener(new BlockCreator());
        gamePanel.addMouseMotionListener(new BlockCreator());
        //Adding gamePanel to the mainPanel
        mainPanel.add(gamePanel);


        JPanel nonGamePanel=new JPanel();
        nonGamePanel.setLayout(null);
        nonGamePanel.setBounds(599,0,200,600);



        //Creating Label
        label=new JLabel("Algorithms");
        label.setBounds(50,225,100,25);
        label.setFont(new Font("Charter",Font.BOLD | Font.ITALIC, 16));

        label2=new JLabel("Animation Speed");
        label2.setBounds(15,175,125,20);
        label2.setFont(new Font("Charter",Font.BOLD , 14));

        //creating JSlider
        speed=new JSlider(JSlider.HORIZONTAL, 0,100,15);
        speed.setBounds(15,150,150,20);
        speed.setOpaque(false);

        //creating text field
        display=new JTextField();
        display.setBounds(140,175,25,25);

        //creating combobox
        String items[]={"Start point", "end point", "insert blocks"};
        select=new JComboBox(items);
        select.setBounds(15,75,150,25);




        //JButton
        dfs=new JRadioButton("Depth First Search ");
        dfs.setBounds(15,275,150,25);
        dfs.setOpaque(false);
        bfs=new JRadioButton("Breadth First Search ");
        bfs.setBounds(15,250,150,25);
        bfs.setOpaque(false);
        dijkstra=new JRadioButton("Dijkstra");
        dijkstra.setBounds(15,300,75,25);
        dijkstra.setOpaque(false);
        start =new JButton("Start");
        start.setBounds(15,350,75, 25);
        start.addActionListener(new ButtonsManager());
        reset=new JButton("Reset");
        reset.setBounds(95, 350,75, 25);
        reset.addActionListener(new ButtonsManager());
        ButtonGroup g=new ButtonGroup();
        g.add(dfs);
        g.add(bfs);
        g.add(dijkstra);


        //Adding change listner to JSlider
        speed.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                display.setText(""+((JSlider)e.getSource()).getValue());
                timeloop=((JSlider)e.getSource()).getValue();
            }
        });

        //Adding combo listner
        select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==select){
                    s=select.getSelectedIndex();
                }
            }
        });


        //adding action Listeners
        dfs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==dfs)option=1;
            }
        });

        bfs.addActionListener((new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==bfs)option=2;
            }
        }));

        dijkstra.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==dijkstra)option=3;
            }
        });

        nonGamePanel.add(speed);
        nonGamePanel.add(label2);
        nonGamePanel.add(display);
        nonGamePanel.add(label);
        nonGamePanel.add(select);
        nonGamePanel.add(start);
        nonGamePanel.add(reset);
        nonGamePanel.add(dfs);
        nonGamePanel.add(bfs);
        nonGamePanel.add(dijkstra);
        nonGamePanel.setBackground(Color.lightGray);

        //adding non gamePanel to the mainPanel
        mainPanel.add(nonGamePanel);

        mainPanel.setOpaque(true);
        return mainPanel;
    }

    public static void GUI(){
        JFrame frame = new JFrame("MAZE Solver");
        JFrame.setDefaultLookAndFeelDecorated(true);
        UI demo=new UI();
        frame.setContentPane(demo.contentPanel());
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
