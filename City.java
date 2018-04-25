import java.util.*;
import java.awt.*;
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
    
    //routes connecting to the city
    //protected int numRoutes;
    protected ArrayList<Route> connectedRoutes;
    
    //will be used for hover functionality over city
    protected Polygon cityShape;
    
    //Number of meeples on the city w/ each color present
    protected int[] meeples = new int[6]; 
    protected int meepleAmount;
    //This array hold each of the 6 colored meeples. Each time a meeple is add/subtracted, the
    //location of that specific color in the array is incremented or decremented 
    
    public City(ArrayList<Integer> meepleIndexes, String nameIn)
    {
        name = nameIn;
        isCountry = false;
        meepleAmount = 1;
        connectedRoutes = new ArrayList<Route>();
        
        //set iscountry
        //set meepleamount
        //////////////To do: set shapes///////////////////
        
        if (name.equals("Augsburg")) { 
            //this is just dummy coordinates to draw a big blue shape so I knew it ran
            int[] xs = {40, 140, 155, 50};
            int[] ys = {40, 40, 155, 150};
            cityShape = new Polygon(xs, ys, 4);
        }
        else if (name.equals("Berlin")) { 
            meepleAmount = 5;
        }
        else if (name.equals("Bremen")) { 
            
        }
        else if (name.equals("Bremerhaven")) { 
            
        }
        else if (name.equals("Chemnitz")) { 
            
        }
        else if (name.equals("Danemark")) { 
            isCountry = true;
        }
        else if (name.equals("Dortmund")) { 
            
        }
        else if (name.equals("Dresden")) { 
            
        }
        else if (name.equals("Dusseldorf")) { 
            
        }
        else if (name.equals("Emden")) { 
            
        }
        else if (name.equals("Erfurt")) { 
            
        }
        else if (name.equals("Frankfurt")) { 
            meepleAmount = 4;
        }
        else if (name.equals("Frankreich")) { 
            isCountry = true;
        }
        else if (name.equals("Freiburg")) { 
            
        }
        else if (name.equals("Hamburg")) { 
            meepleAmount = 4;
        }
        else if (name.equals("Hannover")) { 
            
        }
        else if (name.equals("Karlsruhe")) { 
            
        }
        else if (name.equals("Kassel")) { 
            
        }
        else if (name.equals("Kiel")) { 
            
        }
        else if (name.equals("Koblenz")) { 
            
        }
        else if (name.equals("Koln")) { 
            meepleAmount = 4;
        }
        else if (name.equals("Konstanz")) { 
            
        }
        else if (name.equals("Leipzig")) { 
            meepleAmount = 3;
        }
        else if (name.equals("Lindau")) { 
            
        }
        else if (name.equals("Magdeburg")) { 
            
        }
        else if (name.equals("Mainz")) { 
            
        }
        else if (name.equals("Mannheim")) { 
            
        }
        else if (name.equals("Munchen")) { 
            meepleAmount = 4;
        }
        else if (name.equals("Munster")) { 
            
        }
        else if (name.equals("Niederlande")) { 
            isCountry = true;
        }
        else if (name.equals("Nurnberg")) { 
            
        }
        else if (name.equals("Osterreich")) { 
            isCountry = true;
        }
        else if (name.equals("Regensburg")) { 
            
        }
        else if (name.equals("Rostock")) { 
            
        }
        else if (name.equals("Saarbrucken")) { 
            
        }
        else if (name.equals("Schweiz")) { 
            isCountry = true;
        }
        else if (name.equals("Schwerin")) { 
            
        }
        else if (name.equals("Stuttgart")) { 
            meepleAmount = 3;
        }
        else if (name.equals("Ulm")) { 
            
        }
        else if (name.equals("Wurzburg")) { 
            
        }
        
        //add meeples
        int indexNum;
        for (int i = 0; i < meepleAmount; i++) {
            indexNum = meepleIndexes.remove(meepleIndexes.size() -1);
            meeples[indexNum]++;
        }
        
    }
}