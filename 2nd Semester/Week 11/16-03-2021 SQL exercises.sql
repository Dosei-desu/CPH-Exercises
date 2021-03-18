USE classicmodels;
/*
    4 Find all the French customers
    5 Find first name and last name on employees with the title ”sales rep”
    6 Find name and description of the motorcycle models that cost between 50$ and 100$
    7 Find the customer numbers for the orders that have been cancelled
    8 Find product lines and vendor for products with size 1:18
*/

SELECT * FROM customers WHERE country = 'France';
SELECT firstName, lastName FROM employees WHERE jobTitle = "sales rep";
SELECT productName, productDescription, MSRP FROM products WHERE productLine = "Motorcycles" and MSRP between 50 and 100;
SELECT customerNumber FROM orders WHERE status = "cancelled";
SELECT productLine, productVendor FROM products WHERE productScale = "1:18" ORDER BY productVendor ASC;

/*
    9 List all the motorcycles sorted by product name
    10 List models with less than 1000 in stock sorted by quantity in stock with highest quantity at the top of the list
    11 List the Norwegian customers’ customer name and contact person sorted by the contact person’s first name
*/

SELECT * FROM products WHERE productLine = "Motorcycles" ORDER BY productName;
SELECT * FROM products WHERE quantityInStock < 1000 ORDER BY quantityInStock DESC;
SELECT customerName, contactFirstName, contactLastName FROM customers WHERE country = 'Norway' ORDER BY contactFirstName;

/*
    12 How many German customers are there?
    13 What is the average price for classic car models?
    14 What is the price of the most expensive model from ‘Autoart Studio Design’?
    15 How many different countries do the customers come from?
    16 What is the quantity in stock for 1:12 models?
    17 What is the highest profit amongst the products?
*/

SELECT COUNT(*) as number_of_german_customers FROM customers WHERE country = 'Germany';
SELECT AVG(buyPrice) as average_price FROM products WHERE productLine = 'Classic Cars';
SELECT MAX(buyPrice) as most_expensive_model, productName FROM products WHERE productVendor = 'Autoart Studio Design';
SELECT SUM(quantityInStock) FROM products WHERE productScale = '1:12';
SELECT MAX(MSRP - buyPrice) FROM products;

/*
    18 What is the average price for each product line?
    19 How many different products does each vendor have?
    20 What is the profit percentage wise based on product scale?
    21 How many orders exist for each order status type?
    22 How many orders do each customer have?
*/

SELECT AVG(buyPrice), productLine FROM products GROUP BY productLine;
SELECT COUNT(productName), productVendor FROM products GROUP BY productVendor;
SELECT AVG((MSRP-buyPrice)/buyPrice*100), productScale FROM products GROUP BY productScale;
SELECT `status`, COUNT(*) FROM orders GROUP BY `status`;
SELECT customerNumber, COUNT(*) FROM orders GROUP BY customerNumber;