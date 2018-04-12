import java.nio.file.*;
import java.io.File;
import java.awt.*;
import javax.swing.*;
/**
 * Write a description of class DestinationCard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DestinationCard //extends Card
{
    protected String city1;
    protected String city2;
    protected int points;
    protected Image picture;
    /**
     * Constructor for DestinationCard Class 
     * @param 
     */
    public DestinationCard(String c1, String c2, int p, String fileName) {
        city1 = c1; 
        city2 = c2;
        points = p;
        //Path f = Paths.get("." + "Images\\).toAbsolutePath();
        picture = Toolkit.getDefaultToolkit().getImage("Images\\" + fileName);
        
    }
    
    /**
     * Returns this Card's picture
     */
    public Image getPicture() {
        return picture;
    }
    
    /**
     * Returns this Card's value
     * @return this.value
     */
    public int getPoints() {
        return points;
    }

    /**
     * Returns string representation of this DestinationCard
     * @return  string representation of this DestinationCard
     *
     */
    public String toString() {
        return city1 + "-" + city2;
    }

    /**
     * gets a copy of citynames
     */
    public String[] getCityNames() {
        return new String[] {city1, city2};
    }
}
