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

-- tables
-- Table: COOKBOOKS
CREATE TABLE COOKBOOKS (
    CookbookId int NOT NULL AUTO_INCREMENT,
    Title varchar(100) NOT NULL,
    Description text NULL,
    Isdn varchar(25) NULL,
    Notes text NULL,
    CONSTRAINT COOKBOOKS_pk PRIMARY KEY (CookbookId)
) COMMENT 'Information about each cookbook.  Soon to be an API';

-- Table: cookbook_recipe
CREATE TABLE cookbook_recipe (
    cook_recipeid int NOT NULL AUTO_INCREMENT,
    cookbook_cd int NOT NULL,
    recipe_cd int NOT NULL,
    page_number int NULL,
    CONSTRAINT cookbook_recipe_pk PRIMARY KEY (cook_recipeid)
) COMMENT 'Junction table for each recipe to reference the needed cookbook.';

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
-- Reference: COOKBOOK_RECIPE_COOKBOOKS (table: cookbook_recipe)
ALTER TABLE cookbook_recipe ADD CONSTRAINT COOKBOOK_RECIPE_COOKBOOKS FOREIGN KEY COOKBOOK_RECIPE_COOKBOOKS (cookbook_cd)
    REFERENCES COOKBOOKS (CookbookId);

-- Reference: COOKBOOK_RECIPE_RECIPES (table: cookbook_recipe)
ALTER TABLE cookbook_recipe ADD CONSTRAINT COOKBOOK_RECIPE_RECIPES FOREIGN KEY COOKBOOK_RECIPE_RECIPES (recipe_cd)
    REFERENCES recipes (recipe_id);

-- Reference: RECIPES_USER (table: recipes)
ALTER TABLE recipes ADD CONSTRAINT RECIPES_USER FOREIGN KEY RECIPES_USER (user_cd)
    REFERENCES user (user_id);

-- Reference: RECIPE_TAGS_RECIPES (table: recipe_tags)
ALTER TABLE recipe_tags ADD CONSTRAINT RECIPE_TAGS_RECIPES FOREIGN KEY RECIPE_TAGS_RECIPES (recipe_cd)
    REFERENCES recipes (recipe_id);

-- Reference: RECIPE_TAGS_TAGS (table: recipe_tags)
ALTER TABLE recipe_tags ADD CONSTRAINT RECIPE_TAGS_TAGS FOREIGN KEY RECIPE_TAGS_TAGS (tag_cd)
    REFERENCES tags (tag_id);

-- DATA REFRESH STUFF
INSERT INTO RecipeTracker.user (user_id, first_name, last_name, login_id, password) VALUES (1, 'Johnny', 'Cash', 'CashJ', 'CashJ');
INSERT INTO RecipeTracker.user (user_id, first_name, last_name, login_id, password) VALUES (2, 'Peggy', 'Curbs', 'CurbsP', 'CurbsP');
INSERT INTO RecipeTracker.user (user_id, first_name, last_name, login_id, password) VALUES (3, 'Bob', 'Hamelin', 'HamelB', 'HamelB');
INSERT INTO RecipeTracker.recipes (recipe_id, recipe_name, description, notes, user_cd) VALUES (1, 'Carrot Cake', null, null, 1);
INSERT INTO RecipeTracker.recipes (recipe_id, recipe_name, description, notes, user_cd) VALUES (2, 'Meatloaf', null, null, 2);
INSERT INTO RecipeTracker.recipes (recipe_id, recipe_name, description, notes, user_cd) VALUES (3, 'Tacos', null, null, 3);
INSERT INTO RecipeTracker.recipes (recipe_id, recipe_name, description, notes, user_cd) VALUES (4, 'Creme Brulee', null, null, 1);



-- End of file.

