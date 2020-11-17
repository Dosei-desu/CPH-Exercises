/*
11. Select * from City and Join the Country table on countryCode.
12. Using the above join, select all cities in Europe.
13. SELECT ALL CITIES IN North America with a population greater than 1.000.000
14. Select top 10 countries (distinct), ordered by cities with the highest population. 
15. Select the total population of all cities in Australia (Hint sum(x))
16. Count how many cities in Asia that starts with the letter "A"
17. Select 10 cities ordered by lowest life expectancy
18. Select the capital of United Arab Emirates
*/
USE world;
-- 11-13: The "AS" portions aren't necessary for this to work
SELECT * FROM city AS ci JOIN country AS co ON ci.countrycode = co.code
WHERE co.continent = "North America" AND co.population > 1000000;
-- 14: "DESC" makes it in descending order
SELECT DISTINCT * FROM city AS ci JOIN country AS co ON ci.countrycode = co.code 
ORDER BY ci.population DESC LIMIT 10;
-- 15: "SUM(x)" goes into the selected group/column thingy and not at the end like I thought...
SELECT SUM(population) FROM city WHERE countrycode = "AUS";
-- 16: Same as above (cba to do AS stuff here)
SELECT COUNT(city.name) FROM city JOIN country ON city.countrycode = country.code
WHERE continent = "Asia" AND city.name LIKE "A%";
-- 17: Similar to 14, here with "ASC" for ascending order (it's default, but I just wanna be specific) and 
--     using "IS NOT NULL" to account for null values in the table
SELECT DISTINCT city.name, country.lifeExpectancy FROM city JOIN country ON city.countrycode = country.code
WHERE country.lifeExpectancy IS NOT NULL ORDER BY country.lifeExpectancy ASC LIMIT 10;
-- 18: Seems a lot easier than it is, because country.capital returns an int, which is then comparable to
--     city.id and thus the two have to be joined (again) to make that kind of search work, the SELECT 
--     specifications are not necessary, but rather just formatting to exclude a bunch of useless info
SELECT city.id, city.name, city.population FROM city JOIN country ON city.id = country.capital 
WHERE country.name = "United Arab Emirates";