import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.util.*;
import java.lang.String;
/**
 * PlayGame class sets up the game and displays it to the screen to play.
 *
 * @author (Patrick, Alissa, Chris, Brooke, Hieu)
 * @version (4/18/2018)
 */
public class PlayGame extends JPanel implements MouseListener, MouseMotionListener
{
    //private Image traincol, traincol2, traincol3, traincol4, traincol5, traincol6;
    //private Image traincol7, traincol8, traincol9;
    private static Image boardPic, blackBackground, TicketToRidePic;
    private Image blueDest, globeTrotter, orangeDest, trainCardBack;
    private JButton button1, button2;
    private static boolean playerChosen;
    protected static int numberOfPlayers;
    // initializes the players
    private ArrayList<Player> players = new ArrayList<Player>();
    private Player currentPlayer;
    private static JFrame frame;
    private Deck deck;
    private Board board;
    private int cardsTaken;
    /**
     * Constructor for objects of class playGame
     */
    public PlayGame()
    {
        //hard code in player info
        //         numberOfPlayers = 2;
        //         Player player1 = new Player("Player 1" , "Yellow");
        //         Player player2 = new Player("Player 2" , "Red");

        players = Driver.getPlayers();
        currentPlayer = players.get(0);
        addMouseListener(this);
        addMouseMotionListener(this);
        deck = new Deck();
        board = new Board();
        //String dir = "Images/";
        // traincol = new ImageIcon("Images" + File.separator + "BlackCard.JPG").getImage();
        // traincol2 = new ImageIcon("Images" + File.separator + "BlueCard.JPG").getImage();
        // traincol3 = new ImageIcon("Images" + File.separator + "GreenCard.JPG").getImage();
        // traincol4= new ImageIcon("Images" + File.separator + "OrangeCard.JPG").getImage();
        // traincol5 = new ImageIcon("Images" + File.separator + "PurpleCard.JPG").getImage();
        // traincol6 = new ImageIcon("Images" + File.separator + "RainbowCard.JPG").getImage();
        // traincol7 = new ImageIcon("Images" + File.separator + "RedCard.JPG").getImage();
        // traincol8 = new ImageIcon("Images" + File.separator + "WhiteCard.JPG").getImage();
        // traincol9 = new ImageIcon("Images" + File.separator + "YellowCard.JPG").getImage();
        boardPic = new ImageIcon("Images" + File.separator + "Board.JPG").getImage();
        blackBackground = new ImageIcon("Images" + File.separator + "blackBackground.JPG").getImage();
        TicketToRidePic = new ImageIcon("Images" + File.separator + "HomeScreen.JPG").getImage();
        blueDest = new ImageIcon("Images" + File.separator + "BlueDest.JPG").getImage();
        globeTrotter = new ImageIcon("Images" + File.separator + "Globetrotter.JPG").getImage();
        orangeDest = new ImageIcon("Images" + File.separator + "OrangeDest.JPG").getImage();
        trainCardBack = new ImageIcon("Images" + File.separator + "TrainCardBack.JPG").getImage();

        Dimension size = new Dimension(blackBackground.getWidth(null), boardPic.getHeight(null));
        //width is ... pixels
        //height is ...
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);

        // button1 = new JButton("Select Short Card");
        // button1.setBounds(1100,590,190,20);
        // add(button1);
        // button1.addActionListener(new ActionListener()
        // {
        // public void actionPerformed(ActionEvent e) 
        // { 
        // shortButtonPressed();
        // }         
        // });

        // button2 = new JButton("Select Long Card");
        // button2.setBounds(1100,620,190,20);
        // add(button2);
        // button2.addActionListener(new ActionListener()
        // {
        // public void actionPerformed(ActionEvent e)
        // { 
        // longButtonPressed();
        // }         
        // });

