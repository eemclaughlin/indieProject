package com.ericmclaughlin.entity;

import javax.persistence.*;
import java.io.Serializable;
import org.hibernate.annotations.GenericGenerator;

/**
 * The type User cookbooks.
 */
@Entity(name = "UserCookbooks")
@Table(name = "user_cookbooks")
public class UserCookbooks implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Id
    @ManyToOne
    @JoinColumn(name = "user_cd", referencedColumnName = "user_id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "cookbook_cd", referencedColumnName = "cookbook_id")
    private Cookbook cookbookWithUser;

    /**
     * Instantiates a new User cookbooks.
     */
    public UserCookbooks() {
    }

    /**
     * Instantiates a new User cookbooks.
     * @param user     the user
     * @param cookbookWithUser the cookbook
     */
    public UserCookbooks(User user, Cookbook cookbookWithUser) {
        this.user = user;
        this.cookbookWithUser = cookbookWithUser;
    }

    // **** GETTERS AND SETTERS AND TOSTRING ****
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
     * Gets cookbook.
     * @return the cookbook
     */
    public Cookbook getCookbook() {
        return cookbookWithUser;
    }

    /**
     * Sets cookbook.
     * @param cookbook the cookbook
     */
    public void setCookbook(Cookbook cookbook) {
        this.cookbookWithUser = cookbookWithUser;
    }

    @Override
    public String toString() {
        return "UserCookbooks{" +
                "id=" + id +
                ", user=" + user +
                ", cookbook=" + cookbookWithUser +
                '}';
    }
}
