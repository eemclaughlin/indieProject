# Project Plan
#### (Stretch Goals at End)
#### (Outstanding bugs near end)

#### [Back to main README](../README.md)

### Week 3
- [x] Create project repository on GitHub
- [x] Create project structure in intellij and push
- [x] Complete Problem Statement
- [x] Determine possible Web Services or APIs to use
- [x] Time Log/Journal
- [x] Start project plan
- [x] Create wireframe/template design layout documents
- [x] Document application flow

### Week 4
- [x] Continue work on project plan
- [x] Finish up Project Part 1 and submit.
- [x] Plan layout and design of database
- [x] Create the database and tables
- [x] Start setting up general structure for program
- [x] Set up initial Hibernate work.

### Week 5
- [x] Create a genericDao
- [x] Get test jsp/controller working using genericDao
- [x] Remove non-genericDao classes
- [x] Implement recipe class and get that to display on jsp.
- [x] Add files to gitignore related to database creds.
- [x] Migrate over to AWS.
- [x] Continue adding to ToDo List/Project plan for upcoming weeks

### Week 6
- [x] Continue added entity classes and test data
- [x] Integrate Cognito into project locally
- [x] Get cognito working on the AWS.
- [x] Continue adding to ToDo List/Project plan for upcoming weeks

### Week 7
- [x] Determine API and test retrieving data.
- [x] Work on filtering return data to only what is needed.
- [x] Integrate API classes into project.
- [x] Set up a test for checking API is working.
- [x] Continue adding to ToDo List/Project plan for upcoming weeks

### Week 8
- [x] Finalize database design and implement locally
- [x] Implement final database in AWS.
- [x] Build out login page to login, verify, and dump to homepage.
- [x] Build out homepage to display list of recipes on arrival
- [x] Continue adding to ToDo List/Project plan for upcoming weeks

### Week 9
- [x] Create on add recipe jsp.
- [x] Create on addRecipe.java
- [x] Create form/jsp to search for cookbooks via api
- [x] Create jsp to display search results of api
- [x] Continue adding to ToDo List/Project plan for upcoming weeks

### Week 10
- [x] Create way to view all of a user's cookbooks.
- [x] First pass at cleaning up files.
- [x] Team Project Stuff

### Week 11
- [x] Bye-Week for IndieProject
- [x] Wrap up team project.
- [x] Team project presentation work.

### Week 12
- [x] Integrate error handling.
- [x] Add javadoc and comments on all pages. First Pass.
- [x] Add way to remove cookbooks from database.
- [x] Add way to remove recipes from database.
- [x] Implement a properies file

### Week 13
- [x] Build up unit-testing to get more coverage
- [x] Work on editing recipes page.
- [x] Add way to edit cookbook data
- [x] Create an Add Cookbook Manually page.
- [x] Clean up redundant calls for user information.
- [x] Start working on proper layout and design of jsp pages.
- [x] Break up repeating elements into jsp fragments.

### Week 14
- [x] Final pass on javadoc and comments.
- [x] Get everything working again in AWS.
- [x] Continue converting jsps to new layouts.
- [x] Create the landing page for the site (minus picture).
- [x] Find a main picture, edit, and add it to homepage
- [x] Implement/finalize suggested changes from Paula and from peer.
- [x] Removed the TOBEDELETED folder and its contents.
- [x] Continue with bug and qol fixes. (See below for some noted bugs).

### Week 15
- [x] Continue to refine layout, CSS and HTML.
- [x] Continue with bug and qol fixes. (See below for some noted bugs).
- [x] Breakup classes into more methods.
- [x] Implement sorting capabilities on listCookbooks/Recipes
- [x] Implement a way to search through recipes and cookbooks.
- [x] Final pass on cleaning up code, stacktraces, and printlns.
- [x] Finalize on all the design documents and update.
- [x] Finalize generation of the JavaDocs.
- [x] Finalize project and prep for demonstrations.
- [x] Add project to AWS final time.
- [x] Get another user to test.
  - [x] Implement some suggestions.

### Week 16
- [x] Continue to implement feedback from my test user.
- [x] Upload final project to AWS one more time.
- [x] Record presentation for reference in GitHub.
  - [x] Add link to Readme.md.
- [x] Record presentation for submission for class. (Due 12/13)
  - [x] Add link to Readme.md
  - [x] Add link to Slack.
- [x] Final Self-Evaluation (Due 12/15).
  - [x] Post to GitHub.

## Outstanding Bugs/Refinements (Weeks 14 to 16 Mostly)
- [x] On editRecipe, fix dropdown to show current cookbook on arrival.
- [x] Sort the cookbooks and recipes alphabetically on the list pages.
- [x] Many pages, add back buttons.
- [x] On listCookbooks and listRecipes, if there are no items, print that to user.
- [x] Create a confirmation page for adding books from GoogleBooks.
- [x] Create a confirmation page for deleting a book or recipe.
- [x] On addCookbookSuccess Page, fix the delete/abort button and edit button.
- [x] On addCookbookByISBN, implement a dash removal method.
- [x] On editCookbook/addCookbook, it errors when no page number is entered.
- [x] On editCookbook/addCookbook, date format was not correct and no date causes error.
- [x] On addRecipe, require a page number.
- [x] Center picture of cookbook, on listRecipes.
- [x] On AddCookbookByISBN, Notes aren't being added with the cookbook info.
- [x] On DeleteCookbook, fix phrasing to be more relevant.
- [x] On addCookbook, only last author is array is used. Fix for multiple authors.
- [x] On addCookbook, if Google Books does not have entered isbn, give user options.

# Stretch Goals
### Things I would like to get added given more time.
- [ ] Search Recipes By Tag
- [ ] Add tags to a tags table
- [ ] Associate tags with recipes via junction table.
- [ ] On addCookbookManually, add ability to add picture.
- [ ] Implement icons and images.
- [ ] Add a ratings option to the recipes.
- [ ] Allow user to add recipe pictures.
- [ ] Implement a change profile options.
- [ ] On delete cookbook, add extra confirmation step.
--
#### [Back to main README](../README.md)