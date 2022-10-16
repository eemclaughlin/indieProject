package com.ericmclaughlin.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * A class to represent a user/user account to associate with recipes.
 * @author eemclaughlin
 * @version v1.0 - 09-29-22
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

    // Connection to the RECIPE table/class.  One user can have several recipes.
    // Mapped by refers to instance variable on the ManyToOne on child class (Recipe in this case).
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Recipe> recipes = new HashSet<>();

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
     *
     */
    public User(String firstName, String lastName, String email, String userName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
    }

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
    public void removeBook(Recipe recipe) {
        recipes.remove(recipe);
        recipe.setUser(null);;
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
     * Gets user name.
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     * @param userName the user name
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

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", recipes=" + recipes +
                '}';
    }
}
