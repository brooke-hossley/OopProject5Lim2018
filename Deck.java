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
        String dir = "Images/";
        //add all the short cards into random locations to simulate shuffle
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Berlin", "Chemnitz", 6, (dir + "BerlChem.JPG")));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Berlin", "Erfurt", 7, "BerlErfu.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Berlin", "Leipzig", 4, "BerlLeip.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Bremen", "Berlin", 10, "BremBerl.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Bremen", "Dusseldorf", 5, "BremDuss.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Bremen", "Kassel", 6, "BremKass.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Bremerhaven", "Koln", 7, "BremKoln.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Danemark", "Berlin", 10, "DaneBerl.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Danemark", "Niederlande", 10, "DaneNied.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Dortmund", "Erfurt", 7, "DortErfu.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Dortmund", "Magdeburg", 9, "DortMagd.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Dortmund", "Mannheim", 6, "DortMann.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Dusseldorf", "Konstanz", 10, "DussKons.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Emden", "Hamburg", 6, "EmdeHamb.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Erfurt", "Wurzburg", 6, "ErfuWurz.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Frankfurt", "Munchen", 9, "FrankfMunc.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Frankreich", "Munchen", 8, "FrankrMunc.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Frankfurt", "Lindau", 8, "FranLind.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Frankfurt", "Osterreich", 10, "FranOste.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Frankfurt", "Stuttgart", 4, "FranStut.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Hamburg", "Berlin", 7, "HambBerl.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Hamburg", "Frankfurt", 11, "HambFran.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Hamburg", "Kassel", 7, "HambKass.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Hamburg", "Koblenz", 10, "HambKobl.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Hamburg", "Koln", 9, "HambKoln.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Hamburg", "Leipzig", 10, "HambLeip.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Hamburg", "Rostock", 4, "HambRost.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Hannover", "Frankfurt", 7, "HannFran.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Hannover", "Leipzig", 6, "HannLeip.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Hannover", "Saarbrucken", 11, "HannSaar.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Karlsruhe", "Augsburg", 4, "KarlAugs.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Karlsruhe", "Regensburg", 9, "KarlRege.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Kassel", "Freiburg", 10, "KassFrei.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Koblenz", "Ulm", 7, "KoblUlm.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Koln", "Frankfurt", 4, "KolnFran.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Koln", "Munchen", 11, "KolnMunc.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Koln", "Nurnberg", 8, "KolnNurn.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Koln", "Regensburg", 11, "KolnRege.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Koln", "Saarbrucken", 4, "KolnSaar.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Koln", "Schweiz", 10, "KolnSchw.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Leipzig", "Munchen", 11, "LeipMunc.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Leipzig", "Frankfurt", 10, "LeipFran.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Leipzig", "Nurnberg", 7, "LeipNurn.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Magdeburg", "Koln", 11, "MagdKoln.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Mainz", "Stuttgart", 3, "MainStut.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Mannheim", "Stuttgart", 2, "MannStut.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Mannheim", "Wurzburg", 4, "MannWurz.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Munchen", "Freiburg", 8, "MuncFrei.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Munchen", "Konstanz", 6, "MuncKons.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Munchen", "Stuttgart", 5, "MuncStut.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Munchen", "Wurzburg", 7, "MuncWurz.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Munster", "Stuttgart", 9, "MuncStut.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Niederlande", "Frankfurt", 8, "NiedFran.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Niederlande", "Karlsruhe", 9, "NiedKarl.JPG"));
        shortCards.add(rand.nextInt(shortCards.size()), new DestinationCard("Nurnberg", "Stuttgart", 7, "NurnStut.JPG"));
        //Chris: continue with rest of blue destination cards here

        //add all the long cards into random locations to simulate shuffle
        longCards.add(rand.nextInt(longCards.size()), new DestinationCard("Berlin", "Dusseldorf", 13, "BerlDuss.JPG"));
        longCards.add(rand.nextInt(longCards.size()), new DestinationCard("Berlin", "Frankfurt", 14, "BerlFran.JPG"));
        longCards.add(rand.nextInt(longCards.size()), new DestinationCard("Berlin", "Koln", 14, "BerlKoln.JPG"));
        longCards.add(rand.nextInt(longCards.size()), new DestinationCard("Berlin", "Mainz", 15, "BerlMainz.JPG"));
        longCards.add(rand.nextInt(longCards.size()), new DestinationCard("Berlin", "Munchen", 15, "BerlMunc.JPG"));
        longCards.add(rand.nextInt(longCards.size()), new DestinationCard("Berlin", "Schweiz", 20, "BerlSchw.JPG"));
        longCards.add(rand.nextInt(longCards.size()), new DestinationCard("Berlin", "Stuttgart", 18, "BerlStut.JPG"));
        longCards.add(rand.nextInt(longCards.size()), new DestinationCard("Bremerhaven", "Frankreich", 12, "BremFran.JPG"));
        longCards.add(rand.nextInt(longCards.size()), new DestinationCard("Bremerhaven", "Regensburg", 16, "BremRege.JPG"));
        longCards.add(rand.nextInt(longCards.size()), new DestinationCard("Danemark", "Lindau", 22, "DaneLind.JPG"));
        longCards.add(rand.nextInt(longCards.size()), new DestinationCard("Dortmund", "Munchen", 13, "DortMunc.JPG"));
        longCards.add(rand.nextInt(longCards.size()), new DestinationCard("Dresden", "Augsburg", 12, "DresAugs.JPG"));
        longCards.add(rand.nextInt(longCards.size()), new DestinationCard("Dresden", "Saarbrucken", 16, "DresSaar.JPG"));
        longCards.add(rand.nextInt(longCards.size()), new DestinationCard("Emden", "Freiburg", 15, "EmdeFrei.JPG"));
        longCards.add(rand.nextInt(longCards.size()), new DestinationCard("Emden", "Osterreich", 19, "EmdeOste.JPG"));
        longCards.add(rand.nextInt(longCards.size()), new DestinationCard("Frankreich", "Danemark", 17, "FranDane.JPG"));
        longCards.add(rand.nextInt(longCards.size()), new DestinationCard("Frankreich", "Leipzig", 15, "FranLeip.JPG"));
        longCards.add(rand.nextInt(longCards.size()), new DestinationCard("Hamburg", "Dresden", 12, "HambDres.JPG"));
        longCards.add(rand.nextInt(longCards.size()), new DestinationCard("Hamburg", "Karlsruhe", 14, "HambKarl.JPG"));
        longCards.add(rand.nextInt(longCards.size()), new DestinationCard("Hamburg", "Munchen", 18, "HambMunc.JPG"));
        longCards.add(rand.nextInt(longCards.size()), new DestinationCard("Hamburg", "Stuttgart", 15, "HambStut.JPG"));
        longCards.add(rand.nextInt(longCards.size()), new DestinationCard("Kiel", "Nurnberg", 15, "KielNurn.JPG"));
        longCards.add(rand.nextInt(longCards.size()), new DestinationCard("Kiel", "Schweiz", 20, "KielSchw.JPG"));
        longCards.add(rand.nextInt(longCards.size()), new DestinationCard("Kiel", "Stuttgart", 17, "KielStut.JPG"));
        longCards.add(rand.nextInt(longCards.size()), new DestinationCard("Koln", "Leipzig", 12, "KolnLeip.JPG"));
        longCards.add(rand.nextInt(longCards.size()), new DestinationCard("Leipzig", "Stuttgart", 14, "LeipStut.JPG"));
        longCards.add(rand.nextInt(longCards.size()), new DestinationCard("Leipzig", "Ulm", 12, "LeipUlm.JPG"));
        longCards.add(rand.nextInt(longCards.size()), new DestinationCard("Munster", "Munchen", 14, "MunsMunc.JPG"));
        longCards.add(rand.nextInt(longCards.size()), new DestinationCard("Munster", "Osterreich", 15, "MunsOste.JPG"));
        longCards.add(rand.nextInt(longCards.size()), new DestinationCard("Niederlande", "Berlin", 13, "NiedBerl.JPG"));
        longCards.add(rand.nextInt(longCards.size()), new DestinationCard("Rostock", "Konstanz", 22, "RostKons.JPG"));
        longCards.add(rand.nextInt(longCards.size()), new DestinationCard("Rostock", "Osterreich", 22, "RostOste.JPG"));
        longCards.add(rand.nextInt(longCards.size()), new DestinationCard("Schwerin", "Koblenz", 12, "SchKob.JPG"));
        longCards.add(rand.nextInt(longCards.size()), new DestinationCard("Schwerin", "Frankfurt", 13, "SchwFran.JPG"));
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
