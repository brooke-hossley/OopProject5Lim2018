import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

////////////////////////////////////////////////////////////////////////////////
/**
 * Idk what I'm doing I'm still figuring this class out
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Route extends JPanel
{
    //How many trains needed to claim the route
    protected int length; 

    //The color of the route
    protected ArrayList<RouteColor> color; 

    //if there are two possibilities for this route in different colors
    protected boolean twoColors; 

    //polygon to use as bounds for mouse hover and click
    protected Polygon routeShape;

    //player's color once occupying the route
    protected Color occupiedByColor;

    //holds locations of trains occypying route once it's claimed by a player
    protected Polygon[] occupyingTrains;

    //protected boolean doubleTrack;//If the route has double or triple capacity
    //protected boolean tripleTrack;
    private ArrayList<String> cities = new ArrayList<String>(2);
    //private ArrayList<RouteColor> colors = new ArrayList<RouteColor>();

    private static Image board, blackBackground;

    public Route(int len, RouteColor rcolor, boolean twoCol){
        length = len;
        //color = rcolor;

    }

    public Route(String firstCity, String secondCity)
    {
        //cities.add(firstCity);
        //cities.add(secondCity);
        String cityOneName = firstCity;
        String cityTwoName = secondCity;

        if (cityOneName.equals("Danemark"))
        {
            if(cityTwoName.equals("Kiel"))
            {
                length = 2;
                color.add(RouteColor.GRAY);
            }
            else if(cityTwoName.equals("Bremerhaven"))
            {
                length = 5;
                color.add(RouteColor.GREEN);
            }
        }
        else if (cityOneName.equals("Kiel"))
        {
            if(cityTwoName.equals("Rostock"))
            {
                length = 5;
                color.add(RouteColor.ORANGE);
            }
            else if (cityTwoName.equals("Scwerin"))
            {
                length = 5;
                color.add(RouteColor.YELLOW);
            }
            else if (cityTwoName.equals("Hamburg"))
            {
                length = 5;
                color.add(RouteColor.BLACK);
                color.add(RouteColor.PINK);
            }
            else if (cityTwoName.equals("Bremerhaven"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
            }
            else if (cityTwoName.equals("Danemark"))
            {
                length = 2;
                color.add(RouteColor.GRAY);
            }
        }
        else if (cityOneName.equals("Rostock"))
        {
            if(cityTwoName.equals("Kiel"))
            {
                length = 4;
                color.add(RouteColor.ORANGE);
            }
            else if (cityTwoName.equals("Schwerin"))
            {
                length = 2;
                color.add(RouteColor.RED);
            }
            else if (cityTwoName.equals("Berlin"))
            {
                length = 6;
                color.add(RouteColor.PINK);
            }
        }
        else if (cityOneName.equals("Schwerin"))
        {
            if(cityTwoName.equals("Kiel"))
            {
                length = 3;
                color.add(RouteColor.YELLOW);
            }
            else if (cityTwoName.equals("Rostock"))
            {
                length = 2;
                color.add(RouteColor.RED);
            }
            else if (cityTwoName.equals("Hamburg"))
            {
                length = 2;
                color.add(RouteColor.GREEN);
            }
            else if (cityTwoName.equals("Berlin"))
            {
                length = 5;
                color.add(RouteColor.WHITE);
            }
        }
        else if (cityOneName.equals("Hamburg"))
        {
            if(cityTwoName.equals("Berlin"))
            {
                length = 7;
                color.add(RouteColor.BLUE);
                color.add(RouteColor.YELLOW);
            }
            else if (cityTwoName.equals("Schwerin"))
            {
                length = 2;
                color.add(RouteColor.GREEN);
            }
            else if (cityTwoName.equals("Hannover"))
            {
                length = 4;
                color.add(RouteColor.RED);
                color.add(RouteColor.WHITE);
            }
            else if (cityTwoName.equals("Kiel"))
            {
                length = 2;
                color.add(RouteColor.PINK);
                color.add(RouteColor.BLACK);
            }
            else if (cityTwoName.equals("Bremen"))
            {
                length = 3;
                color.add(RouteColor.ORANGE);
            }
            else if (cityTwoName.equals("Bremerhaven"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
            }
        }
        else if (cityOneName.equals("Bremerhaven"))
        {
            if(cityTwoName.equals("Danemark"))
            {
                length = 5;
                color.add(RouteColor.GREEN);
            }
            else if (cityTwoName.equals("Kiel"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
            }
            else if (cityTwoName.equals("Hamburg"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
            }
            else if (cityTwoName.equals("Bremen"))
            {
                length = 1;
                color.add(RouteColor.WHITE);
            }
            else if (cityTwoName.equals("Emden"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
            }
        }
        else if (cityOneName.equals("Emden"))
        {
            if(cityTwoName.equals("Bremerhaven"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
            }
            else if (cityTwoName.equals("Bremen"))
            {
                length = 3;
                color.add(RouteColor.BLUE);
            }
            else if (cityTwoName.equals("Munster"))
            {
                length = 4;
                color.add(RouteColor.RED);
            }
            else if (cityTwoName.equals("Niederlande"))
            {
                length = 2;
                color.add(RouteColor.WHITE);
            }
        }
        else if (cityOneName.equals("Bremen"))
        {
            if(cityTwoName.equals("Bremerhaven"))
            {
                length = 1;
                color.add(RouteColor.WHITE);
            }
            else if (cityTwoName.equals("Emden"))
            {
                length = 3;
                color.add(RouteColor.BLUE);
            }
            else if (cityTwoName.equals("Munster"))
            {
                length = 3;
                color.add(RouteColor.BLACK);
            }
            else if (cityTwoName.equals("Hannover"))
            {
                length = 3;
                color.add(RouteColor.YELLOW);
            }
            else if (cityTwoName.equals("Hamburg"))
            {
                length = 3;
                color.add(RouteColor.ORANGE);
            }
        }
        else if (cityOneName.equals("Niederlande"))
        {
            if(cityTwoName.equals("Emden"))
            {
                length = 2;
                color.add(RouteColor.WHITE);
            }
            else if (cityTwoName.equals("Munster"))
            {
                length = 2;
                color.add(RouteColor.ORANGE);
            }
            else if (cityTwoName.equals("Dusseldorf"))
            {
                length = 3;
                color.add(RouteColor.PINK);
            }
        }
        else if (cityOneName.equals("Munster"))
        {
            if(cityTwoName.equals("Niederlande"))
            {
                length = 2;
                color.add(RouteColor.ORANGE);
            }
            else if (cityTwoName.equals("Emden"))
            {
                length = 4;
                color.add(RouteColor.RED);
            }
            else if (cityTwoName.equals("Bremen"))
            {
                length = 3;
                color.add(RouteColor.BLACK);
            }
            else if (cityTwoName.equals("Hannover"))
            {
                length = 4;
                color.add(RouteColor.PINK);
            }
            else if (cityTwoName.equals("Dortmund"))
            {
                length = 1;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
        }
        else if (cityOneName.equals("Hannover"))
        {
            if(cityTwoName.equals("Hamburg"))
            {
                length = 4;
                color.add(RouteColor.WHITE);
                color.add(RouteColor.RED);
            }
            else if (cityTwoName.equals("Bremen"))
            {
                length = 3;
                color.add(RouteColor.YELLOW);
            }
            else if (cityTwoName.equals("Munster"))
            {
                length = 4;
                color.add(RouteColor.PINK);
            }
            else if (cityTwoName.equals("Kassel"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityTwoName.equals("Erfurt"))
            {
                length = 5;
                color.add(RouteColor.GREEN);
                color.add(RouteColor.ORANGE);
            }
            else if (cityTwoName.equals("Magdeburg"))
            {
                length = 4;
                color.add(RouteColor.BLUE);
            }
            else if (cityTwoName.equals("Berlin"))
            {
                length = 7;
                color.add(RouteColor.BLACK);
            }
        }
        else if (cityOneName.equals("Berlin"))
        {
            if(cityTwoName.equals("Rostock"))
            {
                length = 6;
                color.add(RouteColor.PINK);
            }
            else if (cityTwoName.equals("Schwerin"))
            {
                length = 5;
                color.add(RouteColor.WHITE);
            }
            else if (cityTwoName.equals("Hamburg"))
            {
                length = 7;
                color.add(RouteColor.BLUE);
                color.add(RouteColor.YELLOW);
            }
            else if (cityTwoName.equals("Hannover"))
            {
                length = 7;
                color.add(RouteColor.BLACK);
            }
            else if (cityTwoName.equals("Magdeburg"))
            {
                length = 3;
                color.add(RouteColor.RED);
            }
            else if (cityTwoName.equals("Leipzig"))
            {
                length = 4;
                color.add(RouteColor.ORANGE);
            }
            else if (cityTwoName.equals("Dresden"))
            {
                length = 5;
                color.add(RouteColor.GREEN);
            }
        }
        else if (cityOneName.equals("Magdeburg"))
        {
            if(cityTwoName.equals("Hannover"))
            {
                length = 4;
                color.add(RouteColor.BLUE);
            }
            else if (cityTwoName.equals("Berlin"))
            {
                length = 3;
                color.add(RouteColor.RED);
            }
            else if (cityTwoName.equals("Leipzig"))
            {
                length = 2;
                color.add(RouteColor.YELLOW);
            }
        }
        else if (cityOneName.equals("Dusseldorf"))
        {
            if(cityTwoName.equals("Niederlande"))
            {
                length = 3;
                color.add(RouteColor.PINK);
            }
            else if (cityTwoName.equals("Dortmund"))
            {
                length = 1;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityTwoName.equals("Koln"))
            {
                length = 1;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
        }
        else if (cityOneName.equals("Dortmund"))
        {
            if(cityTwoName.equals("Munster"))
            {
                length = 1;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityTwoName.equals("Dusseldorf"))
            {
                length = 1;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityTwoName.equals("Kassel"))
            {
                length = 4;
                color.add(RouteColor.GREEN);
            }
        }
        else if (cityOneName.equals("Kassel"))
        {
            if(cityTwoName.equals("Hannover"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityTwoName.equals("Dortmund"))
            {
                length = 4;
                color.add(RouteColor.GREEN);
            }
            else if (cityTwoName.equals("Frankfurt"))
            {
                length = 4;
                color.add(RouteColor.BLUE);
                color.add(RouteColor.WHITE);
            }
            else if (cityTwoName.equals("Erfurt"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
            }
        }
        else if (cityOneName.equals("Leipzig"))
        {
            if(cityTwoName.equals("Erfurt"))
            {
                length = 3;
                color.add(RouteColor.RED);
            }
            else if (cityTwoName.equals("Magdeburg"))
            {
                length = 2;
                color.add(RouteColor.YELLOW);
            }
            else if (cityTwoName.equals("Berlin"))
            {
                length = 4;
                color.add(RouteColor.ORANGE);
            }
            else if (cityTwoName.equals("Dresden"))
            {
                length = 3;
                color.add(RouteColor.BLACK);
            }
            else if (cityTwoName.equals("Chemnitz"))
            {
                length = 2;
                color.add(RouteColor.BLUE);
            }
        }
        else if (cityOneName.equals("Dresden"))
        {
            if(cityTwoName.equals("Berlin"))
            {
                length = 5;
                color.add(RouteColor.GREEN);
            }
            else if (cityTwoName.equals("Leipzig"))
            {
                length = 3;
                color.add(RouteColor.BLACK);
            }
            else if (cityTwoName.equals("Chemnitz"))
            {
                length = 1;
                color.add(RouteColor.YELLOW);
            }
            else if (cityTwoName.equals("Regensburg"))
            {
                length = 7;
                color.add(RouteColor.RED);
            }
        }
        else if (cityOneName.equals("Chemnitz"))
        {
            if(cityTwoName.equals("Dresden"))
            {
                length = 1;
                color.add(RouteColor.YELLOW);
            }
            else if (cityTwoName.equals("Leipzig"))
            {
                length = 2;
                color.add(RouteColor.BLUE);
            }
            else if (cityTwoName.equals("Erfurt"))
            {
                length = 4;
                color.add(RouteColor.BLACK);
            }
            else if (cityTwoName.equals("Regensburg"))
            {
                length = 6;
                color.add(RouteColor.PINK);
            }
        }
        else if (cityOneName.equals("Erfurt"))
        {
            if(cityTwoName.equals("Hannover"))
            {
                length = 5;
                color.add(RouteColor.GREEN);
                color.add(RouteColor.ORANGE);
            }
            else if (cityTwoName.equals("Kassel"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
            }
            else if (cityTwoName.equals("Nurnburg"))
            {
                length = 4;
                color.add(RouteColor.YELLOW);
                color.add(RouteColor.PINK);
            }
            else if (cityTwoName.equals("Regensburg"))
            {
                length = 7;
                color.add(RouteColor.WHITE);
            }
            else if (cityTwoName.equals("Chemnitz"))
            {
                length = 4;
                color.add(RouteColor.BLACK);
            }
            else if (cityTwoName.equals("Leipzig"))
            {
                length = 3;
                color.add(RouteColor.RED);
            }
        }
        else if (cityOneName.equals("Koln"))
        {
            if(cityTwoName.equals("Dusseldorf"))
            {
                length = 1;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityTwoName.equals("Frankfurt"))
            {
                length = 4;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityTwoName.equals("Koblenz"))
            {
                length = 1;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
        }
        else if (cityOneName.equals("Frankfurt"))
        {
            if(cityTwoName.equals("Kassel"))
            {
                length = 4;
                color.add(RouteColor.BLUE);
                color.add(RouteColor.WHITE);
            }
            else if (cityTwoName.equals("Wurzburg"))
            {
                length = 2;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityTwoName.equals("Mannheim"))
            {
                length = 2;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityTwoName.equals("Mainz"))
            {
                length = 2;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityTwoName.equals("Koln"))
            {
                length = 4;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
        }
        else if (cityOneName.equals("Koblenz"))
        {
            if(cityTwoName.equals("Koln"))
            {
                length = 1;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityTwoName.equals("Mainz"))
            {
                length = 2;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityTwoName.equals("Saarbrucken"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
            }
        }
        else if (cityOneName.equals("Mainz"))
        {
            if(cityTwoName.equals("Koblenz"))
            {
                length = 2;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityTwoName.equals("Frankfurt"))
            {
                length = 1;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityTwoName.equals("Mannheim"))
            {
                length = 1;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityTwoName.equals("Saarbrucken"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
            }
        }
        else if (cityOneName.equals("Wurzburg"))
        {
            if(cityTwoName.equals("Frankfurt"))
            {
                length = 2;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityTwoName.equals("Nurnburg"))
            {
                length = 2;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
        }
        else if (cityOneName.equals("Nurnburg"))
        {
            if(cityTwoName.equals("Erfurt"))
            {
                length = 4;
                color.add(RouteColor.PINK);
                color.add(RouteColor.YELLOW);
            }
            else if (cityTwoName.equals("Wurzburg"))
            {
                length = 2;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityTwoName.equals("Augsburg"))
            {
                length = 4;
                color.add(RouteColor.ORANGE);
            }
            else if (cityTwoName.equals("Munchen"))
            {
                length = 5;
                color.add(RouteColor.BLACK);
                color.add(RouteColor.BLUE);
            }
            else if (cityTwoName.equals("Regensburg"))
            {
                length = 3;
                color.add(RouteColor.GREEN);
            }
        }
        else if (cityOneName.equals("Regensburg"))
        {
            if(cityTwoName.equals("Dresden"))
            {
                length = 7;
                color.add(RouteColor.RED);
            }
            else if (cityTwoName.equals("Chemnitz"))
            {
                length = 6;
                color.add(RouteColor.PINK);
            }
            else if (cityTwoName.equals("Erfurt"))
            {
                length = 7;
                color.add(RouteColor.WHITE);
            }
            else if (cityTwoName.equals("Nurnburg"))
            {
                length = 3;
                color.add(RouteColor.GREEN);
            }
            else if (cityTwoName.equals("Munchen"))
            {
                length = 3;
                color.add(RouteColor.ORANGE);
            }
            else if (cityTwoName.equals("OsterreichRIGHT"))
            {
                length = 4;
                color.add(RouteColor.YELLOW);
            }
        }
        else if (cityOneName.equals("Mannheim"))
        {
            if(cityTwoName.equals("Mainz"))
            {
                length = 1;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityTwoName.equals("Frankfurt"))
            {
                length = 2;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityTwoName.equals("Stuttgart"))
            {
                length = 2;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityTwoName.equals("Karlsruhe"))
            {
                length = 1;
                color.add(RouteColor.BLUE);
            }
            else if (cityTwoName.equals("Saarbrucken"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
            }
        }
        else if (cityOneName.equals("Saarbrucken"))
        {
            if(cityTwoName.equals("Frankreich"))
            {
                length = 1;
                color.add(RouteColor.GREEN);
            }
            else if (cityTwoName.equals("Karlsruhe"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
            }
            else if (cityTwoName.equals("Mannheim"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
            }
            else if (cityTwoName.equals("Mainz"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
            }
            else if (cityTwoName.equals("Koblenz"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
            }
        }
        else if (cityOneName.equals("Karlsruhe"))
        {
            if(cityTwoName.equals("Mannheim"))
            {
                length = 1;
                color.add(RouteColor.BLUE);
            }
            else if (cityTwoName.equals("Saarbrucken"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
            }
            else if (cityTwoName.equals("Frankreich"))
            {
                length = 2;
                color.add(RouteColor.BLACK);
            }
            else if (cityTwoName.equals("Freiburg"))
            {
                length = 3;
                color.add(RouteColor.WHITE);
            }
            else if (cityTwoName.equals("Stuttgart"))
            {
                length = 1;
                color.add(RouteColor.PINK);
            }
        }
        else if (cityOneName.equals("Stuttgart"))
        {
            if(cityTwoName.equals("Mannheim"))
            {
                length = 2;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityTwoName.equals("Karlsruhe"))
            {
                length = 1;
                color.add(RouteColor.PINK);
            }
            else if (cityTwoName.equals("Freiburg"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
            }
            else if (cityTwoName.equals("Konstanz"))
            {
                length = 3;
                color.add(RouteColor.GREEN);
            }
            else if (cityTwoName.equals("Ulm"))
            {
                length = 2;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
        }
        else if (cityOneName.equals("Frankreich"))
        {
            if(cityTwoName.equals("Saarbrucken"))
            {
                length = 1;
                color.add(RouteColor.GREEN);
            }
            else if (cityTwoName.equals("Karlsruhe"))
            {
                length = 2;
                color.add(RouteColor.BLACK);
            }
            else if (cityTwoName.equals("Freiburg"))
            {
                length = 2;
                color.add(RouteColor.YELLOW);
            }
        }
        else if (cityOneName.equals("Ulm"))
        {
            if(cityTwoName.equals("Stuttgart"))
            {
                length = 2;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityTwoName.equals("Augsburg"))
            {
                length = 1;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityTwoName.equals("Lindau"))
            {
                length = 2;
                color.add(RouteColor.RED);
            }
        }
        else if (cityOneName.equals("Augsburg"))
        {
            if(cityTwoName.equals("Nurnburg"))
            {
                length = 4;
                color.add(RouteColor.ORANGE);
            }
            else if (cityTwoName.equals("Munchen"))
            {
                length = 2;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityTwoName.equals("Ulm"))
            {
                length = 1;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
        }
        else if (cityOneName.equals("Munchen"))
        {
            if(cityTwoName.equals("Augsburg"))
            {
                length = 2;
                color.add(RouteColor.GRAY);
                color.add(RouteColor.GRAY);
            }
            else if (cityTwoName.equals("Lindau"))
            {
                length = 5;
                color.add(RouteColor.GRAY);
            }
            else if (cityTwoName.equals("OsterreichRIGHT"))
            {
                length = 3;
                color.add(RouteColor.RED);
            }
            else if (cityTwoName.equals("Regensburg"))
            {
                length = 3;
                color.add(RouteColor.ORANGE);
            }
            else if (cityTwoName.equals("Nurnburg"))
            {
                length = 5;
                color.add(RouteColor.BLACK);
                color.add(RouteColor.BLUE);
            }
        }
        else if (cityOneName.equals("Freiburg"))
        {
            if(cityTwoName.equals("Frankreich"))
            {
                length = 2;
                color.add(RouteColor.YELLOW);
            }
            else if (cityTwoName.equals("Karlsruhe"))
            {
                length = 3;
                color.add(RouteColor.WHITE);
            }
            else if (cityTwoName.equals("Stuttgart"))
            {
                length = 3;
                color.add(RouteColor.GRAY);
            }
            else if (cityTwoName.equals("Konstanz"))
            {
                length = 2;
                color.add(RouteColor.BLACK);
            }
            else if (cityTwoName.equals("Schweiz"))
            {
                length = 2;
                color.add(RouteColor.ORANGE);
            }
        }
        else if (cityOneName.equals("Konstanz"))
        {
            if(cityTwoName.equals("Freiburg"))
            {
                length = 2;
                color.add(RouteColor.BLACK);
            }
            else if (cityTwoName.equals("Stuttgart"))
            {
                length = 3;
                color.add(RouteColor.GREEN);
            }
            else if (cityTwoName.equals("Lindau"))
            {
                length = 1;
                color.add(RouteColor.YELLOW);
            }
            else if (cityTwoName.equals("Schweiz"))
            {
                length = 1;
                color.add(RouteColor.WHITE);
            }
        }
        else if (cityOneName.equals("Lindau"))
        {
            if(cityTwoName.equals("Konstanz"))
            {
                length = 1;
                color.add(RouteColor.YELLOW);
            }
            else if (cityTwoName.equals("Schweiz"))
            {
                length = 2;
                color.add(RouteColor.BLUE);
            }
            else if (cityTwoName.equals("OsterreichLEFT"))
            {
                length = 2;
                color.add(RouteColor.PINK);
            }
            else if (cityTwoName.equals("Munchen"))
            {
                length = 5;
                color.add(RouteColor.GRAY);
            }
            else if (cityTwoName.equals("Ulm"))
            {
                length = 2;
                color.add(RouteColor.RED);
            }
        }
        else if (cityOneName.equals("Schweiz"))
        {
            if(cityTwoName.equals("Freiburg"))
            {
                length = 2;
                color.add(RouteColor.ORANGE);
            }
            else if (cityTwoName.equals("Konstanz"))
            {
                length = 1;
                color.add(RouteColor.WHITE);
            }
            else if (cityTwoName.equals("Lindau"))
            {
                length = 2;
                color.add(RouteColor.BLUE);
            }
        }
        else if (cityOneName.equals("OsterreichLEFT"))
        {
            if(cityTwoName.equals("Lindau"))
            {
                length = 2;
                color.add(RouteColor.PINK);
            }
        }
        else if (cityOneName.equals("OsterreichRIGHT"))
        {
            if(cityTwoName.equals("Munchen"))
            {
                length = 3;
                color.add(RouteColor.RED);
            }
            else if (cityTwoName.equals("Regensburg"))
            {
                length = 4;
                color.add(RouteColor.YELLOW);
            }
        }
    }

    public static String getStringrouteColor(RouteColor col) {
        if(col == RouteColor.YELLOW)
        {
            return "yellow";
        }
        else if(col == RouteColor.ORANGE)
        {
            return "orange";
        }
        // return "orange";
        // return "green";
        // return "blue";
        // return "red";
        // return "gray";
        // return "white";
        // return "black";
        // return "purple";
        //else
        else {
            return "nosuchcolor";
        }
    }

    protected int getRouteLength(){
        return length;   
    }

    protected RouteColor getRouteColor(){
        return null;   
    }

    public Route()
    {
        String dir = "Images//";
        board = new ImageIcon(dir + "Board.JPG").getImage();
        blackBackground = new ImageIcon(dir + "blackBackground.JPG").getImage();
        Dimension size = new Dimension(blackBackground.getWidth(null), board.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Ticket To Ride");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Route panel = new Route();
        frame.getContentPane().add(panel);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createAndShowGUI();
                }
            });
    }

    @Override
    public void paintComponent(Graphics g){
        // As we learned in the last lesson,
        // the origin (0,0) is at the upper left corner.
        // x increases to the right, and y increases downward.
        // add 270 to be on board, board ends at 890
        super.paintComponent(g);

        g.drawImage(blackBackground,0,0,null);
        g.drawImage(board,blackBackground.getWidth(null)/4,0,null);

        //used to find coordinates
        g.setColor(new Color(255,0,0));
        g.drawRect(735, 434, 10, 10);
        g.fillRect(735,434,10,10);

        //size of one rectangle in a route
        g.setColor(new Color(0,0,0));
        g.drawRect(630, 400, 31, 10);
        g.fillRect(630,400,31,10);

        g.setColor(new Color(0,0,255));
        g.drawRect(580, 340, 217, 10);
        g.fillRect(580,340,217, 10);

        //Hamburg to Berlin
        g.setColor(new Color(0,255,0));
        int [] a1 = {605, 593, 782, 794};
        int [] a2 = {189, 208, 308, 289};
        g.drawPolygon(a1,a2,4);
        g.fillPolygon(a1,a2,4);

        //Hamburg to Hannover
        g.setColor(new Color(0,255,0));
        int [] a3 = {592, 570, 540, 563};
        int [] a4 = {207, 201, 321, 325};
        g.drawPolygon(a3,a4,4);
        g.fillPolygon(a3,a4,4);

        //Hannover to Berlin
        g.setColor(new Color(0,255,0));
        int [] a5 = {567, 567, 782, 782};
        int [] a6 = {320, 329, 321, 310};
        g.drawPolygon(a5,a6,4);
        g.fillPolygon(a5,a6,4);

        //Hannover to Erfurt
        g.setColor(new Color(0,255,0));
        int [] a7 = {565, 545, 624, 644};
        int [] a8 = {338, 349, 481, 469};
        g.drawPolygon(a7,a8,4);
        g.fillPolygon(a7,a8,4);

        //Erfurt to Chyemnitz
        g.setColor(new Color(0,255,0));
        int [] a9 = {655, 654, 776, 776};
        int [] a10 = {481, 490, 502, 492};
        g.drawPolygon(a9,a10,4);
        g.fillPolygon(a9,a10,4);

        //Erfurt to Nurnburg
        g.setColor(new Color(0,255,0));
        int [] a11 = {651, 628, 631, 653};
        int [] a12 = {498, 498, 620, 619};
        g.drawPolygon(a11,a12,4);
        g.fillPolygon(a11,a12,4);

        //Nurnburg to Regensburg
        g.setColor(new Color(0,255,0));
        int [] a13 = {665, 658, 733, 739};
        int [] a14 = {624, 632, 684, 677};
        g.drawPolygon(a13,a14,4);
        g.fillPolygon(a13,a14,4);

    }
    // protected boolean isDouble(){
    // return doubleTrack;   
    // }

    // protected boolean isTriple(){
    // return tripleTrack;   
    // }
}
