-- Commented all the prior things out since they only need to be initiated once, but I want to save them

-- CREATE DATABASE Pizzabar;
USE Pizzabar;


/*
CREATE TABLE Pizzas(
-- Doesn't have a primary key, so it needs to be remade
	id int NOT NULL,
-- varchar length should be longest possible entry +10-20 ish, redundancy by making it too long is bad
    `name` varchar(50) NOT NULL,
-- can contain "xxx,xx kr"
    price varchar(8) NOT NULL,
-- can contain "small" / "medium" / "large" / "deep-pan" etc.
    size varchar(10) NOT NULL
);
*/
-- DROP TABLE pizzas;
/*
CREATE TABLE Pizzas(
-- Id becomes an auto-incrementing primary key
	id int NOT NULL AUTO_INCREMENT,
-- `___` escapes a word so it isn't confused with a keyword
    `name` varchar(50) NOT NULL,
    price varchar(8) NOT NULL,
    size varchar(10) NOT NULL,
    PRIMARY KEY (id)
);
-- Used to store toppings for pizzas
CREATE TABLE Toppings (
	id int NOT NULL AUTO_INCREMENT,
    `name` varchar(30) NOT NULL,
	price varchar(8) NOT NULL,
    PRIMARY KEY (id)
);
-- Used to link Toppings and Pizzas tables (it is a many-to-many relation)
CREATE TABLE pizza_recipies (
	id int NOT NULL AUTO_INCREMENT,
    pizzas_id int NOT NULL,
    toppings_id int NOT NULL,
    PRIMARY KEY (id)
);
*/
-- USING THE DATABASE --
/*
USE pizzabar;
-- INSERT INTO pizzas (id, `name`, price, size) VALUES (1, "Margherita", "51,00 kr", "Medium"); //doesn't have primary key

-- INSERT INTO Toppings (`name`, price) VALUES ("Cheese", "5,00 kr");
-- INSERT INTO Toppings (`name`, price) VALUES ("Tomato", "3,00 kr");
-- INSERT INTO Toppings (`name`, price) VALUES ("Garlic", "4,25 kr");
-- INSERT INTO Toppings (`name`, price) VALUES ("Ham", "7,00 kr");
-- INSERT INTO Toppings (`name`, price) VALUES ("Pineapple", "7,50 kr");
-- INSERT INTO Toppings (`name`, price) VALUES ("Truffle", "11,50 kr");
-- INSERT INTO Toppings (`name`, price) VALUES ("Glitter", "2,25 kr");

-- INSERT INTO pizza_recipies (pizzas_id, toppings_id) VALUES (1, 1); //adds "cheese" to "margherita" on recipes' id

-- Has primary key, so no need to define id
INSERT INTO pizzas (`name`, price, size) VALUES ("Margherita", "51,00 kr", "Medium");

-- Select name of pizzas and their topics, by using WHERE to check if the two ids contained in recipes is comparable
SELECT pizzas.`name`, toppings.`name` FROM pizzas, toppings, pizza_recipies
WHERE pizzas.id = pizza_recipies.pizzas_id AND toppings.id = pizza_recipies.toppings_id 
ORDER BY pizzas.`name` ASC;
*/