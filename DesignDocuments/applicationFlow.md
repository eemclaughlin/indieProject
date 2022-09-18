# Application Flow

### User Arrives to Page
1. User arrives on page and is prompted to login.
   2. If no login credentials, user chooses to set up an account.

### User Account Set Up
1. User chooses to set up an account and is taken to a new page.
2. User fills out the form with relevant data.
3. Request is sent to java program.
4. A user object is created and the user is added to database.

### User Logs In
1. User enters credentials on initial landing page.
2. User is authenticated and logged in.
3. If authenticated, user is taken to homepage.
   4. If failed, user gets an error.

### User Browses/Searches Recipes
1. User's homepage is a list of all entered recipes (sorted alphabetically by default)
   2. Java program calls for list of recipes from the database.
2. User scrolls up and down to view recipes
3. User changed sort order using dropdown at top of screen.
4. User uses search bar to search for recipes by name or keyword.

### User Views Additional Details on a Recipe
1. User clicks on recipe they want to get more info on and a recipe details screen opens.
2. User views detailed info about the recipe and also the cookbook that has the recipe.

### User Adds a Recipe
1. From homepage or from navigation bar, user navigates to add a recipe.
2. A form is presented to user and user enters recipe name, recipe description, notes, etc.
3. Form is given to Java program which creates an instance of the recipe and adds info to the database.
4. User is taken to recipe details screen for the new recipe.

### User Adds a Cookbook.
1. User navigates to the Add a Cookbook page.
2. A prompt is given to user, to enter a title or ISDN of new cookbook.
   3. User enters requested data.
4. API is called to search for matching cookbook.
5. Relevant cookbook data is added to the database.

### User Views Added Cookbooks
1. At bottom of the Add a Cookbook page, user sees a list of all added/owned cookbooks.
2. Relevant data is populated for each cookbook entry (largely from data from API).

### User Deletes a Cookbook.
1. User uses x by each cookbook.
2. Request is sent to Java app which puts a flag on the entry in the database.
   3. Can't remove as recipes may be referencing that data.

### User Edits a Recipe.
1. User chooses to edit a particular recipe.
2. Database is called and populates a form with relevant data.
3. User alters the necessary fields and save.
4. Data is updated in database.

### User deletes a recipe
1. User uses x by each of the recipes (not pictured in wireframes)
2. Recipe data is removed from database.

#### [Back to main README](../README.md)