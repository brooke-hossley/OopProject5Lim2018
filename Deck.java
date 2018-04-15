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
    //lists to represent remaining destination cards
    //should we use deques? do we always add to bottom of pile or middle?
    protected ArrayList<DestinationCard> shortCards = new ArrayList<>(55);
    protected ArrayList<DestinationCard> longCards = new ArrayList<>(34);
    
    //still trying to figure out how to efficiently store train cards
    protected int[] trainCards = {12,12,12,12,12,12,12,12,14};
    protected int[] discardedTrainCards = new int[9];
    //protected TrainCard[] tCardReferences = new TrainCard[9];
    //protected Image[] trainCardPics= new Image[9];
    
    protected Random rand = new Random();

    /**
     * Constructor for objects of class Deck
     * @param 
     */
    public Deck()
    {
        //add all the short cards into random locations to simulate shuffle
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Berlin", "Chemnitz", 6, "BerlChem.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Berlin", "Erfurt", 7, "BerlErfu.JPG"));
        //continue with rest of blue destination cards
        
        
        //add all the long cards into random locations to simulate shuffle
        longCards.add(rand.nextInt(longCards.size()), new DestinationCard("Berlin", "Dusseldorf", 13, "BerlDuss.JPG"));
        longCards.add(rand.nextInt(longCards.size()), new DestinationCard("Berlin", "Frankfurt", 14, "BerlFran.JPG"));
        //continue with rest of orange destination cards
        
        
        
        //will need rest of stuff in constructor if we store train cards differently
        // trainCardPics[0] = Toolkit.getDefaultToolkit().getImage("Images\\YellowCard.JPG");
        // trainCardPics[1] = Toolkit.getDefaultToolkit().getImage("Images\\BlueCard.JPG");
        // trainCardPics[2] = Toolkit.getDefaultToolkit().getImage("Images\\GreenCard.JPG");
        // trainCardPics[3] = Toolkit.getDefaultToolkit().getImage("Images\\PinkCard.JPG");
        // trainCardPics[4] = Toolkit.getDefaultToolkit().getImage("Images\\RedCard.JPG");
        // trainCardPics[5] = Toolkit.getDefaultToolkit().getImage("Images\\BlackCard.JPG");
        // trainCardPics[6] = Toolkit.getDefaultToolkit().getImage("Images\\OrangeCard.JPG");
        // trainCardPics[7] = Toolkit.getDefaultToolkit().getImage("Images\\WhiteCard.JPG");
        // trainCardPics[8] = Toolkit.getDefaultToolkit().getImage("Images\\RainbowCard.JPG");
        
        // for (int i = 0; i <= 12; i++) 
            // trainCards.add(rand.nextInt(shortCards.size()), new TrainCard(TrainColor.YELLOW, 0, trainCardPics[0]));
        // for (int i = 0; i <= 12; i++) 
            // trainCards.add(rand.nextInt(shortCards.size()), new TrainCard(TrainColor.BLUE, 1, trainCardPics[1]));
        // for (int i = 0; i <= 12; i++) 
            // trainCards.add(rand.nextInt(shortCards.size()), new TrainCard(TrainColor.GREEN, 2, trainCardPics[2]));
        // for (int i = 0; i <= 12; i++) 
            // trainCards.add(rand.nextInt(shortCards.size()), new TrainCard(TrainColor.PINK, 3, trainCardPics[0]));
        // for (int i = 0; i <= 12; i++) 
            // trainCards.add(rand.nextInt(shortCards.size()), new TrainCard(TrainColor.RED, 4, trainCardPics[0]));
        // for (int i = 0; i <= 12; i++) 
            // trainCards.add(rand.nextInt(shortCards.size()), new TrainCard(TrainColor.BLACK, 5, trainCardPics[0]));
        // for (int i = 0; i <= 12; i++) 
            // trainCards.add(rand.nextInt(shortCards.size()), new TrainCard(TrainColor.ORANGE, 6, trainCardPics[0]));
        // for (int i = 0; i <= 12; i++)
            // trainCards.add(rand.nextInt(shortCards.size()), new TrainCard(TrainColor.WHITE, 7, trainCardPics[0]));
        // for (int i = 0; i <= 14; i++)
            // trainCards.add(rand.nextInt(shortCards.size()), new TrainCard(TrainColor.RAINBOW, 8, trainCardPics[0]));
    }
    
    protected void discardTrainCard(int index){
        //increments discarded train card count at given index if legal
        if (index >= 0 && index <=8) {
            discardedTrainCards[index]++;
        }
    }
    
    
    //////////////PROBLEMATIC?? because equally likely to pick from any spot in array//////////////
    /////also will crash if all counts are 0 which is when deck is empty
    /////and be really slow when not a lot of cards left 
    protected int drawTrainCard(){
        int count = 0;
        int index = 0;
        //get a random spot with count > 0
        while (count == 0){
            index = rand.nextInt(9);
            count = trainCards[index];
        }
        trainCards[index]--;
        return index;
    }
    
    
    //need method to move all discards to trainCards deck when that's empty
    
    
    protected void addShortCard(DestinationCard dest){
        //adds to bottom of pile aka position 0 in arraylist
        shortCards.add(0, dest);
    }
    
    protected DestinationCard drawShortCard(){
        //draws from top of pile aka last position in arraylist
        return shortCards.remove(shortCards.size()-1);
    }
    
    protected void addLongCard(DestinationCard dest){
        //adds to bottom of pile aka position 0 in arraylist
        longCards.add(0, dest);
    }
    
    protected DestinationCard drawLongCard(){
        //draws from top of pile aka last position in arraylist
        return longCards.remove(longCards.size()-1);
    }
    
}
