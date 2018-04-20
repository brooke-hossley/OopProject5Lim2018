import java.util.*;
////////////////////////////////////////////////////////////////////////////////
/**
 * This class needs work
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class City
{
    //Name of the city
    protected String name;
    protected boolean isCountry;
    
    //Number of routes connecting to the city
    //protected int numRoutes;
    protected ArrayList<Route> connectedRoutes;
    
    //Number of meeples on the city w/ each color present
    protected int[] meeples = new int[6]; 
    protected int meepleCount;
    //This array hold each of the 6 colored meeples. Each time a meeple is add/subtracted, the
    //location of that specific color in the array is incremented or decremented 
    
    public City(String nameIn, int[] meeplesIn)
    {
        name = nameIn;
    }
    
    protected void addMeeple(MeepleColor meeple){
        switch(meeple){
            case RED: meeples[0] ++;
            break;
            case BLACK: meeples[1] ++;
            break;
            case GREEN: meeples[2] ++;
            break;
            case YELLOW: meeples[3] ++;
            break;
            case BLUE: meeples[4] ++;
            break;
            case WHITE: meeples[5] ++;
            break;             
        }
    }

    protected void removeMeeple(MeepleColor meeple){
        switch(meeple){
            case RED: meeples[0] --;
            break;
            case BLACK: meeples[1] --;
            break;
            case GREEN: meeples[2] --;
            break;
            case YELLOW: meeples[3] --;
            break;
            case BLUE: meeples[4] --;
            break;
            case WHITE: meeples[5] --;
            break;             
        }
    }
}