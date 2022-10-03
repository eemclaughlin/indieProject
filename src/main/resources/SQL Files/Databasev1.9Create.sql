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
    login_id varchar(20) NOT NULL,
    password varchar(25) NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (user_id)
) COMMENT 'Information about each user.';

-- Table: user_cookbooks
CREATE TABLE user_cookbooks (
    id int NOT NULL AUTO_INCREMENT,
    user_cd int NOT NULL,
    cookbook_cd int NOT NULL,
    CONSTRAINT user_cookbooks_pk PRIMARY KEY (id)
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

-- End of file.

