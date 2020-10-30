//kris
public class Pizza {
    String name;
    int id;
    String[] ingredients;
    double price;

    //menu pizza
    public Pizza(String name, int id, String ingredients, double price) {
        this.name = name;
        this.id = id;
        this.ingredients = ingredients.split(",");
        this.price = price;
    }

    //custom pizza
    public Pizza(String[] ingredients) {
        this.ingredients = ingredients;
        this.price = 85.0;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public double getPrice() {
        return price;
    }
}
