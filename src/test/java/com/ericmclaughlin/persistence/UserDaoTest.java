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
public class UserDaoTest {
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

        // Do the insert for user.
        int userId = genericDaoUser.insert(newUser);
        assertNotEquals(0, userId);

        // Verify the insert.
        assertNotNull(userId);

        // Get the entity from the database and test.
        List<User> insertedUser = genericDaoUser.getByPropertyEqual("lastName", "Nye");
        assertEquals(1, insertedUser.size());
    }

    /**
     * Verify successful retrieval of all entities
     * c.READ.u.d
     */
    @Test
    void getAllSuccess() {
        // Get all entities from the database.
        List<User> users = genericDaoUser.getAll();

        // Verify the results.
        assertEquals(3, users.size());
    }

    /**
     * Verify successful retrieval of an entity by the ID
     * c.READ.u.d
     */
    @Test
    void getByIdSuccess() {
        // Get the entity from the database and test.
        User retrievedUser = (User) genericDaoUser.getById(3);
        assertNotNull(retrievedUser);
        assertEquals("Bob", retrievedUser.getFirstName());
        assertEquals("Hamelin", retrievedUser.getLastName());
        assertEquals("bobh@outlook.com", retrievedUser.getEmail());
        assertEquals("HamelB", retrievedUser.getUserName());
    }

    /**
     * Verify successful get of an entity by a property (equal match)
     * c.READ.u.d
     */
    @Test
    void getByPropertyEqualSuccess() {
        // Call for an entity by a exact name
        List<User> users = genericDaoUser.getByPropertyEqual
                ("lastName", "Hamelin");

        // Verify we get 1 result back and that the ID matches expected ID.
        assertEquals(1, users.size());
        assertEquals(3, users.get(0).getUserId());
    }

    /**
     * Verify successful get of entity(s) by partial property (like match)
     * c.READ.u.d
     */
    @Test
    void getByPropertyLikeSuccess() {
        // Call for entity(s) by partial match.
        List<User> users = genericDaoUser.getByPropertyLike
                ("firstName", "e");

        // Verify we get number of results back based on the partial match.
        assertEquals(2, users.size());
    }

    /**
     * Verify successful update of an entity
     * c.r.UPDATE.d
     */
    @Test
    void updateSuccess() {
        // New entity name to change original name to.
        String newFirstName = "Bill";

        // Get entity by the ID.
        User userToUpdate = (User) genericDaoUser.getById(2);

        // Set entity name to the new name and then insert to database.
        userToUpdate.setFirstName(newFirstName);
        genericDaoUser.saveOrUpdate(userToUpdate);

        // Call on entity and then verify the name has been changed.
        User userAfterUpdate = (User) genericDaoUser.getById(2);
        assertEquals(newFirstName, userAfterUpdate.getFirstName());
    }

    /**
     * Verify successful deletion of an entity
     * c.r.u.DELETE
     */
    @Test
    void deleteSuccess() {
        // Get a entity from the database.
        User userToDelete = (User) genericDaoUser.getById(2);

        // Delete entity from the database
        genericDaoUser.delete(userToDelete);

        // Try to get same entity and verify it comes back null.
        assertNull(genericDaoUser.getById(2));
    }
}






