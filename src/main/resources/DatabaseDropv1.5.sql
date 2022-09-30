-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-09-30 13:48:35.734

-- foreign keys
ALTER TABLE cookbook_recipe
    DROP FOREIGN KEY COOKBOOK_RECIPE_COOKBOOKS;

ALTER TABLE cookbook_recipe
    DROP FOREIGN KEY COOKBOOK_RECIPE_RECIPES;

ALTER TABLE recipes
    DROP FOREIGN KEY RECIPES_USER;

ALTER TABLE recipe_tags
    DROP FOREIGN KEY RECIPE_TAGS_RECIPES;

ALTER TABLE recipe_tags
    DROP FOREIGN KEY RECIPE_TAGS_TAGS;

-- tables
DROP TABLE COOKBOOKS;

DROP TABLE cookbook_recipe;

DROP TABLE recipe_tags;

DROP TABLE recipes;

DROP TABLE tags;

DROP TABLE user;

-- End of file.

