-- 1. Get all invoice ids with the customers first name, last name, and the invoice total

SELECT i.invoice_id, c.first_name, c.last_name, i.total
FROM invoice as i
INNER JOIN customer AS c
on i.customer_id = c.customer_id;


-- 2. Print the invoice id, customer's first name, and invoice total. But only if the invoice is over $30.


SELECT i.invoice_id, c.first_name, i.total
FROM invoice as i
INNER JOIN customer AS c
on i.customer_id = c.customer_id
WHERE i.total > 30;

-- 3. Get all the invoices for USA customers in the last 6 months. Use a CTE. 


WITH us_customers AS (
    SELECT c1.customer_id
    FROM customer AS c1
    WHERE c1.country = 'USA'
), last_invoices AS (
    SELECT i1.invoice_id 
    FROM invoice as i1
    WHERE i1.invoice_date > CURRENT_DATE - INTERVAL '6 months'
)
SELECT i.invoice_id, i.total
FROM invoice AS i
WHERE i.customer_id IN (
    SELECT customer_id from us_customers
)
AND i.invoice_id IN (SELECT invoice_id from last_invoices );

-- 4. Create a new table called record_logs
-- -- Fields: log_id, record_id, field_changed, last_update, old_value, new_value


CREATE TABLE IF NOT EXISTS record_logs (
    log_id SERIAL PRIMARY KEY,
    record_id INTEGER NOT NULL,
    field_changed VARCHAR(50),
    last_update TIMESTAMP,
    old_value VARCHAR(50) NOT NULL,
    new_value VARCHAR(50) NOT NULL
);

-- 5. Create a trigger that tracks changes to customer records and logs the changes in our new table
CREATE OR REPLACE FUNCTION log_customer_table_change()
RETURNS TRIGGER
LANGUAGE plpgsql 
AS $$
BEGIN
    INSERT INTO record_logs(record_id, field_changed, last_update, old_value, new_value)
    VALUES (NEW.customer_id,'first_name' , NOW(), OLD.first_name, NEW.first_name);
    RETURN NEW; 
END;
$$;

CREATE TRIGGER trg_log_customer_change
AFTER UPDATE ON customer
FOR EACH ROW
EXECUTE FUNCTION log_customer_table_change();