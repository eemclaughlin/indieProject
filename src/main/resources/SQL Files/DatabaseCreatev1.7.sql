-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-10-01 22:32:15.241

-- tables
-- Table: cookbook_recipe
CREATE TABLE cookbook_recipe (
    cook_recipe_id int NOT NULL AUTO_INCREMENT,
    cookbook_cd int NOT NULL,
    recipe_cd int NOT NULL,
    page_number int NULL,
    CONSTRAINT cookbook_recipe_pk PRIMARY KEY (cook_recipe_id)
) COMMENT 'Junction table for each recipe to reference the needed cookbook.';

-- Table: cookbooks
CREATE TABLE cookbooks (
    cookbook_id int NOT NULL AUTO_INCREMENT,
    title varchar(100) NOT NULL,
    description text NULL,
    isdn varchar(25) NULL,
    notes text NULL,
    CONSTRAINT cookbooks_pk PRIMARY KEY (cookbook_id)
) COMMENT 'Information about each cookbook.  Soon to be an API';

-- Table: recipe_tags
CREATE TABLE recipe_tags (
    tag_cd int NOT NULL,
    recipe_cd int NOT NULL,
    CONSTRAINT recipe_tags_pk PRIMARY KEY (tag_cd,recipe_cd)
) COMMENT 'Junction table to join tags to recipes';

-- Table: recipes
CREATE TABLE recipes (
    recipe_id int NOT NULL AUTO_INCREMENT,
    recipe_name varchar(100) NOT NULL,
    description text NULL,
    notes text NULL,
    user_cd int NOT NULL,
    CONSTRAINT recipes_pk PRIMARY KEY (recipe_id)
) COMMENT 'Tracks information on the various entered recipes';

-- Table: tags
CREATE TABLE tags (
    tag_id int NOT NULL AUTO_INCREMENT,
    tag_name varchar(20) NOT NULL,
    description text NULL,
    CONSTRAINT tags_pk PRIMARY KEY (tag_id)
) COMMENT 'Misc tags for searching recipes';

-- Table: user
CREATE TABLE user (
    user_id int NOT NULL AUTO_INCREMENT,
    first_name varchar(20) NOT NULL,
    last_name varchar(30) NOT NULL,
    login_id varchar(20) NOT NULL,
    password varchar(25) NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (user_id)
) COMMENT 'Information about each user.';

-- foreign keys
-- Reference: cookbook_recipe_cookbooks (table: cookbook_recipe)
ALTER TABLE cookbook_recipe ADD CONSTRAINT cookbook_recipe_cookbooks FOREIGN KEY cookbook_recipe_cookbooks (cookbook_cd)
    REFERENCES cookbooks (cookbook_id);

-- Reference: cookbook_recipe_recipes (table: cookbook_recipe)
ALTER TABLE cookbook_recipe ADD CONSTRAINT cookbook_recipe_recipes FOREIGN KEY cookbook_recipe_recipes (recipe_cd)
    REFERENCES recipes (recipe_id);

-- Reference: recipe_tags_recipes (table: recipe_tags)
ALTER TABLE recipe_tags ADD CONSTRAINT recipe_tags_recipes FOREIGN KEY recipe_tags_recipes (recipe_cd)
    REFERENCES recipes (recipe_id);

-- Reference: recipe_tags_tags (table: recipe_tags)
ALTER TABLE recipe_tags ADD CONSTRAINT recipe_tags_tags FOREIGN KEY recipe_tags_tags (tag_cd)
    REFERENCES tags (tag_id);

-- Reference: recipes_user (table: recipes)
ALTER TABLE recipes ADD CONSTRAINT recipes_user FOREIGN KEY recipes_user (user_cd)
    REFERENCES user (user_id);

-- End of file.

