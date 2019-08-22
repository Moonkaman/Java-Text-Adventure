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

      case "Toe Nail Clipping":
        return "You struggle to swallow the nail clipping and it gets stuck in your throat but eventually you swallow it.";

      case "Paul":
        return "You eat paul whole and then burp up his beak.";

      default:
        return "You eat the " + name;
    }
  }
}