-- *** 1. Queries in MySQL Workbench ***
-- a. Open MySQL Workbench and create a new SQL tab (CTRL / CMD + t)
-- ^ yup ^
-- b. write "USE sakila;" at the very first line.
USE sakila;
-- c. SELECT everything from the "actor" table.
SELECT * FROM actor;
-- d. SELECT everything from the "actor" table where the last_name is "CAGE"
SELECT * FROM actor WHERE last_name = "CAGE";
-- e. SELECT everything from the "actor" table where the first_name is not "ZERO" and not "NICK"
SELECT * FROM actor WHERE first_name NOT IN ("ZERO","NICK");
-- f. SELECT everything from the "actor" table where the first_name is "NICK", "JOHNNY", "JAMES", "MORGAN", or "WHOOPI" (hint: use the "IN" keyword)
SELECT * FROM actor WHERE first_name IN ("NICK", "JOHNNY", "JAMES", "MORGAN", "WHOOPI");
-- g. SELECT all rows from the "actor" table with an actor id ranging from 50 to 150
SELECT * FROM actor WHERE actor_id >= 50 AND actor_id <= 150;
-- h. SELECT all rows from the "actor" table where first_name starts with the letter "C" (HINT: LIKE)
SELECT * FROM actor WHERE first_name LIKE "C%";
-- i. Select all rows from the "actor" table, ordered by first_name
SELECT * FROM actor ORDER BY first_name ASC;
-- j. Select all rows from the "actor" table, ordered by last_name descending
SELECT * FROM actor ORDER BY last_name DESC;
-- k. Get the count of rows in the "actor" table
SELECT COUNT(*) FROM actor;
-- l. Get the count of rows in the "actor" table with distinct first_name
SELECT COUNT(DISTINCT first_name) FROM actor;
-- m. SELECT all the horror films using the IN keyword
-- Have no idea why "IN" is suggested here, at least I don't know any way to do this without JOIN
-- Wait... is it like this?: (it's kind of weird to use IN when there's only one value in the conditional. Pretty odd task, honestly)
-- film_category.category_id = 11 is "Horror" as seen on the "Category" table
SELECT * FROM film_category WHERE category_id IN (11);
-- I did it like this, thinking you wanted the Films returned, rather than just abstract numbers
SELECT * FROM film AS f JOIN film_category AS fc ON f.film_id = fc.film_id WHERE fc.category_id = 11;
-- n. SELECT all the horror films using the AS keyword
-- ^ Like that above? ^
-- Or is it like?:
SELECT * FROM film_category AS fc WHERE fc.category_id IN (11);
-- --  -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
-- *** 2. More queries ***
-- a. INSERT a row in the "actor" table, with your own first and last name.
/*
-- commented out, so it only does it once
INSERT INTO actor (first_name, last_name) VALUES ("Kristoffer", "Pauly"); 
*/
-- b. INSERT 5 rows in the "film_actor" table, with the actor_id given to you, along with 5 film_id's of your choosing.
/*
-- commented out, so it only does it once
INSERT INTO film_actor (actor_id, film_id) VALUES (201, 5);
INSERT INTO film_actor (actor_id, film_id) VALUES (201, 117);
INSERT INTO film_actor (actor_id, film_id) VALUES (201, 150);
INSERT INTO film_actor (actor_id, film_id) VALUES (201, 336);
INSERT INTO film_actor (actor_id, film_id) VALUES (201, 429);
*/
-- c. UPDATE the first_name and last_name of the row containing your name, and set it to your newfound stage name.
/*
-- commented out, so it only does it once
UPDATE actor SET first_name = "Mistoffeles", last_name ="Bauli" WHERE actor_id = 201; 
*/
-- d. Delete the row containing your data, and give up your acting career.
/*
-- commented out, so it only does it once
-- This throws an error if you don't delete the film_actor rows, since they'd end up referecing a NULL value ...
DELETE FROM actor WHERE actor_id = 201;
*/
-- --  -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
-- ***3. JOINS***
-- a. SELECT all rows from the category table. Note what id is "Horror"
SELECT * FROM category;
-- b. SELECT all rows from the film table and join the film_category table on film_id. Then join the category table on the 
-- category ID and add a where clause to retrieve only films with the horror category_id
SELECT * FROM film
JOIN film_category ON film.film_id = film_category.film_id 
JOIN category ON category.category_id = film_category.category_id
WHERE film_category.category_id = 11;
-- ***4. JDBC***
-- In other java folder