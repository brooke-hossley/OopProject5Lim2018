import java.awt.*;
import javax.swing.*;
/**
 * Class for Train Card information
 *
 * @author Alissa Ronca, Patrick Baraber, Brooke Hossley,
 * Hieu Le, Chris Adams
 * @version Spring 2018
 */
public class TrainCard 
{
    //Color of the train card
    protected TrainColor tColor;
    //Index of the card
    protected int arrIndex;
    //Image
    protected Image picture;

    /**
     * Constructor with parameters for the TrainCard class
     * 
     * @param color The color of the train card
     * @param index The index of the train card
     * @param pic The image of the train card
     */
    public TrainCard(TrainColor color, int index, Image pic)
    {
        tColor = color;
        arrIndex = index;
        picture = pic;
    }

    /**
     * Constructor with parameters for the TrainCard class
     * 
     * @param color The color of the train card
     * @param pic The image of the train card
     */
    public String toString()
    {
        switch(tColor)
        {
            case YELLOW: return "a Yellow";
            case BLUE: return "a Blue";
            case GREEN: return "a Green";
            case PINK: return "a Pink";
            case RED: return "a Red";
            case BLACK: return "a Black";   
            case ORANGE: return "an Orange";
            case WHITE: return "a White";
            case RAINBOW: return "a Rainbow";  
        }
        return "";
    }

    /**
     * Determines if the two train cards are the
     * same color
     * 
     * Question: ^?
     * 
     * @param o The object to be compared
     * @return If the cards colors are equal
     */
    public boolean equals(Object o) 
    {
        TrainCard tcard = (TrainCard) o;
        return tcard.tColor == this.tColor;
    }

    /**
     * Returns the train cards color
     * 
     * @return The color of the train card
     */
    protected TrainColor getTrainCardColor()
    {
        return tColor;
    }

    /**
     * Returns the image associated with the train card
     * 
     * @return The image associated with the train card
     */
    protected Image getPicture()
    {
        return picture;
    }

    /**
     * Returns the index of the train card
     * in an array of train cards
     * 
     * @return The index of the train card 
     */
    protected int getArrIndex()
    {
        return arrIndex;
    }

    /**
     * Determins if the train card is a 
     * locomotive card
     * 
     * @return If the train card is a locomotive card
     */
    protected boolean isRainbow() 
    {
        return tColor == TrainColor.RAINBOW;
    }
}
