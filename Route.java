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

    public Route(int length, RouteColor color, boolean doubleTrack, 
    boolean tripleTrack){
        this.length = length;
        this.color = color;
        this.doubleTrack = doubleTrack;
        this.tripleTrack = tripleTrack;
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