        dealDestinationCards();
        drawFirstFour();
    }

    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        g.drawImage(blackBackground,0,0,null);
        g.drawImage(boardPic,270,0,null);
        drawTrainCards(g);
        drawDestinationCards(g);
        drawPlayerInfo(g);
    }

    public void homeScreen(Graphics g)
    {
        g.drawImage(TicketToRidePic,0,0,null);
    }

    public void drawTrainCards(Graphics g)
    {   
        int x1 = 905;
        int y1 = 620;
        //draw face down train card
        if (!deck.trainCards.isEmpty()) {
            g.drawImage(trainCardBack,x1,y1, null);
            y1 -=100;
        }
        //draw the face up train cards
        for (int i=0; i<5; i++) {
            if (deck.faceUpTrainCards.get(i)!=null) {
                //x1 y1 to begin is 905,520
                g.drawImage(deck.faceUpTrainCards.get(i).getPicture(),x1,y1,null);
                //decrements by 100 for the next card
                y1 -= 100;
            }
        }

        //draw the 9 card images on player side
        int x = 10;
        int y = 50;
        for (Image pic: deck.trainCardPics) {
            g.drawImage(pic,x,y,null);
            y += 55;
            x += 10;
        }

    }

    public void drawDestinationCards(Graphics g)
    {
        if (!deck.shortCards.isEmpty()) {
            g.drawImage(blueDest,1050,620,null);
        }
        if (!deck.longCards.isEmpty()) {
            g.drawImage(orangeDest,1150,620,null);
        }
    }

    public void drawPlayerInfo(Graphics g)
    {
        Font font = new Font("Verdana", Font.BOLD, 20);
        g.setFont(font);
        g.setColor(Color.WHITE);

        int x = 905;
        int y = 50;

        g.drawString("Player Scores", x,22);
        for(Player p : players)
        {
            g.setColor(p.getColor());
            g.drawString(p.getName() + ": "+ p.getScore(), x,y);
            y+=25;
        }

        g.setColor(currentPlayer.getColor());
        g.drawString(currentPlayer.getName() + " has " + currentPlayer.getCarsRemaining() + " train pieces", 10,22);

        ////to do: display meeple counts and option to see their destination cards

        //draw the 9 card images on player side
        int x2 = 73;
        int y2 = 77;
        for (int count: currentPlayer.trainCounts) {
            g.setColor(new Color(25, 25, 25));
            g.fillRect(x2, y2, 24, 24);
            g.setColor(Color.white);
            g.drawRect(x2, y2, 24, 24);
            g.drawString("" + count, x2+6, y2+20);
            y2 += 55;
            x2 += 10;
        }

    }

    /**
     * Fills all players' hands with
     * 4 train cards at the beginning of game. 
     */
    public void drawFirstFour()
    {
        // deals out the 4 cards from the draw deck
        for(Player p : players)
        {
            for(int i = 0; i < 4; i++)
            {
                //add a train card to the players hand
                p.addTrainCard(deck.drawTrainCard());
            }
        }   
    }

    protected void chooseDestinationCards(Player p, int keep){
        // if (deck.shortCards.size() + deck.longCards.size() <4) {
        // JOptionPane.showMessageDialog(null,"There are only " + "shortCards.size()";
        // return;
        // }

        JOptionPane.showMessageDialog(null,"Dealing " +
            p.getName()+"'s destination tickets!");
        // players options for their destination cards
        DestinationCard[] cards = new DestinationCard[4];
        // adds three destination cards
        for(int k = 0; k < 3; k++)
        {
            cards[k] = deck.drawShortCard();
        }
        // adds one long destination card
        cards[3] = deck.drawLongCard();
        // check boxes for the players options
        JCheckBox[] boxes = new JCheckBox[4];
        // creates a list of options in a JOption pain
        for(int i = 0; i < 4; i++)
        {
            boxes[i] = new JCheckBox(cards[i].toString() + 
                " for " + cards[i].getPoints() + " points");
        }   

        int count = 0;
        // makes sure at least 2 cards are chosen
        do 
        {
            count = 0;
            JOptionPane.showMessageDialog(null,boxes,"Pick your "
                +"destinations", JOptionPane.QUESTION_MESSAGE);
            for(int n = 0; n < 4; n++)
            {
                if(boxes[n].isSelected())
                {
                    count++;
                }
            }
        } while(count < keep);

        for(int j = 0; j < 4; j++)
        {
            if(boxes[j].isSelected())
            {
                p.addDestinationCard(cards[j]);
            }
            else if(!boxes[j].isSelected() && j != 3)
            {
                if(cards[j].getPoints()<=11)
                {
                    deck.addShortCard(cards[j]);
                }
                else deck.addLongCard(cards[j]);
            }
        }

    }

    /**
     * Gives players destination cards to choose from 
     */
    public void dealDestinationCards() 
    {
        // for each player, display their destination card options and 
        // have them pick at least 2
        for(Player p : players)
        {
            chooseDestinationCards(p, 2);
        }       
    }

    protected void claimRoute (Route route) {
        ////////////////To do:///////////////
        //if route already taken then no
        //ask user which cards to use
        //if valid card combo: claim the route, dispose of the cards, and end player's turn
        //if invalid combo tell them no and let them try again
    }

    public static void playersChosen()
    {
        //repaint();
    }

    public void shortButtonPressed()
    {
        //draw a short destination card
    }

    public void longButtonPressed()
    {
        //draw a long destination card
    }

    /**
     * @param e an event that indicates a mouse action has occured.
     */
    public void mouseEntered( MouseEvent e ) { }

    /**
     * @param e an event that indicates a mouse action has occured.
     */
    public void mouseExited( MouseEvent e ) { }

    /**
     * @param e an event that indicates a mouse action has occured.
     */
    public void mouseMoved( MouseEvent e ) { 
        ////////////////To do:///////////////
        //check if mouse location is within boundaries of a city
        //if so paint a little box for the city info like name and meeples
    }

    /**
     * @param e an event that indicates a mouse action has occured.
     */
    public void mouseDragged( MouseEvent e ) { }

    /**
     * @param e an event that indicates a mouse action has occured.
     */
    public void mousePressed( MouseEvent e ) { }

    /**
     * @param e an event that indicates a mouse action has occured.
     */
    public void mouseReleased( MouseEvent e ) { }

    /**
     * @param e an event that indicates a mouse action has occured.
     */
    public void mouseClicked( MouseEvent e ) {
        //clickX = e.getX();
        //clickY = e.getY();
        //click = true;
        //repaint();
        //e.consume();

        ////////////////To do:///////////////
        //check if clicked on a route

        //check if clicked on a train card in deck
        cardsTaken = 0;

        if(e.getX() >=905 && e.getX() <= 1055 && e.getY() >= 620 && e.getY() <= 470)
        {
            deck.drawTrainCard();
            cardsTaken++;
            if(cardsTaken>=2)
            {
                nextPlayer();   
            }
            repaint();
        }

        if(e.getX() >=905 && e.getX() <= 1055 && e.getY() >= 520 && e.getY() <= 610)  
        {
            //x and y of the bottom most, face up train card
            deck.drawFaceupCard(0);
            cardsTaken++;
            if(cardsTaken>=2)
            {
                nextPlayer();   
            }
            repaint();
        }

        if(e.getX() >=905 && e.getX() <= 1055 && e.getY() >= 420 && e.getY() <= 510)  
        {
            //x and y of the 2nd, face up train card
            deck.drawFaceupCard(1);
            cardsTaken++;
            if(cardsTaken>=2)
            {
                nextPlayer();   
            }
            repaint();
        }

        if(e.getX() >=905 && e.getX() <= 1055 && e.getY() >= 320 && e.getY() <= 410)  
        {
            //x and y of the third, face up train card
            deck.drawFaceupCard(2);
            cardsTaken++;
            if(cardsTaken>=2)
            {
                nextPlayer();   
            }
            repaint();
        }

        if(e.getX() >=905 && e.getX() <= 1055 && e.getY() >= 220 && e.getY() <= 310)  
        {
            //x and y of the fourth, face up train card
            deck.drawFaceupCard(3);
            cardsTaken++;
            if(cardsTaken>=2)
            {
                nextPlayer();   
            }
            repaint();
        }

        if(e.getX() >=905 && e.getX() <= 1055 && e.getY() >=120 && e.getY() <= 210)  
        {
            //x and y of the fifth, face up train card
            deck.drawFaceupCard(4);
            cardsTaken++;
            if(cardsTaken>=2)
            {
                nextPlayer();   
            }
            repaint();
        }

        //check if clicked on destination card deck
        //in all these cases after stuff happens we move to next player in list
        //check if trying to see their own destination cards
        if (e.getX() >= 1050 && e.getX() <=1250 && e.getY() >= 620 && e.getY() <= 770) {
            chooseDestinationCards(currentPlayer, 1);
            nextPlayer();
            repaint();
        }

        //nextPlayer();
        //repaint();
    }

    protected void nextPlayer() {
        int index = players.indexOf(currentPlayer);
        if (index == players.size()-1)
            currentPlayer = players.get(0);
        else 
            currentPlayer = players.get(index+1);
    }

    /**
     * Adds the bonus points to each player
     */
    public void addBonusPoints() 
    {

    }

    /**
     * ends the game and shows the scores
     */
    private void endGame() 
    {

    }

    protected static void createAndShowGUI() {
        //Create and set up the window.
        frame = new JFrame("Ticket To Ride");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PlayGame panel = new PlayGame();
        frame.getContentPane().add(panel);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createAndShowGUI();
                }
            });
    }
}
