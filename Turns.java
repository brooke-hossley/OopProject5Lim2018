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
public class Turns extends JPanel 
{
    //Images
    protected Image pic;
    public Turns(){
        pic = new ImageIcon("Images" + File.separator + "Turns.PNG").getImage();
        Dimension size = new Dimension(pic.getWidth(null), pic.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    /**
     * Panel's paint method to manage the graphics
     * 
     * @param g The Graphics reference
     */
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        g.drawImage(pic, 0, 0, null);
    }

    /**
     * Creates the JFrame for the ClaimingRoutes window
     */
    protected static void createAndShowGUI() 
    {
        //Create and set up the window.
        JFrame frame = new JFrame("Rules: Taking your turn");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Turns panel = new Turns();
        frame.getContentPane().add(panel);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
