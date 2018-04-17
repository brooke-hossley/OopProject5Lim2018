import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
/**
 * The class that runs the game with a level 
 * selector and a help button for the rules
 * 
 * @author Brooke Hossley
 * @version Spring 2018
 */
public class Driver extends JPanel implements ActionListener
{
    //background image
    private static Image background, background2;
    //JButtons for Player selection and rules
    private JButton twoPlayers;
    private JButton threePlayers;
    private JButton rules;
    //Player ArrayList
    private ArrayList<Player> list;

    //The frame to display the menu on
    protected static JFrame frame;
    /**
     * Constructor for the Driver class
     */
    public Driver()
    {
        //Images with paths
        String dir = "Images\\";
        //background = new ImageIcon(dir + "HomeScreen.jpg").getImage();
        //background = background.getScaledInstance();
        background2 = new ImageIcon(dir + "homescreenbackground.jpg").getImage();
        //background2 = background2.getScaledInstance(1200, 700, Image.SCALE_DEFAULT);
        //Set window to correct size
        Dimension size = new Dimension(1200, 700);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
        //Creating the JButtons with actionListeners
        twoPlayers = new JButton("2");
        twoPlayers.setFont(new Font("Arial", Font.BOLD, 40));
        twoPlayers.setBackground(Color.RED);
        twoPlayers.setBounds(750,300,200,100);
        add(twoPlayers);
        twoPlayers.addActionListener(this);
        twoPlayers.setActionCommand("Two");
        add(twoPlayers);

        threePlayers = new JButton("3");
        threePlayers.setFont(new Font("Arial", Font.BOLD, 20));
        threePlayers.setBackground(new Color(51,153,255));
        threePlayers.setBounds(100,600,100,50);
        add(threePlayers);
        threePlayers.addActionListener(this);
        threePlayers.setActionCommand("Three");
        add(threePlayers);

        rules = new JButton("Rules");
        rules.setFont(new Font("Arial", Font.BOLD, 20));
        rules.setBackground(new Color(51,153,255));
        rules.setBounds(100,600,100,50);
        add(rules);
        rules.addActionListener(this);
        rules.setActionCommand("Rules");
        add(rules);
    }

    /**
     * Panel's paint method to manage the graphics
     * 
     * @param g The Graphics reference
     */
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        g.drawImage(background2, 0, 0, null);
        g.drawImage(background, 0, 0, null);
    }

    /**
     * Called when actionListeners are triggered
     * 
     * @param e The action calling the event
     */
    public void actionPerformed(ActionEvent e)
    {
        String action = e.getActionCommand();
        int count = 0;
        if(action.equals("Two")) 
        {
            PlayGame.numberOfPlayers = 2;
            while(count < 2){
                String name = JOptionPane.showInputDialog(frame, "Enter in Player " + count + 
                        " name:");
                String color = JOptionPane.showInputDialog(frame, "Enter in Player " + count + 
                        " color:(Purple, Yellow, White, Red, or Black)");
                Player x = new Player(name, color);
                list.add(x);
                count++;
            }
            PlayGame.createAndShowGUI();
            frame.dispose();
        }
        else if(action.equals("Three"))
        {
            PlayGame.numberOfPlayers = 3;
            while(count < 3){
                String name = JOptionPane.showInputDialog(frame, "Enter in Player " + count + 
                        " name:");
                String color = JOptionPane.showInputDialog(frame, "Enter in Player " + count + 
                        " color:(Purple, Yellow, White, Red, or Black)");
                Player x = new Player(name, color);
                list.add(x);
                count++;
            }
            PlayGame.createAndShowGUI();
            frame.dispose();
        }
        else
        {

        }
    }

    /**
     * Creates the JFrame for the menu
     */
    protected static void createAndShowGUI() 
    {
        //Create and set up the window.
        frame = new JFrame("Welcome to Ticket to Ride: Germany");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Driver panel = new Driver();
        frame.getContentPane().add(panel);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Main method to run the Menu
     * 
     * @param args Unused
     */
    public static void main(String[] args) 
    {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() 
            {
                public void run() 
                {
                    createAndShowGUI();
                }
            });
    }
}
