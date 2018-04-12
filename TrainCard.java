import java.awt.*;
import javax.swing.*;
////////////////////////////////////////////////////////////////////////////////
/**
 * Write a description of class Card here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TrainCard //extends Card
{
    protected TrainColor tColor;
    protected int arrIndex;
    protected Image picture;
    public TrainCard(TrainColor color, int index, Image pic){
        tColor = color;
        arrIndex = index;
        picture = pic;
    }
    
    public TrainCard(TrainColor color, Image pic){
        tColor = color;
        picture = pic;
        switch(tColor){
            case YELLOW: arrIndex = 0; break;
            case BLUE: arrIndex = 1; break;
            case GREEN: arrIndex = 2; break;
            case PINK: arrIndex = 3; break;
            case RED: arrIndex = 4; break;
            case BLACK: arrIndex = 5; break;   
            case ORANGE: arrIndex = 6; break;
            case WHITE: arrIndex = 7; break;
            case RAINBOW: arrIndex = 8;  
        }
    }

    public TrainColor getTrainCardColor(){
        return tColor;
    }

    public Image getPicture(){
        return picture;
    }

    public int getArrIndex(){
        return arrIndex;
    }

    // //Alissa's idea, assign each color a int so it's easier to assign colors. Need more development 
    // public TrainCard(int x){
    // switch(x){
    // case 0: tColor = TrainColor.YELLOW;
    // break;
    // case 1: tColor = TrainColor.BLUE;
    // break;
    // case 2: tColor = TrainColor.GREEN;
    // break;
    // case 3: tColor = TrainColor.PINK;
    // break;
    // case 4: tColor = TrainColor.RED;
    // break;
    // case 5: tColor = TrainColor.BLACK;
    // break;        
    // case 6: tColor = TrainColor.ORANGE;
    // break;  
    // case 7: tColor = TrainColor.WHITE;
    // break;   
    // case 8: tColor = TrainColor.RAINBOW;
    // break;        
    // }
    // }

}
