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
    protected Image objectPic;
    //Buttons 
    protected JButton turns;
    protected JButton objectives;
    protected JButton endGame;
    protected JButton routes;
    //Variable to repaint
    protected boolean objective;
    protected boolean play;
    protected boolean end;
    protected boolean route;
    public Rules(){
        //Images 
        background = new ImageIcon("Images" + File.separator + "homescreenbackground.jpg").getImage();
        rules = new ImageIcon("Images" + File.separator + "rules.png").getImage();
        objectPic = new ImageIcon("Images" + File.separator + "Objectives.png").getImage();
        //Setting up the starting window
        Dimension size = new Dimension(800, 600);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);

        //Setting up buttons 
        objectives = new JButton("Objectives");
        objectives.setFont(new Font("Arial", Font.BOLD, 40));
        objectives.setBackground(Color.CYAN);
        objectives.setBorder(BorderFactory.createLineBorder(Color.black));
        objectives.setBounds(100,250,250,75);
        objectives.addActionListener(this);
        objectives.setActionCommand("obj");
        add(objectives);

        turns = new JButton("Turn Taking");
        turns.setFont(new Font("Arial", Font.BOLD, 40));
        turns.setBackground(Color.RED);
        turns.setBorder(BorderFactory.createLineBorder(Color.black));
        turns.setBounds(450,250,250,75);
        turns.addActionListener(this);
        turns.setActionCommand("Turn");
        add(turns);

        routes = new JButton("Claiming Routes");
        routes.setFont(new Font("Arial", Font.BOLD, 30));
        routes.setBackground(Color.GREEN);
        routes.setBorder(BorderFactory.createLineBorder(Color.black));
        routes.setBounds(100,375,250,75);
        routes.addActionListener(this);
        routes.setActionCommand("claim");
        add(routes);

        endGame = new JButton("End Game");
        endGame.setFont(new Font("Arial", Font.BOLD, 40));
        endGame.setBackground(Color.YELLOW);
        endGame.setBorder(BorderFactory.createLineBorder(Color.black));
        endGame.setBounds(450,375,250,75);
        endGame.addActionListener(this);
        endGame.setActionCommand("Goals");
        add(endGame);
    }

    /**
     * Panel's paint method to manage the graphics
     * 
     * @param g The Graphics reference
     */
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);

        g.drawImage(background, 0, 0, null);
        g.drawImage(rules, 300, 40, null);

    }

    public void actionPerformed(ActionEvent e)
    {
        String action = e.getActionCommand();
        if(action.equals("obj")){
            Objectives.createAndShowGUI();
        }
        else if(action.equals("Turn")){
            Turns.createAndShowGUI();
        }
        else if(action.equals("claim")){
            ClaimingRoutes.createAndShowGUI();
        }
        else{
            EndGame.createAndShowGUI();
        }
    }

    /**
     * Creates the JFrame for the Rules window
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
