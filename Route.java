import java.util.ArrayList;
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
    
    //The color of the route
    protected RouteColor color; 
    
    //if there are two possibilities for this route in different colors
    protected boolean twoColors; 
    
    //polygon to use as bounds for mouse hover and click
    protected Polygon routeShape;
    
    //player's color once occupying the route
    protected Color occupiedByColor;
    
    //holds locations of trains occypying route once it's claimed by a player
    protected Polygon[] occupyingTrains;
    
    //protected boolean doubleTrack;//If the route has double or triple capacity
    //protected boolean tripleTrack;
    private ArrayList<String> cities = new ArrayList<String>(2);
    //private ArrayList<RouteColor> colors = new ArrayList<RouteColor>();
    
    private static Image board, blackBackground;
    
    public Route(int len, RouteColor rcolor, boolean twoCol){
        length = len;
        color = rcolor;
        
    }

    public Route(String firstCity, String secondCity)
    {
        //cities.add(firstCity);
        //cities.add(secondCity);
        String cityOneName = firstCity;
        String cityTwoName = secondCity;
        if (cityOneName.equals("Hamburg"))
        {
            if(cityTwoName.equals("Rostock"))
            {
                //set length

                //set the color to whatever its supposed to be 
                //colors.add(RouteColor.YELLOW);
                //set points?
            }
            else if (cityTwoName.equals("Berlin"))
            {
                //set length
                //set the color to whatever its supposed to be 
                //colors.add(RouteColor.YELLOW);
            }
            else if(cityTwoName.equals("Frankfurt"))
            {

            }
            else if(cityTwoName.equals("Leipzig"))
            {

            }
            else if(cityTwoName.equals("Kassel"))
            {

            }
            else if(cityTwoName.equals("Koln"))
            {

            }
            else if(cityTwoName.equals("Koblenz"))
            {

            }
            else if(cityTwoName.equals("Dresden"))
            {
                //Here down is long
            }
            else if(cityTwoName.equals("Karlsruhe"))
            {

            }
            else if(cityTwoName.equals("Munchen"))
            {

            }
            else if(cityTwoName.equals("Stuttgart"))
            {

            }
        }
        else if(cityOneName.equals("Berlin"))
        {
            //continue on with whats above for every city and their possible routes
            if(cityTwoName.equals("Chemnitz"))
            {

            }
            else if(cityTwoName.equals("Leipzig"))
            {

            }
            else if(cityTwoName.equals("Erfurt"))
            {

            }
            else if(cityTwoName.equals("Dusseldorf"))
            {

            }
            else if(cityTwoName.equals("Munchen"))
            {

            }
            else if(cityTwoName.equals("Koln"))
            {

            }
            else if(cityTwoName.equals("Frankfurt"))
            {

            }
            else if(cityTwoName.equals("Schweiz"))
            {

            }
            else if(cityTwoName.equals("Stuttgart"))
            {

            }
            else if(cityTwoName.equals("Mainz"))
            {

            }
        }
        else if(cityOneName.equals("Danemark"))
        {
            if(cityTwoName.equals("Berlin"))
            {

            }
            else if(cityTwoName.equals("Niederlande"))
            {

            }
            else if(cityTwoName.equals("Lindau"))
            {

            }
        }
        else if(cityOneName.equals("Magdeburg"))
        {
            if(cityTwoName.equals("Koln"))
            {

            }
        }
        else if(cityOneName.equals("Niederlande"))
        {
            if(cityTwoName.equals("Frankfurt"))
            {

            }
            else if(cityTwoName.equals("Karlsruhe"))
            {

            }
            else if(cityTwoName.equals("Berlin"))
            {

            }
        }
        else if(cityOneName.equals("Mannheim"))
        {
            if(cityTwoName.equals("Wurzburg"))
            {

            }
            else if(cityTwoName.equals("Stuttgart"))
            {

            }
        }
        else if(cityOneName.equals("Frankfurt"))
        {
            if(cityTwoName.equals("Munchen"))
            {

            }
            else if(cityTwoName.equals("Osterreich"))
            {

            }
            else if(cityTwoName.equals("Stuttgart"))
            {

            }
            else if(cityTwoName.equals("Lindau"))
            {

            }
        }
        else if(cityOneName.equals("Frankreich"))
        {
            if(cityTwoName.equals("Munchen"))
            {

            }
            else if(cityTwoName.equals("Danemark"))
            {

            }
            else if(cityTwoName.equals("Leipzig"))
            {

            }
        }
        else if(cityOneName.equals("Freiburg"))
        {

        }
        else if(cityOneName.equals("Karlsruhe"))
        {
            if(cityTwoName.equals("Augsburg"))
            {

            }
            else if(cityTwoName.equals("Regensburg"))
            {

            }
        }
        else if(cityOneName.equals("Mainz"))
        {
            if(cityTwoName.equals("Stuttgart"))
            {

            }
        }
        else if(cityOneName.equals("Koblenz"))
        {
            if(cityTwoName.equals("Ulm"))
            {

            }
        }
        else if(cityOneName.equals("Koln"))
        {
            if(cityTwoName.equals("Nurnberg"))
            {

            }
            else if(cityTwoName.equals("Schweiz"))
            {

            }
            else if(cityTwoName.equals("Regensburg"))
            {

            }
            else if(cityTwoName.equals("Saarbrucken"))
            {

            }
            else if(cityTwoName.equals("Frankfurt"))
            {

            }
            else if(cityTwoName.equals("Munchen"))
            {

            }
            else if(cityTwoName.equals("Leipzig"))
            {

            }            
        }
        else if(cityOneName.equals("Nurnberg"))
        {
            if(cityTwoName.equals("Stuttgart"))
            {

            }
        }
        else if(cityOneName.equals("Augsburg"))
        {

        }
        else if(cityOneName.equals("Munchen"))
        {
            if(cityTwoName.equals("Stuttgart"))
            {

            }
            else if(cityTwoName.equals("Wurzburg"))
            {

            }
            else if(cityTwoName.equals("Konstanz"))
            {

            }
            else if(cityTwoName.equals("Freiburg"))
            {

            }  
        }
        else if(cityOneName.equals("Dusseldorf"))
        {
            if(cityTwoName.equals("Konstanz"))
            {

            }
        }
        else if(cityOneName.equals("Dortmund"))
        {
            if(cityTwoName.equals("Erfurt"))
            {

            }
        }
        else if(cityOneName.equals("Kassel"))
        {
            if(cityTwoName.equals("Freiburg"))
            {

            }
        }
        else if(cityOneName.equals("Erfurt"))
        {
            if(cityTwoName.equals("Wurzburg"))
            {

            }
        }
        else if(cityOneName.equals("Dresden"))
        {
            if(cityTwoName.equals("Saarbrucken"))
            {

            }
            else if(cityTwoName.equals("Augsburg"))
            {

            }
        }
        else if(cityOneName.equals("Leipzig"))
        {
            if(cityTwoName.equals("Frankfurt"))
            {

            }
            else if(cityTwoName.equals("Munchen"))
            {

            }
            else if(cityTwoName.equals("Nurnberg"))
            {

            }
            else if(cityTwoName.equals("Ulm"))
            {

            }
            else if(cityTwoName.equals("Stuttgart"))
            {

            }         
        }
        else if(cityOneName.equals("Hannover"))
        {
            if(cityTwoName.equals("Leipzig"))
            {

            }
            else if(cityTwoName.equals("Saarbrucken"))
            {

            }
            else if(cityTwoName.equals("Frankfurt"))
            {

            }
        }
        else if(cityOneName.equals("Munster"))
        {
            if(cityTwoName.equals("Stuttgart"))
            {

            }
            else if(cityTwoName.equals("OsterreichBOTH"))
            {

            }
            else if(cityTwoName.equals("Munchen"))
            {

            }
        }
        else if(cityOneName.equals("Niederlande"))
        {
            if(cityTwoName.equals("Frankfurt"))
            {

            }
            else if(cityTwoName.equals("Karlsruhe"))
            {

            }
            else if(cityTwoName.equals("BerlinEmden"))
            {

            }
        }
        else if(cityOneName.equals("Emden"))
        {
            if(cityTwoName.equals("Hamburg"))
            {

            }
            else if(cityTwoName.equals("OsterreichBOTH"))
            {

            }
            else if(cityTwoName.equals("Freiburg"))
            {

            }
        }
        else if(cityOneName.equals("Bremen"))
        {
            if(cityTwoName.equals("Kassel"))
            {

            }
            else if(cityTwoName.equals("Dusseldorf"))
            {

            }
            else if(cityTwoName.equals("Burlin"))
            {

            }
        }
        else if(cityOneName.equals("Bremerhaven"))
        {
            if(cityTwoName.equals("Koln"))
            {

            }
            else if(cityTwoName.equals("Frankreich"))
            {

            }
            else if(cityTwoName.equals("Regensburg"))
            {

            }
        }
        else if(cityOneName.equals("KielDannemark"))
        {
            if(cityTwoName.equals("Stuttgart"))
            {

            }
            else if(cityTwoName.equals("Schweiz"))
            {

            }
            else if(cityTwoName.equals("Nurnberg"))
            {

            }
        }
        else if(cityOneName.equals("Rostock"))
        {
            if(cityTwoName.equals("OsterreichBOTH"))
            {

            }
            else if(cityTwoName.equals("Konstanz"))
            {

            }
        }
        else if(cityOneName.equals("Schwerin"))
        {
            if(cityTwoName.equals("Koblenz"))
            {

            }
            else if(cityTwoName.equals("Frankfurt"))
            {

            }
        }
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

    protected RouteColor getRouteColor(){
        return color;   
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
