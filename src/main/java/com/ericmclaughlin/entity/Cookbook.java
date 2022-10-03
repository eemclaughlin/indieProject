package com.ericmclaughlin.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * A class to represent a cookbook to associate with recipes.
 *
 * @author eemclaughlin
 * @version v1.0 - 10-02-22
 */
@Entity(name = "Cookbook")
@Table(name = "cookbooks")
public class Cookbook {

    // Variables and hibernate column associations.
    // Designation of id column.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "cookbook_id")
    private int cookbookId;
    private String title;
    private String description;
    private String isdn;
    private String notes;
    // Connection to the RECIPE table/class.  One cookbook can have several recipes.
    // Mapped by refers to instance variable on the ManyToOne on child class (Recipe in this case).
    @OneToMany(mappedBy = "cookbooks", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Recipe> recipes = new HashSet<>();

    /**
     * No argument constructor
     * Instantiates a new Cookbook.
     */
    public Cookbook() {
    }

    /**
     * Constructor
     * Instantiates a new Cookbook.
     * @param title       the title
     * @param description the description
     * @param isdn        the isdn
     * @param notes       the notes
     */
    public Cookbook(String title, String description, String isdn, String notes) {
        this.title = title;
        this.description = description;
        this.isdn = isdn;
        this.notes = notes;
    }

    /**
     * Add recipe associated with cookbook.
     * @param recipe the given recipe
     */
    public void addRecipe(Recipe recipe) {
        // Add set of recipes to recipe.
        recipes.add(recipe);
        // On that recipe, set a cookbook.
        recipe.setCookbooks(this);
    }

    /**
     * Remove recipe.
     * @param recipe the recipe
     */
    public void removeBook(Recipe recipe) {
        recipes.remove(recipe);
        recipe.setCookbooks(null);;
    }

    // **** GETTERS AND SETTERS AND TOSTRING ****
    /**
     * Gets cookbook id.
     * @return the cookbook id
     */
    public int getCookbookId() {
        return cookbookId;
    }

    /**
     * Sets cookbook id.
     * @param cookbookId the cookbook id
     */
    public void setCookbookId(int cookbookId) {
        this.cookbookId = cookbookId;
    }

    /**
     * Gets title.
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
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
     * Gets isdn.
     * @return the isdn
     */
    public String getIsdn() {
        return isdn;
    }

    /**
     * Sets isdn.
     * @param isdn the isdn
     */
    public void setIsdn(String isdn) {
        this.isdn = isdn;
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
     * Gets recipes.
     * @return the recipes
     */
    public Set<Recipe> getRecipes() {
        return recipes;
    }

    /**
     * Sets recipes.
     * @param recipes the recipes
     */
    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }

    @Override
    public String toString() {
        return "Cookbook{" +
                "cookbookId=" + cookbookId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", isdn='" + isdn + '\'' +
                ", notes='" + notes + '\'' +
                ", recipes=" + recipes +
                '}';
    }
}
