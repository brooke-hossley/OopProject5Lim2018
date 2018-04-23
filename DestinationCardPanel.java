import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
/**
 * Write a description of class DestinationCardPanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DestinationCardPanel extends JPanel
{
    private static Image woodBackground;
    DestinationCardPanel()
    {
        woodBackground = new ImageIcon("Images" + File.separator + "WoodPaneling.jpg").getImage();
        Dimension size = new Dimension(woodBackground.getWidth(null), woodBackground.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    protected static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Your Destination Tickets");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        DestinationCardPanel panel = new DestinationCardPanel();
        frame.getContentPane().add(panel);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        g.drawImage(woodBackground,0,0,null);
        //draw the players destination tickets here
        ArrayList<DestinationCard> playersDestinationCards = new ArrayList(); 
        playersDestinationCards = PlayGame.currentPlayer.getDestinationCards();
        int x = 20;
        int y = 20;
        for(int i = 0; i< playersDestinationCards.size();i++)
        {
            g.drawImage(playersDestinationCards.get(i).getPicture(),x,y,null);
            x+=100;
            y+=100;
        }
    }
    

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createAndShowGUI();
                }
            });
    }
}
