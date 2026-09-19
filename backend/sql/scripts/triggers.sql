CREATE OR REPLACE FUNCTION add_threshold_stock_alert_function() RETURNS TRIGGER AS $$
BEGIN
    IF NEW.stock_quantity < NEW.stock_threshold THEN
        INSERT INTO stock_alert(
            stock_alert_message,
            stock_alert_date,
            stock_alert_stock_id
        )
        VALUES(
            'Le seuil minimal a été dépassé',
            CURRENT_TIMESTAMP,
            OLD.stock_id
        );
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER add_threshold_stock_alert
    AFTER UPDATE ON stock
    FOR EACH ROW
    EXECUTE FUNCTION add_threshold_stock_alert_function();


CREATE OR REPLACE FUNCTION delete_threshold_stock_alert_function() RETURNS TRIGGER AS $$
BEGIN
    IF NEW.stock_quantity > NEW.stock_threshold THEN
        DELETE FROM stock_alert
        WHERE stock_alert_stock_id = NEW.stock_id;
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER delete_threshold_stock_alert
    AFTER UPDATE ON stock
    FOR EACH ROW
    EXECUTE FUNCTION delete_threshold_stock_alert_function();


CREATE OR REPLACE FUNCTION assign_pizzaiolo_to_order_function() RETURNS TRIGGER AS $$
DECLARE pizzaioloId INT;
BEGIN
    pizzaioloId := availablePizzaiolo();
    NEW.order_pizzaiolo_id := pizzaioloId;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER assign_pizzaiolo_to_order
    BEFORE INSERT ON orders
    FOR EACH ROW
    EXECUTE FUNCTION assign_pizzaiolo_to_order_function();


CREATE OR REPLACE FUNCTION assign_delivery_man_to_order_function() RETURNS TRIGGER AS $$
DECLARE deliveryManId INT;
BEGIN
    IF NEW.order_state_id = 2 THEN
        deliveryManId := availableDeliveryMan();
        NEW.order_delivery_man_id := deliveryManId;
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER assign_delivery_man_to_order
    BEFORE UPDATE ON orders
    FOR EACH ROW
    EXECUTE FUNCTION assign_delivery_man_to_order_function();


CREATE OR REPLACE FUNCTION withdrawal_ingredient_stock_on_pizza_order_function() RETURNS TRIGGER AS $$
BEGIN
    PERFORM withdrawalIngredientStockOnPizzaOrder(NEW.pizza_order_pizza_id);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER withdrawal_ingredient_stock_on_pizza_order
    AFTER INSERT ON pizza_order
    FOR EACH ROW
    EXECUTE FUNCTION withdrawal_ingredient_stock_on_pizza_order_function();


CREATE OR REPLACE FUNCTION withdrawal_ingredient_stock_on_custom_pizza_order_function() RETURNS TRIGGER AS $$
BEGIN
    IF NEW.custom_pizza_order_personalization_type_id = 2 THEN
        PERFORM withdrawalIngredientStockOnCustomPizzaOrder(NEW.custom_pizza_order_order_id);
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER withdrawal_ingredient_stock_on_custom_pizza_order
    AFTER INSERT ON custom_pizza_order
    FOR EACH ROW
    EXECUTE FUNCTION withdrawal_ingredient_stock_on_custom_pizza_order_function();


CREATE OR REPLACE FUNCTION add_ingredient_stock_on_custom_pizza_order_function() RETURNS TRIGGER AS $$
BEGIN
    IF NEW.custom_pizza_order_personalization_type_id = 1 THEN
        PERFORM addIngredientStockOnCustomPizzaOrder(NEW.custom_pizza_order_order_id);
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER add_ingredient_stock_on_custom_pizza_order
    AFTER INSERT ON custom_pizza_order
    FOR EACH ROW
    EXECUTE FUNCTION add_ingredient_stock_on_custom_pizza_order_function();


CREATE OR REPLACE FUNCTION withdrawal_drink_stock_on_drink_order_function() RETURNS TRIGGER AS $$
BEGIN
    PERFORM withdrawalDrinkStockOnDrinkOrder(NEW.drink_order_order_id);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER withdrawal_drink_stock_on_drink_order
    AFTER INSERT ON drink_order
    FOR EACH ROW
    EXECUTE FUNCTION withdrawal_drink_stock_on_drink_order_function();


CREATE OR REPLACE FUNCTION withdrawal_dessert_stock_on_dessert_order_function() RETURNS TRIGGER AS $$
BEGIN
    PERFORM withdrawalDessertStockOnDessertOrder(NEW.dessert_order_order_id);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER withdrawal_dessert_stock_on_dessert_order
    AFTER INSERT ON dessert_order
    FOR EACH ROW
    EXECUTE FUNCTION withdrawal_dessert_stock_on_dessert_order_function();


CREATE OR REPLACE FUNCTION add_customer_discount_for_late_delivery_function() RETURNS TRIGGER AS $$
BEGIN
    IF NEW.order_state_id = 4 THEN
        UPDATE users
        SET user_discount = 1
        WHERE user_id = NEW.order_user_id;
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER add_customer_discount_for_late_delivery
    AFTER UPDATE ON orders
    FOR EACH ROW
    EXECUTE FUNCTION add_customer_discount_for_late_delivery_function();


CREATE OR REPLACE FUNCTION apply_customer_discount_on_order_function() RETURNS TRIGGER AS $$
DECLARE haveDiscount INT;
BEGIN
    SELECT user_discount
    INTO haveDiscount
    FROM users
    WHERE user_id = NEW.order_user_id;

    IF haveDiscount = 1 THEN
        NEW.order_total_price := NEW.order_total_price * 0.8;
        UPDATE users
        SET user_discount = 0
        WHERE user_id = NEW.order_user_id;
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER apply_customer_discount_on_order
    BEFORE INSERT ON orders
    FOR EACH ROW
    EXECUTE FUNCTION apply_customer_discount_on_order_function();