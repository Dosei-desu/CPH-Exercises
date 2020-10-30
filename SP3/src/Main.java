public class Main {

    public static void main(String[] args) {
//--------Testing the code
        Menu menu = new Menu();
        menu.pizzaMenu();

        menu.viewMenu();

//--------search with pizza number
        menu.viewPizzaByID(13);
        //errors
        menu.viewPizzaByID(35); //incorrect search

//--------search with pizza name
        menu.viewPizzaByName("Alfonso Special");
        menu.viewPizzaByName("mArio"); //incorrect capitalisation (doesn't work with "==", needs ".equals()" method!)
        //errors
        menu.viewPizzaByName("Alfonso"); //incorrect search

//--------search with pizza ingredient(s) (maximum of 5 allowed, since all pizzas come with tomato and cheese)
        menu.viewPizzaByIngredients("Cheese"); //should always be correct since every pizza has cheese
        menu.viewPizzaByIngredients("Prosciutto"); //rare ingredient, but shows up multiple times
        menu.viewPizzaByIngredients("Jalapeno"); //should only return one pizza
        menu.viewPizzaByIngredients("Paprika,Garlic"); //multiple ingredients
        menu.viewPizzaByIngredients("CheEse,gARlic"); //multiple ingredients (incorrect capitalisation)
        menu.viewPizzaByIngredients("Shawarma,Chicken,Paprika,Jalapeno,Garlic,Tomato,Cheese"); //longest possible ingredient combination (for now)
        //errors
        menu.viewPizzaByIngredients("Jalapeno,Chili"); //multiple ingredients, both correct, but no combination existing
        menu.viewPizzaByIngredients("Tomato,Cheese,Shawarma,Chicken,Paprika,Jalapeno,Garlic,Chili"); //longer than intended maximum ingredient limit (7)
        menu.viewPizzaByIngredients("Squid"); //incorrect search
        menu.viewPizzaByIngredients("Humus,Copper Coins"); //incorrect search with two parameters
        menu.viewPizzaByIngredients("Humus,Copper Coins,Squid,Paper Flags,Pearls"); //incorrect search with more than two parameters
    }
}
