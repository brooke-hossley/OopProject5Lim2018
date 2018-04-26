import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
/**
 * Write a description of class DestinationCardPanel here.
 *
 * @author (Patrick Barber)
 * @version (4/26/2018)
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
        playersDestinationCards = PlayGame.currentPlayer.destinations;
        int x = 20;
        int y = 5;
        
        for(int i = 0; i< playersDestinationCards.size();i++)
        {
            g.drawImage(playersDestinationCards.get(i).getPicture(),x,y,null);
            x+=220;
            if(i==3)
            {
             x=20;
             y=350;
            }

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
