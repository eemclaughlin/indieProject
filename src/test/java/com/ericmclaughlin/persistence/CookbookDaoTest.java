package com.ericmclaughlin.persistence;

import com.ericmclaughlin.entity.Cookbook;
import com.ericmclaughlin.entity.Recipe;
import com.ericmclaughlin.entity.User;
import com.ericmclaughlin.testutil.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for accessing the database via the genericDaoTags.
 * @author eemclaughlin
 * @version 1.2 = 10-02-22
 */
public class CookbookDaoTest {
    /**
     * Instance of the generic dao.
     */
    GenericDao genericDaoRecipe;
    GenericDao genericDaoCookbook;
    GenericDao genericDaoUser;

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
        genericDaoRecipe = new GenericDao(Recipe.class);
        genericDaoCookbook = new GenericDao(Cookbook.class);
        genericDaoUser = new GenericDao(User.class);
    }

    /**
     * Verify successful insert of an item
     * CREATE.r.u.d
     */
    @Test
    void insertSuccess() {
        // Create new user.
        User newUser = new User("Bill", "Nye", "NyeB", "NyeB");

        // Create a new entity.
        Cookbook newCookbook = new Cookbook("Greatest Cookbook", "Bob Hamelin",
                "Hamelin Press",null, "A Test Cookbook",
                "1231231231", "1231231231231", 123, "EN",
                null, null, "Test Note", newUser);

        // Do the insert for user.
        int userId = genericDaoRecipe.insert(newUser);
        assertNotEquals(0, userId);

        // Insert the entity.
        newUser.addCookbook(newCookbook);
        int cookbookId = genericDaoCookbook.insert(newCookbook);

        // Verify the insert.
        assertNotNull(userId);
        assertNotNull(cookbookId);

        // Get the entity from the database and test.
        List<Cookbook> insertedCookbook = genericDaoCookbook.getByPropertyEqual("title", "Greatest Cookbook");
        assertEquals(1, insertedCookbook.size());
    }

    /**
     * Verify successful retrieval of all entities
     * c.READ.u.d
     */
    @Test
    void getAllSuccess() {
        // Get all entities from the database.
        List<Cookbook> cookbooks = genericDaoCookbook.getAll();

        // Verify the results.
        assertEquals(2, cookbooks.size());
    }

    /**
     * Verify successful retrieval of an entity by the ID
     * c.READ.u.d
     */
    @Test
    void getByIdSuccess() {
        // Get the entity from the database and test.
        Cookbook retrievedCookbook = (Cookbook)genericDaoCookbook.getById(1);
        assertNotNull(retrievedCookbook);
        assertEquals("The Best Cookbook", retrievedCookbook.getTitle());
        assertEquals("Jean-Luc Picard", retrievedCookbook.getAuthor());
        assertEquals("Enterprise Press", retrievedCookbook.getPublisher());
        assertEquals(1, retrievedCookbook.getUser().getUserId());
    }

    /**
     * Verify successful get of an entity by a property (equal match)
     * c.READ.u.d
     */
    @Test
    void getByPropertyEqualSuccess() {
        // Call for an entity by a exact name
        List<Cookbook> cookbooks = genericDaoCookbook.getByPropertyEqual
                ("title", "The Next Best Cookbook");

        // Verify we get 1 result back and that the ID matches expected ID.
        assertEquals(1, cookbooks.size());
        assertEquals(2, cookbooks.get(0).getCookbookId());
    }

    /**
     * Verify successful get of entity(s) by partial property (like match)
     * c.READ.u.d
     */
    @Test
    void getByPropertyLikeSuccess() {
        // Call for entity(s) by partial match.
        List<Cookbook> cookbooks = genericDaoCookbook.getByPropertyLike
                ("title", "The");

        // Verify we get number of results back based on the partial match.
        assertEquals(2, cookbooks.size());
    }

    /**
     * Verify successful update of an entity
     * c.r.UPDATE.d
     */
    @Test
    void updateSuccess() {
        // New entity name to change original name to.
        String cookbookTitle = "The Best Cookbook Ever";

        // Get entity by the ID.
        Cookbook cookbookToUpdate = (Cookbook) genericDaoCookbook.getById(1);

        // Set entity name to the new name and then insert to database.
        cookbookToUpdate.setTitle(cookbookTitle);
        genericDaoCookbook.saveOrUpdate(cookbookToUpdate);

        // Call on entity and then verify the name has been changed.
        Cookbook cookbookAfterUpdate = (Cookbook) genericDaoCookbook.getById(1);
        assertEquals(cookbookTitle, cookbookAfterUpdate.getTitle());
    }

    /**
     * Verify successful deletion of an entity
     * c.r.u.DELETE
     */
    @Test
    void deleteSuccess() {
        // Get a entity from the database.
        Cookbook cookbookToDelete = (Cookbook) genericDaoCookbook.getById(2);

        // Delete entity from the database
        genericDaoCookbook.delete(cookbookToDelete);

        // Try to get same entity and verify it comes back null.
        assertNull(genericDaoRecipe.getById(2));
    }
}






