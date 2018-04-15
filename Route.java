import java.util.ArrayList;
import java.awt.*;

////////////////////////////////////////////////////////////////////////////////
/**
 * Idk what I'm doing I'm still figuring this class out
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Route
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

    // protected boolean isDouble(){
        // return doubleTrack;   
    // }

    // protected boolean isTriple(){
        // return tripleTrack;   
    // }
}
