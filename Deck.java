import java.util.ArrayList;
import java.util.Random;
/**
 * Write a description of class Deck here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Deck
{
   protected ArrayList<Card> cards = new ArrayList<>();
    protected Random r = new Random();

    /**
     * Empty constructor for objects of class Deck
     */
    public Deck() {};

    /**
     * Constructor for objects of class Deck
     * @param c ArrayList of Cards
     */
    public Deck(ArrayList<Card> c)
    {
        for (Card cr : c)
            cards.add(cr);
    }
    
    /**
     * Draws a Card from this.cards
     * @return the randomly-drawn Card
     */
    public Card drawCard() {
        int i = r.nextInt(cards.size());
        return cards.remove(i);
    }
    
    /**
     * Adds a Card to this.cards in a random location
     * @param c Card to add to this.cards
     */
    public void addCard(Card c) {
        int i = r.nextInt(cards.size() + 1);
        cards.add(i, c);
    }
}
