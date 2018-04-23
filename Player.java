////////////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.awt.*;

/**
 * Holds all player info
 *
 * @author (Patrick, Brooke, Aliss, Chris, Hieu)
 * @version (4/19/2018)
 */
public class Player
{
    //Player name, color, and points
    protected String name;
    protected Color color;
    protected int score;
    protected int carsRemaining;
    //protected boolean turn = false;
    protected boolean isLastTurn = false;
    //Int array [9] each spot has a different color tain card with how many the player has
    protected int[] trainCounts = new int[9];
    protected ArrayList<TrainCard> trainCards = new ArrayList();

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
        score = 0;
        carsRemaining = 45;
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
            color = new Color(50, 50, 50);
    }
    
    protected boolean useTrainCars(int count) {
        if (count <= carsRemaining) {
            carsRemaining -= count;
            return true;
        }
        return false;
    }

    protected void addTrainCard(TrainCard tcard){
        trainCards.add(tcard);
        trainCounts[tcard.getArrIndex()]++;
    }

    protected void addRoute(Route route){
        //figure out how many points route is worth
        int n = 0;
        if (route.length < 3) 
            n = route.length;
        else if (route.length == 3) 
            n = 4;
        else if (route.length == 4) 
            n = 7;
        else if (route.length == 5) 
            n = 10;
        else if (route.length == 6) 
            n = 15;
        else if (route.length == 7) 
            n = 18;
            
        score += n;
        useTrainCars(route.length);
        route.occupiedByColor = this.color;
        controlledRoutes.add(route);
    }
    
    //checks if player can legally take route if it's available
    //by determining if player has enough train pieces and correct train cards
    protected boolean canTakeRoute(Route route) {
        if (!route.isOpen() || carsRemaining < route.length) {
            return false;
        }
        
        if (route.color.contains(RouteColor.GRAY)) {
            for (int i=0; i<8; i++) {
                if (trainCounts[8] + trainCounts[i] >= route.length)
                    return true;
            }
            return false;
        }
        
        if (route.color.contains(RouteColor.YELLOW)) {
            if (trainCounts[8] + trainCounts[0] >= route.length)
                return true;
        }
        
        if (route.color.contains(RouteColor.BLUE)) {
            if (trainCounts[8] + trainCounts[1] >= route.length)
                return true;
        }
        
        if (route.color.contains(RouteColor.GREEN)) {
            if (trainCounts[8] + trainCounts[2] >= route.length)
                return true;
        }
        
        if (route.color.contains(RouteColor.PINK)) {
            if (trainCounts[8] + trainCounts[3] >= route.length)
                return true;
        }
        
        if (route.color.contains(RouteColor.RED)) {
            if (trainCounts[8] + trainCounts[4] >= route.length)
                return true;
        }
        
        if (route.color.contains(RouteColor.BLACK)) {
            if (trainCounts[8] + trainCounts[5] >= route.length)
                return true;
        }
        
        if (route.color.contains(RouteColor.ORANGE)) {
            if (trainCounts[8] + trainCounts[6] >= route.length)
                return true;
        }
        
        if (route.color.contains(RouteColor.WHITE)) {
            if (trainCounts[8] + trainCounts[7] >= route.length)
                return true;
        }
        
        return false;
    }

    protected TrainCard removeTrainCard(int index){
        if (index >=0 && index <=8 && trainCounts[index] > 0) {
            trainCounts[index]--;
            int listIndex;
            for (listIndex = 0; listIndex < trainCards.size(); listIndex ++) {
                if (trainCards.get(listIndex).arrIndex == index) 
                    break;
            }
            return trainCards.remove(listIndex);
        }
        return null;
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
        //score += d.getPoints();
        completedDestinations.add(d);
    }
    
    //finds score to add based on all the completed destination cards
    protected int getPosDestScore() {
        int total = 0;
        for (DestinationCard dc: completedDestinations) {
            total += dc.points;
        }
        return total;
    }
    
    //finds score to subtract based on all the incompleted destination cards
    protected int getNegDestScore() {
        int total = 0;
        for (DestinationCard dc: destinations) {
            total += dc.points;
        }
        return total;
    }
}
