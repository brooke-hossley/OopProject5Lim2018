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
    protected ArrayList<City> cities;

    /**
     * Constructor for objects of class Board
     */
    public Board()
    {
        routes = new ArrayList<Route>();
        cities = new ArrayList<City>();
        routes.add(new Route("Bremen","Bremerhaven"));
        
    }

    
}
