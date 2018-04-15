import java.util.*;
/**
 * Write a description of class CityList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CityList
{
    private ArrayList<City> cityArrayList;

    /**
     * Constructor for objects of class CityList
     */
    public CityList()
    {
        //construct array list with all city names
        cityArrayList = new ArrayList<City>();
        cityArrayList.add(new City ("test"));
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public City getCity(int i)
    {
        if (i > -1 && i < cityArrayList.size())
        {
            return cityArrayList.get(i);
        }
        else 
        {
            return null;
        }
    }
}
