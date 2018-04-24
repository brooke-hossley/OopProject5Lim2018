import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.font.*;
import java.io.*;
/**
 * Write a description of class Rules here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rules extends JPanel implements ActionListener
{
    //Images 
    protected Image background, rules;
    //Buttons 
    protected JButton gamePlay;
    protected JButton components;
    protected JButton endGame;
    protected JButton goals;
    //Variable to repaint
    protected boolean comp;
    protected boolean play;
    protected boolean end;
    protected boolean goal;
    public Rules(){
        //Images 
        background = new ImageIcon("Images" + File.separator + "homescreenbackground.jpg").getImage();
        rules = new ImageIcon("Images" + File.separator + "rules.png").getImage();
        //Setting up the starting window
        Dimension size = new Dimension(800, 600);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);

        //Setting up buttons 
        components = new JButton("Components");
        components.setFont(new Font("Arial", Font.BOLD, 40));
        components.setBackground(Color.CYAN);
        components.setBorder(BorderFactory.createLineBorder(Color.black));
        components.setBounds(100,250,250,75);
        add(components);
        components.addActionListener(this);
        components.setActionCommand("Comp");

        gamePlay = new JButton("Game Play");
        gamePlay.setFont(new Font("Arial", Font.BOLD, 40));
        gamePlay.setBackground(Color.RED);
        gamePlay.setBorder(BorderFactory.createLineBorder(Color.black));
        gamePlay.setBounds(450,250,250,75);
        add(gamePlay);
        gamePlay.addActionListener(this);
        gamePlay.setActionCommand("Play");

        goals = new JButton("Game Goals");
        goals.setFont(new Font("Arial", Font.BOLD, 40));
        goals.setBackground(Color.GREEN);
        goals.setBorder(BorderFactory.createLineBorder(Color.black));
        goals.setBounds(100,375,250,75);
        add(goals);
        goals.addActionListener(this);
        goals.setActionCommand("Goals");

        endGame = new JButton("End Game");
        endGame.setFont(new Font("Arial", Font.BOLD, 40));
        endGame.setBackground(Color.YELLOW);
        endGame.setBorder(BorderFactory.createLineBorder(Color.black));
        endGame.setBounds(450,375,250,75);
        add(endGame);
        endGame.addActionListener(this);
        endGame.setActionCommand("Goals");
    }

    /**
     * Panel's paint method to manage the graphics
     * 
     * @param g The Graphics reference
     */
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        if(comp){

        }
        else if(play){

        }
        else if(goal){

        }
        else if(end){

        }
        else{
            g.drawImage(background, 0, 0, null);
            g.drawImage(rules, 300, 40, null);
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        String action = e.getActionCommand();
        if(action.equals("Comp")){
            comp = true;
            repaint();
        }
        else if(action.equals("Play")){
            play = true;
            repaint();
        }
        else if(action.equals("Goals")){
            goal = true;
            repaint();
        }
        else{
            end = true;
            repaint();
        }
    }

    public void components(Graphics g){

    }

    public void gamePlay(Graphics g){

    }

    public void endGame(Graphics g){

    }

    public void goals(Graphics g){

    }

    /**
     * Creates the JFrame for the Help window
     */
    protected static void createAndShowGUI() 
    {
        //Create and set up the window.
        JFrame frame = new JFrame("Rules: Selection Page");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Rules panel = new Rules();
        frame.getContentPane().add(panel);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

}
