package com.ericmclaughlin.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * This represents a single recipe in the recipe tracker application.
 * @author eemclaughlin
 * @version v2.0 11-19-22 eem.
 */
@Entity(name = "Recipe")
@Table(name = "recipes")
public class Recipe {

    // Variables and associations to database for Hibernate.
    // Designation of ID for Hibernate
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "recipe_id")
    private int recipeId;
    @Column(name = "recipe_name")
    private String recipeName;
    private String description;
    private String notes;
    @Column(name = "page_number")
    private int pageNumber;

    // Connection to the user table to associate a user with a recipe(s)
    @ManyToOne
    @JoinColumn(name = "user_cd", foreignKey = @ForeignKey(name = "recipes_user"))
    private User user;

    // Connection to the user table to associate a user with a recipe(s)
    @ManyToOne
    @JoinColumn(name = "cookbook_cd", foreignKey = @ForeignKey(name = "recipes_cookbooks"))
    private Cookbook cookbooks;

    // Many to Many Connection to tags via a junction table recipe_tags.
    // recipe refers to recipe on the RecipeTag class.
    @OneToMany(mappedBy = "recipe", fetch = FetchType.EAGER)
    private Set<RecipeTag> tags = new HashSet<RecipeTag>();

    // CONSTRUCTORS
    /**
     * No argument constructor
     * Instantiates a new Recipe.
     */
    public Recipe() {
    }

    /**
     * Constructor with the relevant arguments (no tags)
     * Instantiates a new Recipe.
     * @param recipeName  the recipe name
     * @param description the description
     * @param notes       the notes
     * @param pageNumber  the page number
     * @param user        the user
     * @param cookbooks   the cookbooks
     */
    public Recipe(String recipeName, String description, String notes, int pageNumber, User user, Cookbook cookbooks) {
        this.recipeName = recipeName;
        this.description = description;
        this.notes = notes;
        this.pageNumber = pageNumber;
        this.user = user;
        this.cookbooks = cookbooks;
    }

    // UNIQUE METHODS
    /**
     * Pass in a tag, instantiate a new RecipeTag, pass in current recipe and new tag.
     * Add recipeTag to set of tags and then get tags and add to recipes.
     * @param tag
     */
    public void addTag(Tag tag) {
        RecipeTag recipeTag = new RecipeTag(this, tag);
        tags.add(recipeTag);
        tag.getRecipes().add(recipeTag);
    }

    /**
     * Iterate through list of tags and remove appropriate one.
     * @param tag
     */
    public void removeTag(Tag tag) {
        for(Iterator<RecipeTag> iterator = tags.iterator(); iterator.hasNext(); )
        {
            RecipeTag recipeTag = iterator.next();

            if(recipeTag.getTag().equals(this) && recipeTag.getRecipe().equals(tag))
            {
                iterator.remove();
                recipeTag.getTag().getRecipes().remove(recipeTag);
                recipeTag.setTag(null);
                recipeTag.setRecipe(null);
            }
        }
    }

    // **** GETTERS AND SETTERS AND TOSTRING ****
    /**
     * Gets recipe id.
     * @return the recipe id
     */
    public int getRecipeId() {
        return recipeId;
    }

    /**
     * Sets recipe id.
     * @param recipeId the recipe id
     */
    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    /**
     * Gets recipe name.
     * @return the recipe name
     */
    public String getRecipeName() {
        return recipeName;
    }

    /**
     * Sets recipe name.
     * @param recipeName the recipe name
     */
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    /**
     * Gets description.
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets notes.
     * @return the notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Sets notes.
     * @param notes the notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * Gets page number.
     * @return the page number
     */
    public int getPageNumber() {
        return pageNumber;
    }

    /**
     * Sets page number.
     * @param pageNumber the page number
     */
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    /**
     * Gets user.
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets cookbooks.
     * @return the cookbooks
     */
    public Cookbook getCookbooks() {
        return cookbooks;
    }

    /**
     * Sets cookbooks.
     * @param cookbooks the cookbooks
     */
    public void setCookbooks(Cookbook cookbooks) {
        this.cookbooks = cookbooks;
    }

    /**
     * Gets tags.
     * @return the tags
     */
    public Set<RecipeTag> getTags() {
        return tags;
    }

    /**
     * Sets tags.
     * @param tags the tags
     */
    public void setTags(Set<RecipeTag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeId=" + recipeId +
                ", recipeName='" + recipeName + '\'' +
                ", description='" + description + '\'' +
                ", notes='" + notes + '\'' +
                ", pageNumber='" + pageNumber + '\'' +
                ", user=" + user +
                ", cookbooks=" + cookbooks +
                '}';
    }
}