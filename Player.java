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
    protected boolean turn = false;
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
    
    public String getName()
    {
        return name;
    }

    public Color getColor()
    {
        return color;
    }

    public void updateScore(int n)
    {
        score+=n;	   
    }
    
    public int getScore()
    {
        return score;
    }
    
    public void updateTrains(int n){
        carsRemaining = carsRemaining - n;
    }
    
    public int getCarsRemaining()
    {
        return carsRemaining;
    }
    
    public void changeTurn()
    {
        turn = !turn;
    }
    
    public boolean isTurn()
    {
        return turn;
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

    protected boolean addRoute(Route route){
        //make sure its not occupied already
        if (route.occupiedByColor == null) {
            route.occupiedByColor = this.color;
            controlledRoutes.add(route);
            return true;
        }
        return false;
    }

    protected boolean removeTrainCard(int index){
        if (index >=0 && index <=8 && trainCounts[index] >= 0) {
            trainCounts[index]--;
            return true;
        }
        return false;
    }

    protected void addMeeple(int index) {
        meeples[index]++;
    }

    protected void addDestinationCard(DestinationCard d){
        destinations.add(d);
    }
    
    //add method to get rid of destination card they don't want anymore
    
    public ArrayList<DestinationCard> getDest()
    {
        return destinations;
    }

    protected void CompleteDestinationCard(DestinationCard d){
        if(destinations.contains(d)){
            destinations.remove(d);
        }
        score += d.getPoints();
        completedDestinations.add(d);
    }
}
