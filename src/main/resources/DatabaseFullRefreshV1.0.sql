-- foreign keys
ALTER TABLE COOKBOOK_RECIPE
    DROP FOREIGN KEY COOKBOOK_RECIPE_COOKBOOKS;

ALTER TABLE COOKBOOK_RECIPE
    DROP FOREIGN KEY COOKBOOK_RECIPE_RECIPES;

ALTER TABLE RECIPES
    DROP FOREIGN KEY RECIPES_USER;

ALTER TABLE RECIPE_TAGS
    DROP FOREIGN KEY RECIPE_TAGS_RECIPES;

ALTER TABLE RECIPE_TAGS
    DROP FOREIGN KEY RECIPE_TAGS_TAGS;

-- tables
DROP TABLE COOKBOOKS;

DROP TABLE COOKBOOK_RECIPE;

DROP TABLE RECIPES;

DROP TABLE RECIPE_TAGS;

DROP TABLE TAGS;

DROP TABLE USER;

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

-- Table: COOKBOOK_RECIPE
CREATE TABLE COOKBOOK_RECIPE (
    CookRecipeId int NOT NULL AUTO_INCREMENT,
    CookbookCd int NOT NULL,
    RecipeCd int NOT NULL,
    PageNumber int NULL,
    CONSTRAINT COOKBOOK_RECIPE_pk PRIMARY KEY (CookRecipeId)
) COMMENT 'Junction table for each recipe to reference the needed cookbook.';

-- Table: RECIPES
CREATE TABLE RECIPES (
    RecipeId int NOT NULL AUTO_INCREMENT,
    RecipeName varchar(100) NOT NULL,
    Description text NULL,
    Notes text NULL,
    UserCd int NOT NULL,
    CONSTRAINT RECIPES_pk PRIMARY KEY (RecipeId)
) COMMENT 'Tracks information on the various entered recipes';

-- Table: RECIPE_TAGS
CREATE TABLE RECIPE_TAGS (
    TagCd int NOT NULL,
    RecipeCd int NOT NULL,
    CONSTRAINT RECIPE_TAGS_pk PRIMARY KEY (TagCd,RecipeCd)
) COMMENT 'Junction table to join tags to recipes';

-- Table: TAGS
CREATE TABLE TAGS (
    TagId int NOT NULL AUTO_INCREMENT,
    TagName varchar(20) NOT NULL,
    Description text NULL,
    CONSTRAINT TAGS_pk PRIMARY KEY (TagId)
) COMMENT 'Misc tags for searching recipes';

-- Table: USER
CREATE TABLE USER (
    UserId int NOT NULL AUTO_INCREMENT,
    FirstName varchar(20) NOT NULL,
    LastName varchar(30) NOT NULL,
    LoginId varchar(20) NOT NULL,
    Password varchar(25) NOT NULL,
    CONSTRAINT USER_pk PRIMARY KEY (UserId)
) COMMENT 'Information about each user.';

-- foreign keys
-- Reference: COOKBOOK_RECIPE_COOKBOOKS (table: COOKBOOK_RECIPE)
ALTER TABLE COOKBOOK_RECIPE ADD CONSTRAINT COOKBOOK_RECIPE_COOKBOOKS FOREIGN KEY COOKBOOK_RECIPE_COOKBOOKS (CookbookCd)
    REFERENCES COOKBOOKS (CookbookId);

-- Reference: COOKBOOK_RECIPE_RECIPES (table: COOKBOOK_RECIPE)
ALTER TABLE COOKBOOK_RECIPE ADD CONSTRAINT COOKBOOK_RECIPE_RECIPES FOREIGN KEY COOKBOOK_RECIPE_RECIPES (RecipeCd)
    REFERENCES RECIPES (RecipeId);

-- Reference: RECIPES_USER (table: RECIPES)
ALTER TABLE RECIPES ADD CONSTRAINT RECIPES_USER FOREIGN KEY RECIPES_USER (UserCd)
    REFERENCES USER (UserId);

-- Reference: RECIPE_TAGS_RECIPES (table: RECIPE_TAGS)
ALTER TABLE RECIPE_TAGS ADD CONSTRAINT RECIPE_TAGS_RECIPES FOREIGN KEY RECIPE_TAGS_RECIPES (RecipeCd)
    REFERENCES RECIPES (RecipeId);

-- Reference: RECIPE_TAGS_TAGS (table: RECIPE_TAGS)
ALTER TABLE RECIPE_TAGS ADD CONSTRAINT RECIPE_TAGS_TAGS FOREIGN KEY RECIPE_TAGS_TAGS (TagCd)
    REFERENCES TAGS (TagId);

INSERT INTO RecipeTracker.USER (UserId, FirstName, LastName, LoginId, Password) VALUES (1, 'Johnny', 'Cash', 'CashJ', 'CashJ');
INSERT INTO RecipeTracker.USER (UserId, FirstName, LastName, LoginId, Password) VALUES (2, 'Peggy', 'Curbs', 'CurbsP', 'CurbsP');
INSERT INTO RecipeTracker.USER (UserId, FirstName, LastName, LoginId, Password) VALUES (3, 'Bob', 'Hamelin', 'HamelB', 'HamelB');
INSERT INTO RecipeTracker.RECIPES (RecipeId, RecipeName, Description, Notes, UserCd) VALUES (1, 'Carrot Cake', null, null, 1);
INSERT INTO RecipeTracker.RECIPES (RecipeId, RecipeName, Description, Notes, UserCd) VALUES (2, 'Meatloaf', null, null, 2);
INSERT INTO RecipeTracker.RECIPES (RecipeId, RecipeName, Description, Notes, UserCd) VALUES (3, 'Tacos', null, null, 3);
INSERT INTO RecipeTracker.RECIPES (RecipeId, RecipeName, Description, Notes, UserCd) VALUES (4, 'Creme Brulee', null, null, 1);

-- End of file.