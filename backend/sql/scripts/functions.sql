CREATE OR REPLACE FUNCTION availablePizzaiolo() RETURNS BIGINT AS $$
DECLARE pizzaioloId BIGINT;
BEGIN
    SELECT p.pizzaiolo_id INTO pizzaioloId
    FROM pizzaiolo p
    LEFT JOIN orders o ON o.order_pizzaiolo_id = p.pizzaiolo_id
    GROUP BY p.pizzaiolo_id
    ORDER BY COUNT(o.order_pizzaiolo_id) ASC
    LIMIT 1;
    RETURN pizzaioloId;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION availableDeliveryMan() RETURNS BIGINT AS $$
DECLARE deliveryManId BIGINT;
BEGIN
    SELECT d.delivery_man_id INTO deliveryManId
    FROM delivery_man d
    LEFT JOIN orders o ON o.order_delivery_man_id = d.delivery_man_id
    GROUP BY d.delivery_man_id
    ORDER BY COUNT(o.order_delivery_man_id) ASC
    LIMIT 1;
    RETURN deliveryManId;
END;
$$ LANGUAGE plpgsql;
