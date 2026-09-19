CREATE VIEW pizza_list AS
SELECT
    p.pizza_name,
    p.pizza_price,
    STRING_AGG(DISTINCT i.ingredient_name, ', ') AS ingredients,
    STRING_AGG(DISTINCT a.allergen_name, ', ') AS allergens
FROM pizza p
INNER JOIN pizza_allergen pa ON p.pizza_id = pa.pizza_allergen_pizza_id
INNER JOIN allergen a ON a.allergen_id = pa.pizza_allergen_allergen_id
INNER JOIN pizza_ingredient pi ON p.pizza_id = pi.pizza_ingredient_pizza_id
INNER JOIN ingredient i ON i.ingredient_id = pi.pizza_ingredient_ingredient_id
GROUP BY p.pizza_name, p.pizza_price;

CREATE VIEW pizza_sales AS
SELECT
    p.pizza_id,
    p.pizza_name,
    COALESCE(SUM(po.pizza_order_quantity), 0) + COALESCE(SUM(cpo.custom_pizza_order_quantity), 0) AS sales
FROM pizza p
LEFT JOIN pizza_order po ON p.pizza_id = po.pizza_order_pizza_id
LEFT JOIN custom_pizza_order cpo ON p.pizza_id = cpo.custom_pizza_order_pizza_id
GROUP BY p.pizza_id, p.pizza_name;

CREATE VIEW drink_sales AS
SELECT
    d.drink_id,
    d.drink_name,
    COALESCE(SUM(dro.drink_order_quantity), 0) AS sales
FROM drink d
LEFT JOIN drink_order dro ON dro.drink_order_drink_id = d.drink_id
GROUP BY d.drink_id, d.drink_name;

CREATE VIEW dessert_sales AS
SELECT
    d.dessert_id,
    d.dessert_name,
    COALESCE(SUM(dor.dessert_order_quantity), 0) AS sales
FROM dessert d
LEFT JOIN dessert_order dor ON dor.dessert_order_dessert_id = d.dessert_id
GROUP BY d.dessert_id, d.dessert_name;