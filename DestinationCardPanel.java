import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
/**
 * A class to help with displaying each players 
 * destination tickets 
 *
 * @author Patrick Barber
 * @version Spring 2018
 */
public class DestinationCardPanel extends JPanel implements ActionListener
{
    private static Image woodBackground;
    private JButton nextButton;
    private int count;

    /**
     * Default constructor of the DestinationCardPanel class
     */
    DestinationCardPanel()
    {
        woodBackground = new ImageIcon("Images" + File.separator + 
            "WoodPaneling.jpg").getImage();
        Dimension size = new Dimension(woodBackground.getWidth(null), 
                woodBackground.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);

        nextButton = new JButton("Next");
        nextButton.setFont(new Font("Arial", Font.BOLD, 20));
        nextButton.setBackground(Color.RED);
        nextButton.setBorder(BorderFactory.createLineBorder(Color.black));
        nextButton.setBounds(1050, 700, 100, 50);
        add(nextButton);
        nextButton.addActionListener(this);
        nextButton.setActionCommand("Next");
        count = 0;
    }

    /**
     * Called when actionListeners are triggered
     * 
     * @param e The action calling the event
     */
    public void actionPerformed(ActionEvent e)
    {
        String action = e.getActionCommand();
        if(action.equals("Next"))
        {
            count = 10;
            repaint();
        }   
    }

    /**
     * Panel's paint method to manage the graphics
     * 
     * @param g The Graphics reference
     */
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        g.drawImage(woodBackground,0,0,null);
        //Draw the players destination tickets 
        ArrayList<DestinationCard> playersDestinationCards = new ArrayList(); 
        playersDestinationCards = PlayGame.currentPlayer.destinations;
        int x = 20;
        int y = 5;
        for(int i = count; i < playersDestinationCards.size(); i++)
        {
            g.drawImage(playersDestinationCards.get(i).getPicture(), x, y, null);
            x += 220;
            if(i == 4 || i == 14)
            {
                x = 20;
                y = 350;
            }
            if(i == 19 || i == 19)
            {
                break;
            }
        }
    }

    /**
     * Creates the JFrame for the DestinationCardPanel window
     */
    protected static void createAndShowGUI() 
    {
        //Create and set up the window.
        JFrame frame = new JFrame(PlayGame.currentPlayer.name + "'s Destination Tickets");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        DestinationCardPanel panel = new DestinationCardPanel();
        frame.getContentPane().add(panel);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
