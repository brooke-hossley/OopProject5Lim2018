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
public class EndGameWin extends JPanel 
{
    //Images
    protected Image pic, fireworks, celebrate;

    public EndGameWin(){
        pic = new ImageIcon("Images" + File.separator + "EndScreen.jpg").getImage();
        fireworks = new ImageIcon("Images" + File.separator + "fireworks2.gif").getImage();
        celebrate = new ImageIcon("Images" + File.separator + "celebrate.gif").getImage();
        celebrate = celebrate.getScaledInstance(pic.getWidth(null), pic.getHeight(null), Image.SCALE_DEFAULT);
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
        g.drawImage(fireworks, 20, 300, this);
        g.drawImage(fireworks, 800, 300, this);
        g.drawImage(celebrate, 50, 100, this);
        g.setFont(new Font("Monospaced", Font.BOLD, 80));
        String text = "Score Board";
        g.setColor(Color.WHITE);
        int x = 320; int y = 100;
        g.drawString(text, ShiftWest(x, 1), ShiftNorth(y, 1));
        g.drawString(text, ShiftWest(x, 1), ShiftSouth(y, 1));
        g.drawString(text, ShiftEast(x, 1), ShiftNorth(y, 1));
        g.drawString(text, ShiftEast(x, 1), ShiftSouth(y, 1));
        g.setColor(Color.RED);
        g.drawString(text, x, y);
        g.setFont(new Font("Monospaced", Font.BOLD, 30));
        x = 30; y = 200;
        //for(Player p : PlayGame.players){
        //String text2 = p.name;
        String text2 = "Player 1";
        g.setColor(Color.WHITE);
        g.drawString(text2, ShiftWest(x, 1), ShiftNorth(y, 1));
        g.drawString(text2, ShiftWest(x, 1), ShiftSouth(y, 1));
        g.drawString(text2, ShiftEast(x, 1), ShiftNorth(y, 1));
        g.drawString(text2, ShiftEast(x, 1), ShiftSouth(y, 1));
        g.setColor(Color.BLUE);
        g.drawString(text2, x, y);

        //String text3 = p.score + " points";
        String text3 = "150 points";
        x = 230;
        g.setColor(Color.WHITE);
        g.drawString(text3, ShiftWest(x, 1), ShiftNorth(y, 1));
        g.drawString(text3, ShiftWest(x, 1), ShiftSouth(y, 1));
        g.drawString(text3, ShiftEast(x, 1), ShiftNorth(y, 1));
        g.drawString(text3, ShiftEast(x, 1), ShiftSouth(y, 1));
        g.setColor(Color.GREEN);
        g.drawString(text3, x, y);

        //         if(p.globeTrotter){
        //             String text4 = "Globe Trotter!";
        //             x = 330;
        //             g.setColor(Color.WHITE);
        //             g.drawString(text4, ShiftWest(x, 1), ShiftNorth(y, 1));
        //             g.drawString(text4, ShiftWest(x, 1), ShiftSouth(y, 1));
        //             g.drawString(text4, ShiftEast(x, 1), ShiftNorth(y, 1));
        //             g.drawString(text4, ShiftEast(x, 1), ShiftSouth(y, 1));
        //             g.setColor(Color.YELLOW);
        //             g.drawString(text4, x, y);
        //         }

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
     * Creates the JFrame for the ClaimingRoutes window
     */
    protected static void createAndShowGUI() 
    {
        //Create and set up the window.
        JFrame frame = new JFrame("Score Board");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        EndGameWin panel = new EndGameWin();
        frame.getContentPane().add(panel);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
