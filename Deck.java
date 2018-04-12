import java.util.ArrayList;
import java.util.Random;
import java.awt.*;
import javax.swing.*;
/**
 * Write a description of class Deck here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Deck
{
    protected ArrayList<DestinationCard> shortCards = new ArrayList<>(55);
    protected ArrayList<DestinationCard> longCards = new ArrayList<>(34);
    protected ArrayList<TrainCard> trainCards = new ArrayList<>(110);
    protected Random rand = new Random();

    /**
     * Constructor for objects of class Deck
     * @param c ArrayList of Cards
     */
    public Deck()
    {
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Berlin", "Chemnitz", 6, "BerlChem.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Berlin", "Erfurt", 7, "BerlErfu.JPG"));
        //continue with rest of blue destination cards
        
        
        
        longCards.add(rand.nextInt(longCards.size()), new DestinationCard("Berlin", "Dusseldorf", 13, "BerlDuss.JPG"));
        longCards.add(rand.nextInt(longCards.size()), new DestinationCard("Berlin", "Frankfurt", 14, "BerlFran.JPG"));
        //continue with rest of orange destination cards
        
        
        Image[] trainPics= new Image[9];
        trainPics[0] = Toolkit.getDefaultToolkit().getImage("Images\\YellowCard.JPG");
        trainPics[1] = Toolkit.getDefaultToolkit().getImage("Images\\BlueCard.JPG");
        trainPics[2] = Toolkit.getDefaultToolkit().getImage("Images\\GreenCard.JPG");
        trainPics[3] = Toolkit.getDefaultToolkit().getImage("Images\\PinkCard.JPG");
        trainPics[4] = Toolkit.getDefaultToolkit().getImage("Images\\RedCard.JPG");
        trainPics[5] = Toolkit.getDefaultToolkit().getImage("Images\\BlackCard.JPG");
        trainPics[6] = Toolkit.getDefaultToolkit().getImage("Images\\OrangeCard.JPG");
        trainPics[7] = Toolkit.getDefaultToolkit().getImage("Images\\WhiteCard.JPG");
        trainPics[8] = Toolkit.getDefaultToolkit().getImage("Images\\RainbowCard.JPG");
        
        for (int i = 0; i <= 12; i++) {
            trainCards.add(rand.nextInt(shortCards.size()), new TrainCard(TrainColor.YELLOW, 0, trainPics[0]));
        }
        for (int i = 0; i <= 12; i++) {
            trainCards.add(rand.nextInt(shortCards.size()), new TrainCard(TrainColor.BLUE, 1, trainPics[1]));
        }
        for (int i = 0; i <= 12; i++) {
            trainCards.add(rand.nextInt(shortCards.size()), new TrainCard(TrainColor.GREEN, 2, trainPics[2]));
        }
        for (int i = 0; i <= 12; i++) {
            trainCards.add(rand.nextInt(shortCards.size()), new TrainCard(TrainColor.PINK, 3, trainPics[0]));
        }
        for (int i = 0; i <= 12; i++) {
            trainCards.add(rand.nextInt(shortCards.size()), new TrainCard(TrainColor.RED, 4, trainPics[0]));
        }
        for (int i = 0; i <= 12; i++) {
            trainCards.add(rand.nextInt(shortCards.size()), new TrainCard(TrainColor.BLACK, 5, trainPics[0]));
        }
        for (int i = 0; i <= 12; i++) {
            trainCards.add(rand.nextInt(shortCards.size()), new TrainCard(TrainColor.ORANGE, 6, trainPics[0]));
        }
        for (int i = 0; i <= 12; i++) {
            trainCards.add(rand.nextInt(shortCards.size()), new TrainCard(TrainColor.WHITE, 7, trainPics[0]));
        }
        for (int i = 0; i <= 14; i++) {
            trainCards.add(rand.nextInt(shortCards.size()), new TrainCard(TrainColor.RAINBOW, 8, trainPics[0]));
        }
    }
    
    // /**
     // * Draws a random Card from this.cards
     // * @return the randomly-drawn Card
     // */
    // public Card drawCard() {
        // //int i = rand.nextInt(cards.size());
        // //return cards.remove(i);
    // }

    // /**
     // * Adds a Card to bottom of the deck
     // * @param c Card to add to this.cards
     // */
    // public void addCard(Card c) {
        // //can we just add to end for efficiency?
        // //int i = ran.nextInt(cards.size() + 1);
        // //cards.add(c);
    // }
}
