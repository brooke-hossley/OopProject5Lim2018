import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
/**
 * Class for board information 
 *
 * @author Alissa Ronca, Patrick Baraber, Brooke Hossley,
 * Hieu Le, Chris Adams
 * @version Spring 2018
 */
public class Board
{
    //ArrayList of routes and a HashMap of the city names
    protected ArrayList<Route> routes;
    protected HashMap<String, City> allCities;

    /**
     * Default constructor for the Board class
     */
    public Board()
    {
        ArrayList<Integer> meepleIndexes = new ArrayList<Integer>(60);
        for(int i = 0; i < 6; i++) 
        {
            for(int j = 0; j < 10; j++) 
            {
                meepleIndexes.add(i);
            }
        }
        //To randomize the colors of the Meeples per city
        Collections.shuffle(meepleIndexes);
        //Construction of the hash map
        allCities = new HashMap<String, City>();
        allCities.put("Augsburg", new City(meepleIndexes, "Augsburg"));
        allCities.put("Berlin", new City(meepleIndexes, "Berlin"));
        allCities.put("Bremen", new City(meepleIndexes, "Bremen"));
        allCities.put("Bremerhaven", new City(meepleIndexes, "Bremerhaven"));
        allCities.put("Chemnitz", new City(meepleIndexes, "Chemnitz"));
        allCities.put("Danemark", new City(meepleIndexes, "Danemark"));
        allCities.put("Dortmund", new City(meepleIndexes, "Dortmund"));
        allCities.put("Dresden", new City(meepleIndexes, "Dresden"));
        allCities.put("Dusseldorf", new City(meepleIndexes, "Dusseldorf"));
        allCities.put("Emden", new City(meepleIndexes, "Emden"));
        allCities.put("Erfurt", new City(meepleIndexes, "Erfurt"));
        allCities.put("Frankfurt", new City(meepleIndexes, "Frankfurt"));
        allCities.put("Frankreich", new City(meepleIndexes, "Frankreich"));
        allCities.put("Freiburg", new City(meepleIndexes, "Freiburg"));
        allCities.put("Hamburg", new City(meepleIndexes, "Hamburg"));
        allCities.put("Hannover", new City(meepleIndexes, "Hannover"));
        allCities.put("Karlsruhe", new City(meepleIndexes, "Karlsruhe"));
        allCities.put("Kassel", new City(meepleIndexes, "Kassel"));
        allCities.put("Kiel", new City(meepleIndexes, "Kiel"));
        allCities.put("Koblenz", new City(meepleIndexes, "Koblenz"));
        allCities.put("Koln", new City(meepleIndexes, "Koln"));
        allCities.put("Konstanz", new City(meepleIndexes, "Konstanz"));
        allCities.put("Leipzig", new City(meepleIndexes, "Leipzig"));
        allCities.put("Lindau", new City(meepleIndexes, "Lindau"));
        allCities.put("Magdeburg", new City(meepleIndexes, "Magdeburg"));
        allCities.put("Mainz", new City(meepleIndexes, "Mainz"));
        allCities.put("Mannheim", new City(meepleIndexes, "Mannheim"));
        allCities.put("Munchen", new City(meepleIndexes, "Munchen"));
        allCities.put("Munster", new City(meepleIndexes, "Munster"));
        allCities.put("Niederlande", new City(meepleIndexes, "Niederlande"));
        allCities.put("Nurnberg", new City(meepleIndexes, "Nurnberg"));
        allCities.put("Osterreich", new City(meepleIndexes, "Osterreich"));
        allCities.put("Regensburg", new City(meepleIndexes, "Regensburg"));
        allCities.put("Rostock", new City(meepleIndexes, "Rostock"));
        allCities.put("Saarbrucken", new City(meepleIndexes, "Saarbrucken"));
        allCities.put("Schweiz", new City(meepleIndexes, "Schweiz"));
        allCities.put("Schwerin", new City(meepleIndexes, "Schwerin"));
        allCities.put("Stuttgart", new City(meepleIndexes, "Stuttgart"));
        allCities.put("Ulm", new City(meepleIndexes, "Ulm"));
        allCities.put("Wurzburg", new City(meepleIndexes, "Wurzburg"));
        
        //Construction of the routes
        routes = new ArrayList<Route>();
        routes.add(new Route("Danemark","Kiel", allCities));
        routes.add(new Route("Danemark","Bremerhaven", allCities));
        routes.add(new Route("Kiel","Rostock", allCities));
        routes.add(new Route("Kiel","Schwerin", allCities));
        routes.add(new Route("Kiel","Hamburg", allCities));
        routes.add(new Route("Kiel","Bremerhaven", allCities));
        routes.add(new Route("Rostock","Schwerin", allCities));
        routes.add(new Route("Rostock","Berlin", allCities));
        routes.add(new Route("Schwerin","Hamburg", allCities));
        routes.add(new Route("Schwerin","Berlin", allCities));
        routes.add(new Route("Hamburg","Berlin", allCities));
        routes.add(new Route("Hamburg","Hannover", allCities));
        routes.add(new Route("Hamburg","Bremen", allCities));
        routes.add(new Route("Hamburg","Bremerhaven", allCities));
        routes.add(new Route("Bremerhaven","Bremen", allCities));
        routes.add(new Route("Bremerhaven","Emden", allCities));
        routes.add(new Route("Emden","Bremen", allCities));
        routes.add(new Route("Emden","Munster", allCities));
        routes.add(new Route("Emden","Niederlande", allCities));
        routes.add(new Route("Bremen","Munster", allCities));
        routes.add(new Route("Bremen","Hannover", allCities));
        routes.add(new Route("Niederlande","Munster", allCities));
        routes.add(new Route("Niederlande","Dusseldorf", allCities));
        routes.add(new Route("Munster","Hannover", allCities));
        routes.add(new Route("Munster","Dortmund", allCities));
        routes.add(new Route("Hannover","Kassel", allCities));
        routes.add(new Route("Hannover","Erfurt", allCities));
        routes.add(new Route("Hannover","Magdeburg", allCities));
        routes.add(new Route("Hannover","Berlin", allCities));
        routes.add(new Route("Berlin","Magdeburg", allCities));
        routes.add(new Route("Berlin","Leipzig", allCities));
        routes.add(new Route("Berlin","Dresden", allCities));
        routes.add(new Route("Magdeburg","Leipzig", allCities));
        routes.add(new Route("Dusseldorf","Dortmund", allCities));
        routes.add(new Route("Dusseldorf","Koln", allCities));
        routes.add(new Route("Kassel","Dortmund", allCities));
        routes.add(new Route("Kassel","Frankfurt", allCities));
        routes.add(new Route("Kassel","Erfurt", allCities));
        routes.add(new Route("Leipzig","Erfurt", allCities));
        routes.add(new Route("Leipzig","Dresden", allCities));
        routes.add(new Route("Leipzig","Chemnitz", allCities));
        routes.add(new Route("Dresden","Chemnitz", allCities));
        routes.add(new Route("Dresden","Regensburg", allCities));

        routes.add(new Route("Chemnitz","Leipzig", allCities));
        routes.add(new Route("Chemnitz","Erfurt", allCities));
        routes.add(new Route("Chemnitz","Regensburg", allCities));
        routes.add(new Route("Erfurt","Nurnberg", allCities));
        routes.add(new Route("Erfurt","Regensburg", allCities));
        routes.add(new Route("Koln","Dusseldorf", allCities));
        routes.add(new Route("Koln","Frankfurt", allCities));
        routes.add(new Route("Koln","Koblenz", allCities));
        routes.add(new Route("Frankfurt","Wurzburg", allCities));
        routes.add(new Route("Frankfurt","Mannheim", allCities));
        routes.add(new Route("Frankfurt","Mainz", allCities));
        routes.add(new Route("Koblenz","Mainz", allCities));
        routes.add(new Route("Koblenz","Saarbrucken", allCities));
        routes.add(new Route("Mainz","Mannheim", allCities));
        routes.add(new Route("Mainz","Saarbrucken", allCities));
        routes.add(new Route("Wurzburg","Nurnberg", allCities));
        routes.add(new Route("Nurnberg","Augsburg", allCities));
        routes.add(new Route("Nurnberg","Munchen", allCities));
        routes.add(new Route("Nurnberg","Regensburg", allCities));
        routes.add(new Route("Regensburg","Munchen", allCities));
        routes.add(new Route("Regensburg","Osterreich", allCities));
        routes.add(new Route("Mannheim","Stuttgart", allCities));
        routes.add(new Route("Mannheim","Karlsruhe", allCities));
        routes.add(new Route("Mannheim","Saarbrucken", allCities));
        routes.add(new Route("Saarbrucken","Frankreich", allCities));
        routes.add(new Route("Saarbrucken","Karlsruhe", allCities));
        routes.add(new Route("Karlsruhe","Frankreich", allCities));
        routes.add(new Route("Karlsruhe","Freiburg", allCities));
        routes.add(new Route("Karlsruhe","Stuttgart", allCities));
        routes.add(new Route("Stuttgart","Freiburg", allCities));
        routes.add(new Route("Stuttgart","Konstanz", allCities));
        routes.add(new Route("Stuttgart","Ulm", allCities));
        routes.add(new Route("Frankreich","Freiburg", allCities));
        routes.add(new Route("Ulm","Augsburg", allCities));
        routes.add(new Route("Ulm","Lindau", allCities));
        routes.add(new Route("Augsburg","Munchen", allCities));
        routes.add(new Route("Munchen","Lindau", allCities));
        routes.add(new Route("Munchen","Osterreich", allCities));
        routes.add(new Route("Munchen","Regensburg", allCities));
        routes.add(new Route("Freiburg","Frankreich", allCities));
        routes.add(new Route("Freiburg","Konstanz", allCities));
        routes.add(new Route("Freiburg","Schweiz", allCities));
        routes.add(new Route("Konstanz","Schweiz", allCities));
        routes.add(new Route("Konstanz","Lindau", allCities));
        routes.add(new Route("Lindau","Schweiz", allCities));
        routes.add(new Route("Lindau","Osterreich", allCities));
        
        //Question: ?
        // Connect cities to their routes
        for (Route r : routes) 
        {
            for (City c : r.twoCities) 
            {
                c.connectedRoutes.add(r); 
            }
        }
    }

