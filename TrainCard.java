////////////////////////////////////////////////////////////////////////////////
/**
 * Write a description of class Card here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TrainCard extends Card
{
    protected TrainColor tColor;
    
    public TrainCard(TrainColor color){
        tColor = color;
    }
    //Alissa's idea, assign each color a int so it's easier to assign colors. Need more development 
    public TrainCard(int x){
        switch(x){
            case 0: tColor = TrainColor.YELLOW;
            break;
            case 1: tColor = TrainColor.BLUE;
            break;
            case 2: tColor = TrainColor.GREEN;
            break;
            case 3: tColor = TrainColor.PINK;
            break;
            case 4: tColor = TrainColor.RED;
            break;
            case 5: tColor = TrainColor.BLACK;
            break;        
            case 6: tColor = TrainColor.ORANGE;
            break;  
            case 7: tColor = TrainColor.WHITE;
            break;   
            case 8: tColor = TrainColor.RAINBOW;
            break;        
        }
    }

    public TrainColor getTrainCardColor(){
        return tColor;
    }
}
