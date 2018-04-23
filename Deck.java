import java.util.*;
import java.util.Random;
import java.awt.*;
import javax.swing.*;
import java.io.File;
/**
 * Write a description of class Deck here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Deck
{
    //lists to represent remaining destination cards
    protected ArrayList<DestinationCard> shortCards;
    protected ArrayList<DestinationCard> longCards;

    //still trying to figure out how to efficiently store train cards
    protected ArrayList<TrainCard> trainCards;
    protected ArrayList<TrainCard> discardedTrainCards;
    protected ArrayList<TrainCard> faceUpTrainCards;

    //protected TrainCard[] tCardReferences = new TrainCard[9];
    protected Image[] trainCardPics;

    protected Random rand = new Random();

    /**
     * Constructor for objects of class Deck
     * @param 
     */
    public Deck()
    {
        shortCards = new ArrayList<DestinationCard>(55);
        longCards = new ArrayList<DestinationCard>(34);
        trainCards = new ArrayList<TrainCard>(110);
        discardedTrainCards = new ArrayList<TrainCard>(110);
        faceUpTrainCards = new ArrayList<TrainCard>(5);
        trainCardPics = new Image[9];
        //add all the short cards in order
        shortCards.add(new DestinationCard("Berlin", "Chemnitz", 6, "BerlChem.JPG"));
        shortCards.add(new DestinationCard("Berlin", "Erfurt", 7, "BerlErfu.JPG"));
        shortCards.add(new DestinationCard("Berlin", "Leipzig", 4, "BerlLeip.JPG"));
        shortCards.add(new DestinationCard("Bremen", "Berlin", 10, "BremBerl.JPG"));
        shortCards.add(new DestinationCard("Bremen", "Dusseldorf", 5, "BremDuss.JPG"));
        shortCards.add(new DestinationCard("Bremen", "Kassel", 6, "BremKass.JPG"));
        shortCards.add(new DestinationCard("Bremerhaven", "Koln", 7, "BremKoln.JPG"));
        shortCards.add(new DestinationCard("Danemark", "Berlin", 10, "DaneBerl.JPG"));
        shortCards.add(new DestinationCard("Danemark", "Niederlande", 10, "DaneNied.JPG"));
        shortCards.add(new DestinationCard("Dortmund", "Erfurt", 7, "DortErfu.JPG"));
        shortCards.add(new DestinationCard("Dortmund", "Magdeburg", 9, "DortMagd.JPG"));
        shortCards.add(new DestinationCard("Dortmund", "Mannheim", 6, "DortMann.JPG"));
        shortCards.add(new DestinationCard("Dusseldorf", "Konstanz", 10, "DussKons.JPG"));
        shortCards.add(new DestinationCard("Emden", "Hamburg", 6, "EmdeHamb.JPG"));
        shortCards.add(new DestinationCard("Erfurt", "Wurzburg", 6, "ErfuWurz.JPG"));
        shortCards.add(new DestinationCard("Frankfurt", "Munchen", 9, "FrankfMunc.JPG"));
        shortCards.add(new DestinationCard("Frankreich", "Munchen", 8, "FrankrMunc.JPG"));
        shortCards.add(new DestinationCard("Frankfurt", "Lindau", 8, "FranLind.JPG"));
        shortCards.add(new DestinationCard("Frankfurt", "Osterreich", 10, "FranOste.JPG"));
        shortCards.add(new DestinationCard("Frankfurt", "Stuttgart", 4, "FranStut.JPG"));
        shortCards.add(new DestinationCard("Hamburg", "Berlin", 7, "HambBerl.JPG"));
        shortCards.add(new DestinationCard("Hamburg", "Frankfurt", 11, "HambFran.JPG"));
        shortCards.add(new DestinationCard("Hamburg", "Kassel", 7, "HambKass.JPG"));
        shortCards.add(new DestinationCard("Hamburg", "Koblenz", 10, "HambKobl.JPG"));
        shortCards.add(new DestinationCard("Hamburg", "Koln", 9, "HambKoln.JPG"));
        shortCards.add(new DestinationCard("Hamburg", "Leipzig", 10, "HambLeip.JPG"));
        shortCards.add(new DestinationCard("Hamburg", "Rostock", 4, "HambRost.JPG"));
        shortCards.add(new DestinationCard("Hannover", "Frankfurt", 7, "HannFran.JPG"));
        shortCards.add(new DestinationCard("Hannover", "Leipzig", 6, "HannLeip.JPG"));
        shortCards.add(new DestinationCard("Hannover", "Saarbrucken", 11, "HannSaar.JPG"));
        shortCards.add(new DestinationCard("Karlsruhe", "Augsburg", 4, "KarlAugs.JPG"));
        shortCards.add(new DestinationCard("Karlsruhe", "Regensburg", 9, "KarlRege.JPG"));
        shortCards.add(new DestinationCard("Kassel", "Freiburg", 10, "KassFrei.JPG"));
        shortCards.add(new DestinationCard("Koblenz", "Ulm", 7, "KoblUlm.JPG"));
        shortCards.add(new DestinationCard("Koln", "Frankfurt", 4, "KolnFran.JPG"));
        shortCards.add(new DestinationCard("Koln", "Munchen", 11, "KolnMunc.JPG"));
        shortCards.add(new DestinationCard("Koln", "Nurnberg", 8, "KolnNurn.JPG"));
        shortCards.add(new DestinationCard("Koln", "Regensburg", 11, "KolnRege.JPG"));
        shortCards.add(new DestinationCard("Koln", "Saarbrucken", 4, "KolnSaar.JPG"));
        shortCards.add(new DestinationCard("Koln", "Schweiz", 10, "KolnSchw.JPG"));
        shortCards.add(new DestinationCard("Leipzig", "Munchen", 11, "LeipMunc.JPG"));
        shortCards.add(new DestinationCard("Leipzig", "Frankfurt", 10, "LeipFran.JPG"));
        shortCards.add(new DestinationCard("Leipzig", "Nurnberg", 7, "LeipNurn.JPG"));
        shortCards.add(new DestinationCard("Magdeburg", "Koln", 11, "MagdKoln.JPG"));
        shortCards.add(new DestinationCard("Mainz", "Stuttgart", 3, "MainStut.JPG"));
        shortCards.add(new DestinationCard("Mannheim", "Stuttgart", 2, "MannStut.JPG"));
        shortCards.add(new DestinationCard("Mannheim", "Wurzburg", 4, "MannWurz.JPG"));
        shortCards.add(new DestinationCard("Munchen", "Freiburg", 8, "MuncFrei.JPG"));
        shortCards.add(new DestinationCard("Munchen", "Konstanz", 6, "MuncKons.JPG"));
        shortCards.add(new DestinationCard("Munchen", "Stuttgart", 5, "MuncStut.JPG"));
        shortCards.add(new DestinationCard("Munchen", "Wurzburg", 7, "MuncWurz.JPG"));
        shortCards.add(new DestinationCard("Munster", "Stuttgart", 9, "MuncStut.JPG"));
        shortCards.add(new DestinationCard("Niederlande", "Frankfurt", 8, "NiedFran.JPG"));
        shortCards.add(new DestinationCard("Niederlande", "Karlsruhe", 9, "NiedKarl.JPG"));
        shortCards.add(new DestinationCard("Nurnberg", "Stuttgart", 7, "NurnStut.JPG"));
        
        Collections.shuffle(shortCards);
        
        //add all the long cards into random locations to simulate shuffle
        longCards.add(new DestinationCard("Berlin", "Dusseldorf", 13, "BerlDuss.JPG"));
        longCards.add(new DestinationCard("Berlin", "Frankfurt", 14, "BerlFran.JPG"));
        longCards.add(new DestinationCard("Berlin", "Koln", 14, "BerlKoln.JPG"));
        longCards.add(new DestinationCard("Berlin", "Mainz", 15, "BerlMainz.JPG"));
        longCards.add(new DestinationCard("Berlin", "Munchen", 15, "BerlMunc.JPG"));
        longCards.add(new DestinationCard("Berlin", "Schweiz", 20, "BerlSchw.JPG"));
        longCards.add(new DestinationCard("Berlin", "Stuttgart", 18, "BerlStut.JPG"));
        longCards.add(new DestinationCard("Bremerhaven", "Frankreich", 12, "BremFran.JPG"));
        longCards.add(new DestinationCard("Bremerhaven", "Regensburg", 16, "BremRege.JPG"));
        longCards.add(new DestinationCard("Danemark", "Lindau", 22, "DaneLind.JPG"));
        longCards.add(new DestinationCard("Dortmund", "Munchen", 13, "DortMunc.JPG"));
        longCards.add(new DestinationCard("Dresden", "Augsburg", 12, "DresAugs.JPG"));
        longCards.add(new DestinationCard("Dresden", "Saarbrucken", 16, "DresSaar.JPG"));
        longCards.add(new DestinationCard("Emden", "Freiburg", 15, "EmdeFrei.JPG"));
        longCards.add(new DestinationCard("Emden", "Osterreich", 19, "EmdeOste.JPG"));
        longCards.add(new DestinationCard("Frankreich", "Danemark", 17, "FranDane.JPG"));
        longCards.add(new DestinationCard("Frankreich", "Leipzig", 15, "FranLeip.JPG"));
        longCards.add(new DestinationCard("Hamburg", "Dresden", 12, "HambDres.JPG"));
        longCards.add(new DestinationCard("Hamburg", "Karlsruhe", 14, "HambKarl.JPG"));
        longCards.add(new DestinationCard("Hamburg", "Munchen", 18, "HambMunc.JPG"));
        longCards.add(new DestinationCard("Hamburg", "Stuttgart", 15, "HambStut.JPG"));
        longCards.add(new DestinationCard("Kiel", "Nurnberg", 15, "KielNurn.JPG"));
        longCards.add(new DestinationCard("Kiel", "Schweiz", 20, "KielSchw.JPG"));
        longCards.add(new DestinationCard("Kiel", "Stuttgart", 17, "KielStut.JPG"));
        longCards.add(new DestinationCard("Koln", "Leipzig", 12, "KolnLeip.JPG"));
        longCards.add(new DestinationCard("Leipzig", "Stuttgart", 14, "LeipStut.JPG"));
        longCards.add(new DestinationCard("Leipzig", "Ulm", 12, "LeipUlm.JPG"));
        longCards.add(new DestinationCard("Munster", "Munchen", 14, "MunsMunc.JPG"));
        longCards.add(new DestinationCard("Munster", "Osterreich", 15, "MunsOste.JPG"));
        longCards.add(new DestinationCard("Niederlande", "Berlin", 13, "NiedBerl.JPG"));
        longCards.add(new DestinationCard("Rostock", "Konstanz", 22, "RostKons.JPG"));
        longCards.add(new DestinationCard("Rostock", "Osterreich", 22, "RostOste.JPG"));
        longCards.add(new DestinationCard("Schwerin", "Koblenz", 12, "SchKob.JPG"));
        longCards.add(new DestinationCard("Schwerin", "Frankfurt", 13, "SchwFran.JPG"));
        //are we missing one? hamburg Berlin 15? 
        
        Collections.shuffle(longCards);

        
        //load in train card images and construct approptiate amount of each color
        trainCardPics[0] = Toolkit.getDefaultToolkit().getImage("Images" + File.separator + "YellowCard.JPG");
        trainCardPics[1] = Toolkit.getDefaultToolkit().getImage("Images" + File.separator + "BlueCard.JPG");
        trainCardPics[2] = Toolkit.getDefaultToolkit().getImage("Images" + File.separator + "GreenCard.JPG");
        trainCardPics[3] = Toolkit.getDefaultToolkit().getImage("Images" + File.separator + "PurpleCard.JPG");
        trainCardPics[4] = Toolkit.getDefaultToolkit().getImage("Images" + File.separator + "RedCard.JPG");
        trainCardPics[5] = Toolkit.getDefaultToolkit().getImage("Images" + File.separator + "BlackCard.JPG");
        trainCardPics[6] = Toolkit.getDefaultToolkit().getImage("Images" + File.separator + "OrangeCard.JPG");
        trainCardPics[7] = Toolkit.getDefaultToolkit().getImage("Images" + File.separator + "WhiteCard.JPG");
        trainCardPics[8] = Toolkit.getDefaultToolkit().getImage("Images" + File.separator + "RainbowCard.JPG");

        for (int i = 0; i < 12; i++) 
            trainCards.add(new TrainCard(TrainColor.YELLOW, 0, trainCardPics[0]));
        for (int i = 0; i < 12; i++) 
            trainCards.add(new TrainCard(TrainColor.BLUE, 1, trainCardPics[1]));
        for (int i = 0; i < 12; i++) 
            trainCards.add(new TrainCard(TrainColor.GREEN, 2, trainCardPics[2]));
        for (int i = 0; i < 12; i++) 
            trainCards.add(new TrainCard(TrainColor.PINK, 3, trainCardPics[3]));
        for (int i = 0; i < 12; i++) 
            trainCards.add(new TrainCard(TrainColor.RED, 4, trainCardPics[4]));
        for (int i = 0; i < 12; i++) 
            trainCards.add(new TrainCard(TrainColor.BLACK, 5, trainCardPics[5]));
        for (int i = 0; i < 12; i++) 
            trainCards.add(new TrainCard(TrainColor.ORANGE, 6, trainCardPics[6]));
        for (int i = 0; i < 12; i++)
            trainCards.add(new TrainCard(TrainColor.WHITE, 7, trainCardPics[7]));
        for (int i = 0; i < 14; i++)
            trainCards.add(new TrainCard(TrainColor.RAINBOW, 8, trainCardPics[8]));
        Collections.shuffle(trainCards);
            
        //put top 5 traincards into faceup deck
        for (int i = 0; i < 5; i++)
            faceUpTrainCards.add(trainCards.remove((shortCards.size()-1)));

    }

    ///////////to do: need to check if 3 or more are rainbow////////////////
    protected TrainCard drawFaceupCard(int index){
        if (faceUpTrainCards.size() - 1 < index) {
            return null;
        }
        TrainCard removing = faceUpTrainCards.remove(index);
        if (trainCards.isEmpty() && discardedTrainCards.isEmpty()) {
            return removing;
        }
        //TrainCard replacement = drawTrainCard();
        faceUpTrainCards.add(index, drawTrainCard());
        //only allow 5 reshuffles incase we can't avoid having 3 rainbows in deck
        int reshuffleCount = 0;
        //check if three rainbows with a count
        while (reshuffleCount < 10 && threeRainbowsUp()) {
            //discard all the faceup cards
            while (!faceUpTrainCards.isEmpty()) {
                discardedTrainCards.add(faceUpTrainCards.remove(faceUpTrainCards.size()-1));
            }
            //draw 5 more
            for (int i = 0; i < 5; i++)
                faceUpTrainCards.add(drawTrainCard());
            reshuffleCount++;
        }
        
        return removing;
    }
    
    private boolean threeRainbowsUp() {
        int count = 0; 
        for (TrainCard t: faceUpTrainCards) {
            if (t.isRainbow()) 
                count++;
        }
        return count >= 3;
    }

    protected void discardTrainCard(TrainCard tCard){
        discardedTrainCards.add(tCard);
        if (trainCards.isEmpty()) {
            //reshuffle discards into train deck
            reshuffleDiscards();
        }
        
        if (faceUpTrainCards.size() < 5) {
            faceUpTrainCards.add(drawTrainCard());
            return;
        }
    }

    //draw traincard from top of deck
    protected TrainCard drawTrainCard(){
        if (trainCards.isEmpty()) {
            //return null if train deck and discards are both empty
            if (discardedTrainCards.isEmpty())
                return null;
            //otherwise reshuffle discards into train deck
            reshuffleDiscards();
        }
        return trainCards.remove(trainCards.size()-1);
    }

    //method to move all discards to trainCards deck when that's empty
    private void reshuffleDiscards() {
        Collections.shuffle(discardedTrainCards);
        while (!discardedTrainCards.isEmpty()) {
            trainCards.add(discardedTrainCards.remove(discardedTrainCards.size()-1));
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

    public static void main (String args[]) {
        Deck d = new Deck();
        System.out.println(d.shortCards.size()-1);
        System.out.println(d.longCards.size()-1);
        System.out.println(d.trainCards.size());
        System.out.println(d.discardedTrainCards.size());
        System.out.println(d.faceUpTrainCards.size());
    }

}
