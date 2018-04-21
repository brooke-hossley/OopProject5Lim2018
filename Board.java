import java.util.*;
/**
 * Write a description of class Board here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Board
{
    // instance variables - replace the example below with your own
    protected ArrayList<Route> routes;
    protected HashMap<String, City> allCities;

    /**
     * Constructor for objects of class Board
     */
    public Board()
    {
        routes = new ArrayList<Route>();
        allCities = new HashMap<String, City>();
        allCities.put("Augsburg", new City("Augsburg"));
        allCities.put("Berlin", new City("Berlin"));
        allCities.put("Bremen", new City("Bremen"));
        allCities.put("Bremerhaven", new City("Bremerhaven"));
        allCities.put("Chemnitz", new City("Chemnitz"));
        allCities.put("Danemark", new City("Danemark"));
        allCities.put("Dortmund", new City("Dortmund"));
        allCities.put("Dresden", new City("Dresden"));
        allCities.put("Dusseldorf", new City("Dusseldorf"));
        allCities.put("Emden", new City("Emden"));
        allCities.put("Erfurt", new City("Erfurt"));
        allCities.put("Frankfurt", new City("Frankfurt"));
        allCities.put("Frankreich", new City("Frankreich"));
        allCities.put("Freiburg", new City("Freiburg"));
        allCities.put("Hamburg", new City("Hamburg"));
        allCities.put("Hannover", new City("Hannover"));
        allCities.put("Karlsruhe", new City("Karlsruhe"));
        allCities.put("Kassel", new City("Kassel"));
        allCities.put("Kiel", new City("Kiel"));
        allCities.put("Koblenz", new City("Koblenz"));
        allCities.put("Koln", new City("Koln"));
        allCities.put("Konstanz", new City("Konstanz"));
        allCities.put("Leipzig", new City("Leipzig"));
        allCities.put("Lindau", new City("Lindau"));
        allCities.put("Magdeburg", new City("Magdeburg"));
        allCities.put("Mainz", new City("Mainz"));
        allCities.put("Mannheim", new City("Mannheim"));
        allCities.put("Munchen", new City("Munchen"));
        allCities.put("Munster", new City("Munster"));
        allCities.put("Niederlande", new City("Niederlande"));
        allCities.put("Nurnberg", new City("Nurnberg"));
        allCities.put("Osterreich", new City("Osterreich"));
        allCities.put("Regensburg", new City("Regensburg"));
        allCities.put("Rostock", new City("Rostock"));
        allCities.put("Saarbrucken", new City("Saarbrucken"));
        allCities.put("Schweiz", new City("Schweiz"));
        allCities.put("Schwerin", new City("Schwerin"));
        allCities.put("Stuttgart", new City("Stuttgart"));
        allCities.put("Ulm", new City("Ulm"));
        allCities.put("Wurzburg", new City("Wurzburg"));
        
        
        
        
        routes.add(new Route("Bremen","Bremerhaven", allCities));
    }

}
