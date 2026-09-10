/* Get all fields and records from customer */
-- SELECT * from customer;


-- Get all fields from customer, but only if they are from Arizona
-- SELECT * from customer WHERE state = 'AZ';

-- Get all invoices older than 6 months 
/*
SELECT *
FROM invoice
WHERE invoice_date < CURRENT_DATE - INTERVAL '6 months';
*/

-- Update all customer phone numbers to NULL if they don’t follow this format: ‘+1 555 555-5555’
/*
UPDATE customer
SET phone = NULL
WHERE phone !~* '^\+1 [0-9]{3} [0-9]{3}-[0-9]{4}$';
*/

-- Get all tracks that are longer than 180000 milliseconds 
/*
SELECT * from track 
WHERE milliseconds > 180000;
*/

-- Update all customers not in the USA so that their country=USA and address, city, & state are NULL
/*
UPDATE customer
SET
    city=NULL,
    state=NULL,
    address=NULL,
    country ='USA'
WHERE country != 'USA';
*/ 

-- Given a customer_id, return their total spending across all invoices using a function 
/*
CREATE OR REPLACE FUNCTION total_spending(id INT)
RETURNS NUMERIC AS $$
DECLARE
    result NUMERIC;
BEGIN
    SELECT SUM(invoice.total) 
    INTO result
    FROM invoice
    WHERE customer_id = id;

    RETURN result;
END;
$$ LANGUAGE plpgsql;

SELECT total_spending(1);
*/


-- Given an employee_id + new_manager_id, create a stored procedure to update an Employee’s ReportsTo field.
-- -- Prevent an employee reporting to themselves, reporting to a non-existence employee, or creating a circular management relationship
/*
CREATE PROCEDURE update_manager(p_employee_id INT, p_new_manager_id INT)
LANGUAGE plpgsql
AS $$
BEGIN
    IF p_employee_id = p_new_manager_id THEN
        RAISE NOTICE 'Cannot report to yourself';

    ELSIF NOT EXISTS (
        SELECT 1 FROM employee WHERE employee_id = p_new_manager_id
    ) THEN
        RAISE NOTICE 'Cannot report to a non-existent employee';

    ELSIF EXISTS (
        WITH RECURSIVE chain AS (
            SELECT employee_id, reports_to
            FROM employee
            WHERE employee_id = p_new_manager_id
            UNION ALL
            SELECT e.employee_id, e.reports_to
            FROM employee e
            JOIN chain c ON e.employee_id = c.reports_to
        )
        SELECT 1 FROM chain WHERE employee_id = p_employee_id
    ) THEN
        RAISE NOTICE 'Cannot create a circular management relationship';

    ELSE
        UPDATE employee AS e
        SET reports_to = p_new_manager_id
        WHERE e.employee_id = p_employee_id;
    END IF;
END;
$$;
*/


-- Create a new schema: pets
-- -- Create two related tables: Customer + Pets
-- -- Demonstrate populating records into these tables
/*
CREATE SCHEMA pets;

CREATE TABLE pets.customer (
    customer_id SERIAL PRIMARY KEY,
    first_name  VARCHAR(50) NOT NULL,
    last_name   VARCHAR(50) NOT NULL,
    email       VARCHAR(100) UNIQUE
);

CREATE TABLE pets.pet (
    pet_id      SERIAL PRIMARY KEY,
    customer_id INT NOT NULL REFERENCES pets.customer(customer_id),
    name        VARCHAR(50) NOT NULL,
    species     VARCHAR(50),
    birth_date  DATE
);
INSERT INTO pets.customer (first_name, last_name, email) VALUES
    ('Jane', 'Doe', 'jane.doe@example.com'),
    ('John', 'Smith', 'john.smith@example.com');

INSERT INTO pets.pet (customer_id, name, species, birth_date) VALUES
    (1, 'Violeta', 'Dog', '2020-05-14'),
    (1, 'Peluo', 'Cat', '2019-11-02'),
    (2, 'Cacaguate', 'Dog', '2021-01-30');
*/