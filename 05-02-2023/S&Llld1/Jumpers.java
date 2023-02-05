import java.util.*;
public class Jumpers {

    HashMap<Integer,Integer> snakes = new HashMap<>();
    HashMap<Integer,Integer> ladders = new HashMap<>();


    Jumpers() {
        ladders.put(19,42);
        ladders.put(27,55);
        ladders.put(37,65);
        ladders.put(59,82);
        ladders.put(78,97);
        snakes.put(25,8);
        snakes.put(48,18);
        snakes.put(64,11);
        snakes.put(74,47);
        snakes.put(88,50);
        snakes.put(95,45);
        snakes.put(98,2);
    }
    
}
