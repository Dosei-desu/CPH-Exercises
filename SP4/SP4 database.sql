-- CREATE DATABSE marios_pizzabar;
USE marios_pizzabar;

/*
CREATE TABLE Order_history(
-- Id becomes an auto-incrementing primary key
	id int NOT NULL AUTO_INCREMENT,
-- timestamp
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,`pizza_ingredients (old)`
-- unique id for customer
	unique_id varchar(4) NOT NULL,
	delivered BOOLEAN NOT NULL,
-- whether it is order by phone or not
    remote BOOLEAN NOT NULL,
-- pizza order
	pizza_id varchar(4) NOT NULL,
    `name` varchar(50) NOT NULL,
    ingredients varchar(85) NOT NULL,
    price varchar(8) NOT NULL,
-- customer
	customer varchar(50) NOT NULL, 
	phone_number varchar(20) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO order_history (unique_id, delivered, remote, pizza_id, `name`, ingredients, price, customer, phone_number) 
VALUES ("01", TRUE, TRUE, "29", "Margherita", "Tomato, and Cheese","53.0","Kris","666");
*/
/*
CREATE TABLE Pizza(
-- Id becomes an auto-incrementing primary key
	id int NOT NULL AUTO_INCREMENT,
-- `___` escapes a word so it isn't confused with a keyword
    `name` varchar(50) NOT NULL,
    ingredients varchar(85) NOT NULL,
    price varchar(5) NOT NULL,
    PRIMARY KEY (id)
);
*/
/*
-- OLD
CREATE TABLE Pizzas(
-- Id becomes an auto-incrementing primary key
	id int NOT NULL AUTO_INCREMENT,
-- `___` escapes a word so it isn't confused with a keyword
    `name` varchar(50) NOT NULL,
    price varchar(5) NOT NULL,
    PRIMARY KEY (id)
);
*/
/*
-- OLD
-- Used to store ingredients for pizzas
CREATE TABLE Ingredients (
	id int NOT NULL AUTO_INCREMENT,
    `name` varchar(30) NOT NULL,
    PRIMARY KEY (id)
);
*/
/*
-- OLD
-- Used to link Ingredients and Pizzas tables (it is a many-to-many relation)
CREATE TABLE Pizza_ingredients (
	id int NOT NULL AUTO_INCREMENT,
    pizzas_id int NOT NULL,
    toppings_id int NOT NULL,
    PRIMARY KEY (id)
);
*/
/*
-- OLD
CREATE TABLE Order_history(
-- Id becomes an auto-incrementing primary key
	id int NOT NULL AUTO_INCREMENT,
-- `___` escapes a word so it isn't confused with a keyword
    `name` varchar(50) NOT NULL,
    price varchar(8) NOT NULL,
    `time` TIMESTAMP NOT NULL,
    PRIMARY KEY (id)
);
*/
/*
//Pizza menu implementation (old)
INSERT INTO pizzas (`name`, price) VALUES ("Pepe",61.0);
INSERT INTO pizzas (`name`, price) VALUES ("Mario",64.0);
INSERT INTO pizzas (`name`, price) VALUES ("Alfonso Special",64.0); 
INSERT INTO pizzas (`name`, price) VALUES ("Vesuvio",61.0); 
INSERT INTO pizzas (`name`, price) VALUES ("Capricciosa",65.0); 
INSERT INTO pizzas (`name`, price) VALUES ("Quatro",67.0); 
INSERT INTO pizzas (`name`, price) VALUES ("Delizia",67.0); 
INSERT INTO pizzas (`name`, price) VALUES ("Hawaii",65.0); 
INSERT INTO pizzas (`name`, price) VALUES ("Bacone",72.0); 
INSERT INTO pizzas (`name`, price) VALUES ("Milano",70.0); 
INSERT INTO pizzas (`name`, price) VALUES ("Balkoni",61.0); 
INSERT INTO pizzas (`name`, price) VALUES ("O Solo Mio",72.0); 
INSERT INTO pizzas (`name`, price) VALUES ("Bari",67.0); 
INSERT INTO pizzas (`name`, price) VALUES ("Vegetariana",72.0); 
INSERT INTO pizzas (`name`, price) VALUES ("Torino",70.0); 
INSERT INTO pizzas (`name`, price) VALUES ("Venicia",70.0); 
INSERT INTO pizzas (`name`, price) VALUES ("Samos",70.0); 
INSERT INTO pizzas (`name`, price) VALUES ("Roma",72.0); 
INSERT INTO pizzas (`name`, price) VALUES ("Prince",69.0); 
INSERT INTO pizzas (`name`, price) VALUES ("Italiano",65.0); 
INSERT INTO pizzas (`name`, price) VALUES ("Gorgonzola",67.0); 
INSERT INTO pizzas (`name`, price) VALUES ("Parma",72.0); 
INSERT INTO pizzas (`name`, price) VALUES ("Mafioso",69.0); 
INSERT INTO pizzas (`name`, price) VALUES ("Speciale",70.0); 
INSERT INTO pizzas (`name`, price) VALUES ("Siciliana",72.0); 
INSERT INTO pizzas (`name`, price) VALUES ("Messi",67.0); 
INSERT INTO pizzas (`name`, price) VALUES ("Juventus",69.0); 
INSERT INTO pizzas (`name`, price) VALUES ("Pollo",69.0); 
INSERT INTO pizzas (`name`, price) VALUES ("Margherita",53.0); 
INSERT INTO pizzas (`name`, price) VALUES ("Opera",67.0); 
INSERT INTO pizzas (`name`, price) VALUES ("Baron",70.0); 
INSERT INTO pizzas (`name`, price) VALUES ("Forza",69.0); 
INSERT INTO pizzas (`name`, price) VALUES ("Maldini",72.0); 
INSERT INTO pizzas (`name`, price) VALUES ("Matador",73.0); 
INSERT INTO pizzas (`name`, price) VALUES ("The Kirby",69.0); 
INSERT INTO pizzas (`name`, price) VALUES ("Unicorn",77.0); 
INSERT INTO pizzas (`name`, price) VALUES ("Jack O' Lantern",66.0); 

//Pizza menu implementation (new)
INSERT INTO pizza (`name`, ingredients, price) VALUES ("Pepe","Tomato,Cheese,Pepperoni",61.0);
INSERT INTO pizza (`name`, ingredients, price) VALUES ("Mario","Tomato,Cheese,Shawarma,Creme Fraiche,Chili",64.0);
INSERT INTO pizza (`name`, ingredients, price) VALUES ("Alfonso Special","Tomato,Cheese,Minced Beef,Onion,Chili",64.0); 
INSERT INTO pizza (`name`, ingredients, price) VALUES ("Vesuvio","Tomato,Cheese,Ham",61.0); 
INSERT INTO pizza (`name`, ingredients, price) VALUES ("Capricciosa","Tomato,Cheese,Ham,Mushroom",65.0); 
INSERT INTO pizza (`name`, ingredients, price) VALUES ("Quatro","Tomato,Cheese,Ham,Pepperoni",67.0); 
INSERT INTO pizza (`name`, ingredients, price) VALUES ("Delizia","Tomato,Cheese,Pepperoni,Paprika,Onion",67.0); 
INSERT INTO pizza (`name`, ingredients, price) VALUES ("Hawaii","Tomato,Cheese,Ham,Pineapple",65.0); 
INSERT INTO pizza (`name`, ingredients, price) VALUES ("Bacone","Tomato,Cheese,Ham,Pepperoni,Bacon",72.0); 
INSERT INTO pizza (`name`, ingredients, price) VALUES ("Milano","Tomato,Cheese,Ham,Meat Sauce",70.0); 
INSERT INTO pizza (`name`, ingredients, price) VALUES ("Balkoni","Tomato,Cheese,Ham,Bacon,Egg",61.0); 
INSERT INTO pizza (`name`, ingredients, price) VALUES ("O Solo Mio","Tomato,Cheese,Ham,Bacon,Cocktail Shrimp",72.0); 
INSERT INTO pizza (`name`, ingredients, price) VALUES ("Bari","Tomato,Cheese,Beef Sauce,Mushroom,Sliced Tomato",67.0); 
INSERT INTO pizza (`name`, ingredients, price) VALUES ("Vegetariana","Tomato,Cheese,Mushroom,Onion,Paprika,Pineapple",72.0); 
INSERT INTO pizza (`name`, ingredients, price) VALUES ("Torino","Tomato,Cheese,Shawarma,Mushroom,Onion",70.0); 
INSERT INTO pizza (`name`, ingredients, price) VALUES ("Venicia","Tomato,Cheese,Shawarma,Mushroom,Gorgonzola",70.0); 
INSERT INTO pizza (`name`, ingredients, price) VALUES ("Samos","Tomato,Cheese,Minced Beef,Mushroom,Chili",70.0); 
INSERT INTO pizza (`name`, ingredients, price) VALUES ("Roma","Tomato,Cheese,Meat Strips,Mushroom,Paprika,Garlic",72.0); 
INSERT INTO pizza (`name`, ingredients, price) VALUES ("Prince","Tomato,Cheese,Minced Beef,Pepperoni,Bacon,Onion",69.0); 
INSERT INTO pizza (`name`, ingredients, price) VALUES ("Italiano","Tomato,Cheese,Meat Sauce,Onion",65.0); 
INSERT INTO pizza (`name`, ingredients, price) VALUES ("Gorgonzola","Tomato,Cheese,Gorgonzola,Mushroom,Onion",67.0); 
INSERT INTO pizza (`name`, ingredients, price) VALUES ("Parma","Tomato,Cheese,Prosciutto,Mushroom,Gorgonzola",72.0); 
INSERT INTO pizza (`name`, ingredients, price) VALUES ("Mafioso","Tomato,Cheese,Prosciutto,Artichoke,Garlic",69.0); 
INSERT INTO pizza (`name`, ingredients, price) VALUES ("Speciale","Tomato,Cheese,Shawarma,Chicken,Paprika,Jalapeno,Garlic",70.0); 
INSERT INTO pizza (`name`, ingredients, price) VALUES ("Siciliana","Tomato,Cheese,Shawarma,Bacon,Pepperoni,Paprika",72.0); 
INSERT INTO pizza (`name`, ingredients, price) VALUES ("Messi","Tomato,Cheese,Chicken,Bacon,Curry Powder",67.0); 
INSERT INTO pizza (`name`, ingredients, price) VALUES ("Juventus","Tomato,Cheese,Chicken,Bacon,Egg",69.0); 
INSERT INTO pizza (`name`, ingredients, price) VALUES ("Pollo","Tomato,Cheese,Chicken,Mushroom,Paprika",69.0); 
INSERT INTO pizza (`name`, ingredients, price) VALUES ("Margherita","Tomato,Cheese",53.0); 
INSERT INTO pizza (`name`, ingredients, price) VALUES ("Opera","Tomato,Cheese,Pepperoni,Mushroom",67.0); 
INSERT INTO pizza (`name`, ingredients, price) VALUES ("Baron","Tomato,Cheese,Meat Strips,Pepperoni,Garlic",70.0); 
INSERT INTO pizza (`name`, ingredients, price) VALUES ("Forza","Tomato,Cheese,Shawarma,Onion,Bearnaise Sauce",69.0); 
INSERT INTO pizza (`name`, ingredients, price) VALUES ("Maldini","Tomato,Cheese,Shawarma,Chicken,Pepperoni,Onion",72.0); 
INSERT INTO pizza (`name`, ingredients, price) VALUES ("Matador","Tomato,Cheese,Beef,Mushroom,Onion,Bearnaise Sauce",73.0); 
INSERT INTO pizza (`name`, ingredients, price) VALUES ("The Kirby","Cheese,Gouda,Gorgonzola,Camembert,Emmentaler,Cream Cheese,Blue Cheese",69.0); 
INSERT INTO pizza (`name`, ingredients, price) VALUES ("Unicorn","Glitter,Orphan Tears,Fairy Dust,Skittles",77.0); 
INSERT INTO pizza (`name`, ingredients, price) VALUES ("Jack O' Lantern","Pumpkin,A Stephen King Novel,The Ring DVD,Lit Candles,Canned Farts",66.0); 
*/
/*
//Pizza ingredients implementation
INSERT INTO ingredients (`name`) VALUES ("Tomato");
INSERT INTO ingredients (`name`) VALUES ("Cheese");
INSERT INTO ingredients (`name`) VALUES ("Pepperoni");
INSERT INTO ingredients (`name`) VALUES ("Shawarma");
INSERT INTO ingredients (`name`) VALUES ("Creme Fraiche");
INSERT INTO ingredients (`name`) VALUES ("Chili");
INSERT INTO ingredients (`name`) VALUES ("Minced Beef");
INSERT INTO ingredients (`name`) VALUES ("Onion");
INSERT INTO ingredients (`name`) VALUES ("Ham");
INSERT INTO ingredients (`name`) VALUES ("Mushroom");
INSERT INTO ingredients (`name`) VALUES ("Paprika");
INSERT INTO ingredients (`name`) VALUES ("Pineapple");
INSERT INTO ingredients (`name`) VALUES ("Bacon");
INSERT INTO ingredients (`name`) VALUES ("Meat Sauce");
INSERT INTO ingredients (`name`) VALUES ("Egg");
INSERT INTO ingredients (`name`) VALUES ("Cocktail Shrimp");
INSERT INTO ingredients (`name`) VALUES ("Cheese");
INSERT INTO ingredients (`name`) VALUES ("Beef Sauce");
INSERT INTO ingredients (`name`) VALUES ("Sliced Tomato");
INSERT INTO ingredients (`name`) VALUES ("Gorgonzola");
INSERT INTO ingredients (`name`) VALUES ("Meat Strips");
INSERT INTO ingredients (`name`) VALUES ("Garlic");
INSERT INTO ingredients (`name`) VALUES ("Prosciutto");
INSERT INTO ingredients (`name`) VALUES ("Artichoke");
INSERT INTO ingredients (`name`) VALUES ("Chicken");
INSERT INTO ingredients (`name`) VALUES ("Jalapeno");
INSERT INTO ingredients (`name`) VALUES ("Curry Powder");
INSERT INTO ingredients (`name`) VALUES ("Bearnaise Sauce");
INSERT INTO ingredients (`name`) VALUES ("Gouda");
INSERT INTO ingredients (`name`) VALUES ("Camembert");
INSERT INTO ingredients (`name`) VALUES ("Emmentaler");
INSERT INTO ingredients (`name`) VALUES ("Cream Cheese");
INSERT INTO ingredients (`name`) VALUES ("Blue Cheese");
INSERT INTO ingredients (`name`) VALUES ("Glitter");
INSERT INTO ingredients (`name`) VALUES ("Orphan Tears");
INSERT INTO ingredients (`name`) VALUES ("Fairy Dust");
INSERT INTO ingredients (`name`) VALUES ("Skittles");
INSERT INTO ingredients (`name`) VALUES ("Pumpkin");
INSERT INTO ingredients (`name`) VALUES ("A Stephen King Novel");
INSERT INTO ingredients (`name`) VALUES ("The Ring DVD");
INSERT INTO ingredients (`name`) VALUES ("Lit Candles");
INSERT INTO ingredients (`name`) VALUES ("Canned Farts");
*/
/*
-- Pizza_ingredients link list (need to save it here, because I might accidentally delete it again....)
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (1, 1);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (1, 2);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (1, 3);

INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (2, 1);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (2, 2);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (2, 4);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (2, 5);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (2, 6);

INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (3, 1);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (3, 2);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (3, 7);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (3, 8);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (3, 6);

INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (4, 1);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (4, 2);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (4, 9);

INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (5, 1);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (5, 2);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (5, 9);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (5, 10);

INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (6, 1);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (6, 2);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (6, 9);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (6, 3);

INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (7, 1);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (7, 2);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (7, 3);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (7, 11);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (7, 8);

INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (8, 1);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (8, 2);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (8, 9);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (8, 12);

INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (9, 1);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (9, 2);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (9, 9);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (9, 3);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (9, 13);

INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (10, 1);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (10, 2);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (10, 9);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (10, 14);

INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (11, 1);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (11, 2);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (11, 3);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (11, 13);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (11, 15);

INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (12, 1);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (12, 2);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (12, 9);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (12, 13);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (12, 16);

INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (13, 1);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (13, 2);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (13, 18);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (13, 10);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (13, 19);

INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (14, 1);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (14, 2);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (14, 10);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (14, 8);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (14, 11);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (14, 12);

INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (15, 1);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (15, 2);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (15, 4);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (15, 10);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (15, 8);

INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (16, 1);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (16, 2);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (16, 4);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (16, 10);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (16, 20);

INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (17, 1);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (17, 2);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (17, 7);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (17, 10);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (17, 6);

INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (18, 1);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (18, 2);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (18, 21);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (18, 10);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (18, 11);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (18, 22);

INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (19, 1);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (19, 2);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (19, 7);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (19, 3);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (19, 13);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (19, 8);

INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (20, 1);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (20, 2);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (20, 14);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (20, 8);

INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (21, 1);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (21, 2);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (21, 20);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (21, 10);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (21, 8);

INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (22, 1);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (22, 2);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (22, 23);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (22, 10);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (22, 20);

INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (23, 1);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (23, 2);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (23, 23);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (23, 24);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (23, 22);

INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (24, 1);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (24, 2);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (24, 4);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (24, 25);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (24, 11);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (24, 26);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (24, 22);

INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (25, 1);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (25, 2);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (25, 4);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (25, 13);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (25, 3);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (25, 11);

INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (26, 1);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (26, 2);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (26, 25);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (26, 13);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (26, 27);

INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (27, 1);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (27, 2);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (27, 25);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (27, 13);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (27, 15);

INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (28, 1);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (28, 2);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (28, 25);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (28, 10);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (28, 11);

INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (29, 1);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (29, 2);

INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (30, 1);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (30, 2);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (30, 3);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (30, 10);

INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (31, 1);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (31, 2);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (31, 21);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (31, 3);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (31, 22);

INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (32, 1);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (32, 2);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (32, 4);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (32, 8);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (32, 28);

INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (33, 1);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (33, 2);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (33, 4);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (33, 25);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (33, 3);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (33, 8);

INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (34, 1);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (34, 2);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (34, 43);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (34, 10);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (34, 8);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (34, 28);

INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (35, 2);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (35, 29);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (35, 20);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (35, 30);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (35, 31);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (35, 32);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (35, 33);

INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (36, 34);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (36, 35);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (36, 36);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (36, 37);

INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (37, 38);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (37, 39);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (37, 40);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (37, 41);
INSERT INTO pizza_ingredients (pizzas_id, toppings_id) VALUES (37, 42);
*/
