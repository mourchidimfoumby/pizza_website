INSERT INTO user_role (
    user_role_id,
    user_role_name
)
VALUES
    (1, 'User'),
    (2, 'Admin');

INSERT INTO users (
    user_id,
    user_last_name,
    user_first_name,
    user_email,
    user_password,
    user_phone_number,
    user_address,
    user_role_id
)
VALUES
    (1, 'Girard', 'Sophie', 'sophie.girard@email.com', 'motdepasse1', '1234567890', '123 Rue Principale', 1),
    (2, 'Lefevre', 'Pierre', 'pierre.lefevre@email.com', 'motdepasse2', '2345678901', '456 Avenue Sainte-Catherine', 1),
    (3, 'Martin', 'Catherine', 'catherine.martin@email.com', 'motdepasse3', '3456789012', '789 Boulevard René-Lévesque', 1),
    (4, 'Tremblay', 'Luc', 'luc.tremblay@email.com', 'motdepasse4', '4567890123', '987 Rue Sherbrooke', 1),
    (5, 'Dubois', 'Valérie', 'valerie.dubois@email.com', 'motdepasse5', '5678901234', '654 Avenue Laurier', 1),
    (6, 'Gagnon', 'David', 'david.gagnon@email.com', 'motdepasse6', '6789012345', '321 Rue Ontario', 1),
    (7, 'Beaulieu', 'Isabelle', 'isabelle.beaulieu@email.com', 'motdepasse7', '7890123456', '876 Boulevard de Maisonneuve', 1),
    (8, 'Roy', 'Sébastien', 'sebastien.roy@email.com', 'motdepasse8', '8901234567', '543 Avenue Papineau', 1),
    (9, 'Pelletier', 'Amélie', 'amelie.pelletier@email.com', 'motdepasse9', '9012345678', '2100 Rue de la Montagne', 1),
    (10, 'Lavoie', 'Claude', 'claude.lavoie@email.com', 'motdepasse10', '1234509876', '4567 Rue Peel', 1),
    (11, 'Gauthier', 'Nathalie', 'nathalie.gauthier@email.com', 'motdepasse11', '2345098765', '765 Rue Notre-Dame', 1),
    (12, 'Fortin', 'Éric', 'eric.fortin@email.com', 'motdepasse12', '3450987654', '8765 Rue Saint-Hubert', 1),
    (13, 'Boucher', 'Julie', 'julie.boucher@email.com', 'motdepasse13', '4569876543', '5432 Boulevard Saint-Laurent', 1),
    (14, 'Bélanger', 'Mathieu', 'mathieu.belanger@email.com', 'motdepasse14', '5678765432', '8765 Avenue du Mont-Royal', 1),
    (15, 'Fournier', 'Valérie', 'valerie.fournier@email.com', 'motdepasse15', '6787654321', '1234 Rue Saint-Denis', 1),
    (16, 'Leclerc', 'Émilie', 'emilie.leclerc@email.com', 'motdepasse16', '7896543210', '5678 Avenue Mont-Royal', 1),
    (17, 'Moreau', 'Sylvain', 'sylvain.moreau@email.com', 'motdepasse17', '8765432109', '9876 Rue Sainte-Catherine', 1),
    (18, 'Roux', 'Caroline', 'caroline.roux@email.com', 'motdepasse18', '9876543210', '3210 Boulevard de l''Acadie', 1),
    (19, 'Gagnon', 'Olivier', 'olivier.gagnon@email.com', 'motdepasse19', '1098765432', '6543 Rue Beaubien', 1),
    (20, 'Leroux', 'Marie', 'marie.leroux@email.com', 'motdepasse20', '2109876543', '7890 Avenue des Pins', 1),
    (21, 'Boucher', 'Alexandre', 'alexandre.boucher@email.com', 'motdepasse21', '3210987654', '4321 Boulevard Saint-Joseph', 1),
    (22, 'Martin', 'Émilie', 'emilie.martin@email.com', 'motdepasse22', '4321098765', '5678 Rue Rachel', 1),
    (23, 'Girard', 'Sébastien', 'sebastien.girard@email.com', 'motdepasse23', '5432109876', '8765 Avenue Laurier', 1),
    (24, 'Lefevre', 'Nathalie', 'nathalie.lefevre@email.com', 'motdepasse24', '6543210987', '9876 Rue de la Roche', 1),
    (25, 'Beaulieu', 'Nicolas', 'nicolas.beaulieu@email.com', 'motdepasse25', '7654321098', '1098 Rue du Parc', 1),
    (26, 'Fortin', 'Marie', 'marie.fortin@email.com', 'motdepasse26', '8765432109', '2109 Avenue des Érables', 1),
    (27, 'Caron', 'François', 'francois.caron@email.com', 'motdepasse27', '9876543210', '3210 Rue Berri', 1),
    (28, 'Blanchard', 'Jessica', 'jessica.blanchard@email.com', 'motdepasse28', '2109876543', '5432 Avenue des Pins', 1),
    (29, 'Couture', 'Étienne', 'etienne.couture@email.com', 'motdepasse29', '5432109876', '8765 Rue Saint-Denis', 1),
    (30, 'Dufour', 'Julia', 'julia.dufour@email.com', 'motdepasse30', '6543210987', '96 Avenue Mont-Royal', 1),
    (31, 'Boucher', 'Patrick', 'patrick.boucher@admin.com', '123456789', '6543210987', '98 Avenue Mont-Royal', 2),
    (32, 'Adams', 'Gomez', 'gomez.adams@admin.com', 'azertyuiop', '6543210987', '6 Avenue Mont-Royal', 2),
    (33, 'Leonard', 'Lenny', 'leonard.lenny@admin.com', 'abcdefghij', '6543210987', '7 Avenue Mont-Royal', 2);

