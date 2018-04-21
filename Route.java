import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

////////////////////////////////////////////////////////////////////////////////
/**
 * Idk what I'm doing I'm still figuring this class out
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Route extends JPanel
{
    //How many trains needed to claim the route
    protected int length; 

    //hold the two cities
    protected ArrayList<City> twoCities;

    //The possible colors of the route
    protected ArrayList<RouteColor> color; 

    //polygon to use as bounds for mouse hover and click
    protected Polygon routeShape;

    //player's color once occupying the route
    protected Color occupiedByColor;

    //holds locations of trains occypying route once it's claimed by a player
    protected Polygon[] occupyingTrains;

    private static Image board, blackBackground;

    public Route(String cityOneName, String cityTwoName, HashMap<String, City> map)
    {
        twoCities = new ArrayList(2);
        color = new ArrayList<RouteColor>();
        ArrayList<String> cityNames = new ArrayList<String>(2);
        
        cityNames.add(cityOneName);
        cityNames.add(cityTwoName);
        twoCities.add(map.get(cityOneName));
        twoCities.add(map.get(cityTwoName));

        if (cityNames.contains("Danemark"))
        {
            if(cityNames.contains("Kiel"))
            {
                length = 2;
                color.add(RouteColor.GRAY);
            }
            else if(cityNames.contains("Bremerhaven"))
            {
                length = 5;
                color.add(RouteColor.GREEN);
            }
        }
        else if (cityNames.contains("Kiel"))
        {
            if(cityNames.contains("Rostock"))
            {
                length = 5;
                color.add(RouteColor.ORANGE);
            }
            else if (cityNames.contains("Schwerin"))
            {
                length = 5;
                color.add(RouteColor.YELLOW);
            }
            else if (cityNames.contains("Hamburg"))
            {
                length = 5;
                color.add(RouteColor.BLACK);
                color.add(RouteColor.PINK);
            }
            else if (cityNames.contains("Bremerhaven"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
            }
        }
        else if (cityNames.contains("Rostock"))
        {
            if (cityNames.contains("Schwerin"))
            {
                length = 2;
                color.add(RouteColor.RED);
            }
            else if (cityNames.contains("Berlin"))
            {
                length = 6;
                color.add(RouteColor.PINK);
            }
        }
        else if (cityNames.contains("Schwerin"))
        {
            if (cityNames.contains("Hamburg"))
            {
                length = 2;
                color.add(RouteColor.GREEN);
            }
            else if (cityNames.contains("Berlin"))
            {
                length = 5;
                color.add(RouteColor.WHITE);
            }
        }
        else if (cityNames.contains("Hamburg"))
        {
            if(cityNames.contains("Berlin"))
            {
                length = 7;
                color.add(RouteColor.BLUE);
                color.add(RouteColor.YELLOW);
            }
            else if (cityNames.contains("Hannover"))
            {
                length = 4;
                color.add(RouteColor.RED);
                color.add(RouteColor.WHITE);
            }
            else if (cityNames.contains("Bremen"))
            {
                length = 3;
                color.add(RouteColor.ORANGE);
            }
            else if (cityNames.contains("Bremerhaven"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
            }
        }
        else if (cityNames.contains("Bremerhaven"))
        {
            if (cityNames.contains("Bremen"))
            {
                length = 1;
                color.add(RouteColor.WHITE);
            }
            else if (cityNames.contains("Emden"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
            }
        }
        else if (cityNames.contains("Emden"))
        {
            if (cityNames.contains("Bremen"))
            {
                length = 3;
                color.add(RouteColor.BLUE);
            }
            else if (cityNames.contains("Munster"))
            {
                length = 4;
                color.add(RouteColor.RED);
            }
            else if (cityNames.contains("Niederlande"))
            {
                length = 2;
                color.add(RouteColor.WHITE);
            }
        }
        else if (cityNames.contains("Bremen"))
        {
            if (cityNames.contains("Munster"))
            {
                length = 3;
                color.add(RouteColor.BLACK);
            }
            else if (cityNames.contains("Hannover"))
            {
                length = 3;
                color.add(RouteColor.YELLOW);
            }
        }
        else if (cityNames.contains("Niederlande"))
        {
            if (cityNames.contains("Munster"))
            {
                length = 2;
                color.add(RouteColor.ORANGE);
            }
            else if (cityNames.contains("Dusseldorf"))
            {
                length = 3;
                color.add(RouteColor.PINK);
            }
        }
        else if (cityNames.contains("Munster"))
        {
            if (cityNames.contains("Hannover"))
            {
                length = 4;
                color.add(RouteColor.PINK);
            }
            else if (cityNames.contains("Dortmund"))
            {
                length = 1;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
        }
        else if (cityNames.contains("Hannover"))
        {
            if (cityNames.contains("Kassel"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityNames.contains("Erfurt"))
            {
                length = 5;
                color.add(RouteColor.GREEN);
                color.add(RouteColor.ORANGE);
            }
            else if (cityNames.contains("Magdeburg"))
            {
                length = 4;
                color.add(RouteColor.BLUE);
            }
            else if (cityNames.contains("Berlin"))
            {
                length = 7;
                color.add(RouteColor.BLACK);
            }
        }
        else if (cityNames.contains("Berlin"))
        {
            if (cityNames.contains("Magdeburg"))
            {
                length = 3;
                color.add(RouteColor.RED);
            }
            else if (cityNames.contains("Leipzig"))
            {
                length = 4;
                color.add(RouteColor.ORANGE);
            }
            else if (cityNames.contains("Dresden"))
            {
                length = 5;
                color.add(RouteColor.GREEN);
            }
        }
        else if (cityNames.contains("Magdeburg"))
        {
            if (cityNames.contains("Leipzig"))
            {
                length = 2;
                color.add(RouteColor.YELLOW);
            }
        }
        else if (cityNames.contains("Dusseldorf"))
        {
            if (cityNames.contains("Dortmund"))
            {
                length = 1;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityNames.contains("Koln"))
            {
                length = 1;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
        }
        else if (cityNames.contains("Kassel"))
        {
            if (cityNames.contains("Dortmund"))
            {
                length = 4;
                color.add(RouteColor.GREEN);
            }
            else if (cityNames.contains("Frankfurt"))
            {
                length = 4;
                color.add(RouteColor.BLUE);
                color.add(RouteColor.WHITE);
            }
            else if (cityNames.contains("Erfurt"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
            }
        }
        else if (cityNames.contains("Leipzig"))
        {
            if(cityNames.contains("Erfurt"))
            {
                length = 3;
                color.add(RouteColor.RED);
            }
            else if (cityNames.contains("Dresden"))
            {
                length = 3;
                color.add(RouteColor.BLACK);
            }
            else if (cityNames.contains("Chemnitz"))
            {
                length = 2;
                color.add(RouteColor.BLUE);
            }
        }
        else if (cityNames.contains("Dresden"))
        {
            if (cityNames.contains("Chemnitz"))
            {
                length = 1;
                color.add(RouteColor.YELLOW);
            }
            else if (cityNames.contains("Regensburg"))
            {
                length = 7;
                color.add(RouteColor.RED);
            }
        }
        else if (cityNames.contains("Chemnitz"))
        {
            if(cityNames.contains("Dresden"))
            {
                length = 1;
                color.add(RouteColor.YELLOW);
            }
            else if (cityNames.contains("Leipzig"))
            {
                length = 2;
                color.add(RouteColor.BLUE);
            }
            else if (cityNames.contains("Erfurt"))
            {
                length = 4;
                color.add(RouteColor.BLACK);
            }
            else if (cityNames.contains("Regensburg"))
            {
                length = 6;
                color.add(RouteColor.PINK);
            }
        }
        else if (cityNames.contains("Erfurt"))
        {
            if(cityNames.contains("Hannover"))
            {
                length = 5;
                color.add(RouteColor.GREEN);
                color.add(RouteColor.ORANGE);
            }
            else if (cityNames.contains("Kassel"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
            }
            else if (cityNames.contains("Nurnburg"))
            {
                length = 4;
                color.add(RouteColor.YELLOW);
                color.add(RouteColor.PINK);
            }
            else if (cityNames.contains("Regensburg"))
            {
                length = 7;
                color.add(RouteColor.WHITE);
            }
            else if (cityNames.contains("Chemnitz"))
            {
                length = 4;
                color.add(RouteColor.BLACK);
            }
            else if (cityNames.contains("Leipzig"))
            {
                length = 3;
                color.add(RouteColor.RED);
            }
        }
        else if (cityNames.contains("Koln"))
        {
            if(cityNames.contains("Dusseldorf"))
            {
                length = 1;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityNames.contains("Frankfurt"))
            {
                length = 4;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityNames.contains("Koblenz"))
            {
                length = 1;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
        }
        else if (cityNames.contains("Frankfurt"))
        {
            if(cityNames.contains("Kassel"))
            {
                length = 4;
                color.add(RouteColor.BLUE);
                color.add(RouteColor.WHITE);
            }
            else if (cityNames.contains("Wurzburg"))
            {
                length = 2;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityNames.contains("Mannheim"))
            {
                length = 2;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityNames.contains("Mainz"))
            {
                length = 2;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityNames.contains("Koln"))
            {
                length = 4;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
        }
        else if (cityNames.contains("Koblenz"))
        {
            if(cityNames.contains("Koln"))
            {
                length = 1;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityNames.contains("Mainz"))
            {
                length = 2;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityNames.contains("Saarbrucken"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
            }
        }
        else if (cityNames.contains("Mainz"))
        {
            if(cityNames.contains("Koblenz"))
            {
                length = 2;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityNames.contains("Frankfurt"))
            {
                length = 1;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityNames.contains("Mannheim"))
            {
                length = 1;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityNames.contains("Saarbrucken"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
            }
        }
        else if (cityNames.contains("Wurzburg"))
        {
            if(cityNames.contains("Frankfurt"))
            {
                length = 2;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityNames.contains("Nurnburg"))
            {
                length = 2;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
        }
        else if (cityNames.contains("Nurnburg"))
        {
            if(cityNames.contains("Erfurt"))
            {
                length = 4;
                color.add(RouteColor.PINK);
                color.add(RouteColor.YELLOW);
            }
            else if (cityNames.contains("Wurzburg"))
            {
                length = 2;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityNames.contains("Augsburg"))
            {
                length = 4;
                color.add(RouteColor.ORANGE);
            }
            else if (cityNames.contains("Munchen"))
            {
                length = 5;
                color.add(RouteColor.BLACK);
                color.add(RouteColor.BLUE);
            }
            else if (cityNames.contains("Regensburg"))
            {
                length = 3;
                color.add(RouteColor.GREEN);
            }
        }
        else if (cityNames.contains("Regensburg"))
        {
            if(cityNames.contains("Dresden"))
            {
                length = 7;
                color.add(RouteColor.RED);
            }
            else if (cityNames.contains("Chemnitz"))
            {
                length = 6;
                color.add(RouteColor.PINK);
            }
            else if (cityNames.contains("Erfurt"))
            {
                length = 7;
                color.add(RouteColor.WHITE);
            }
            else if (cityNames.contains("Nurnburg"))
            {
                length = 3;
                color.add(RouteColor.GREEN);
            }
            else if (cityNames.contains("Munchen"))
            {
                length = 3;
                color.add(RouteColor.ORANGE);
            }
            else if (cityNames.contains("Osterreich"))
            {
                length = 4;
                color.add(RouteColor.YELLOW);
            }
        }
        else if (cityNames.contains("Mannheim"))
        {
            if(cityNames.contains("Mainz"))
            {
                length = 1;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityNames.contains("Frankfurt"))
            {
                length = 2;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityNames.contains("Stuttgart"))
            {
                length = 2;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityNames.contains("Karlsruhe"))
            {
                length = 1;
                color.add(RouteColor.BLUE);
            }
            else if (cityNames.contains("Saarbrucken"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
            }
        }
        else if (cityNames.contains("Saarbrucken"))
        {
            if(cityNames.contains("Frankreich"))
            {
                length = 1;
                color.add(RouteColor.GREEN);
            }
            else if (cityNames.contains("Karlsruhe"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
            }
            else if (cityNames.contains("Mannheim"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
            }
            else if (cityNames.contains("Mainz"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
            }
            else if (cityNames.contains("Koblenz"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
            }
        }
        else if (cityNames.contains("Karlsruhe"))
        {
            if(cityNames.contains("Mannheim"))
            {
                length = 1;
                color.add(RouteColor.BLUE);
            }
            else if (cityNames.contains("Saarbrucken"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
            }
            else if (cityNames.contains("Frankreich"))
            {
                length = 2;
                color.add(RouteColor.BLACK);
            }
            else if (cityNames.contains("Freiburg"))
            {
                length = 3;
                color.add(RouteColor.WHITE);
            }
            else if (cityNames.contains("Stuttgart"))
            {
                length = 1;
                color.add(RouteColor.PINK);
            }
        }
        else if (cityNames.contains("Stuttgart"))
        {
            if(cityNames.contains("Mannheim"))
            {
                length = 2;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityNames.contains("Karlsruhe"))
            {
                length = 1;
                color.add(RouteColor.PINK);
            }
            else if (cityNames.contains("Freiburg"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
            }
            else if (cityNames.contains("Konstanz"))
            {
                length = 3;
                color.add(RouteColor.GREEN);
            }
            else if (cityNames.contains("Ulm"))
            {
                length = 2;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
        }
        else if (cityNames.contains("Frankreich"))
        {
            if(cityNames.contains("Saarbrucken"))
            {
                length = 1;
                color.add(RouteColor.GREEN);
            }
            else if (cityNames.contains("Karlsruhe"))
            {
                length = 2;
                color.add(RouteColor.BLACK);
            }
            else if (cityNames.contains("Freiburg"))
            {
                length = 2;
                color.add(RouteColor.YELLOW);
            }
        }
        else if (cityNames.contains("Ulm"))
        {
            if(cityNames.contains("Stuttgart"))
            {
                length = 2;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityNames.contains("Augsburg"))
            {
                length = 1;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityNames.contains("Lindau"))
            {
                length = 2;
                color.add(RouteColor.RED);
            }
        }
        else if (cityNames.contains("Augsburg"))
        {
            if(cityNames.contains("Nurnburg"))
            {
                length = 4;
                color.add(RouteColor.ORANGE);
            }
            else if (cityNames.contains("Munchen"))
            {
                length = 2;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityNames.contains("Ulm"))
            {
                length = 1;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
        }
        else if (cityNames.contains("Munchen"))
        {
            if(cityNames.contains("Augsburg"))
            {
                length = 2;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityNames.contains("Lindau"))
            {
                length = 5;
                color.add(RouteColor.GRAY);
            }
            else if (cityNames.contains("Osterreich"))
            {
                length = 3;
                color.add(RouteColor.RED);
            }
            else if (cityNames.contains("Regensburg"))
            {
                length = 3;
                color.add(RouteColor.ORANGE);
            }
            else if (cityNames.contains("Nurnburg"))
            {
                length = 5;
                color.add(RouteColor.BLACK);
                color.add(RouteColor.BLUE);
            }
        }
        else if (cityNames.contains("Freiburg"))
        {
            if(cityNames.contains("Frankreich"))
            {
                length = 2;
                color.add(RouteColor.YELLOW);
            }
            else if (cityNames.contains("Karlsruhe"))
            {
                length = 3;
                color.add(RouteColor.WHITE);
            }
            else if (cityNames.contains("Stuttgart"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
            }
            else if (cityNames.contains("Konstanz"))
            {
                length = 2;
                color.add(RouteColor.BLACK);
            }
            else if (cityNames.contains("Schweiz"))
            {
                length = 2;
                color.add(RouteColor.ORANGE);
            }
        }
        else if (cityNames.contains("Konstanz"))
        {
            if(cityNames.contains("Freiburg"))
            {
                length = 2;
                color.add(RouteColor.BLACK);
            }
            else if (cityNames.contains("Stuttgart"))
            {
                length = 3;
                color.add(RouteColor.GREEN);
            }
            else if (cityNames.contains("Lindau"))
            {
                length = 1;
                color.add(RouteColor.YELLOW);
            }
            else if (cityNames.contains("Schweiz"))
            {
                length = 1;
                color.add(RouteColor.WHITE);
            }
        }
        else if (cityNames.contains("Lindau"))
        {
            if(cityNames.contains("Konstanz"))
            {
                length = 1;
                color.add(RouteColor.YELLOW);
            }
            else if (cityNames.contains("Schweiz"))
            {
                length = 2;
                color.add(RouteColor.BLUE);
            }
            else if (cityNames.contains("Osterreich"))
            {
                length = 2;
                color.add(RouteColor.PINK);
            }
            else if (cityNames.contains("Munchen"))
            {
                length = 5;
                color.add(RouteColor.GRAY);
            }
            else if (cityNames.contains("Ulm"))
            {
                length = 2;
                color.add(RouteColor.RED);
            }
        }
        else if (cityNames.contains("Schweiz"))
        {
            if(cityNames.contains("Freiburg"))
            {
                length = 2;
                color.add(RouteColor.ORANGE);
            }
            else if (cityNames.contains("Konstanz"))
            {
                length = 1;
                color.add(RouteColor.WHITE);
            }
            else if (cityNames.contains("Lindau"))
            {
                length = 2;
                color.add(RouteColor.BLUE);
            }
        }
        else if (cityNames.contains("Osterreich"))
        {
            if(cityNames.contains("Lindau"))
            {
                length = 2;
                color.add(RouteColor.PINK);
            }
        }
        else if (cityNames.contains("Osterreich"))
        {
            if(cityNames.contains("Munchen"))
            {
                length = 3;
                color.add(RouteColor.RED);
            }
            else if (cityNames.contains("Regensburg"))
            {
                length = 4;
                color.add(RouteColor.YELLOW);
            }
        }
        
        map.get(cityOneName).addRoute(this);
        map.get(cityTwoName).addRoute(this);
        
    }
    
    protected boolean containsMouse(int x, int y){
        return routeShape.contains(x, y);
    }
    
    //check is route is open to take
    protected boolean isOpen(){
        return occupiedByColor == null;
    }

    protected void claimRoute(Player p) {
        occupiedByColor = p.getColor();
        
        //increment player score with points its worth
        int n = 0;
        if (length < 3) 
            n = length;
        else if (length == 3) 
            n = 4;
        else if (length == 4) 
            n = 7;
        else if (length == 5) 
            n = 10;
        else if (length == 6) 
            n = 15;
        else if (length == 7) 
            n = 18;
            
        p.updateScore(n);
    }
    
    public String toString() {
        return twoCities.get(0).name + twoCities.get(1).name;
    }

    public static String getStringrouteColor(RouteColor col) {
        if(col == RouteColor.YELLOW)
        {
            return "yellow";
        }
        else if(col == RouteColor.ORANGE)
        {
            return "orange";
        }
        // return "orange";
        // return "green";
        // return "blue";
        // return "red";
        // return "gray";
        // return "white";
        // return "black";
        // return "purple";
        //else
        else {
            return "nosuchcolor";
        }
    }

    protected int getRouteLength(){
        return length;   
    }


    public Route()
    {
        String dir = "Images//";
        board = new ImageIcon(dir + "Board.JPG").getImage();
        blackBackground = new ImageIcon(dir + "blackBackground.JPG").getImage();
        Dimension size = new Dimension(blackBackground.getWidth(null), board.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Ticket To Ride");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Route panel = new Route();
        frame.getContentPane().add(panel);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
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

    @Override
    public void paintComponent(Graphics g){
        // As we learned in the last lesson,
        // the origin (0,0) is at the upper left corner.
        // x increases to the right, and y increases downward.
        // add 270 to be on board, board ends at 890
        super.paintComponent(g);

        g.drawImage(blackBackground,0,0,null);
        g.drawImage(board,blackBackground.getWidth(null)/4,0,null);

        //used to find coordinates
        g.setColor(new Color(255,0,0));
        g.drawRect(735, 434, 10, 10);
        g.fillRect(735,434,10,10);

        //size of one rectangle in a route
        g.setColor(new Color(0,0,0));
        g.drawRect(630, 400, 31, 10);
        g.fillRect(630,400,31,10);

        g.setColor(new Color(0,0,255));
        g.drawRect(580, 340, 217, 10);
        g.fillRect(580,340,217, 10);

        //Hamburg to Berlin
        g.setColor(new Color(0,255,0));
        int [] a1 = {605, 593, 782, 794};
        int [] a2 = {189, 208, 308, 289};
        g.drawPolygon(a1,a2,4);
        g.fillPolygon(a1,a2,4);

        //Hamburg to Hannover
        g.setColor(new Color(0,255,0));
        int [] a3 = {592, 570, 540, 563};
        int [] a4 = {207, 201, 321, 325};
        g.drawPolygon(a3,a4,4);
        g.fillPolygon(a3,a4,4);

        //Hannover to Berlin
        g.setColor(new Color(0,255,0));
        int [] a5 = {567, 567, 782, 782};
        int [] a6 = {320, 329, 321, 310};
        g.drawPolygon(a5,a6,4);
        g.fillPolygon(a5,a6,4);

        //Hannover to Erfurt
        g.setColor(new Color(0,255,0));
        int [] a7 = {565, 545, 624, 644};
        int [] a8 = {338, 349, 481, 469};
        g.drawPolygon(a7,a8,4);
        g.fillPolygon(a7,a8,4);

        //Erfurt to Chyemnitz
        g.setColor(new Color(0,255,0));
        int [] a9 = {655, 654, 776, 776};
        int [] a10 = {481, 490, 502, 492};
        g.drawPolygon(a9,a10,4);
        g.fillPolygon(a9,a10,4);

        //Erfurt to Nurnburg
        g.setColor(new Color(0,255,0));
        int [] a11 = {651, 628, 631, 653};
        int [] a12 = {498, 498, 620, 619};
        g.drawPolygon(a11,a12,4);
        g.fillPolygon(a11,a12,4);

        //Nurnburg to Regensburg
        g.setColor(new Color(0,255,0));
        int [] a13 = {665, 658, 733, 739};
        int [] a14 = {624, 632, 684, 677};
        g.drawPolygon(a13,a14,4);
        g.fillPolygon(a13,a14,4);

    }
    // protected boolean isDouble(){
    // return doubleTrack;   
    // }

    // protected boolean isTriple(){
    // return tripleTrack;   
    // }
}
