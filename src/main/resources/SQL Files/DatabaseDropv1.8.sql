-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-10-02 23:46:20.861

-- foreign keys
ALTER TABLE recipe_tags
    DROP FOREIGN KEY recipe_tags_recipes;

ALTER TABLE recipe_tags
    DROP FOREIGN KEY recipe_tags_tags;

ALTER TABLE recipes
    DROP FOREIGN KEY recipes_cookbooks;

ALTER TABLE recipes
    DROP FOREIGN KEY recipes_user;

ALTER TABLE user_cookbooks
    DROP FOREIGN KEY user_cookbooks_cookbooks;

ALTER TABLE user_cookbooks
    DROP FOREIGN KEY user_cookbooks_user;

-- tables
DROP TABLE cookbooks;

DROP TABLE recipe_tags;

DROP TABLE recipes;

DROP TABLE tags;

DROP TABLE user;

DROP TABLE user_cookbooks;

-- End of file.

