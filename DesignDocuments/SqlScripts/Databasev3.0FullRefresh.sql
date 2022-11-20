-- DROP SECTION
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

-- END DROP SECTION
-- CREATE SECTION

-- tables
-- Table: cookbooks
CREATE TABLE cookbooks (
    cookbook_id int NOT NULL AUTO_INCREMENT,
    title varchar(100) NOT NULL,
    author varchar(50) NULL,
    publisher varchar(100) NULL,
    published_date date NULL,
    description text NULL,
    isbn_ten varchar(20) NULL,
    isbn_thirteen varchar(20) NULL,
    page_count int NULL,
    language varchar(5) NULL,
    small_image_link varchar(200) NULL,
    med_image_link varchar(200) NULL,
    notes varchar(300) NULL,
    user_cd int NOT NULL,
    CONSTRAINT cookbooks_pk PRIMARY KEY (cookbook_id)
) COMMENT 'Information about each cookbook.  Soon to be an API';

-- Table: recipe_tags
CREATE TABLE recipe_tags (
    id int NOT NULL AUTO_INCREMENT,
    tag_cd int NOT NULL,
    recipe_cd int NOT NULL,
    CONSTRAINT recipe_tags_pk PRIMARY KEY (id)
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
    email varchar(50) NULL,
    login_name varchar(20) NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (user_id)
) COMMENT 'Information about each user.';

-- foreign keys
-- Reference: cookbooks_user (table: cookbooks)
ALTER TABLE cookbooks ADD CONSTRAINT cookbooks_user FOREIGN KEY cookbooks_user (user_cd)
    REFERENCES user (user_id);

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

-- END CREATE SECTION
-- START DATA ENTRY

INSERT INTO RecipeTracker.user (user_id, first_name, last_name, email, login_name) VALUES (1, 'Johnny', 'Cash', 'jcash@yahoo.com', 'CashJ');
INSERT INTO RecipeTracker.user (user_id, first_name, last_name, email, login_name) VALUES (2, 'Test', 'User1', 'eemclaughlin@madisoncollege.edu', 'testuser1!');
INSERT INTO RecipeTracker.user (user_id, first_name, last_name, email, login_name) VALUES (3, 'Bob', 'Hamelin', 'bobh@outlook.com', 'HamelB');
INSERT INTO RecipeTracker.tags (tag_id, tag_name, description) VALUES (1, 'Rice', 'Rice');
INSERT INTO RecipeTracker.tags (tag_id, tag_name, description) VALUES (2, 'Whole Milk', 'Whole Milk');
INSERT INTO RecipeTracker.tags (tag_id, tag_name, description) VALUES (3, 'Carrots', 'Carrots');
INSERT INTO RecipeTracker.tags (tag_id, tag_name, description) VALUES (4, 'Beef', 'Beef');
INSERT INTO RecipeTracker.cookbooks (cookbook_id, title, author, publisher, user_cd) VALUE (1, 'The Best Cookbook', 'Jean-Luc Picard', 'Enterprise Press', 1);
INSERT INTO RecipeTracker.cookbooks (cookbook_id, title, author, publisher, user_cd) VALUE (2, 'The Next Best Cookbook', 'James T Kirk', 'Enterprise Press', 2);
INSERT INTO RecipeTracker.recipes (recipe_id, recipe_name, description, notes, page_number, user_cd, cookbook_cd) VALUES (1, 'Carrot Cake', null, null, 300, 1, 1);
INSERT INTO RecipeTracker.recipes (recipe_id, recipe_name, description, notes, page_number, user_cd, cookbook_cd) VALUES (2, 'Meatloaf', null, null, 25, 2, 2);
INSERT INTO RecipeTracker.recipes (recipe_id, recipe_name, description, notes, page_number, user_cd, cookbook_cd) VALUES (3, 'Tacos', null, null, 36, 3, 2);
INSERT INTO RecipeTracker.recipes (recipe_id, recipe_name, description, notes, page_number, user_cd, cookbook_cd) VALUES (4, 'Creme Brulee', null, null, 281, 1, 1);

-- End of file.

