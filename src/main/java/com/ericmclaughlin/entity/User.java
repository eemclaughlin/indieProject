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
 * @version v1.2 - 10-31-22
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

    // Many to Many Connection to cookbooks via a junction table user_cookbooks.
    // cookbook refers to cookbook on the UserCookbook class.
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<UserCookbooks> cookbookWithUser = new HashSet<>();

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
     * Add a cookbook associated with a user
     * @param cookbook the cookbook to add to the user.
     */
    public void addCookbook(Cookbook cookbook) {
        UserCookbooks userCookbooks = new UserCookbooks(this, cookbook);
        cookbookWithUser.add(userCookbooks);
        cookbook.getUser().add(userCookbooks);
    }

    public void removeCookbook(Cookbook cookbook) {
        for (Iterator<UserCookbooks> iterator = cookbookWithUser.iterator(); iterator.hasNext(); ) {
            UserCookbooks userCookbooks = iterator.next();

            if (userCookbooks.getCookbook().equals(this) && userCookbooks.getUser().equals(cookbook)) {
                iterator.remove();
                userCookbooks.getCookbook().getUser().remove(userCookbooks);
                userCookbooks.setCookbook(null);
                userCookbooks.setUser(null);
            }
        }
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
    public Set<UserCookbooks> getCookbooks() {
        return cookbookWithUser;
    }

    /**
     * Sets cookbooks.
     * @param cookbooks the cookbooks
     */
    public void setCookbooks(Set<UserCookbooks> cookbooks) {
        this.cookbookWithUser = cookbooks;
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
