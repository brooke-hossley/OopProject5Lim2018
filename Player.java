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
    //Int array of meeples [6] each spot has one of the six colors
    //Int array [9] each spot has a different color tain card with how many the palyer has
    String name;
    Color color;
    int score = 0;
    int[] trainCards = new int[9];
    int[] meeples = new int[6];
    ArrayList<DestinationCard> destinations = new ArrayList(); //An ArrayList to hold the players destination tickets they currently have
    ArrayList<DestinationCard> completedDestinations = new ArrayList(); //And to hold the completed tickets
    public Player(String pname, Color pcolor){
        name = pname;
        color = pcolor;
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
    
    protected void CompleteDestinationTicket(DestinationCard d){
        if(destinations.contains(d)){
            destinations.remove(d);
        }
        completedDestinations.add(d);
    }
}
