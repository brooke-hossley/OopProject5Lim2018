import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.font.*;
import java.io.*;
/**
 * Write a description of class ClaimingRoutes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClaimingRoutes extends JPanel implements ActionListener
{
    //Images
    
    public ClaimingRoutes(){
        

    }
    
     /**
     * Panel's paint method to manage the graphics
     * 
     * @param g The Graphics reference
     */
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);

    }

    public void actionPerformed(ActionEvent e)
    {
        String action = e.getActionCommand();
    }

    /**
     * Creates the JFrame for the ClaimingRoutes window
     */
    protected static void createAndShowGUI() 
    {
        //Create and set up the window.
        JFrame frame = new JFrame("Rules: How to Claim Routes");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ClaimingRoutes panel = new ClaimingRoutes();
        frame.getContentPane().add(panel);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
