import java.util.*;
public class Snakes {
    HashMap<Integer,Integer> sahm ;
    Snakes(HashMap<Integer,Integer> lhm) {
      sahm = lhm;
    }
   public boolean snakeChecker(int position) {
    if(sahm.containsKey(position)) {
        return true;
    }
    return false;
   }
   public int snakePunish(int position) {
    return sahm.get(position);
   }


}
