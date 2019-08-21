import java.util.ArrayList;

public class Room {
  String name;
  String description;
  ArrayList<Item> items = new ArrayList<Item>();
  Room north;
  Room east;
  Room south;
  Room west;

  public Room(String name, String description, Room north, Room east, Room  south, Room west) {
    this.name = name;
    this.description = description;
    this.north = north;
    this.east = east;
    this.south = south;
    this.west = west;
  }
}