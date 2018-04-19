import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.font.*;
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
    private Image train;
    //JButtons for Player selection and rules
    private JButton twoPlayers;
    private JButton threePlayers;
    private JButton rules;
    //Player ArrayList
    private ArrayList<Player> list = new ArrayList<Player>();;

    //The frame to display the menu on
    protected static JFrame frame;
    /**
     * Constructor for the Driver class
     */
    public Driver()
    {
        //Images with paths
        String dir = "Images\\";
        background = new ImageIcon(dir + "HomeScreen.jpg").getImage();
        background2 = new ImageIcon(dir + "homescreenbackground.jpg").getImage();
        train = new ImageIcon(dir + "Traingif.gif").getImage();
        train = train.getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        //Set window to correct size
        Dimension size = new Dimension(1500, 800);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
        //Creating the JButtons with actionListeners
        twoPlayers = new JButton("2");
        twoPlayers.setFont(new Font("Arial", Font.BOLD, 40));
        twoPlayers.setBackground(Color.CYAN);
        twoPlayers.setBorder(BorderFactory.createLineBorder(Color.black));
        twoPlayers.setBounds(400,615,100,75);
        add(twoPlayers);
        twoPlayers.addActionListener(this);
        twoPlayers.setActionCommand("Two");

        threePlayers = new JButton("3");
        threePlayers.setFont(new Font("Arial", Font.BOLD, 40));
        threePlayers.setBackground(new Color(51,153,255));
        threePlayers.setBorder(BorderFactory.createLineBorder(Color.black));
        threePlayers.setBounds(600,615,100,75);
        add(threePlayers);
        threePlayers.addActionListener(this);
        threePlayers.setActionCommand("Three");

        rules = new JButton("Rules");
        rules.setFont(new Font("Arial", Font.BOLD, 20));
        rules.setBackground(Color.RED);
        rules.setBorder(BorderFactory.createLineBorder(Color.black));
        rules.setBounds(850,630,100,50);
        add(rules);
        rules.addActionListener(this);
        rules.setActionCommand("Rules");
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
        g.drawImage(train, 1000, 500, this);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 80));
        String text = "Germany";
        int x = 600; int y = 490;
        g.drawString(text, ShiftWest(x, 1), ShiftNorth(y, 1));
        g.drawString(text, ShiftWest(x, 1), ShiftSouth(y, 1));
        g.drawString(text, ShiftEast(x, 1), ShiftNorth(y, 1));
        g.drawString(text, ShiftEast(x, 1), ShiftSouth(y, 1));
        g.setColor(new Color(204, 0, 0));
        g.drawString(text, x, y);
        String text2A = "Select the number";
        String text2B = "of players to begin!";
        g.setColor(Color.WHITE);
        g.fillRect(50, 600, 300, 100);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.setColor(Color.BLACK);
        g.drawString(text2A, 70, 650);
        g.drawString(text2B, 60, 680);
    }

    int ShiftNorth(int p, int distance) {
        return (p - distance);
    }

    int ShiftSouth(int p, int distance) {
        return (p + distance);
    }

    int ShiftEast(int p, int distance) {
        return (p + distance);
    }

    int ShiftWest(int p, int distance) {
        return (p - distance);
    }

    /**
     * Called when actionListeners are triggered
     * 
     * @param e The action calling the event
     */
    public void actionPerformed(ActionEvent e)
    {
        String action = e.getActionCommand();
        int count = 1;
        if(action.equals("Two")) 
        {
            PlayGame.numberOfPlayers = 2;
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
        else if(action.equals("Three"))
        {
            PlayGame.numberOfPlayers = 3;
            while(count < 4){
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
    //Make a getPlayers() to return arraylist

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
