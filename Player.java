////////////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.awt.*;

/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    //Player name, color, and points
    protected String name;
    protected Color color;
    protected int score = 0;
    protected int carsRemaining = 45;
    
    //Int array [9] each spot has a different color tain card with how many the player has
    protected int[] trainCards = new int[9];
    
    //Int array of meeples [6] each spot has one of the six colors
    protected int[] meeples = new int[6];
    
    //An ArrayList to hold the players destination tickets they currently have
    protected ArrayList<DestinationCard> destinations = new ArrayList(); 
    
    //And to hold the completed tickets
    protected ArrayList<DestinationCard> completedDestinations = new ArrayList(); 
    
    //The routes this player controls
    protected ArrayList<Route> controlledRoutes = new ArrayList();
    
    public Player(String pName, String pColor){
        name = pName;
        
        //set color based on pcolor string
        if (pColor.equalsIgnoreCase("Purple"))
            color = new Color(200, 0, 255);
        else if (pColor.equalsIgnoreCase("Yellow"))
            color = Color.yellow;
        else if (pColor.equalsIgnoreCase("White"))
            color = Color.white;
        else if (pColor.equalsIgnoreCase("Red"))
            color = Color.red;
        else if (pColor.equalsIgnoreCase("Black"))
            color = Color.black;
    }
    
    protected boolean useTrainCars(int count) {
        if (count <= carsRemaining) {
            carsRemaining -= count;
            return true;
        }
        return false;
    }
    
    protected void addTrainCard(int index){
        if (index >=0 && index <=8)
            trainCards[index]++;
    }
    
    protected boolean addRoute(Route route){
        //make sure its not occupied already
        if (route.occupiedByColor == null) {
            route.occupiedByColor = this.color;
            controlledRoutes.add(route);
            return true;
        }
        return false;
    }
    
    //Same concept as the Cities meeples
    protected void addTrainCard(TrainColor tcolor){
        switch(tcolor){
            case YELLOW: trainCards[0] ++;
                    break;
            case BLUE: trainCards[1] ++;
                    break;
            case GREEN: trainCards[2] ++;
                    break;
            case PINK: trainCards[3] ++;
                    break;
            case RED: trainCards[4] ++;
                    break;
            case BLACK: trainCards[5] ++;
                    break;        
            case ORANGE: trainCards[6] ++;
                    break;  
            case WHITE: trainCards[7] ++;
                    break;   
            case RAINBOW: trainCards[8] ++;
                    break;        
        }
    }
    
    protected boolean removeTrainCard(int index){
        if (index >=0 && index <=8 && trainCards[index] >= 0) {
            trainCards[index]--;
            return true;
        }
        return false;
    }
    
    protected boolean removeTrainCard(TrainColor color){
        switch(color){
            case YELLOW: trainCards[0] --;
                    break;
            case BLUE: trainCards[1] --;
                    break;
            case GREEN: trainCards[2] --;
                    break;
            case PINK: trainCards[3] --;
                    break;
            case RED: trainCards[4] --;
                    break;
            case BLACK: trainCards[5] --;
                    break;        
            case ORANGE: trainCards[6] --;
                    break;  
            case WHITE: trainCards[7] --;
                    break;   
            case RAINBOW: trainCards[8] --;
                    break;        
            default: return false;
        }
        return true;
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
    
    protected void addMeeple(int index) {
        meeples[index]++;
    }
    
    protected void addDestinationCard(DestinationCard d){
        destinations.add(d);
    }
    
    protected void CompleteDestinationCard(DestinationCard d){
        if(destinations.contains(d)){
            destinations.remove(d);
        }
        completedDestinations.add(d);
    }
}
