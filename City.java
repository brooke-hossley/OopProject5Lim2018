////////////////////////////////////////////////////////////////////////////////
/**
 * Write a description of class City here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class City
{
    //Number of routes connecting to the city
    //Number of meeples on the city w/ each color present
    CityName name;
    String cityname;
    int routes; //The number of paths off of this particular city
    int[] meeples = new int[6]; //This array hold each of the 6 colored meeples. Each time a meeple is add/subtracted, the
    //location of that specific color in the array is incremented or decremented 
    public City(CityName name, int numRoutes){
        this.name = name;
        routes = numRoutes;
    }

    public City(String nameIn)
    {
        cityname = nameIn;  
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
// //city w/ each color present
    // CityName name;
    // int routes; //The number of paths off of this particular city
    // int[] meeples = new int[6]; //This array hold each of the 6 colored meeples. Each time a meeple is add/subtracted, the
    // //location of that specific color in the array is incremented or decremented 
    // public City(CityName name, int numRoutes){
        // this.name = name;
        // routes = numRoutes;
    // }

    // protected void addMeeple(MeepleColor meeple){
        // switch(meeple){
            // case RED: meeples[0] ++;
            // break;
            // case BLACK: meeples[1] ++;
            // break;
            // case GREEN: meeples[2] ++;
            // break;
            // case YELLOW: meeples[3] ++;
            // break;
            // case BLUE: meeples[4] ++;
            // break;
            // case WHITE: meeples[5] ++;
            // break;             
        // }
    // }
    
    // protected void removeMeeple(MeepleColor meeple){
        // switch(meeple){
            // case RED: meeples[0] --;
            // break;
            // case BLACK: meeples[1] --;
            // break;
            // case GREEN: meeples[2] --;
            // break;
            // case YELLOW: meeples[3] --;
            // break;
            // case BLUE: meeples[4] --;
            // break;
            // case WHITE: meeples[5] --;
            // break;             
        // }
    // }
// }
