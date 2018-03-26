////////////////////////////////////////////////////////////////////////////////
import java.util.*;
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    //Int array of meeples [6] each spot has one of the six colors
    //Int array [9] each spot has a different color tain card with how many the palyer has
    String name;
    PlayerColor color;
    int[] trainCards = new int[9];
    ArrayList<Route> destinations = new ArrayList<Route>(); //An ArrayList to hold the players destination tickets they currently have
    ArrayList<Route> completedDestinations = new ArrayList<Route>(); //And to hold the completed tickets
    public Player(String name, PlayerColor color){
        this.name = name;
        this.color = color;
    }
    //Same concept as the Cities meeples
    protected void addTrainCard(TrainColor color){
        switch(color){
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
    
    protected void removeTrainCard(TrainColor color){
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
        }
    }
    
    protected void addDestinationTeckets(Route route){
        destinations.add(route);
    }
    
    protected void addCompletedDestinationTicket(Route route){
        if(destinations.contains(route)){
            destinations.remove(route);
        }
        completedDestinations.add(route);
    }
}
