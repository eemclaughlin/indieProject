package com.ericmclaughlin.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Class for referencing Tags out from the database.  Tags are used with recipes for better
 * sorting and searching.
 * @author Eric McLaughlin
 * @version 2.0 11-19-22 eem.
 */
@Entity(name = "Tag")
@Table(name = "tags")
public class Tag {

    // Variables and hibernate column associations.
    // Designation of id column.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "tag_id")
    private int tagId;
    @Column(name = "tag_name")
    private String tagName;
    private String description;

    // Many to Many Connection to recipes via a junction table recipe_tags.
    // tag refers to tag on the RecipeTag class.
    @OneToMany(mappedBy = "tag", fetch = FetchType.EAGER)
    private Set<RecipeTag> recipes = new HashSet<>();

    // Constructors
    /**
     * No argument constructor
     * Instantiates a new Tags.
     */
    public Tag() {
    }

    /**
     * Argument constructor
     * Instantiates a new Tags.
     * @param tagName     the tag name
     * @param description the description
     */
    public Tag(String tagName, String description) {
        this.tagName = tagName;
        this.description = description;
    }

    // Getters and Setters
    /**
     * Gets tag id.
     * @return the tag id
     */
    public int getTagId() {
        return tagId;
    }

    /**
     * Sets tag id.
     * @param tagId the tag id
     */
    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    /**
     * Gets tag name.
     * @return the tag name
     */
    public String getTagName() {
        return tagName;
    }

    /**
     * Sets tag name.
     * @param tagName the tag name
     */
    public void setTagName(String tagName) {
        this.tagName = tagName;
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
     * Gets recipes.
     * @return the recipes
     */
    public Set<RecipeTag> getRecipes() {
        return recipes;
    }

    /**
     * Sets recipes.
     * @param recipes the recipes
     */
    public void setRecipes(Set<RecipeTag> recipes) {
        this.recipes = recipes;
    }

    // toString
    @Override
    public String toString() {
        return "Tags{" +
                "tagId=" + tagId +
                ", tagName='" + tagName + '\'' +
                ", description='" + description + '\'' +
                ", recipes=" + recipes +
                '}';
    }
}
