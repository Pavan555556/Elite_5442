import java.util.*;
public class Dice {
    int max;
    int min;
    Dice(int max,int min) {
        this.max = max;
        this.min = min;
    }
    public int dice() {
        return (int)(Math.random()*(max - min + 1) + min);
    }
}
