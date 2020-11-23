/**
 * @author Timmy & Kris & Johan
 */

import com.sun.xml.internal.ws.util.StringUtils; //used for "capitalise()", which is a StringUtils function

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
    public Pizza(String ingredients) {
        this.ingredients = ingredients.split(",");

//------decided not to use this, as it screws with the statistics
        //gives the custom pizza a unique code based on the ingredients
        /*
        String ingCode = "";
        for (int i = 0; i < this.ingredients.length; i++) {
            ingCode += this.ingredients[i].toLowerCase().charAt(0);
            ingCode += this.ingredients[i].toLowerCase().charAt(1);
        }
        this.name = "Custom Pizza ("+ingCode+")";
        */

        this.name = "Custom Pizza";
        this.id = 0;
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

    //idea from Johan, which saves a lot of lines of code
    @Override
    public String toString() { //contains everything necessary for the formatting that was previously in Menu.viewMenu()
        StringBuilder pizzaString = new StringBuilder();
        pizzaString.append(this.id);
        if(this.id < 10){
            pizzaString.append(" --- \"");
        }else{
            pizzaString.append(" -- \"");
        }
        pizzaString.append(this.name);
        pizzaString.append("\" --- " );
        for (int i = 0; i < ingredients.length; i++) {
            StringUtils.capitalize(ingredients[i]);
            pizzaString.append(ingredients[i]);
            if(i < ingredients.length-2) {
                pizzaString.append(", ");
            }else if(i < ingredients.length-1){
                pizzaString.append(", and ");
            }
        }
        pizzaString.append(" --- ");
        pizzaString.append(this.price);
        pizzaString.append("kr.");
        return pizzaString.toString();
    }
}
