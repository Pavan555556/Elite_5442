import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Number of Players : ");
        int Number_of_Players = input.nextInt();
        Queue<Player> player_position_tracker_queue = new LinkedList<>();       
        for(int i = 1; i < Number_of_Players + 1; i++ ) {
           System.out.print("Enter player " + String.valueOf(i) + " name : ");
            String name = input.next();
            Player player = new Player(name,0);
            player_position_tracker_queue.add(player);
        }  
       Jumpers jump_obj = new Jumpers();
       Ladders ladders_obj = new Ladders(jump_obj.ladders);
       Snakes snakes_obj = new Snakes(jump_obj.snakes);
    while(player_position_tracker_queue.size() > 1) {
        Player player_to_throw_dice = player_position_tracker_queue.poll();
        System.out.println(player_to_throw_dice.getName() + " its your turn");    
        System.out.print("Enter 1 to continue : ");
        int player_signal = input.nextInt();
        if(player_signal == 1) {

         
            Dice dice_obj = new Dice();  
            int dice_val = dice_obj.dice_val(); 
            System.out.println(dice_val);
            int player_curr_value ;
            if(player_to_throw_dice.getPosition() + dice_val < 100) {
                player_curr_value = player_to_throw_dice.getPosition() + dice_val;
                player_to_throw_dice.setPosition(player_curr_value) ;
                if(snakes_obj.snakeChecker(player_to_throw_dice.getPosition())) {
                    player_to_throw_dice.setPosition(snakes_obj.snakePunish(player_to_throw_dice.getPosition()));    
                }
                if(ladders_obj.ladderChecker(player_to_throw_dice.getPosition())) {
                    player_to_throw_dice.setPosition(ladders_obj.ladderReward(player_to_throw_dice.getPosition()));
                }
                System.out.println(player_to_throw_dice.getPosition());
                player_position_tracker_queue.offer(player_to_throw_dice);
                
            }
           
           else if(player_to_throw_dice.getPosition() + dice_val == 100) {
                System.out.println(player_to_throw_dice.getName() + " you won the game");
            }
            else {
                System.out.println("Smaller Value is needed");
            
                player_position_tracker_queue.offer(player_to_throw_dice);
            }
        }
        else {
            player_position_tracker_queue.offer(player_to_throw_dice);
            continue;
        }
    } 
        
    }
}