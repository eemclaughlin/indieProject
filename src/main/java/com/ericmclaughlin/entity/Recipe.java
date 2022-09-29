package com.ericmclaughlin.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

/**
 * This represents a single recipe in the recipe tracker application.
 * @author eemclaughlin
 * @version v1.0 - 09-29-22
 */
@Entity(name = "Recipe")
@Table(name = "RECIPES")
public class Recipe {

    // Variables and associations to database for Hibernate.
    // Designation of ID for Hibernate
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "RecipeId")
    private int recipeId;

    @Column(name = "RecipeName")
    private String recipeName;

    @Column(name = "Description")
    private String description;

    @Column(name = "Notes")
    private String notes;

    // Connection to the user table to associate a user with a recipe(s)
    @ManyToOne
    private User user;

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
     * @param user        the user
     */
    public Recipe(String recipeName, String description, String notes, User user) {
        this.recipeName = recipeName;
        this.description = description;
        this.notes = notes;
        this.user = user;
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

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeId=" + recipeId +
                ", recipeName='" + recipeName + '\'' +
                ", description='" + description + '\'' +
                ", notes='" + notes + '\'' +
                ", user=" + user +
                '}';
    }
}