package com.mfoumby.pizzawebsitebackend.features.pizza.data

import com.mfoumby.pizzawebsitebackend.features.pizza.data.fields.AllergenFields
import com.mfoumby.pizzawebsitebackend.features.pizza.data.fields.FullPizzaFields
import com.mfoumby.pizzawebsitebackend.features.pizza.data.fields.IngredientFields
import com.mfoumby.pizzawebsitebackend.features.pizza.data.fields.PizzaAllergenFields
import com.mfoumby.pizzawebsitebackend.features.pizza.data.fields.PizzaFields
import com.mfoumby.pizzawebsitebackend.features.pizza.data.fields.PizzaIngredientFields

fun getPizzasQuery() = """
    SELECT JSONB_AGG(
        JSONB_BUILD_OBJECT(
            '${FullPizzaFields.PIZZA}',
            JSONB_BUILD_OBJECT(
                '${PizzaFields.PIZZA_ID}', P.${PizzaFields.PIZZA_ID},
                '${PizzaFields.PIZZA_NAME}', P.${PizzaFields.PIZZA_NAME},
                '${PizzaFields.PIZZA_PRICE}', P.${PizzaFields.PIZZA_PRICE},
                '${PizzaFields.PIZZA_IMAGE_URL}', P.${PizzaFields.PIZZA_IMAGE_URL}
            ),
            '${FullPizzaFields.INGREDIENT}',
            (
                SELECT JSONB_AGG(
                    JSONB_BUILD_OBJECT(
                        '${IngredientFields.INGREDIENT_ID}', I.${IngredientFields.INGREDIENT_ID},
                        '${IngredientFields.INGREDIENT_NAME}', I.${IngredientFields.INGREDIENT_NAME},
                        '${IngredientFields.INGREDIENT_UPDATABLE}', I.${IngredientFields.INGREDIENT_UPDATABLE},
                        '${IngredientFields.INGREDIENT_STOCK_ID}', I.${IngredientFields.INGREDIENT_STOCK_ID}
                    )
                )
                FROM ${PizzaIngredientFields.TABLE_NAME} PI
                INNER JOIN ${IngredientFields.TABLE_NAME} I 
                    ON I.${IngredientFields.INGREDIENT_ID} = PI.${PizzaIngredientFields.PIZZA_INGREDIENT_INGREDIENT_ID}
                WHERE PI.${PizzaIngredientFields.PIZZA_INGREDIENT_PIZZA_ID} = P.${PizzaFields.PIZZA_ID}
            ),
            '${FullPizzaFields.ALLERGEN}',
            (
                SELECT JSONB_AGG(
                    JSONB_BUILD_OBJECT(
                        '${AllergenFields.ALLERGEN_ID}', A.${AllergenFields.ALLERGEN_ID},
                        '${AllergenFields.ALLERGEN_NAME}', A.${AllergenFields.ALLERGEN_NAME}
                    )
                )
                FROM ${PizzaAllergenFields.TABLE_NAME} PA
                INNER JOIN ${AllergenFields.TABLE_NAME} A 
                    ON A.${AllergenFields.ALLERGEN_ID} = PA.${PizzaAllergenFields.PIZZA_ALLERGEN_ALLERGEN_ID}
                WHERE PA.${PizzaAllergenFields.PIZZA_ALLERGEN_PIZZA_ID} = P.${PizzaFields.PIZZA_ID}
            )
        )
    )
    FROM ${PizzaFields.TABLE_NAME} P
""".trimIndent()