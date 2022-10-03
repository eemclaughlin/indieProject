package com.ericmclaughlin.persistence;

import com.ericmclaughlin.entity.Cookbook;
import com.ericmclaughlin.entity.Recipe;
import com.ericmclaughlin.entity.User;
import com.ericmclaughlin.testutil.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for accessing the database via the genericDaoTags.
 * @author eemclaughlin
 * @version 1.2 = 10-02-22
 */
public class RecipeDaoTest {
    /**
     * Instance of the generic dao.
     */
    GenericDao genericDao;
    GenericDao genericDaoCookbook;

    /**
     * Run set up tasks before each test:
     * 1. Execute sql which deletes everything from the table and inserts records)
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        // Instantiate the GenericDao and pass in what we are working with.
        genericDao = new GenericDao(Recipe.class);
        genericDaoCookbook = new GenericDao(Cookbook.class);
    }

    /**
     * Verify successful insert of a recipe.
     * CREATE.r.u.d
     */
    @Test
    void insertSuccess() {
        // Create new author.
        User newUser = new User("Bill", "Nye", "NyeB", "NyeB");
        // Create new cookbook.
        //Cookbook newCookbook = new Cookbook("Greatest Cookbook", "Test", "123-123-123", "Test");
        Cookbook retrievedCookbook = (Cookbook)genericDaoCookbook.getById(1);

        // Create a new recipe and insert user reference.
        // Recipe needs to know about the user and user needs to know about the recipe.
        String recipeName = "Rice Pudding";
        String description = "Pudding made with whole milk and rice";
        String notes = "Delicious!";
        int pageNumber = 523;

        Recipe recipe = new Recipe(recipeName, description, notes, pageNumber, newUser, retrievedCookbook);

        // !!! Recipe needs to know about user and user needs to know about recipe.
        newUser.addRecipe(recipe);
        retrievedCookbook.addRecipe(recipe);

        // Do the insert for user.  (Cookbook is already there)
        int userId = genericDao.insert(newUser);
        assertNotEquals(0, userId);

        // Get recipe by name and then verify that we got 1 entry back.
        List<Recipe> insertedRecipe = genericDao.getByPropertyEqual("recipeName", "Rice Pudding");
        assertEquals(1, insertedRecipe.size());
    }

    /**
     * Verify successful retrieval of all recipes
     * c.READ.u.d
     */
    @Test
    void getAllSuccess() {
        List<Recipe> recipes = genericDao.getAll();
        assertEquals(4, recipes.size());
    }

    /**
     * Verify successful retrieval of a recipe by the ID
     * c.READ.u.d
     */
    @Test
    void getByIdSuccess() {
        Recipe retrievedRecipe = (Recipe)genericDao.getById(1);
        assertEquals("Carrot Cake", retrievedRecipe.getRecipeName());
        //TODO: Add other assertions for the other fields, if needed.
    }

    /**
     * Verify successful get of a recipe by a property (equal match)
     * c.READ.u.d
     */
    @Test
    void getByPropertyEqualSuccess() {
        // Call for a recipe by a exact name
        List<Recipe> recipes = genericDao.getByPropertyEqual("recipeName", "Tacos");

        // Verify we get 1 result back and that the ID matches expected ID.
        assertEquals(1, recipes.size());
        assertEquals(3, recipes.get(0).getRecipeId());
    }

    /**
     * Verify successful get of recipe(s) by partial property (like match)
     * c.READ.u.d
     */
    @Test
    void getByPropertyLikeSuccess() {
        // Call for recipe(s) by partial match.
        List<Recipe> recipes = genericDao.getByPropertyLike("recipeName", "m");

        // Verify we get number of results back based on the partial match.
        assertEquals(2, recipes.size());
    }

    /**
     * Verify successful update of a Book
     * c.r.UPDATE.d
     */
    @Test
    void updateSuccess() {
        // New recipe name to change original name to.
        String recipeName = "Grandma's Meatloaf";

        // Get recipe by the ID.
        Recipe recipeToUpdate = (Recipe)genericDao.getById(2);

        // Set recipe name to the new name and then insert to database.
        recipeToUpdate.setRecipeName(recipeName);
        genericDao.saveOrUpdate(recipeToUpdate);

        // Call on recipe and then verify the name has been changed.
        Recipe recipeAfterUpdate = (Recipe)genericDao.getById(2);
        assertEquals(recipeName, recipeAfterUpdate.getRecipeName());
    }

    /**
     * Verify successful deletion of a recipe
     * c.r.u.DELETE
     */
    @Test
    void deleteSuccess() {
        // Get a recipe from the database.
        Recipe retrievedRecipe = (Recipe)genericDao.getById(3);

        // Delete recipe from the database
        genericDao.delete(retrievedRecipe);

        // Try to get same recipe and verify it comes back null.
        assertNull(genericDao.getById(3));
    }
}






