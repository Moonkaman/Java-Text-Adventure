public class Item {
  String name;
  Boolean edible;
  int damage;
  int weight;

  public Item(String name, Boolean edible, int damage, int weight) {
    this.name = name;
    this.edible = edible;
    this.damage = damage;
    this.weight = weight;
  }

  public String eat() {
    switch(name) {
      case "Rat":
        return "The rat screams as you devour it whole.";
      
      default:
        return "You eat the " + name;
    }
  }
}