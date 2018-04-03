import java.nio.file.Path;
import java.io.File;
/**
 * Write a description of class DestinationCard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DestinationCard extends Card
{
    protected final String cities[] = new String[2];
    protected final int value;

    /**
     * Constructor for DestinationCard Class 
     * @param c[] 2 element  array of cities
     */
    public DestinationCard(String c[], int v) {
        type = "DestinationCard";
        cities[0] = c[0]; cities[1] = c[1];
        value = v;
    }
    
    /**
     * Constructor for DestinationCard class with path
     * @param c[] 2 element  array of cities
     * @param p image path
     */
    public DestinationCard(String c[], int v, Path p) {
        this(c,v);
        imagePath = p;
    }

    /**
     * Constructor for DestinationCard class with String path
     * @param c[] 2 element  array of cities
     * @param p image path (String)
     */
    public DestinationCard(String c[], int v, String p) {
        this(c,v);
        imagePath = (new File(p)).toPath();
    }

    /**
     * Returns this Card's value
     * @return this.value
     */
    public int getValue() {
        return value;
    }

    /**
     * Returns string representation of this DestinationCard
     * @return  string representation of this DestinationCard
     *
     */
    public String toString() {
        return cities[0] + "-" + cities[1];
    }

    /**
     * gets a copy of this.cities
     * @return a copy of this.cities
     */
    public String[] getCities() {
        return new String[] { cities[0], cities[1] };
    }
}