    /**
     * Method for traversing the graph to figure out
     * which destination cards are completed for each player
     * 
     * @param p Player
     */
    protected void traverseDestinations(Player p) 
    {
        for (DestinationCard card : p.destinations) 
        {
            boolean done = false;
            ArrayList<City> reachableCities = new ArrayList<City>();
            while (!done) 
            {
                done = true; 
                for (Route route : p.controlledRoutes) 
                {
                    City city1 = route.twoCities.get(0);
                    City city2 = route.twoCities.get(1);
                    if(reachableCities.isEmpty())
                    {
                        if(allCities.get(card.city1).equals(city1) || 
                        allCities.get(card.city2).equals(city1)) 
                        {
                            reachableCities.add(city1);
                            done = false;
                        }
                        else if(allCities.get(card.city1).equals(city2) || 
                        allCities.get(card.city2).equals(city2)) 
                        {
                            reachableCities.add(city2);
                            done = false;
                        }
                    }
                    else if(!city1.isCountry && 
                        reachableCities.contains(city1) && 
                        !reachableCities.contains(city2)) 
                    {
                        reachableCities.add(city2);
                        done = false;
                    }
                    else if(!city2.isCountry && 
                        reachableCities.contains(city2) &&
                        !reachableCities.contains(city1)) 
                    {
                        reachableCities.add(city1);
                        done = false;
                    }
                }
            }
            //Check if both card cities are reachable to complete card
            if(reachableCities.contains(allCities.get(card.city1)) && 
            reachableCities.contains(allCities.get(card.city2))) 
            {
                p.completedDestinations.add(card);
                p.numCompletedDest++;
            }
        }

        for(DestinationCard completed : p.completedDestinations) 
        {
            p.destinations.remove(completed);
        }
    }
}
