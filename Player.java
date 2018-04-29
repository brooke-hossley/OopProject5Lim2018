////////////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.awt.*;
/**
 * Class to hold player information
 *
 * @author Alissa Ronca, Patrick Baraber, Brooke Hossley,
 * Hieu Le, Chris Adams
 * @version Spring 2018
 */
public class Player
{
    //Player name, color, and points
    protected static boolean globeTrotter = false;
    protected String name;
    protected Color color;
    protected int score;
    protected int carsRemaining;
    protected boolean isLastTurn = false;
    //Array of different color tain cards with how many the player has
    protected int[] trainCounts = new int[9];
    protected ArrayList<TrainCard> trainCards = new ArrayList();
    //Array of meeple colors
    protected int[] meeples = new int[6];
    //ArrayList to hold the players destination tickets they currently have
    protected ArrayList<DestinationCard> destinations = new ArrayList(); 
    //ArrayList to hold the completed tickets
    protected ArrayList<DestinationCard> completedDestinations 
    = new ArrayList(); 
    //ArrayList to hold the routes this player controls
    protected ArrayList<Route> controlledRoutes = new ArrayList();

    /**
     * Constructor with parameters for the Player class
     * 
     * @param pName Players name
     * @param pColor Players color
     */
    public Player(String pName, String pColor)
    {
        name = pName;
        score = 0;
        carsRemaining = 3;
        //Set the player color 
        if (pColor.equalsIgnoreCase("Purple"))
        {
            color = new Color(200, 0, 255);
        }
        else if (pColor.equalsIgnoreCase("Yellow"))
        {
            color = Color.yellow;
        }
        else if (pColor.equalsIgnoreCase("White"))
        {
            color = Color.white;
        }
        else if (pColor.equalsIgnoreCase("Red"))
        {
            color = Color.red;
        }
        else 
        {
            color = new Color(0, 170, 225);
        }
    }

    /**
     * Question
     * 
     * @param count The number of train cards used
     * @return If the player has enough train cards to claim the route
     */
    protected boolean useTrainCars(int count) 
    {
        if(count <= carsRemaining) 
        {
            carsRemaining -= count;
            return true;
        }
        return false;
    }

    /**
     * Methor to add train cards to a players hand
     * 
     * @param tCard The kind of train card
     */
    protected void addTrainCard(TrainCard tCard){
        trainCards.add(tCard);
        trainCounts[tCard.getArrIndex()]++;
    }

    /**
     * Method to add a claimed route to the player information
     * 
     * @param route The route being claimed
     */
    protected void addRoute(Route route){
        //Determining point value
        int n = 0;
        if (route.length < 3) 
        {
            n = route.length;
        }
        else if (route.length == 3) 
        {
            n = 4;
        }
        else if (route.length == 4) 
        {
            n = 7;
        }
        else if (route.length == 5) 
        {
            n = 10;
        }
        else if (route.length == 6) 
        {
            n = 15;
        }
        else if (route.length == 7) 
        {
            n = 18;
        }
        score += n;
        //Question
        useTrainCars(route.length);
        //Set the route to the player color
        route.occupiedByColor = this.color;
        //Add the route to the list of claimed routes
        controlledRoutes.add(route);
    }

    /**
     * Method that checks if player can legally take route if it's available
     * by determining if player has enough train pieces and correct train cards
     * 
     * @param route The route attempting to be claimed
     * @return If the route can be claimed
     */
    protected boolean canTakeRoute(Route route) 
    {
        //Not available
        if (!route.isOpen() || carsRemaining < route.length) 
        {
            return false;
        }
        //If the route is gray
        if (route.color.contains(RouteColor.GRAY)) 
        {
            for (int i=0; i<8; i++)
            {
                if (trainCounts[8] + trainCounts[i] >= route.length)
                    return true;
            }
            return false;
        }
        //All other colors
        if (route.color.contains(RouteColor.YELLOW)) 
        {
            if (trainCounts[8] + trainCounts[0] >= route.length)
                return true;
        }
        if (route.color.contains(RouteColor.BLUE)) 
        {
            if (trainCounts[8] + trainCounts[1] >= route.length)
                return true;
        }
        if (route.color.contains(RouteColor.GREEN)) 
        {
            if (trainCounts[8] + trainCounts[2] >= route.length)
                return true;
        }
        if (route.color.contains(RouteColor.PINK)) 
        {
            if (trainCounts[8] + trainCounts[3] >= route.length)
                return true;
        }
        if (route.color.contains(RouteColor.RED)) 
        {
            if (trainCounts[8] + trainCounts[4] >= route.length)
                return true;
        }
        if (route.color.contains(RouteColor.BLACK)) 
        {
            if (trainCounts[8] + trainCounts[5] >= route.length)
                return true;
        }
        if (route.color.contains(RouteColor.ORANGE)) 
        {
            if (trainCounts[8] + trainCounts[6] >= route.length)
                return true;
        }
        if (route.color.contains(RouteColor.WHITE)) 
        {
            if (trainCounts[8] + trainCounts[7] >= route.length)
                return true;
        }
        return false;
    }

    /**
     * Method to remove train cards from the players hand 
     * after a route is claimed
     * 
     * Question
     * 
     * @param index The index of the train card color
     * @return  
     */
    protected TrainCard removeTrainCard(int index)
    {
        if (index >=0 && index <=8 && trainCounts[index] > 0) 
        {
            trainCounts[index]--;
            int listIndex;
            for (listIndex = 0; listIndex < trainCards.size(); listIndex ++) 
            {
                if (trainCards.get(listIndex).arrIndex == index) 
                    break;
            }
            return trainCards.remove(listIndex);
        }
        return null;
    }

    /**
     * Method to add Meeples to player information
     * 
     * @param index Index of the color Meeple being added
     */
    protected void addMeeple(int index) 
    {
        meeples[index]++;
    }

    /**
     * Method to add a Destination Card to player information
     * 
     * @param dCard The destination card being added
     */
    protected void addDestinationCard(DestinationCard dCard)
    {
        destinations.add(dCard);
    }

    /**
     * Method to collect the additional points the destinations
     * give the player
     * 
     * @return The number of points
     */
    protected int getPosDestScore() 
    {
        int total = 0;
        for (DestinationCard dc: completedDestinations) 
        {
            total += dc.points;
        }
        return total;
    }

    /**
     * Method to subtract the additional points the uncompleted destinations
     * give the player
     * 
     * @return The number of points
     */
    protected int getNegDestScore() 
    {
        int total = 0;
        for (DestinationCard dc: destinations) 
        {
            total += dc.points;
        }
        return total;
    }
}
