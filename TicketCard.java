////////////////////////////////////////////////////////////////////////////////
/**
 * Write a description of class TicketCard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TicketCard
{
    protected CityName start;
    protected CityName end;
    protected String length;
    protected int points;

    public TicketCard(CityName start, CityName end, int points, String length){
        this.start = start;
        this.end = end;
        this.points = points;
        this.length = length;
    }

    private int getPoints(){
        return points;   
    }
}
