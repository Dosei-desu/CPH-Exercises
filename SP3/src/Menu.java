//kris
import com.sun.xml.internal.ws.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu {
    ArrayList<Pizza> menuPizzas = new ArrayList<Pizza>();
    public void pizzaMenu(){
        //pizza menu
        this.menuPizzas.add(0, new MenuPizza("Pepe",1,"Tomato,Cheese,Pepperoni",61.0));
        this.menuPizzas.add(1, new MenuPizza("Mario",2,"Tomato,Cheese,Shawarma,Creme Fraiche,Chili",64.0));
        this.menuPizzas.add(2, new MenuPizza("Alfonso Special",3,"Tomato,Cheese,Minced Beef,Onion,Chili",64.0));
        this.menuPizzas.add(3, new MenuPizza("Vesuvio",4,"Tomato,Cheese,Ham",61.0));
        this.menuPizzas.add(4, new MenuPizza("Capricciosa",5,"Tomato,Cheese,Ham,Mushroom",65.0));
        this.menuPizzas.add(5, new MenuPizza("Quatro",6,"Tomato,Cheese,Ham,Pepperoni",67.0));
        this.menuPizzas.add(6, new MenuPizza("Delizia",7,"Tomato,Cheese,Pepperoni,Paprika,Onion",67.0));
        this.menuPizzas.add(7, new MenuPizza("Hawaii",8,"Tomato,Cheese,Ham,Pineapple",65.0));
        this.menuPizzas.add(8, new MenuPizza("Bacone",9,"Tomato,Cheese,Ham,Pepperoni,Bacon",72.0));
        this.menuPizzas.add(9, new MenuPizza("Milano",10,"Tomato,Cheese,Ham,Meat Sauce",70.0));
        this.menuPizzas.add(10,new MenuPizza("Balkoni",11,"Tomato,Cheese,Ham,Bacon,Egg",61.0));
        this.menuPizzas.add(11,new MenuPizza("O Solo Mio",12,"Tomato,Cheese,Ham,Bacon,Cocktail Shrimp",72.0));
        this.menuPizzas.add(12,new MenuPizza("Bari",13,"Tomato,Cheese,Beef Sauce,Mushroom,Sliced Tomato",67.0));
        this.menuPizzas.add(13,new MenuPizza("Vegetariana",14,"Tomato,Cheese,Mushroom,Onion,Paprika,Pineapple",72.0));
        this.menuPizzas.add(14,new MenuPizza("Torino",15,"Tomato,Cheese,Shawarma,Mushroom,Onion",70.0));
        this.menuPizzas.add(15,new MenuPizza("Venicia",16,"Tomato,Cheese,Shawarma,Mushroom,Gorgonzola",70.0));
        this.menuPizzas.add(16,new MenuPizza("Samos",17,"Tomato,Cheese,Minced Beef,Mushroom,Chili",70.0));
        this.menuPizzas.add(17,new MenuPizza("Roma",18,"Tomato,Cheese,Meat Strips,Mushroom,Paprika,Garlic",72.0));
        this.menuPizzas.add(18,new MenuPizza("Prince",19,"Tomato,Cheese,Minced Beef,Pepperoni,Bacon,Onion",69.0));
        this.menuPizzas.add(19,new MenuPizza("Italiano",20,"Tomato,Cheese,Meat Sauce,Onion",65.0));
        this.menuPizzas.add(20,new MenuPizza("Gorgonzola",21,"Tomato,Cheese,Gorgonzola,Mushroom,Onion",67.0));
        this.menuPizzas.add(21,new MenuPizza("Parma",22,"Tomato,Cheese,Prosciutto,Mushroom,Gorgonzola",72.0));
        this.menuPizzas.add(22,new MenuPizza("Mafioso",23,"Tomato,Cheese,Prosciutto,Artichoke,Garlic",69.0));
        this.menuPizzas.add(23,new MenuPizza("Speciale",24,"Tomato,Cheese,Shawarma,Chicken,Paprika,Jalapeno,Garlic",70.0));
        this.menuPizzas.add(24,new MenuPizza("Siciliana",25,"Tomato,Cheese,Shawarma,Bacon,Pepperoni,Paprika",72.0));
        this.menuPizzas.add(25,new MenuPizza("Messi",26,"Tomato,Cheese,Chicken,Bacon,Curry Powder",67.0));
        this.menuPizzas.add(26,new MenuPizza("Juventus",27,"Tomato,Cheese,Chicken,Bacon,Egg",69.0));
        this.menuPizzas.add(27,new MenuPizza("Pollo",28,"Tomato,Cheese,Chicken,Mushroom,Paprika",69.0));
        this.menuPizzas.add(28,new MenuPizza("Margherita",29,"Tomato,Cheese",53.0));
        this.menuPizzas.add(29,new MenuPizza("Opera",30,"Tomato,Cheese,Pepperoni,Mushroom",67.0));
        this.menuPizzas.add(30,new MenuPizza("Baron",31,"Tomato,Cheese,Meat Strips,Pepperoni,Garlic",70.0));
        this.menuPizzas.add(31,new MenuPizza("Forza",32,"Tomato,Cheese,Shawarma,Onion,Bearnaise Sauce",69.0));
        this.menuPizzas.add(32,new MenuPizza("Maldini",33,"Tomato,Cheese,Shawarma,Chicken,Pepperoni,Onion",72.0));
        this.menuPizzas.add(33,new MenuPizza("Matador",34,"Tomato,Cheese,Beef,Mushroom,Onion,Bearnaise Sauce",73.0));
    }
//--view entire menu
    public void viewMenu(){
        String view = "";

        for (int n = 0; n < menuPizzas.size(); n++) {
            view += menuPizzas.get(n).getId();
            if(menuPizzas.get(n).getId() < 10){
                view += " --- Name: \"";
            }else{
                view += " -- Name: \"";
            }
            view += menuPizzas.get(n).getName()+"\" -- "+"Ingredients: |";
            for (int i = 0; i < menuPizzas.get(n).getIngredients().length; i++) {
                view += menuPizzas.get(n).getIngredients()[i];
                if(i < menuPizzas.get(n).getIngredients().length-1){
                    view += ", ";
                }
            }
            view += "| -- Price: "+menuPizzas.get(n).getPrice()+"kr.\n";
        }
        System.out.println(view);
    }
//--searching based on ID
    public void viewPizzaByID(int id){
        String view = "";
        for (int n = 0; n < menuPizzas.size(); n++) {
            //searches through menuPizzas to see if the ID matches
            if(id == menuPizzas.get(n).getId()){
                view += "Pizza number: "+id;
                view += "\n\""+menuPizzas.get(n).getName()+"\"\nIngredients: ";
                for (int i = 0; i < menuPizzas.get(n).getIngredients().length; i++) {
                    view += menuPizzas.get(n).getIngredients()[i];
                    if(i < menuPizzas.get(n).getIngredients().length-1){
                        view += ", ";
                    }
                }
                view += "\nPrice: "+menuPizzas.get(n).getPrice()+"kr.\n";
            }
        }
        if(view == ""){ //if ID didn't match any pizza
            view = "Pizza number "+id+" does not exist.\n";
        }
        System.out.println(view);
    }
//--searching based on name
    public void viewPizzaByName(String name){
        String view = "";
        for (int n = 0; n < menuPizzas.size(); n++) {
            //searches through menuPizzas to see if the ID matches
            if(name.toLowerCase().equals(menuPizzas.get(n).getName().toLowerCase())){
                view += "\""+menuPizzas.get(n).getName()+"\"";
                view += "\nID: "+menuPizzas.get(n).getId()+"\nIngredients: ";
                for (int i = 0; i < menuPizzas.get(n).getIngredients().length; i++) {
                    view += menuPizzas.get(n).getIngredients()[i];
                    if(i < menuPizzas.get(n).getIngredients().length-1){
                        view += ", ";
                    }
                }
                view += "\nPrice: "+menuPizzas.get(n).getPrice()+"kr.\n";
            }
        }
        if(view == ""){ //if name didn't match any pizza
            view = "\""+name+"\" does not exist.\n";
        }
        System.out.println(view);
    }
//--searching based on ingredient(s) (max seven, even though all come with tomato and cheese (for now))
    public void viewPizzaByIngredients(String ingredients){
        String view = "";
        boolean doOnce = true;

//------//
        //Short way to turn words like "this" or "tHIs" into "This" (tl;dr: capitalises user input)
        String[] ing = ingredients.toLowerCase().split(",");
        for (int n = 0; n < ing.length; n++) {
            ing[n] = StringUtils.capitalize(ing[n]);
        }
//------//

        for (int i = 0; i < menuPizzas.size(); i++) {
            List<String> menuPizzaList = Arrays.asList(menuPizzas.get(i).ingredients);
            //checks for ingredients that match the ones inputted
            if (ing.length == 1) {
                if (menuPizzaList.contains(ing[0]))
                {
                    if (doOnce) {
                        view += "Pizzas with " + ingredients + ":\n";
                        doOnce = false;
                    }
                    view = printHelper(view, menuPizzas.get(i));
                }
            }
            if (ing.length == 2) {
                if (menuPizzaList.contains(ing[0]) && menuPizzaList.contains(ing[1]))
                {
                    if (doOnce) {
                        view += "Pizzas with " + ingredients + ":\n";
                        doOnce = false;
                    }
                    view = printHelper(view, menuPizzas.get(i));
                }
            }
            if (ing.length == 3) {
                if (menuPizzaList.contains(ing[0]) && menuPizzaList.contains(ing[1]) && menuPizzaList.contains(ing[2]))
                {
                    if (doOnce) {
                        view += "Pizzas with " + ingredients + ":\n";
                        doOnce = false;
                    }
                    view = printHelper(view, menuPizzas.get(i));
                }
            }
            if (ing.length == 4) {
                if (menuPizzaList.contains(ing[0]) && menuPizzaList.contains(ing[1]) && menuPizzaList.contains(ing[2]) &&
                    menuPizzaList.contains(ing[3]))
                {
                    if (doOnce) {
                        view += "Pizzas with " + ingredients + ":\n";
                        doOnce = false;
                    }
                    view = printHelper(view, menuPizzas.get(i));
                }
            }
            if (ing.length == 5) {
                if (menuPizzaList.contains(ing[0]) && menuPizzaList.contains(ing[1]) && menuPizzaList.contains(ing[2]) &&
                    menuPizzaList.contains(ing[3]) && menuPizzaList.contains(ing[4]))
                {
                    if (doOnce) {
                        view += "Pizzas with " + ingredients + ":\n";
                        doOnce = false;
                    }
                    view = printHelper(view, menuPizzas.get(i));
                }
            }
            if (ing.length == 6) {
                if (menuPizzaList.contains(ing[0]) && menuPizzaList.contains(ing[1]) && menuPizzaList.contains(ing[2]) &&
                    menuPizzaList.contains(ing[3]) && menuPizzaList.contains(ing[4]) && menuPizzaList.contains(ing[5]))
                {
                    if (doOnce) {
                        view += "Pizzas with " + ingredients + ":\n";
                        doOnce = false;
                    }
                    view = printHelper(view, menuPizzas.get(i));
                }
            }
            if (ing.length == 7) {
                if (menuPizzaList.contains(ing[0]) && menuPizzaList.contains(ing[1]) && menuPizzaList.contains(ing[2]) &&
                    menuPizzaList.contains(ing[3]) && menuPizzaList.contains(ing[4]) && menuPizzaList.contains(ing[5]) &&
                    menuPizzaList.contains(ing[6]))
                {
                    if (doOnce) {
                        view += "Pizzas with " + ingredients + ":\n";
                        doOnce = false;
                    }
                    view = printHelper(view, menuPizzas.get(i));
                }
            }
        }
        //if ingredients don't match any pizza
        if(view == "" && ing.length <= 1){ //for one ingredient
            view = "There are no pizzas with "+ingredients+".\n";
        }
        if(view == "" && ing.length > 1 || ing.length > 7){ //for multiple ingredients or if there are more ingredients than is allowed (7)
            view += "There are no pizzas with ";
            for (int n = 0; n < ing.length; n++) {
                view += ing[n];
                if(n < ing.length-2) {
                    view += ", ";
                }else if(n < ing.length-1){
                    view += ", and ";
                }
            }
            view += ".\n";
        }
        System.out.println(view);
    }
    //helper function
    public String printHelper(String view, Pizza menuPizzas){
        view += "Pizza number: " + menuPizzas.getId();
        if (menuPizzas.getId() < 10) {
            view += " --- \"";
        } else {
            view += " -- \"";
        }
        view += menuPizzas.getName() + "\"\n";
        return view;
    }
}


