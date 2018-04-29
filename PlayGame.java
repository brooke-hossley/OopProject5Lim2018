import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*; //Question: needed?
import java.util.*;
import java.lang.String;
/**
 * PlayGame class sets up the game and displays it to the screen to play.
 *
 * @author Alissa Ronca, Patrick Baraber, Brooke Hossley,
 * Hieu Le, Chris Adams
 * @version Spring 2018
 */
public class PlayGame extends JPanel implements MouseListener, 
MouseMotionListener, ActionListener
{
    public static String info;
    // initializes the players
    protected static int numberOfPlayers;
    protected static ArrayList<Player> players = new ArrayList<Player>();
    protected static Player currentPlayer;
    //Images and JFrame 
    private static Image boardPic, blackBackground, TicketToRidePic;
    private static JFrame frame;
    private Image shortDest, globeTrotter, longDest, trainCardBack,
    yellowMeeple, greenMeeple,blueMeeple, whiteMeeple,blackMeeple, redMeeple;
    //Game components 
    private boolean secondClick, choosingTrainCard, finalTurn;
    private Deck deck;
    private Board board;
    private JLabel viewDestCards;
    private ImageIcon destCard;
    private JButton helpButton;
    /**
     * Default constructor for the PlayGame class
     */
    public PlayGame()
    {
        //Getting the number of players for the game
        players = Driver.getPlayers();
        currentPlayer = players.get(0);
        //Creating the deck and board used for the game
        deck = new Deck();
        board = new Board();
        boardPic = new ImageIcon("Images" + File.separator 
            + "Board.JPG").getImage();
        blackBackground = new ImageIcon("Images" + File.separator 
            + "blackBackground.JPG").getImage();
        TicketToRidePic = new ImageIcon("Images" + File.separator 
            + "HomeScreen.JPG").getImage();
        destCard =  new ImageIcon("Images" + File.separator 
            + "BlueDest.JPG");
        shortDest = destCard.getImage();
        globeTrotter = new ImageIcon("Images" + File.separator 
            + "Globetrotter.JPG").getImage();
        longDest = new ImageIcon("Images" + File.separator 
            + "OrangeDest.JPG").getImage();
        trainCardBack = new ImageIcon("Images" + File.separator 
            + "TrainCardBack.JPG").getImage();
        //Setting up window size
        Dimension size = new Dimension(blackBackground.getWidth(null), 
                boardPic.getHeight(null));

        blackMeeple = new ImageIcon("Images" + File.separator 
        + "blackMeeple.PNG").getImage();
        redMeeple = new ImageIcon("Images" + File.separator 
        + "redMeeple.PNG").getImage();
        greenMeeple = new ImageIcon("Images" + File.separator 
        + "greenMeeple.PNG").getImage();
        whiteMeeple = new ImageIcon("Images" + File.separator 
        + "whiteMeeple.PNG").getImage();
        blueMeeple = new ImageIcon("Images" + File.separator 
        + "blueMeeple.PNG").getImage();
        yellowMeeple = new ImageIcon("Images" + File.separator 
        + "yellowMeeple.PNG").getImage();

        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
        //Game set up
        dealDestinationCards();
        drawFirstFour();
        //Adding the help button to the board
        helpButton = new JButton("Help");
        helpButton.setFont(new Font("Arial", Font.BOLD, 20));
        helpButton.setBackground(Color.RED);
        helpButton.setBorder(BorderFactory.createLineBorder(Color.black));
        helpButton.setBounds(1100, 850, 100, 50);
        add(helpButton);
        helpButton.addActionListener(this);
        helpButton.setActionCommand("Help");
        //Enabeling the mouse
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    /**
     * Called when actionListeners are triggered
     * 
     * @param e The action calling the event
     */
    public void actionPerformed(ActionEvent e)
    {
        String action = e.getActionCommand();
        if(action.equals("Help"))
        {
            Rules.createAndShowGUI();
        }   
    }

    /**
     * Panel's paint method to manage the most of the graphics
     * 
     * @param g The Graphics reference
     */
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        g.drawImage(blackBackground, 0, 0, null);
        g.drawImage(boardPic, 270, 0, null);
        paintTrainCards(g);
        paintDestinationCardsFront(g);
        paintPlayerInfo(g);
        paintDestinationCardBack(g);
        paintPlayerRoutes(g);
        paintMeepleCount(g);
    }

    public void paintMeepleCount(Graphics g)
    {
        g.drawImage(redMeeple,5,590,null);
        g.drawImage(blackMeeple, 46, 590, null);
        g.drawImage(greenMeeple, 87,590,null);
        g.drawImage(yellowMeeple, 128,590,null);
        g.drawImage(blueMeeple, 169,590,null);
        g.drawImage(whiteMeeple, 210,590,null);
        int a = 13;
        int b = 610;
        for(int i = 0 ; i <=5;i++)
        {
            g.setColor(new Color(25, 25, 25));
            g.fillRect(a, b, 20, 20);
            g.setColor(Color.white);
            g.drawRect(a, b, 20, 20);
            g.drawString("" + currentPlayer.meeples[i], a+4, b+18);
            a+=41;
        }
    }

    /**
     * Panel's paint method to paint the back of the destination 
     * cards
     * 
     * Question: Merge the paint classes?
     * 
     * @param g The Graphics reference 
     */
    protected void paintDestinationCardBack(Graphics g)
    {
        g.drawImage(shortDest, 50, 700, null);
        Font font = new Font("Verdana", Font.BOLD, 20);
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString("View your", 50, 670);
        g.drawString("destination cards", 50, 690);
    }

    /**
     * Panel's paint method for the front of the destination cards
     * 
     * @param g The Graphics reference
     */
    protected void paintDestinationCardsFront(Graphics g)
    {
        if (!deck.shortCards.isEmpty()) {
            g.drawImage(shortDest,905,720,null);
        }
        if (!deck.longCards.isEmpty()) {
            g.drawImage(longDest,905,820,null);
        }
    }

    /**
     * Panel's paint method to paint each players claimed route
     * 
     * @param g The Graphics reference 
     */
    protected void paintPlayerRoutes(Graphics g) 
    {
        for (Player p : players) 
        {
            g.setColor(p.color);
            for (Route r : p.controlledRoutes) 
            {
                g.fillPolygon(r.routeShape);
            }
        }
    }

    /**
     * Panel's paint method to paint the train cards
     * 
     * @param g The Graphics reference 
     */
    protected void paintTrainCards(Graphics g)
    {   
        int x = 905;
        int y = 620;
        //Draw face down train card
        if (deck.trainCards.size() + deck.discardedTrainCards.size() > 0) 
        {
            g.drawImage(trainCardBack, x, y, null);
        }
        y -= 100;
        //Draw the face up train cards
        for (int i = 0; i < 5; i++) 
        {
            if (i < deck.faceUpTrainCards.size()) 
            {
                g.drawImage(deck.faceUpTrainCards.get(i).getPicture(), 
                    x, y, null);
                y -= 100;
            }
        }
        //Draw the train cards
        x = 10;
        y = 50;
        for (Image pic : deck.trainCardPics) 
        {
            g.drawImage(pic, x, y, null);
            y += 55;
            x += 10;
        }

        //When deck is empty bad things happen
        //Question: Fixed?
    }

    /**
     * Panel's paint method for the Player information
     * 
     * @param g The Graphics reference
     */
    protected void paintPlayerInfo(Graphics g)
    {
        Font font = new Font("Verdana", Font.BOLD, 20);
        g.setFont(font);
        g.setColor(Color.WHITE);

        int x = 905;
        int y = 50;

        g.drawString("Player Scores", x, 22);
        for(Player p : players) 
        {
            g.setColor(p.color);
            g.drawString(p.name + ": "+ p.score, x, y);
            y += 25;
        }

        g.setColor(currentPlayer.color);
        g.drawString(currentPlayer.name + " has " + 3 + " train pieces", 10,22);

        ////to do: display meeple counts. Question: Pat, done?

        //Draw the train cards the player has
        x = 73;
        y = 77;
        for (int count: currentPlayer.trainCounts) 
        {
            g.setColor(new Color(25, 25, 25));
            g.fillRect(x, y, 24, 24);
            g.setColor(Color.white);
            g.drawRect(x, y, 24, 24);
            g.drawString("" + count, x + 6, y + 20);
            y += 55;
            x += 10;
        }
    }

    /**
     * Method to return the current player
     * 
     * @return The current player
     */
    protected Player getCurrentPlayer()
    {
        return currentPlayer;   
    }

    /**
     * Method that fills all players' hands with
     * 4 train cards at the beginning of game
     */
    protected void drawFirstFour()
    {
        //Deals out the 4 cards from the draw deck
        for(Player p : players)
        {
            for(int i = 0; i < 4; i++)
            {
                //Add a train card to the players hand
                p.addTrainCard(deck.drawTrainCard());
            }
        }   
    }

    /**
     * Method to choose destination cards
     * 
     * @param p The player choosing the destination card
     * @param keep How many destination tickets the player is keeping
     */
    protected void chooseDestinationCards(Player p, int keep){
        /*////////TO DO: add functionality for player 
        to choose which combo of cards to take//////////*/
        //Question: Progress?

        JOptionPane.showMessageDialog(null, "Dealing " +
            p.name + "'s destination tickets!");
        //Players options for their destination cards (3 short and 1 long)
        DestinationCard[] cards = new DestinationCard[4];
        //Adds three destination cards
        for(int k = 0; k < 3; k++) 
        {
            cards[k] = deck.drawShortCard();
        }
        //Adds one long destination card
        cards[3] = deck.drawLongCard();
        //Check boxes for the players options
        JCheckBox[] boxes = new JCheckBox[4];
        //Creates a list of options in a JOption pain
        for(int i = 0; i < 4; i++) 
        {
            boxes[i] = new JCheckBox(cards[i].toString() + 
                " for " + cards[i].getPoints() + " points");
        }   
        //Count for numbers of check boxes clicked
        int count = 0;
        //Makes sure at least 2 cards are chosen
        do {
            count = 0;
            JOptionPane.showMessageDialog(null, boxes, "Pick your "
                + "destinations", JOptionPane.QUESTION_MESSAGE);
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
            else 
            {
                if(cards[j].getPoints() <= 11)
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
    protected void dealDestinationCards() 
    {
        /*For each player, display their destination card options and 
        have them pick at least 2 */
        for(Player p : players)
        {
            chooseDestinationCards(p, 2);
        }       
    }

    /**
     * Method for claiming routes
     * 
     * @param route The route being claimed
     */
    protected void claimRouteDialogue(Route route) 
    {
        ////////////////To do://///////////// Question: ?
        ArrayList<Integer> cardsToRemove = new ArrayList();
        boolean validCombo = false;
        int numRainbowsToRemove = 0;
        int numOtherToRemove = 0;
        int otherColorIndex = 0;
        while (!validCombo) {
            //if (currentPlayer.trainCounts[8] > 0) {
            JSpinner numberSpinner;
            SpinnerNumberModel numberSpinnerModel = 
                new SpinnerNumberModel(0, 0, currentPlayer.trainCounts[8], 1);
            numberSpinner = new JSpinner(numberSpinnerModel);
            //JOptionPane.showMessageDialog(null, numberSpinner);
            //}

            /*/if (route.color.contains(RouteColor.GRAY) 
            || route.color.size() > 2) {*/
            String[] colorOptions = route.getCardColors();
            JComboBox cardColor = new JComboBox(colorOptions);
            /* Object selected = JOptionPane.showInputDialog
            (null, "What card color will you use?", "Card Selection", 
            JOptionPane.DEFAULT_OPTION, null, values, "0");*/
            // if ( selected != null ){//null if the user cancels. 
            // String selectedString = selected.toString();
            // //do something
            // }else{
            // System.out.println("User cancelled");
            // }
            //}

            Object[] message = {
                    "Number of Locomotives:", numberSpinner,
                    "Other Card Color:", cardColor};

            String option = JOptionPane.showInputDialog(null, message, 
                    "Choose Cards", JOptionPane.OK_CANCEL_OPTION);

            //Graphically ask user which cards to use if there's a choice
            //if its one color only need to ask about locomotive number
            //use JSpinner for locomotive number
            //if two colored route ask locomotive # and which of 2 colors to use
            //if grey route ask locomotive # and which other color to use

            // if (its valid) 
            validCombo = true;
            // int numRainbowToRemove = ______
            // int numOtherToRemove = ______
            // int otherColorIndex = ______

        }
        for (int i = 0; i < numRainbowsToRemove; i++) {
            cardsToRemove.add(8);
        }
        for (int i = 0; i < numOtherToRemove; i++) {
            cardsToRemove.add(otherColorIndex);
        }

        //if valid card combo: dispose of the cards
        for (int index: cardsToRemove) {
            deck.discardTrainCard(currentPlayer.removeTrainCard(index));
        }
        //if invalid combo tell them no and let them try again
    }

    public void mouseEntered(MouseEvent e) { }

    public void mouseExited(MouseEvent e) { }

    public void mouseDragged( MouseEvent e ) { }

    public void mousePressed( MouseEvent e ) { }

    public void mouseReleased( MouseEvent e ) { }

    /**
     * Method checking for mouse movement to create a hovering box
     * over cities
     * 
     * @param e an event that indicates a mouse action has occured.
     */
    public void mouseMoved(MouseEvent e) 
    { 
        ////////////////To do:///////////////
        //check if mouse location is within boundaries of a city
        //if so paint a little box for the city info like name and meeples
        for (City c : board.allCities.values()) 
        {
            if (c.cityShape != null && 
            c.cityShape.contains(e.getX(), e.getY())) 
            {
                //show a box with city name and meeple counts 
                /*the city's meeple counts will
                be in c.meeples which is an int[]*/
                setToolTipText(c.name);
                return;
            }
        }
    }

    /**
     * Method that deals with mouse clicking 
     * 
     * @param e an event that indicates a mouse action has occured.
     */
    public void mouseClicked(MouseEvent e) 
    {
        choosingTrainCard = false;
        //Check if clicked on a train card in the deck
        if(e.getX() >= 905 && e.getX() <= 1055 && e.getY() >= 620 && 
        e.getY() <= 710) 
        {
            if (deck.trainCards.size() + 
            deck.discardedTrainCards.size() > 0) 
            {
                currentPlayer.addTrainCard(deck.drawTrainCard());
                if(secondClick) 
                {
                    repaint();
                    nextPlayer();
                }
                secondClick =! secondClick;
                repaint();
            }
            return;
        }
        int cardIndex = 0;
        //x and y of the bottom most, face up train card
        if(e.getX() >= 905 && e.getX() <= 1055 && e.getY() >= 520 && 
        e.getY() <= 610 && deck.faceUpTrainCards.size() > 0) 
        {
            cardIndex = 0;
            choosingTrainCard = true;
        }
        //x and y of the 2nd, face up train card
        if(e.getX() >= 905 && e.getX() <= 1055 && e.getY() >= 420 && 
        e.getY() <= 510 && deck.faceUpTrainCards.size() > 1)  
        {
            cardIndex = 1;
            choosingTrainCard = true;
        }
        //x and y of the 3rd, face up train card
        if(e.getX() >= 905 && e.getX() <= 1055 && e.getY() >= 320 && 
        e.getY() <= 410 && deck.faceUpTrainCards.size() > 2)  
        {
            cardIndex = 2;
            choosingTrainCard = true;
        }
        //x and y of the 4th, face up train card
        if(e.getX() >= 905 && e.getX() <= 1055 && e.getY() >= 220 && 
        e.getY() <= 310 && deck.faceUpTrainCards.size() > 3)  
        {
            cardIndex = 3;
            choosingTrainCard = true;
        }
        //x and y of the 5th, face up train card
        if(e.getX() >= 905 && e.getX() <= 1055 && e.getY() >=120 && 
        e.getY() <= 210 && deck.faceUpTrainCards.size() > 4)  
        {
            cardIndex = 4;
            choosingTrainCard = true;
        }

        if (choosingTrainCard) 
        {
            /*/TO DO: should also check if there's only rainbow 
            left and no blind deck Question: progress?*/
            if(deck.faceUpTrainCards.get(cardIndex).isRainbow() || 
            deck.faceUpTrainCards.isEmpty()) 
            {
                if (secondClick) 
                {
                    //Reject trying to take rainbow card on second click
                    return;
                }
                else 
                {
                    //Can't choose a second card now so set secondclick to true
                    secondClick = true;
                }
            }
            currentPlayer.addTrainCard(deck.drawFaceupCard(cardIndex));
            if(secondClick) 
            {
                repaint();
                nextPlayer();   
            }
            secondClick =! secondClick;
            repaint();
            return;
        }

        //Check if clicked on destination card deck
        /*/in all these cases after stuff happens we move 
        to next player in list Question: how to fix??*/
        //Check if trying to see their own destination cards
        if(!secondClick) 
        {
            if(e.getX() >= 905 && e.getX() <= 1055 && 
            e.getY() >= 720 && e.getY() <= 910 ) 
            {
                chooseDestinationCards(currentPlayer, 1);
                repaint();
                nextPlayer();
                repaint();
                return;
            }
            for (Route possibleR : board.routes) 
            {
                if(possibleR.containsMouse(e.getX(), e.getY()) && 
                currentPlayer.canTakeRoute(possibleR)) 
                {
                    claimRouteDialogue(possibleR);
                    /*deck.discardTrainCard
                     * (currentPlayer.removeTrainCard(the index)) 
                    for each card Question: works? */
                    currentPlayer.addRoute(possibleR);
                    repaint();
                    //TO DO: let player choose meeples Question: pat, done?
                    nextPlayer();
                    repaint();
                    return;
                }
            }
        }

        if(e.getX() >=50 && e.getX() <= 200 && 
        e.getY() >= 700 && e.getY() <= 790)
        {
            DestinationCardPanel.createAndShowGUI();
        }
    }

    /**
     * Method that causes the move to the next player if 
     * the game isn't over, or calls endGame if it is
     */
    protected void nextPlayer() 
    {
        if(currentPlayer.isLastTurn) 
        {
            endGame();
            return;
        }
        else if(currentPlayer.carsRemaining <= 3) 
        {
            currentPlayer.isLastTurn = true;
            finalTurn = true;
        }
        int index = players.indexOf(currentPlayer);
        if (index == players.size()-1)
            currentPlayer = players.get(0);
        else 
            currentPlayer = players.get(index+1);

        if (finalTurn) 
        {
            JOptionPane.showMessageDialog(null, "FINAL ROUND: It is now " +
                currentPlayer.name + "'s FINAL turn.");
        }
        else {
            JOptionPane.showMessageDialog(null, "It is now " +
                currentPlayer.name + "'s turn.");
        }
    }

    /**
     * Adds the bonus points to each player
     */
    protected void addBonusPoints() 
    {
        //To determin the glober trotter bonus
        int[] playerTotal = new int[players.size()];
        int index = 0;
        for(Player p : players)
        {
            playerTotal[index] += p.getPosDestScore();
            index++;
        }
        int max;
        if(playerTotal.length == 2)
        {
            max = 0;
            index = 0;
            for(int x = 0; x < playerTotal.length; x++)
            {
                if(playerTotal[x] > max)
                {
                    max = playerTotal[x]; index = x;
                }
                else if(playerTotal[x] == max)
                { 
                    players.get(0).score += 15;
                    players.get(1).score += 15;
                }
                else if(playerTotal[x] != max && x == 1)
                {
                    players.get(index).score += 15;
                }
            }
        }
        else
        {
            max = 0;
            index = 0;
            for(int x = 0; x < playerTotal.length; x++)
            {
                if(playerTotal[x] > max)
                {
                    max = playerTotal[x]; 
                    index = x;
                }
                else if(playerTotal[0] == playerTotal[1])
                { 
                    players.get(0).score += 15;
                    players.get(1).score += 15;
                }
                else if(playerTotal[0] == playerTotal[2])
                { 
                    players.get(0).score += 15;
                    players.get(2).score += 15;
                }
                else if(playerTotal[1] == playerTotal[2])
                { 
                    players.get(1).score += 15;
                    players.get(2).score += 15;
                }
                else if(playerTotal[x] != max && x == 2)
                {
                    players.get(index).score += 15;
                }
            }
        }
        //To determin the Meeple bonus
        if(playerTotal.length == 2)
        {
            for(int y = 0; y < 6; y++)
            {
                if(players.get(0).meeples[y] > 
                players.get(1).meeples[y])
                {
                    players.get(0).score += 20;
                    players.get(1).score += 10;
                }
                else if(players.get(0).meeples[y] == 
                players.get(1).meeples[y])
                {
                    players.get(0).score += 20;
                    players.get(1).score += 20;
                }
                else if(players.get(0).meeples[y] < 
                players.get(1).meeples[y])
                {
                    players.get(0).score += 10;
                    players.get(1).score += 20;
                }
            }
        }
        else
        {
            for(int z = 0; z < 6; z++)
            {
                if(players.get(0).meeples[z] > players.get(1).meeples[z] &&
                players.get(0).meeples[z] > players.get(2).meeples[z])
                {
                    players.get(0).score += 20;
                    if(players.get(1).meeples[z] > players.get(2).meeples[z])
                    {
                        players.get(1).score += 10;
                    }
                    else if(players.get(1).meeples[z] == 
                    players.get(2).meeples[z])
                    {
                        players.get(1).score += 10;
                        players.get(2).score += 10;
                    }
                    else if(players.get(1).meeples[z] < 
                    players.get(2).meeples[z])
                    {
                        players.get(2).score += 10;
                    }
                }
                else if(players.get(0).meeples[z] < players.get(1).meeples[z] &&
                players.get(1).meeples[z] > players.get(2).meeples[z])
                {
                    players.get(1).score += 20;
                    if(players.get(0).meeples[z] > players.get(2).meeples[z])
                    {
                        players.get(0).score += 10;
                    }
                    else if(players.get(0).meeples[z] == 
                    players.get(2).meeples[z])
                    {
                        players.get(0).score += 10;
                        players.get(2).score += 10;
                    }
                    else if(players.get(0).meeples[z] < 
                    players.get(2).meeples[z])
                    {
                        players.get(2).score += 10;
                    }
                }
                else if(players.get(0).meeples[z] < players.get(2).meeples[z] &&
                players.get(1).meeples[z] < players.get(2).meeples[z])
                {
                    players.get(2).score += 20;
                    if(players.get(0).meeples[z] > 
                    players.get(1).meeples[z])
                    {
                        players.get(0).score += 10;
                    }
                    else if(players.get(0).meeples[z] == 
                    players.get(1).meeples[z])
                    {
                        players.get(0).score += 10;
                        players.get(1).score += 10;
                    }
                    else if(players.get(0).meeples[z] < 
                    players.get(1).meeples[z])
                    {
                        players.get(1).score += 10;
                    }
                }
                else if(players.get(0).meeples[z] == 
                players.get(1).meeples[z] &&
                players.get(0).meeples[z] > 
                players.get(2).meeples[z])
                {
                    players.get(0).score += 20;
                    players.get(1).score += 20;
                }
                else if(players.get(0).meeples[z] == 
                players.get(2).meeples[z] &&
                players.get(0).meeples[z] > 
                players.get(1).meeples[z])
                {
                    players.get(0).score += 20;
                    players.get(2).score += 20;
                }
                else if(players.get(1).meeples[z] == 
                players.get(2).meeples[z] &&
                players.get(1).meeples[z] > 
                players.get(0).meeples[z])
                {
                    players.get(1).score += 20;
                    players.get(2).score += 20;
                }
                else if(players.get(0).meeples[z] == 
                players.get(1).meeples[z] &&
                players.get(0).meeples[z] < 
                players.get(2).meeples[z])
                {
                    players.get(0).score += 10;
                    players.get(1).score += 10;
                    players.get(2).score += 20;
                }
                else if(players.get(0).meeples[z] == 
                players.get(2).meeples[z] &&
                players.get(0).meeples[z] < 
                players.get(1).meeples[z])
                {
                    players.get(0).score += 10;
                    players.get(1).score += 20;
                    players.get(2).score += 10;
                }
                else if(players.get(1).meeples[z] == 
                players.get(2).meeples[z] &&
                players.get(1).meeples[z] < 
                players.get(0).meeples[z])
                {
                    players.get(0).score += 20;
                    players.get(1).score += 10;
                    players.get(2).score += 10;
                }
            }
        }
    }

    /**
     * Method to end the game and show the scores
     */
    protected void endGame() 
    {
        for (Player p : players) 
        {
            board.traverseDestinations(p);
            int add = p.getPosDestScore();
            int sub = p.getNegDestScore();
            p.score += add;
            p.score += sub;
            EndGameWin.createAndShowGUI();
        }
        addBonusPoints();
    }

    /**
     * Creates the JFrame for the PlayGame window
     */
    protected static void createAndShowGUI() 
    {
        //Create and set up the window.
        frame = new JFrame("Ticket To Ride");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PlayGame panel = new PlayGame();
        frame.getContentPane().add(panel);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
