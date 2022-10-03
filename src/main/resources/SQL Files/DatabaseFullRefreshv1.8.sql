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

-- tables
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
    page_number int NOT NULL,
    user_cd int NOT NULL,
    cookbook_cd int NOT NULL,
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

-- Table: user_cookbooks
CREATE TABLE user_cookbooks (
    user_cd int NOT NULL,
    cookbook_cd int NOT NULL,
    CONSTRAINT user_cookbooks_pk PRIMARY KEY (user_cd,cookbook_cd)
) COMMENT 'Junction table between users and cookbooks';

-- foreign keys
-- Reference: recipe_tags_recipes (table: recipe_tags)
ALTER TABLE recipe_tags ADD CONSTRAINT recipe_tags_recipes FOREIGN KEY recipe_tags_recipes (recipe_cd)
    REFERENCES recipes (recipe_id);

-- Reference: recipe_tags_tags (table: recipe_tags)
ALTER TABLE recipe_tags ADD CONSTRAINT recipe_tags_tags FOREIGN KEY recipe_tags_tags (tag_cd)
    REFERENCES tags (tag_id);

-- Reference: recipes_cookbooks (table: recipes)
ALTER TABLE recipes ADD CONSTRAINT recipes_cookbooks FOREIGN KEY recipes_cookbooks (cookbook_cd)
    REFERENCES cookbooks (cookbook_id);

-- Reference: recipes_user (table: recipes)
ALTER TABLE recipes ADD CONSTRAINT recipes_user FOREIGN KEY recipes_user (user_cd)
    REFERENCES user (user_id);

-- Reference: user_cookbooks_cookbooks (table: user_cookbooks)
ALTER TABLE user_cookbooks ADD CONSTRAINT user_cookbooks_cookbooks FOREIGN KEY user_cookbooks_cookbooks (cookbook_cd)
    REFERENCES cookbooks (cookbook_id);

-- Reference: user_cookbooks_user (table: user_cookbooks)
ALTER TABLE user_cookbooks ADD CONSTRAINT user_cookbooks_user FOREIGN KEY user_cookbooks_user (user_cd)
    REFERENCES user (user_id);

-- DATA REFRESH STUFF
INSERT INTO RecipeTracker.user (user_id, first_name, last_name, login_id, password) VALUES (1, 'Johnny', 'Cash', 'CashJ', 'CashJ');
INSERT INTO RecipeTracker.user (user_id, first_name, last_name, login_id, password) VALUES (2, 'Peggy', 'Curbs', 'CurbsP', 'CurbsP');
INSERT INTO RecipeTracker.user (user_id, first_name, last_name, login_id, password) VALUES (3, 'Bob', 'Hamelin', 'HamelB', 'HamelB');
INSERT INTO RecipeTracker.cookbooks (cookbook_id, title) VALUE (1, 'The Best Cookbook');
INSERT INTO RecipeTracker.cookbooks (cookbook_id, title) VALUE (2, 'The Next Best Cookbook');
INSERT INTO RecipeTracker.recipes (recipe_id, recipe_name, description, notes, page_number, user_cd, cookbook_cd) VALUES (1, 'Carrot Cake', null, null, 300, 1, 1);
INSERT INTO RecipeTracker.recipes (recipe_id, recipe_name, description, notes, page_number, user_cd, cookbook_cd) VALUES (2, 'Meatloaf', null, null, 25, 2, 2);
INSERT INTO RecipeTracker.recipes (recipe_id, recipe_name, description, notes, page_number, user_cd, cookbook_cd) VALUES (3, 'Tacos', null, null, 36, 3, 2);
INSERT INTO RecipeTracker.recipes (recipe_id, recipe_name, description, notes, page_number, user_cd, cookbook_cd) VALUES (4, 'Creme Brulee', null, null, 281, 1, 1);

-- End of file.
