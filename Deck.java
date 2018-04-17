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
    protected ArrayList<DestinationCard> shortCards = new ArrayList<>(55);
    protected ArrayList<DestinationCard> longCards = new ArrayList<>(34);
    
    //still trying to figure out how to efficiently store train cards
    protected ArrayList<TrainCard> trainCards = new ArrayList(110);
    protected ArrayList<TrainCard> discardedTrainCards = new ArrayList(110);
    protected ArrayList<TrainCard> faceUpTrains = new ArrayList(5);
    
    //protected TrainCard[] tCardReferences = new TrainCard[9];
    protected Image[] trainCardPics= new Image[9];
    
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
        //Chris: continue with rest of blue destination cards here
        
        
        //add all the long cards into random locations to simulate shuffle
        longCards.add(rand.nextInt(longCards.size()), new DestinationCard("Berlin", "Dusseldorf", 13, "BerlDuss.JPG"));
        longCards.add(rand.nextInt(longCards.size()), new DestinationCard("Berlin", "Frankfurt", 14, "BerlFran.JPG"));
        //Chris: continue with rest of orange destination cards here
        
        
        
        //will need rest of stuff in constructor if we store train cards differently
        trainCardPics[0] = Toolkit.getDefaultToolkit().getImage("Images\\YellowCard.JPG");
        trainCardPics[1] = Toolkit.getDefaultToolkit().getImage("Images\\BlueCard.JPG");
        trainCardPics[2] = Toolkit.getDefaultToolkit().getImage("Images\\GreenCard.JPG");
        trainCardPics[3] = Toolkit.getDefaultToolkit().getImage("Images\\PinkCard.JPG");
        trainCardPics[4] = Toolkit.getDefaultToolkit().getImage("Images\\RedCard.JPG");
        trainCardPics[5] = Toolkit.getDefaultToolkit().getImage("Images\\BlackCard.JPG");
        trainCardPics[6] = Toolkit.getDefaultToolkit().getImage("Images\\OrangeCard.JPG");
        trainCardPics[7] = Toolkit.getDefaultToolkit().getImage("Images\\WhiteCard.JPG");
        trainCardPics[8] = Toolkit.getDefaultToolkit().getImage("Images\\RainbowCard.JPG");
        
        for (int i = 0; i < 12; i++) 
            trainCards.add(rand.nextInt(trainCards.size()), new TrainCard(TrainColor.YELLOW, 0, trainCardPics[0]));
        for (int i = 0; i < 12; i++) 
            trainCards.add(rand.nextInt(trainCards.size()), new TrainCard(TrainColor.BLUE, 1, trainCardPics[1]));
        for (int i = 0; i < 12; i++) 
            trainCards.add(rand.nextInt(trainCards.size()), new TrainCard(TrainColor.GREEN, 2, trainCardPics[2]));
        for (int i = 0; i < 12; i++) 
            trainCards.add(rand.nextInt(trainCards.size()), new TrainCard(TrainColor.PINK, 3, trainCardPics[0]));
        for (int i = 0; i < 12; i++) 
            trainCards.add(rand.nextInt(trainCards.size()), new TrainCard(TrainColor.RED, 4, trainCardPics[0]));
        for (int i = 0; i < 12; i++) 
            trainCards.add(rand.nextInt(trainCards.size()), new TrainCard(TrainColor.BLACK, 5, trainCardPics[0]));
        for (int i = 0; i < 12; i++) 
            trainCards.add(rand.nextInt(trainCards.size()), new TrainCard(TrainColor.ORANGE, 6, trainCardPics[0]));
        for (int i = 0; i < 12; i++)
            trainCards.add(rand.nextInt(trainCards.size()), new TrainCard(TrainColor.WHITE, 7, trainCardPics[0]));
        for (int i = 0; i < 14; i++)
            trainCards.add(rand.nextInt(trainCards.size()), new TrainCard(TrainColor.RAINBOW, 8, trainCardPics[0]));
            
        //put top 5 traincards into faceup deck
        for (int i = 0; i < 5; i++)
            faceUpTrains.add(trainCards.remove(shortCards.size()-1));
        
    }
    
    //add methods for showing 5 cards
    
    protected void discardTrainCard(TrainCard tCard){
        discardedTrainCards.add(tCard);
    }
    
    //draw traincard from top of deck
    protected TrainCard drawTrainCard(){
        if (trainCards.isEmpty()) {
            reshuffleDiscards();
        }
        return trainCards.remove(rand.nextInt(trainCards.size()));
    }
    
    //method to move all discards to trainCards deck when that's empty
    protected void reshuffleDiscards() {
        while (!discardedTrainCards.isEmpty()) {
            trainCards.add(discardedTrainCards.remove(rand.nextInt(trainCards.size())));
        }
    }
    
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