INSERT INTO stock (
    stock_id,
    stock_name,
    stock_quantity,
    stock_threshold,
    stock_manager_id
)
VALUES
    (1, 'Sauce tomate', 20, 5, 31),
    (2, 'Fromage mozzarella', 30, 5, 31),
    (3, 'Jambon cuit', 30, 5, 31),
    (4, 'Ananas', 30, 5, 31),
    (5, 'Parmesan râpé', 30, 5, 31),
    (6, 'Gorgonzola', 30, 5, 31),
    (7, 'Basilic frais', 30, 5, 31),
    (8, 'Pepperoni', 20, 5, 31),
    (9, 'Champignons tranchés', 30, 5, 31),
    (10, 'Sirop de vanille', 15, 5, 31),
    (11, 'Cannelle en poudre', 10, 5, 31),
    (12, 'Olives noires', 20, 5, 31),
    (13, 'Poivrons verts', 20, 5, 31),
    (14, 'Tomates cerises', 15, 5, 31),
    (15, 'Huile d''olive', 10, 5, 31),
    (16, 'Poulet grillé', 30, 5, 31),
    (17, 'Oignons rouges', 15, 5, 31),
    (18, 'Cheddar râpé', 30, 5, 31),
    (19, 'Artichauts', 15, 5, 31),
    (20, 'Crème fraiche', 50, 5, 31),
    (21, 'Coca-Cola Original', 50, 10, 32),
    (22, 'Oasis Tropical', 50, 10, 32),
    (23, 'Orangina', 50, 10, 32),
    (24, 'Coca-Cola Zéro', 50, 10, 32),
    (25, 'Eau minérale', 50, 10, 32),
    (26, 'Café noir', 50, 5, 32),
    (27, 'Jus d''orange', 40, 10, 32),
    (28, 'Thé vert', 40, 10, 32),
    (29, 'Limonade', 50, 10, 32),
    (30, 'Cidre', 50, 10, 32),
    (31, 'Smoothie aux fruits', 50, 10, 32),
    (32, 'Bières IPA', 50, 10, 32),
    (33, 'Lait frappé', 40, 10, 32),
    (34, 'Cookie Géant', 60, 20, 33),
    (35, 'Muffin Chocolat', 60, 20, 33),
    (36, 'Tiramisu', 60, 20, 33),
    (37, 'Fondant au chocolat', 60, 20, 33),
    (38, 'Mousse au citron', 60, 20, 33),
    (39, 'Gâteau aux noix', 60, 20, 32);

