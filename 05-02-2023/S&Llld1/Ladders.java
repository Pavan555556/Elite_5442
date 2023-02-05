import java.util.*;

interface ladders_l {
  boolean ladderChecker(int position);
  int ladderReward(int position);
}

public class Ladders implements ladders_l {
    HashMap<Integer,Integer> lahm ;
   Ladders(HashMap<Integer,Integer> lhm) {
     lahm = lhm;
   }
   public boolean ladderChecker(int position) {
    if(lahm.containsKey(position)) {
        return true;
    }
    return false;
   }
   public int ladderReward(int position) {
    return lahm.get(position);
   }
}
