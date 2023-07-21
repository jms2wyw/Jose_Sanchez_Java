Use northwind;
-- List all the different products
SELECT category
FROM products;

-- List all products made by dell
SELECT *
FROM products
WHERE product_name = "Dell Inspirion";

-- List all orders shipped to Pennsylvanis
SELECT *
FROM orders
WHERE ship_state = "Pennsylvania";

-- List all employees by first name and last name that have last name that starts with w
SELECT first_name, last_name
FROM employees
WHERE last_name
LIKE 'W%';

-- List all customers with the zip codes that start with 55
SELECT *
FROM customers
WHERE postal_code
LIKE '55%';

-- List all customers with zip codes that end with 0
SELECT *
FROM customers
WHERE postal_code
LIKE '%0';

-- List by first, last name and email with customers that have emails that end in '.org'
SELECT first_name, last_name, email
FROM customers
WHERE email
LIKE '%.org';

-- List all customers by first,last name and phone number that has the area code 202
SELECT first_name, last_name, phone
FROM customers
WHERE phone
LIKE "1-(202%";

-- List all customers by first, last name and phone number that is int he area code 202 and is ordered by last name 
SELECT first_name, last_name, phone
FROM customers
WHERE phone
LIKE "1-(202%"
ORDER BY last_name, first_name;

