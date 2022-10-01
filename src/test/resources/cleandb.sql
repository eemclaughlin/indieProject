delete from recipes;
delete from user;
INSERT INTO RecipeTracker.user (user_id, first_name, last_name, login_id, password) VALUES (1, 'Johnny', 'Cash', 'CashJ', 'CashJ');
INSERT INTO RecipeTracker.user (user_id, first_name, last_name, login_id, password) VALUES (2, 'Peggy', 'Curbs', 'CurbsP', 'CurbsP');
INSERT INTO RecipeTracker.user (user_id, first_name, last_name, login_id, password) VALUES (3, 'Bob', 'Hamelin', 'HamelB', 'HamelB');
INSERT INTO RecipeTracker.recipes (recipe_id, recipe_name, description, notes, user_cd) VALUES (1, 'Carrot Cake', null, null, 1);
INSERT INTO RecipeTracker.recipes (recipe_id, recipe_name, description, notes, user_cd) VALUES (2, 'Meatloaf', null, null, 2);
INSERT INTO RecipeTracker.recipes (recipe_id, recipe_name, description, notes, user_cd) VALUES (3, 'Tacos', null, null, 3);
INSERT INTO RecipeTracker.recipes (recipe_id, recipe_name, description, notes, user_cd) VALUES (4, 'Creme Brulee', null, null, 1);