////////////////////////////////////////////////////////////////////////////////
/**
 * Write a description of class TicketCard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TicketCard extends Card
{
    protected CityName city1; //The two cities that are listed on the desination tickets
    protected CityName city2;
    //An exception is the Austria tickets because on the ticket it hits both Austrias that are on the board
    //protected String length; //Aka how many train tickets are needed to claim the route 
    protected int points; //How much the ticket is worth in the end game

    public TicketCard(CityName city1, CityName city2, int points, String length){
        this.city1 = city1;
        this.city2 = city2;
        this.points = points;
        //this.length = length;
    }

    private int getPoints(){
        return points;   
    }
}
