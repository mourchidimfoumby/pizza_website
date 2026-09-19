CREATE OR REPLACE FUNCTION withdrawalIngredientStockOnPizzaOrder(pizzaOrderId BIGINT) RETURNS VOID AS $$
DECLARE
    orderQuantity INT;
    ingredientQuantity INT;
    stockId BIGINT;
    done BOOLEAN DEFAULT FALSE;
    ingredientList CURSOR FOR
        SELECT pi.pizza_ingredient_quantity, i.ingredient_stock_id
        FROM pizza_order po
        INNER JOIN pizza_ingredient pi ON po.pizza_order_pizza_id = pi.pizza_ingredient_pizza_id
        INNER JOIN ingredient i ON pi.pizza_ingredient_ingredient_id = i.ingredient_id
        WHERE po.pizza_order_order_id = pizzaOrderId;

BEGIN
    SELECT po.pizza_order_quantity INTO orderQuantity
    FROM pizza_order po
    WHERE po.pizza_order_order_id = pizzaOrderId;

    OPEN ingredientList;
    LOOP
        FETCH ingredientList INTO ingredientQuantity, stockId;
        EXIT WHEN NOT FOUND;
        UPDATE stock
        SET stock_quantity = stock_quantity - (ingredientQuantity * orderQuantity)
        WHERE stock_id = stockId;
    END LOOP;
    CLOSE ingredientList;
END;
$$ LANGUAGE plpgsql;


CREATE OR REPLACE FUNCTION withdrawalIngredientStockOnCustomPizzaOrder(customPizzaOrderId BIGINT) RETURNS VOID AS $$
DECLARE
    orderQuantity INT;
    ingredientQuantity INT;
    stockId BIGINT;

BEGIN
    SELECT
        cp.custom_pizza_order_quantity,
        pi.pizza_ingredient_quantity,
        i.ingredient_stock_id
    INTO orderQuantity, ingredientQuantity, stockId
    FROM custom_pizza_order cp
    INNER JOIN pizza_ingredient pi ON cp.custom_pizza_order_ingredient_id = pi.pizza_ingredient_ingredient_id
    INNER JOIN ingredient i ON pi.pizza_ingredient_ingredient_id = i.ingredient_id
    WHERE cp.custom_pizza_order_order_id = customPizzaOrderId
    AND cp.custom_pizza_order_personalization_type_id = 1;

    UPDATE stock
    SET stock_quantity = stock_quantity - (ingredientQuantity * orderQuantity)
    WHERE stock_id = stockId;
END;
$$ LANGUAGE plpgsql;


CREATE OR REPLACE FUNCTION addIngredientStockOnCustomPizzaOrder(customPizzaOrderId BIGINT) RETURNS VOID AS $$
DECLARE
    orderQuantity INT;
    ingredientQuantity INT;
    stockId BIGINT;

BEGIN
    SELECT
        cp.custom_pizza_order_quantity,
        pi.pizza_ingredient_quantity,
        i.ingredient_stock_id
    INTO orderQuantity, ingredientQuantity, stockId
    FROM custom_pizza_order cp
    INNER JOIN pizza_ingredient pi ON cp.custom_pizza_order_ingredient_id = pi.pizza_ingredient_ingredient_id
    INNER JOIN ingredient i ON pi.pizza_ingredient_ingredient_id = i.ingredient_id
    WHERE cp.custom_pizza_order_order_id = customPizzaOrderId
    AND cp.custom_pizza_order_personalization_type_id = 2;

    UPDATE stock
    SET stock_quantity = stock_quantity + (ingredientQuantity * orderQuantity)
    WHERE stock_id = stockId;
END;
$$ LANGUAGE plpgsql;


CREATE OR REPLACE FUNCTION withdrawalDrinkStockOnDrinkOrder(drinkOrderId BIGINT) RETURNS VOID AS $$
DECLARE
    orderQuantity INT;
    drinkVolume INT;
    stockId BIGINT;

BEGIN
    SELECT
        d.drink_volume,
        d.drink_stock_id,
        dor.drink_order_quantity
    INTO drinkVolume, stockId, orderQuantity
    FROM drink_order dor
    INNER JOIN drink d ON dor.drink_order_drink_id = d.drink_id
    WHERE dor.drink_order_order_id = drinkOrderId;

    UPDATE stock
    SET stock_quantity = stock_quantity - (drinkVolume * orderQuantity)
    WHERE stock_id = stockId;
END;
$$ LANGUAGE plpgsql;


CREATE OR REPLACE FUNCTION withdrawalDessertStockOnDessertOrder(dessertOrderId BIGINT) RETURNS VOID AS $$
DECLARE
    orderQuantity INT;
    stockId BIGINT;

BEGIN
    SELECT d.dessert_stock_id, de.dessert_order_quantity INTO stockId, orderQuantity
    FROM dessert_order de
    INNER JOIN dessert d ON de.dessert_order_dessert_id = d.dessert_id
    WHERE de.dessert_order_order_id = dessertOrderId;

    UPDATE stock
    SET stock_quantity = stock_quantity - orderQuantity
    WHERE stock_id = stockId;
END;
$$ LANGUAGE plpgsql;