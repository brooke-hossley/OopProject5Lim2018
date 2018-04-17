import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.util.*;
import java.lang.String;
/**
 * Write a description of class playGame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PlayGame extends JPanel implements MouseListener
{
    private Image sdest, sdest2, sdest3, sdest4, sdest5, sdest6, sdest7, sdest8;
    private Image sdest9, sdest10, sdest11, sdest12, sdest13, sdest14, sdest15, sdest16;
    private Image sdest17, sdest18, sdest19, sdest20, sdest21, sdest22, sdest23, sdest24;
    private Image sdest25, sdest26, sdest27, sdest28, sdest29, sdest30, sdest31, sdest32;
    private Image sdest33, sdest34, sdest35, sdest36, sdest37, sdest38, sdest39, sdest40;
    private Image sdest41, sdest42, sdest43, sdest44, sdest45, sdest46, sdest47, sdest48;
    private Image sdest49, sdest50, sdest51, sdest52, sdest53, sdest54, sdest55;

    private Image ldest, ldest2, ldest3, ldest4, ldest5, ldest6, ldest7, ldest8, ldest9;
    private Image ldest10, ldest11, ldest12, ldest13, ldest14, ldest15, ldest16, ldest17, ldest18;
    private Image ldest19, ldest20, ldest21, ldest22, ldest23, ldest24, ldest25, ldest26, ldest27;
    private Image ldest28, ldest29, ldest30, ldest31, ldest32, ldest33, ldest34;

    private Image traincol, traincol2, traincol3, traincol4, traincol5, traincol6;
    private Image traincol7, traincol8, traincol9;

    private static Image board, blackBackground, TicketToRidePic;

    private Image misc, misc2, misc3, misc4;

    private JButton button1, button2;

    private static boolean playerChosen;
    protected static int numberOfPlayers;

    private static JFrame frame;
    
    private Deck trainCards;
    /**
     * Constructor for objects of class playGame
     */
    public PlayGame()
    {
        addMouseListener(this);
        //createDestinationDeck();
        String dir = "Images/";
        sdest = new ImageIcon(dir + "BerlChem.JPG").getImage();
        sdest2 = new ImageIcon(dir + "BerlErfu.JPG").getImage();
        sdest3 = new ImageIcon(dir + "BerlLeip.JPG").getImage();
        sdest4 = new ImageIcon(dir + "BremBerl.JPG").getImage();
        sdest5 = new ImageIcon(dir + "BremDuss.JPG").getImage();
        sdest6 = new ImageIcon(dir + "BremKass.JPG").getImage();
        sdest7 = new ImageIcon(dir + "BremKoln.JPG").getImage();
        sdest8 = new ImageIcon(dir + "DaneBerl.JPG").getImage();
        sdest9 = new ImageIcon(dir + "DaneNied.JPG").getImage();
        sdest10 = new ImageIcon(dir + "DkortErfu.JPG").getImage();
        sdest11 = new ImageIcon(dir + "DortMagd.JPG").getImage();
        sdest12 = new ImageIcon(dir + "DortMann.JPG").getImage();
        sdest13 = new ImageIcon(dir + "DussKons.JPG").getImage();
        sdest14 = new ImageIcon(dir + "EmdeHamb.JPG").getImage();
        sdest15 = new ImageIcon(dir + "ErfuWurz.JPG").getImage();
        sdest16 = new ImageIcon(dir + "FrankfMunc.JPG").getImage();
        sdest17 = new ImageIcon(dir + "FrankrMunc.JPG").getImage();
        sdest18 = new ImageIcon(dir + "FranLind.JPG").getImage();
        sdest19 = new ImageIcon(dir + "FranOste.JPG").getImage();
        sdest20 = new ImageIcon(dir + "FranStut.JPG").getImage();
        sdest21 = new ImageIcon(dir + "HambBerl.JPG").getImage();
        sdest22 = new ImageIcon(dir + "HambFran.JPG").getImage();
        sdest23 = new ImageIcon(dir + "HambKass.JPG").getImage();
        sdest24 = new ImageIcon(dir + "HambKobl.JPG").getImage();
        sdest25 = new ImageIcon(dir + "HambKoln.JPG").getImage();
        sdest26 = new ImageIcon(dir + "HambLeip.JPG").getImage();
        sdest27 = new ImageIcon(dir + "HambRost.JPG").getImage();
        sdest28 = new ImageIcon(dir + "HannFran.JPG").getImage();
        sdest29 = new ImageIcon(dir + "HannLeip.JPG").getImage();
        sdest30 = new ImageIcon(dir + "HannSaar.JPG").getImage();
        sdest31 = new ImageIcon(dir + "KarlAugs.JPG").getImage();
        sdest32 = new ImageIcon(dir + "KarlRege.JPG").getImage();
        sdest33 = new ImageIcon(dir + "KassFrei.JPG").getImage();
        sdest34 = new ImageIcon(dir + "KoblUlm.JPG").getImage();
        sdest35 = new ImageIcon(dir + "KolnFran.JPG").getImage();
        sdest36 = new ImageIcon(dir + "KolnMunc.JPG").getImage();
        sdest37 = new ImageIcon(dir + "KolnNurn.JPG").getImage();
        sdest38 = new ImageIcon(dir + "KolnRege.JPG").getImage();
        sdest39 = new ImageIcon(dir + "KolnSaar.JPG").getImage();
        sdest40 = new ImageIcon(dir + "KolnSchw.JPG").getImage();
        sdest41 = new ImageIcon(dir + "LeipMunc.JPG").getImage();
        sdest42 = new ImageIcon(dir + "LeipFran.JPG").getImage();
        sdest43 = new ImageIcon(dir + "LiepNurn.JPG").getImage();
        sdest44 = new ImageIcon(dir + "MagdKoln.JPG").getImage();
        sdest45 = new ImageIcon(dir + "MainStut.JPG").getImage();
        sdest46 = new ImageIcon(dir + "MannStut.JPG").getImage();
        sdest47 = new ImageIcon(dir + "MannWurz.JPG").getImage();
        sdest48 = new ImageIcon(dir + "MuncFrei.JPG").getImage();
        sdest49 = new ImageIcon(dir + "MuncKons.JPG").getImage();
        sdest50 = new ImageIcon(dir + "MuncStut.JPG").getImage();
        sdest51 = new ImageIcon(dir + "MuncWurz.JPG").getImage();
        sdest52 = new ImageIcon(dir + "MunStut.JPG").getImage();
        sdest53 = new ImageIcon(dir + "NiedFran.JPG").getImage();
        sdest54 = new ImageIcon(dir + "Nied Karl.JPG").getImage();
        sdest55 = new ImageIcon(dir + "Nurn Stut.JPG").getImage();

        ldest = new ImageIcon(dir + "BerlDuss.JPG").getImage();
        ldest2 = new ImageIcon(dir + "BerlFran.JPG").getImage();
        ldest3 = new ImageIcon(dir + "BerlKoln.JPG").getImage();
        ldest4 = new ImageIcon(dir + "BerlMain.JPG").getImage();
        ldest5 = new ImageIcon(dir + "BerlMunc.JPG").getImage();
        ldest6 = new ImageIcon(dir + "BerlSchw.JPG").getImage();
        ldest7 = new ImageIcon(dir + "BerlStut.JPG").getImage();
        ldest8 = new ImageIcon(dir + "BremFran.JPG").getImage();
        ldest9 = new ImageIcon(dir + "BremRege.JPG").getImage();
        ldest10 = new ImageIcon(dir + "DaneLine.JPG").getImage();
        ldest11 = new ImageIcon(dir + "DortMunc.JPG").getImage();
        ldest12 = new ImageIcon(dir + "DresAugs.JPG").getImage();
        ldest13 = new ImageIcon(dir + "DresSaar.JPG").getImage();
        ldest14 = new ImageIcon(dir + "EmdeFrei.JPG").getImage();
        ldest15 = new ImageIcon(dir + "EmdeOste.JPG").getImage();
        ldest16 = new ImageIcon(dir + "FranDane.JPG").getImage();
        ldest17 = new ImageIcon(dir + "FranLeip.JPG").getImage();
        ldest18 = new ImageIcon(dir + "HambDres.JPG").getImage();
        ldest19 = new ImageIcon(dir + "HambKarl.JPG").getImage();
        ldest20 = new ImageIcon(dir + "HambMunc.JPG").getImage();
        ldest21 = new ImageIcon(dir + "HambStut.JPG").getImage();
        ldest22 = new ImageIcon(dir + "KielNurn.JPG").getImage();
        ldest23 = new ImageIcon(dir + "KielSchw.JPG").getImage();
        ldest24 = new ImageIcon(dir + "KielStut.JPG").getImage();
        ldest25 = new ImageIcon(dir + "KolnLeip.JPG").getImage();
        ldest26 = new ImageIcon(dir + "LeipStut.JPG").getImage();
        ldest27 = new ImageIcon(dir + "LeipUlm.JPG").getImage();
        ldest28 = new ImageIcon(dir + "MunsMunc.JPG").getImage();
        ldest29 = new ImageIcon(dir + "MunsOste.JPG").getImage();
        ldest30 = new ImageIcon(dir + "NiedBerl.JPG").getImage();
        ldest31 = new ImageIcon(dir + "RostKons.JPG").getImage();
        ldest32 = new ImageIcon(dir + "RostOste.JPG").getImage();
        ldest33 = new ImageIcon(dir + "SchKob.JPG").getImage();
        ldest34 = new ImageIcon(dir + "SchwFran.JPG").getImage();

        traincol = new ImageIcon(dir + "BlackCard.JPG").getImage();
        traincol2 = new ImageIcon(dir + "BlueCard.JPG").getImage();
        traincol3 = new ImageIcon(dir + "GreenCard.JPG").getImage();
        traincol4= new ImageIcon(dir + "OrangeCard.JPG").getImage();
        traincol5 = new ImageIcon(dir + "PurpleCard.JPG").getImage();
        traincol6 = new ImageIcon(dir + "RainbowCard.JPG").getImage();
        traincol7 = new ImageIcon(dir + "RedCard.JPG").getImage();
        traincol8 = new ImageIcon(dir + "WhiteCard.JPG").getImage();
        traincol9 = new ImageIcon(dir + "YellowCard.JPG").getImage();

        board = new ImageIcon(dir + "Board.JPG").getImage();
        blackBackground = new ImageIcon(dir + "blackBackground.JPG").getImage();
        TicketToRidePic = new ImageIcon(dir + "HomeScreen.JPG").getImage();

        misc = new ImageIcon(dir + "BlueDest.JPG").getImage();
        misc2 = new ImageIcon(dir + "Globetrotter.JPG").getImage();
        misc3 = new ImageIcon(dir + "OrangeDest.JPG").getImage();
        misc4 = new ImageIcon(dir + "TrainCardBack.JPG").getImage();

        Dimension size = new Dimension(blackBackground.getWidth(null), board.getHeight(null));
        //width is 900 pixels
        //height is 600
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);

         button1 = new JButton("Select Short Card");
        button1.setBounds(1100,590,190,20);
        add(button1);
        button1.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e) 
                { 
                  shortButtonPressed();
                }         
            });

        button2 = new JButton("Select Long Card");
        button2.setBounds(1100,620,190,20);
        add(button2);
        button2.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                { 
                    longButtonPressed();
                }         
            });

    }

    public void paintComponent(Graphics g) 
    {
       super.paintComponent(g);
        drawLoadingScreen(g);
        
        if(playersChosen)
        {
            g.drawImage(blackBackground,0,0,null);
            g.drawImage(board,270,0,null);
        }
        drawTrainCards(g);
        drawDestinationCards(g);
        }
    }

    public void homeScreen(Graphics g)
    {
        g.drawImage(TicketToRidePic,0,0,null);

    }

    public void drawTrainCards(Graphics g)
    {
        //g.drawImage(trainCards.drawTrainCard.getPicture(),0,0,null);        
        g.drawImage(misc4,930,650,null);
    }

    public void drawDestinationCards(Graphics g)
    {
        g.drawImage(misc,1100,650,null);
        g.drawImage(misc3,1200,650,null);
    }

    public static void playersChosen()
    {
        playersChosen = true;
        //repaint();
    }

    public void shortButtonPressed()
    {
        
    }
    
    public void longButtonPressed()
    {
        
    }

    /**
     * Create all the TrainCarCards
     */
    private void createTrainDeck()
    {
        trainCards = new Deck();
    }

    /**
     * Create all the destination cards
     */
    private void createDestinationDeck()
    {

    }

    /**
     * creates the game board
     */
    private void createGameBoard() 
    {
        //gameBoard = new Board();
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
    }

    /**
     * Gets user input to set up the game (number of players, etc)
     */
    private void getGameOptions() 
    {

    }

    /**
     * Gives players train cards, gives them destination cards to choose from
     * lets them choose
     * @param g The graphics object 
     */
    private void setUpGame(Graphics g) 
    {

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
