import java.io.File;
import java.awt.*;
import javax.swing.*;
/**
 * Class for Destination Card information
 *
 * @author Alissa Ronca, Patrick Baraber, Brooke Hossley,
 * Hieu Le, Chris Adams
 * @version Spring 2018
 */
public class DestinationCard 
{
    //Names of the cities on the card
    protected String city1;
    protected String city2;
    //Point value
    protected int points;
    //Image
    protected Image picture;
    /**
     * Constructor with parameters for the DestinationCard Class 
     * 
     * @param c1 One of the cities on the destination card
     * @param c2 The other city on the destination card
     * @param p The point value of the destination 
     * @param fileName The file name for the image
     */
    public DestinationCard(String c1, String c2, int p, String fileName) 
    {
        city1 = c1; 
        city2 = c2;
        points = p;
        picture = Toolkit.getDefaultToolkit().getImage("Images" + 
            File.separator + fileName);
    }

    /**
     * Returns card picture
     * 
     * @return The image associated with the destination card
     */
    protected Image getPicture() 
    {
        return picture;
    }

    /**
     * Returns the card point value
     * 
     * @return Point value of the destination
     */
    protected int getPoints() 
    {
        return points;
    }

    /**
     * Returns a string representation of a Destination Card
     * 
     * @return A string representation of a Destination Card
     */
    public String toString()
    {
        return city1 + "-" + city2;
    }

    /**
     * Gets a copy of city names on the destination ticket 
     * 
     * @return An array of city names
     */
    public String[] getCityNames() 
    {
        return new String[] {city1, city2};
    }
}
