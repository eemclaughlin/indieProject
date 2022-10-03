package com.ericmclaughlin.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

/**
 * This represents a single recipe in the recipe tracker application.
 * @author eemclaughlin
 * @version v1.0 - 09-29-22
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

    /**
     * No argument constructor
     * Instantiates a new Recipe.
     */
    public Recipe() {
    }

    /**
     * Constructor with the relevant arguments
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