INSERT INTO drink (
    drink_id,
    drink_name,
    drink_price,
    drink_volume,
    drink_image_url,
    drink_stock_id
)
VALUES
    (1, 'Coca-Cola Original', 1.00, 0.33, 'https://pngimg.com/uploads/cocacola/cocacola_PNG10.png', 21),
    (2, 'Oasis Tropical', 1.00, 0.33, 'https://www.tang-freres.fr/wp-content/uploads/produits/178245.png', 22),
    (3, 'Orangina', 1.00, 0.33, 'https://www.sushiplaza.com/images/Image/Boissons--Orangina-33-cl.png', 23),
    (4, 'Coca-Cola Zéro', 1.00, 0.33, 'https://www.bieres64-40.fr/wp-content/uploads/2022/12/cocazero33.png', 24),
    (5, 'Eau minérale', 1.50, 0.50, 'https://png.pngtree.com/png-vector/20240913/ourmid/pngtree-mineral-water-bottle-png-image_13600124.png', 25),
    (6, 'Café noir', 1.00, 0.25, 'https://png.pngtree.com/png-vector/20240529/ourmid/pngtree-espresso-cup-with-a-rich-dark-coffee-shot-png-image_12511778.png', 26),
    (7, 'Jus d''orange', 3.00, 0.30, 'https://static.vecteezy.com/system/resources/thumbnails/055/804/947/small/fresh-orange-juice-in-a-clear-glass-on-isolated-background-png.png', 27),
    (8, 'Thé vert', 1.30, 0.20, 'https://png.pngtree.com/png-vector/20241213/ourmid/pngtree-green-tea-with-fresh-leaves-png-image_14744620.png', 28),
    (9, 'Limonade', 2.80, 0.75, 'https://png.pngtree.com/png-vector/20240628/ourmid/pngtree-iced-lemonade-in-a-plastic-cup-with-condensation-droplets-on-it-png-image_12734110.png', 29);

INSERT INTO dessert (
    dessert_id,
    dessert_name,
    dessert_price,
    dessert_image_url,
    dessert_stock_id
)
VALUES
    (1, 'Cookie Géant', 7.50, 'https://madame-cookies.com/cdn/shop/files/j8hn.png?v=1745400662', 34),
    (2, 'Muffin Chocolat', 3.80, 'https://static.vecteezy.com/system/resources/previews/055/930/281/non_2x/freshly-baked-chocolate-muffins-stacked-on-top-of-each-other-free-png.png', 35),
    (3, 'Tiramisu', 4.50, 'https://static.vecteezy.com/system/resources/previews/068/507/324/non_2x/tiramisu-isolated-on-transparent-background-free-png.png', 36),
    (4, 'Fondant au chocolat', 5.00, 'https://odikisushi.fr/wp-content/uploads/2021/06/Fondant-au-chocolat.png', 37),
    (5, 'Mousse au citron', 3.50, 'https://i.pinimg.com/736x/eb/7f/02/eb7f02c6135383d191caf6a3f084b035.jpg', 38),
    (6, 'Gâteau aux noix', 4.00, 'https://popapilles.com/wp-content/uploads/2025/06/trianon-noix-pecan-caramel.png', 39);

INSERT INTO ingredient (
    ingredient_id,
    ingredient_name,
    ingredient_updatable,
    ingredient_stock_id
)
VALUES
    (1, 'Sauce tomate', 0, 1),
    (2, 'Fromage mozzarella', 1, 2),
    (3, 'Jambon cuit', 1, 3),
    (4, 'Ananas', 1, 4),
    (5, 'Parmesan râpé', 1, 5),
    (6, 'Gorgonzola', 1, 6),
    (7, 'Basilic frais', 1, 7),
    (8, 'Pepperoni', 1, 8),
    (9, 'Champignons tranchés', 1, 9),
    (10, 'Sirop de vanille', 1, 10),
    (11, 'Cannelle en poudre', 1, 11),
    (12, 'Olives noires', 1, 12),
    (13, 'Poivrons verts', 1, 13),
    (14, 'Tomates cerises', 1, 14),
    (15, 'Huile d''olive', 0, 15),
    (16, 'Poulet grillé', 1, 16),
    (17, 'Oignons rouges', 1, 17),
    (18, 'Cheddar râpé', 1, 18),
    (19, 'Artichauts', 1, 19),
    (20, 'Crème fraiche', 1, 20);

