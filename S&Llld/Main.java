import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        /* Asking for number of players */
        System.out.print("Enter Number of Players : ");
        int Number_of_Players = input.nextInt();
        /* Adding players to queue to keep track of the turns while playing */
        Queue<Player> player_position_tracker_queue = new LinkedList<>();
        for(int i = 1; i < Number_of_Players + 1; i++ ) {
           System.out.print("Enter player " + String.valueOf(i) + " name : ");
            String name = input.next();
            player_position_tracker_queue.add(new Player(name,0));
        }
    
    
         
        /* Snakes and Ladders */
        
        /* Have to add more ladders */
       Jumpers jump_obj = new Jumpers();
       Ladders ladders_obj = new Ladders(jump_obj.ladders);
        
        
        /* Have to add more snakes */
       Snakes snakes_obj = new Snakes(jump_obj.snakes);
       
        
        
        /* Snakes and Ladders */
        /*____________________________________________________________________________________
         * ____________________________________________________________________________________
         */
    while(player_position_tracker_queue.size() > 1) {
        Player player_to_throw_dice = player_position_tracker_queue.poll();
        System.out.println(player_to_throw_dice.name + " its your turn");    
        System.out.print("Enter 1 to continue, 0 to quit : ");
        int player_signal = input.nextInt();
        if(player_signal == 1) {

            int max = 6;
            int min = 1;  
            Dice dice = new Dice(max,min);  
            int dice_val = dice.dice(); 
            System.out.println(dice_val);
            int player_curr_value ;
            if(player_to_throw_dice.position + dice_val < 100) {
                player_curr_value = player_to_throw_dice.position + dice_val;
                player_to_throw_dice.position = player_curr_value;  
                if(snakes_obj.snakeChecker(player_to_throw_dice.position)) {
                    player_to_throw_dice.position = snakes_obj.snakePunish(player_to_throw_dice.position);    
                }
                if(ladders_obj.ladderChecker(player_to_throw_dice.position)) {
                    player_to_throw_dice.position = ladders_obj.ladderReward(player_to_throw_dice.position);
                }
                System.out.println(player_to_throw_dice.position);
                player_position_tracker_queue.offer(player_to_throw_dice);
                
            }
           
           else if(player_to_throw_dice.position + dice_val == 100) {
                System.out.println(player_to_throw_dice.name + "you won the game");
            }
            else {
                System.out.println("Smaller Value is needed");
            
                player_position_tracker_queue.offer(player_to_throw_dice);
            }
        }
        else if(player_signal == 0) {
            System.out.println("Are you sure want to quit..? Press 0 again to confirm ");
             int confirmation = input.nextInt();
             if(confirmation == 0) {
                System.out.println("You lost the game");
            
             }
        }
        else {
            player_position_tracker_queue.offer(player_to_throw_dice);
            continue;
        }
    } 
        
    }
}