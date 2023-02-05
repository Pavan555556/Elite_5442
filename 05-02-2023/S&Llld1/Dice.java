import java.util.*;


interface dices {
    int max = 6;
    int min = 1;
    int dice_val();
}


public class Dice implements dices {
   
    public int dice_val() {
        return (int)(Math.random()*(max - min + 1) + min);
    }
}
