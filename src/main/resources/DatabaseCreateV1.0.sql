-- Last modification date: 2022-09-29 01:51:13.978

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

-- End of file.

