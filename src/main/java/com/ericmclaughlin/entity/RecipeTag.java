package com.ericmclaughlin.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Method for storing the relationship between a recipe and a tag.
 * Junction table denoted that a recipe can have several tags.
 * @author Eric McLaughlin
 * @version 2.0 11-19-22 eem.
 */
@Entity(name = "RecipeTag")
@Table(name = "recipe_tags")
public class RecipeTag implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Id
    @ManyToOne
    @JoinColumn(name = "recipe_cd", referencedColumnName = "recipe_id")
    private Recipe recipe;

    @Id
    @ManyToOne
    @JoinColumn(name = "tag_cd", referencedColumnName = "tag_id")
    private Tag tag;

    // CONSTRUCTORS
    /**
     * Instantiates a new Recipe tag.
     */
    public RecipeTag() {
    }

    /**
     * Instantiates a new Recipe tag.
     * @param recipe the recipe
     * @param tag    the tag
     */
    public RecipeTag(Recipe recipe, Tag tag) {
        this.recipe = recipe;
        this.tag = tag;
    }

    // GETTERS AND SETTERS
    /**
     * Gets id.
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets recipe.
     * @return the recipe
     */
    public Recipe getRecipe() {
        return recipe;
    }

    /**
     * Sets recipe.
     * @param recipe the recipe
     */
    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    /**
     * Gets tag.
     * @return the tag
     */
    public Tag getTag() {
        return tag;
    }

    /**
     * Sets tag.
     * @param tag the tag
     */
    public void setTag(Tag tag) {
        this.tag = tag;
    }

    // TO STRING
    @Override
    public String toString() {
        return "RecipeTag{" +
                "id=" + id +
                ", recipe=" + recipe +
                ", tag=" + tag +
                '}';
    }
}
