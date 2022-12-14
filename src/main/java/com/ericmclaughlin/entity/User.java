package com.ericmclaughlin.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * A class to represent a user/user account to associate with recipes.
 *
 * @author eemclaughlin
 * @version v2.0 11-19-22 eem.
 */
@Entity(name = "User")
@Table(name = "user")
public class User {

    // Variables and hibernate column associations.
    // Designation of id column.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "user_id")
    private int userId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @Column(name = "login_name")
    private String userName;

    // Connection to the COOKBOOK table to associate a user with a cookbook(s).
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Cookbook> cookbooks = new HashSet<>();

    // Connection to the RECIPE table/class.  One user can have several recipes.
    // Mapped by refers to instance variable on the ManyToOne on child class (Recipe in this case).
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Recipe> recipes = new HashSet<>();

    // Constructors
    /**
     * No argument constructor
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Constructor with user arguments.
     * Instantiates a new User.
     * @param firstName the first name
     * @param lastName  the last name
     * @param email  the email
     * @param userName  the user name
     */
    public User(String firstName, String lastName, String email, String userName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
    }

    // UNIQUE METHODS
    /**
     * Add recipe associated with user.
     * @param recipe the given recipe
     */
    public void addRecipe(Recipe recipe) {
        // Add set of recipes to recipe.
        recipes.add(recipe);
        // On that recipe, set a user.
        recipe.setUser(this);
    }

    /**
     * Remove recipe.
     * @param recipe the recipe
     */
    public void removeRecipe(Recipe recipe) {
        recipes.remove(recipe);
        recipe.setUser(null);;
    }

    /**
     * Add cookbook associated with user.
     * @param cookbook the given recipe
     */
    public void addCookbook(Cookbook cookbook) {
        // Add set of recipes to recipe.
        cookbooks.add(cookbook);
        // On that recipe, set a user.
        cookbook.setUser(this);
    }

    /**
     * Remove cookbook.
     * @param cookbook the recipe
     */
    public void removeCookbook(Cookbook cookbook) {
        cookbooks.remove(cookbook);
        cookbook.setUser(null);;
    }

    // **** GETTERS AND SETTERS AND TOSTRING ****
    /**
     * Gets user id.
     * @return the user id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets user id.
     * @param userId the user id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets first name.
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets email.
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets username.
     * @return the username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets username.
     * @param userName the username
     */
    public void setUserName(String userName) {
        this.userName = userName;
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

    /**
     * Gets cookbooks.
     * @return the cookbooks
     */
    public Set<Cookbook> getCookbooks() {
        return cookbooks;
    }

    /**
     * Sets cookbooks.
     * @param cookbooks the cookbooks
     */
    public void setCookbooks(Set<Cookbook> cookbooks) {
        this.cookbooks = cookbooks;
    }

    // TO STRING
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", cookbooks=" + cookbooks +
                ", recipes=" + recipes +
                '}';
    }
}
