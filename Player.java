import java.util.ArrayList;

public class Player {
  String name;
  int health = 100;
  Room room;
  ArrayList<Item> inventory = new ArrayList<Item>();

  public Player(String name, Room room) {
    this.name = name;
    this.room = room;
  }

  public String greeting() {
    return "Hello, my name is " + name;
  }
}