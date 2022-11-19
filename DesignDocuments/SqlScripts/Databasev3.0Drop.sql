-- Last modification date: 2022-11-19 15:28:20.399

-- foreign keys
ALTER TABLE cookbooks
    DROP FOREIGN KEY cookbooks_user;

ALTER TABLE recipe_tags
    DROP FOREIGN KEY recipe_tags_recipes;

ALTER TABLE recipe_tags
    DROP FOREIGN KEY recipe_tags_tags;

ALTER TABLE recipes
    DROP FOREIGN KEY recipes_cookbooks;

ALTER TABLE recipes
    DROP FOREIGN KEY recipes_user;

-- tables
DROP TABLE cookbooks;

DROP TABLE recipe_tags;

DROP TABLE recipes;

DROP TABLE tags;

DROP TABLE user;

-- End of file.

