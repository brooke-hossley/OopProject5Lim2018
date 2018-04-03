
/**
 * Write a description of class playGame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PlayGame implements MouseListener
{
    /**
     * Constructor for objects of class playGame
     */
    public PlayGame()
    {
        createDestinationDeck();
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new PlayGame();
                }
            });
    }

    /**
     * Create all the TrainCarCards
     */
    private void createTrainDeck()
    {

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
        gameBoard = new Board();
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
        clickX = e.getX();
        clickY = e.getY();
        click = true;
        repaint();
        e.consume();
    }

    public void paintComponent(Graphics g) 
    {

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
}