INSERT INTO pizza (
    pizza_id,
    pizza_name,
    pizza_price,
    pizza_image_url
)
VALUES
    (1, 'Margherita', 8.5,  'https://upload.wikimedia.org/wikipedia/commons/d/d8/Pizza_margherita.png'),
    (2, 'Pepperoni Supreme', 10.5, 'https://valentinos.com/wp-content/uploads/2024/11/pepperoni.png'),
    (3, 'Vegetariana', 9.5,  'https://interlakenpizza.ch/image/catalog/Pizza%20vegetariana.png'),
    (4, 'Hawaiian', 11.0, 'https://png.pngtree.com/png-vector/20240724/ourmid/pngtree-hawaiian-pizza-with-pineapple-png-image_13047011.png'),
    (5, 'Mediterranean', 11.5,  'https://pizza2go.com.tr/wp-content/uploads/2022/11/pizza2go-mediterranean.png'),
    (6, 'BBQ Chicken', 10.0, 'https://www.nicepng.com/png/full/303-3035697_bbq-chicken-pizza-medium-traditional-crust-barbeque-chicken.png'),
    (7, 'Capricciosa', 10.8, 'https://www.pizzeriagraniantichi.it/templates/yootheme/cache/88/pizza-capricciosa-2-8862bafd.png');

INSERT INTO pizza_ingredient (
    pizza_ingredient_pizza_id,
    pizza_ingredient_ingredient_id,
    pizza_ingredient_quantity
) VALUES
    (1, 1, 0.15),
    (1, 2, 0.2),
    (1, 5, 0.15),
    (1, 6, 0.1),
    (2, 1, 0.15),
    (2, 2, 0.2),
    (2, 7, 0.02),
    (3, 1, 0.15),
    (3, 2, 0.2),
    (3, 8, 0.1),
    (3, 9, 0.08),
    (4, 1, 0.15),
    (4, 2, 0.2),
    (4, 9, 0.1),
    (4, 13, 0.08),
    (4, 14, 0.12),
    (4, 12, 0.1),
    (4, 7, 0.007),
    (5, 1, 0.15),
    (5, 2, 0.2),
    (5, 4, 0.15),
    (5, 3, 0.2),
    (6, 1, 0.15),
    (6, 2, 0.2),
    (6, 12, 0.1),
    (6, 13, 0.15),
    (6, 14, 0.12),
    (6, 7, 0.007),
    (6, 15, 0.015),
    (7, 1, 0.15),
    (7, 2, 0.2),
    (7, 3, 0.2),
    (7, 12, 0.1),
    (7, 9, 0.1),
    (7, 19, 0.2);

INSERT INTO allergen (
    allergen_id,
    allergen_name
)
VALUES
    (1, 'Histamine'),
    (2, 'Lait de vache'),
    (3, 'Protéine de pois');

INSERT INTO pizza_allergen (
    pizza_allergen_pizza_id,
    pizza_allergen_allergen_id
)
VALUES
    (1, 2),
    (2, 2),
    (3, 2),
    (3, 3),
    (4, 2),
    (5, 1),
    (5, 2),
    (6, 2),
    (7, 2);

INSERT INTO order_state (
    order_state_id,
    order_state_name
)
VALUES
    (1, 'Confirmée'),
    (2, 'Prête'),
    (3, 'Livrée'),
    (4, 'Livrée en retard');

INSERT INTO orders (
    order_id,
    order_date,
    order_total_price,
    order_user_id,
    order_state_id
) VALUES
    (1, 1705759200000, 15.00, 1, 3),
    (2, 1705771800000, 25.90, 2, 3),
    (3, 1705781700000, 33.80, 3, 2),
    (4, 1705752000000, 20.00, 1, 4);

INSERT INTO drink_order(
    drink_order_drink_id,
    drink_order_order_id,
    drink_order_quantity
) VALUES
    (1,1,1),
    (9,3,1),
    (6,3,1),
    (5,3,1);

INSERT INTO dessert_order(
    dessert_order_dessert_id,
    dessert_order_order_id,
    dessert_order_quantity
) VALUES
    (1,2,1),
    (3,3,1),
    (4,3,1);

INSERT INTO pizza_order(
    pizza_order_pizza_id,
    pizza_order_order_id,
    pizza_order_quantity
) VALUES
    (5,1,1),
    (1,2,1),
    (2,2,1),
    (3,3,1),
    (7,3,1);

INSERT INTO personalization_type (
    personalization_type_id,
    personalization_type_name
) VALUES
      (1,'Ajout'),
      (2,'Retrait');

INSERT INTO custom_pizza_order(
    custom_pizza_order_pizza_id,
    custom_pizza_order_ingredient_id,
    custom_pizza_order_order_id,
    custom_pizza_order_personalization_type_id,
    custom_pizza_order_quantity
) VALUES
    (5,8,4,1,20),
    (5,16,4,1,1),
    (5,12,4,1,1);