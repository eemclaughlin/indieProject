package com.ericmclaughlin.persistence;

import com.ericmclaughlin.entity.Cookbook;
import com.ericmclaughlin.entity.Recipe;
import com.ericmclaughlin.entity.Tag;
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
public class TagsDaoTest {
    /**
     * Instance of the generic dao.
     */
    GenericDao genericDaoRecipe;
    GenericDao genericDaoCookbook;
    GenericDao genericDaoUser;
    GenericDao genericDaoTag;

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
        genericDaoTag = new GenericDao(Tag.class);
    }

    /**
     * Verify successful insert of an item
     * CREATE.r.u.d
     */
    @Test
    void insertSuccess() {
        // Create new entity.
        Tag newTag = new Tag("Cabbage", "Cabbage is a leafy green");

        // Do the insert for user.
        int tagId = genericDaoTag.insert(newTag);
        assertNotEquals(0, tagId);

        // Verify the insert.
        assertNotNull(tagId);

        // Get the entity from the database and test.
        List<Tag> insertedTag = genericDaoTag.getByPropertyEqual("tagName", "Cabbage");
        assertEquals(1, insertedTag.size());
    }

    /**
     * Verify successful retrieval of all entities
     * c.READ.u.d
     */
    @Test
    void getAllSuccess() {
        // Get all entities from the database.
        List<Tag> tags = genericDaoTag.getAll();

        // Verify the results.
        assertEquals(4, tags.size());
    }

    /**
     * Verify successful retrieval of an entity by the ID
     * c.READ.u.d
     */
    @Test
    void getByIdSuccess() {
        // Get the entity from the database and test.
        Tag retrievedTag = (Tag) genericDaoTag.getById(3);
        assertNotNull(retrievedTag);
        assertEquals("Carrots", retrievedTag.getTagName());
        assertEquals("Carrots", retrievedTag.getDescription());
    }

    /**
     * Verify successful get of an entity by a property (equal match)
     * c.READ.u.d
     */
    @Test
    void getByPropertyEqualSuccess() {
        // Call for an entity by a exact name
        List<Tag> tags = genericDaoTag.getByPropertyEqual("tagName", "Carrots");

        // Verify we get 1 result back and that the ID matches expected ID.
        assertEquals(1, tags.size());
        assertEquals(3, tags.get(0).getTagId());
    }

    /**
     * Verify successful get of entity(s) by partial property (like match)
     * c.READ.u.d
     */
    @Test
    void getByPropertyLikeSuccess() {
        // Call for entity(s) by partial match.
        List<Tag> tags = genericDaoTag.getByPropertyLike("tagName", "o");

        // Verify we get number of results back based on the partial match.
        assertEquals(2, tags.size());
    }

    /**
     * Verify successful update of an entity
     * c.r.UPDATE.d
     */
    @Test
    void updateSuccess() {
        // New entity name to change original name to.
        String newTag = "Half and Half";

        // Get entity by the ID.
        Tag tagToUpdate = (Tag) genericDaoTag.getById(2);

        // Set entity name to the new name and then insert to database.
        tagToUpdate.setTagName(newTag);
        genericDaoTag.saveOrUpdate(tagToUpdate);

        // Call on entity and then verify the name has been changed.
        Tag tagAfterUpdate = (Tag) genericDaoTag.getById(2);
        assertEquals(newTag, tagAfterUpdate.getTagName());
    }

    /**
     * Verify successful deletion of an entity
     * c.r.u.DELETE
     */
    @Test
    void deleteSuccess() {
        // Get a entity from the database.
        User userToDelete = (User) genericDaoUser.getById(2);
        Tag tagToDelete = (Tag) genericDaoTag.getById(2);

        // Delete entity from the database
        genericDaoTag.delete(tagToDelete);

        // Try to get same entity and verify it comes back null.
        assertNull(genericDaoTag.getById(2));
    }
}






