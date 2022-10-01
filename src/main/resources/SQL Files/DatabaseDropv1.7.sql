-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-10-01 22:32:15.241

-- foreign keys
ALTER TABLE cookbook_recipe
    DROP FOREIGN KEY cookbook_recipe_cookbooks;

ALTER TABLE cookbook_recipe
    DROP FOREIGN KEY cookbook_recipe_recipes;

ALTER TABLE recipe_tags
    DROP FOREIGN KEY recipe_tags_recipes;

ALTER TABLE recipe_tags
    DROP FOREIGN KEY recipe_tags_tags;

ALTER TABLE recipes
    DROP FOREIGN KEY recipes_user;

-- tables
DROP TABLE cookbook_recipe;

DROP TABLE cookbooks;

DROP TABLE recipe_tags;

DROP TABLE recipes;

DROP TABLE tags;

DROP TABLE user;

-- End of file.

