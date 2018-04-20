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
    private static ArrayList<Player> list = new ArrayList<Player>();;

    //The frame to display the menu on
    protected static JFrame frame;
    /**
     * Constructor for the Driver class
     */
    public Driver()
    {
        //Images with paths
        //String dir = "Images\\";
        background = new ImageIcon("Images" + File.separator + "HomeScreen.jpg").getImage();
        background = background.getScaledInstance(900, 500, Image.SCALE_DEFAULT);
        background2 = new ImageIcon("Images" + File.separator + "homescreenbackground.jpg").getImage();
        train = new ImageIcon("Images" + File.separator + "Traingif.gif").getImage();
        train = train.getScaledInstance(400, 200, Image.SCALE_DEFAULT);
        //Set window to correct size
        Dimension size = new Dimension(1250, 800);
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
        rules.setBounds(830,630,100,50);
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
        //Draw the images for the homescreen
        g.drawImage(background2, 0, 0, null);
        g.drawImage(background, 0, 0, null);
        g.drawImage(train, 950, 550, this);
        //Writing on the homescreen
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 80));

        String text = "Germany";
        int x = 500; int y = 490;
        g.drawString(text, ShiftWest(x, 1), ShiftNorth(y, 1));
        g.drawString(text, ShiftWest(x, 1), ShiftSouth(y, 1));
        g.drawString(text, ShiftEast(x, 1), ShiftNorth(y, 1));
        g.drawString(text, ShiftEast(x, 1), ShiftSouth(y, 1));
        g.setColor(new Color(204, 0, 0));
        g.drawString(text, x, y);

        g.setFont(new Font("Arial", Font.BOLD, 35));
        String text2A = "Select the number";
        g.setColor(Color.BLACK);
        x = 70; y = 650;
        g.drawString(text2A, ShiftWest(x, 1), ShiftNorth(y, 1));
        g.drawString(text2A, ShiftWest(x, 1), ShiftSouth(y, 1));
        g.drawString(text2A, ShiftEast(x, 1), ShiftNorth(y, 1));
        g.drawString(text2A, ShiftEast(x, 1), ShiftSouth(y, 1));
        g.setColor(Color.WHITE);
        g.drawString(text2A, x, y);
        String text2B = "of players to begin!";
        g.setColor(Color.BLACK);
        x = 60; y = 680;
        g.drawString(text2B, ShiftWest(x, 1), ShiftNorth(y, 1));
        g.drawString(text2B, ShiftWest(x, 1), ShiftSouth(y, 1));
        g.drawString(text2B, ShiftEast(x, 1), ShiftNorth(y, 1));
        g.drawString(text2B, ShiftEast(x, 1), ShiftSouth(y, 1));
        g.setColor(Color.WHITE);
        g.drawString(text2B, x, y);

        String text3 = "A project by Alissa, Brooke, Pat, Hieu, and Chris";
        g.setColor(Color.BLACK);
        x = 60; y = 540;
        g.drawString(text3, ShiftWest(x, 1), ShiftNorth(y, 1));
        g.drawString(text3, ShiftWest(x, 1), ShiftSouth(y, 1));
        g.drawString(text3, ShiftEast(x, 1), ShiftNorth(y, 1));
        g.drawString(text3, ShiftEast(x, 1), ShiftSouth(y, 1));
        g.setColor(new Color(102, 255, 102));
        g.drawString(text3, x, y);

        g.setFont(new Font("Arial", Font.BOLD, 25));
        String text4A = "Welcome to";
        g.setColor(Color.BLACK);
        x = 1000; y = 100;
        g.drawString(text4A, ShiftWest(x, 1), ShiftNorth(y, 1));
        g.drawString(text4A, ShiftWest(x, 1), ShiftSouth(y, 1));
        g.drawString(text4A, ShiftEast(x, 1), ShiftNorth(y, 1));
        g.drawString(text4A, ShiftEast(x, 1), ShiftSouth(y, 1));
        g.setColor(Color.WHITE);
        g.drawString(text4A, x, y);
        String text4B = "Ticket to Ride: Germany!";
        g.setColor(Color.BLACK);
        x = 930; y = 130;
        g.drawString(text4B, ShiftWest(x, 1), ShiftNorth(y, 1));
        g.drawString(text4B, ShiftWest(x, 1), ShiftSouth(y, 1));
        g.drawString(text4B, ShiftEast(x, 1), ShiftNorth(y, 1));
        g.drawString(text4B, ShiftEast(x, 1), ShiftSouth(y, 1));
        g.setColor(Color.WHITE);
        g.drawString(text4B, x, y);
        String text4C = "A fun family game";
        g.setColor(Color.BLACK);
        x = 970; y = 200;
        g.drawString(text4C, ShiftWest(x, 1), ShiftNorth(y, 1));
        g.drawString(text4C, ShiftWest(x, 1), ShiftSouth(y, 1));
        g.drawString(text4C, ShiftEast(x, 1), ShiftNorth(y, 1));
        g.drawString(text4C, ShiftEast(x, 1), ShiftSouth(y, 1));
        g.setColor(Color.WHITE);
        g.drawString(text4C, x, y);
        String text4D = "for all ages!";
        g.setColor(Color.BLACK);
        x = 1000; y = 230;
        g.drawString(text4D, ShiftWest(x, 1), ShiftNorth(y, 1));
        g.drawString(text4D, ShiftWest(x, 1), ShiftSouth(y, 1));
        g.drawString(text4D, ShiftEast(x, 1), ShiftNorth(y, 1));
        g.drawString(text4D, ShiftEast(x, 1), ShiftSouth(y, 1));
        g.setColor(Color.WHITE);
        g.drawString(text4D, x, y);
        String text4E = "Please play responsibly";
        g.setColor(Color.BLACK);
        x = 935; y = 300;
        g.drawString(text4E, ShiftWest(x, 1), ShiftNorth(y, 1));
        g.drawString(text4E, ShiftWest(x, 1), ShiftSouth(y, 1));
        g.drawString(text4E, ShiftEast(x, 1), ShiftNorth(y, 1));
        g.drawString(text4E, ShiftEast(x, 1), ShiftSouth(y, 1));
        g.setColor(Color.WHITE);
        g.drawString(text4E, x, y);
        //Draw box border
        g.setColor(Color.BLACK);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        g.drawRect(920, 50, 310, 300);
        g.setColor(Color.RED);
        g.drawRect(925, 55, 300, 290);
        g.setColor(Color.YELLOW);
        g.drawRect(930, 60, 290, 280);
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
            String[] possibleValues = { "Purple", "Yellow", "Red", "White", "Black" };
            ArrayList<String> possibleVals = new ArrayList(5);
            possibleVals.add("Purple");
            possibleVals.add("Yellow");
            possibleVals.add("Red");
            possibleVals.add("White");
            possibleVals.add("Black");

            while(count < 3){
                String name = JOptionPane.showInputDialog(frame, "Enter in Player " + count + 
                        " name:");
                Object colors = JOptionPane.showInputDialog(null,
                        "Choose one", "Input",
                        JOptionPane.INFORMATION_MESSAGE, null,
                        possibleValues, possibleValues[0]);

                String color = (String) colors;
                possibleVals.remove(color);

                String temp[] = new String[possibleValues.length - 1];
                for (int i = 0; i < possibleVals.size(); i++) {
                    temp[i] = possibleVals.get(i);
                }
                possibleValues = temp;

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
            String[] possibleValues = { "Purple", "Yellow", "Red", "White", "Black" };
            ArrayList<String> possibleVals = new ArrayList(5);
            possibleVals.add("Purple");
            possibleVals.add("Yellow");
            possibleVals.add("Red");
            possibleVals.add("White");
            possibleVals.add("Black");

            while(count < 4){
                String name = JOptionPane.showInputDialog(frame, "Enter in Player " + count + 
                        " name:");
                Object colors = JOptionPane.showInputDialog(null,
                        "Choose one", "Input",
                        JOptionPane.INFORMATION_MESSAGE, null,
                        possibleValues, possibleValues[0]);

                String color = (String) colors;
                possibleVals.remove(color);

                String temp[] = new String[possibleValues.length - 1];
                for (int i = 0; i < possibleVals.size(); i++) {
                    temp[i] = possibleVals.get(i);
                }
                possibleValues = temp;

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
    public static ArrayList<Player> getPlayers()
    {
        return list;
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
