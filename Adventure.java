import java.util.Scanner;
import java.util.Random; 

public class Adventure {
  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      Random r = new Random();
      Boolean exit = false;
      Room[] rooms = new Room[]{
        new Room("Stone Room", "It's like full of stones or whatever", null, null, null, null),
        new Room("Pig room", "This room is full of pigs, some half eaten", null, null, null, null)
      };
      
      Item[] items = new Item[]{
        new Item("Sword", false, 10, 3),
        new Item("Rat", true, 10, 3),
        new Item("Cheese", true, 10, 3),
        new Item("Severed Limb", true, 10, 3),
        new Item("Hammer", false, 10, 3),
        new Item("Axe Body Spray", false, 10, 3),
        new Item("Toe Nail Clipping", true, 10, 3),
        new Item("Sandwich", true, 10, 3),
        new Item("Scissors", false, 10, 3),
        new Item("Can of Spam", false, 10, 3),
        new Item("Paul", true, 10, 3)
      };
      
      for(int i = 0; i < rooms.length; i++) {
        for(int a = 0; a < r.nextInt((5 - 0) + 1) + 0; a++) {
          rooms[i].items.add(items[r.nextInt((items.length - 0) + 1) + 0]);
        }
      }

      rooms[0].north = rooms[1];
      rooms[1].south = rooms[0];

      System.out.println("Enter a name for your player");

      String name = scanner.nextLine();

      Player player = new Player(name, rooms[0]);

      while(!exit) {
        System.out.print("> ");
        String input = scanner.nextLine();
        switch(input){
          case "exit":
            exit = true;
            break;

          case "hi":
            System.out.println(player.greeting());
            break;

          case "desc":
            System.out.println(player.room.name + ": " + player.room.description);
            break;

          case "items":
            if(player.room.items.size() == 0) {
              System.out.println("There are no Items in this room.");
              break;
            }
            for(Item item : player.room.items){
              System.out.println("  - " + item.name);
            }
            break;

          case "get": {
            System.out.println("Enter what you want to pick up");
            String what = scanner.nextLine();
            Boolean success = false;
            for(int i = 0; i < player.room.items.size(); i++) {
              if(player.room.items.get(i).name.equals(what)) {
                player.inventory.add(player.room.items.get(i));
                player.room.items.remove(i);
                success = true;
                break;
              }
            }
            if(!success){
              System.out.println("That item isn't in the room.");
            }
            break;
          }

            case "drop": {
            System.out.println("Enter what you want to drop");
            String what = scanner.nextLine();
            Boolean success = false;
            for(int i = 0; i < player.inventory.size(); i++) {
              if(player.inventory.get(i).name.equals(what)) {
                player.room.items.add(player.inventory.get(i));
                player.inventory.remove(i);
                success = true;
                break;
              }
            }
            if(!success){
              System.out.println("That item isn't in your inventory.");
            }
            break;
          }

          case "eat": {
            System.out.println("Enter what you want to eat");
            String what = scanner.nextLine();
            Boolean success = false;
            for(int i = 0; i < player.inventory.size(); i++) {
              if(player.inventory.get(i).name.equals(what)) {
                System.out.println(player.inventory.get(i).eat());
                player.inventory.remove(i);
                success = true;
                break;
              }
            }
            if(!success){
              System.out.println("That item isn't in your inventory.");
            }
            break;
          }

          case "inventory":
            if(player.inventory.size() == 0) {
              System.out.println("Your inventory is empty.");
              break;
            }
            for(Item item : player.inventory) {
              System.out.println("  - " + item.name);
            }
            break;
          
          case "n":
            if(player.room.north != null) {
              System.out.println("You move north into: " + player.room.north.name + ".");
              player.room = player.room.north;
            } else {
              System.out.println("You can't go there.");
            }
            break;

          case "e":
            if(player.room.east != null) {
              System.out.println("You move east into: " + player.room.east.name + ".");
              player.room = player.room.east;
            } else {
              System.out.println("You can't go there.");
            }
            break;

          case "s":
            if(player.room.south != null) {
              System.out.println("You move south into: " + player.room.south.name + ".");
              player.room = player.room.south;
            } else {
              System.out.println("You can't go there.");
            }
            break;

          case "w":
            if(player.room.west != null) {
              System.out.println("You move west into: " + player.room.west.name + ".");
              player.room = player.room.west;
            } else {
              System.out.println("You can't go there.");
            }
            break;


          default:
            System.out.println(input);
            break;
        }
      }
  }
}