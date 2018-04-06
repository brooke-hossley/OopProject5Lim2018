import java.util.ArrayList;
////////////////////////////////////////////////////////////////////////////////
/**
 * Write a description of class Route here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Route
{
    protected int length; //Aka how many trains are needed to claim the route
    protected RouteColor color; //The color of the route
    protected boolean doubleTrack;//If the route has double or triple capacity
    protected boolean tripleTrack;
    private ArrayList<String> cities = new ArrayList<String>();
    private ArrayList<RouteColor> colors = new ArrayList<RouteColor>();
    public Route(int length, RouteColor color, boolean doubleTrack, 
    boolean tripleTrack){
        this.length = length;
        this.color = color;
        this.doubleTrack = doubleTrack;
        this.tripleTrack = tripleTrack;
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
            else if(cityTwoName.equals(""))
            {

            }
        }
        else if(cityOneName.equals("Berlin"))
        {
            //continue on with whats above for every city and their possible routes
        }
    }

    public static String getStringrouteColor(RouteColor col) {
        if(col == YELLOW)
        {
            return "yellow";
        }
        else if( col == ORANGE)
        {
            return "orange";
        }
        return "orange";
        return "green";
        return "blue";
        return "red";
        return "gray";
        return "white";
        return "black";
        return "purple";
        //else
        {
            return "nosuchcolor";
        }
        
    }

    protected int getRouteLength(){
        return length;   
    }

    protected RouteColor getRouteColor(){
        return color;   
    }

    protected boolean isDouble(){
        return doubleTrack;   
    }

    protected boolean isTriple(){
        return tripleTrack;   
    }
}
