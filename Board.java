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
        //continue here with the rest
        //can eliminate redundancies in Route constructor if statements
        //
        
        
        
        
        
    }

    public static void main (String args[]) {
        Board b = new Board();
        int count = 0;
        for (Route r: b.routes) {
            System.out.println(r);
            count ++;
            if (count >15) break;
        }
        System.out.println("");
        City c1 = b.allCities.get("Berlin");
        for (Route r1: c1.connectedRoutes) {
            System.out.println(r1);
        }
    }
}
