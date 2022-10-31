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
    private String author;
    private String publisher;
    @Column(name = "published_date")
    private String publishedDate;
    private String description;
    @Column(name = "isbn_ten")
    private String isdnTen;
    @Column(name = "isbn_thirteen")
    private String isdnThirteen;
    @Column(name = "page_count")
    private Integer pageCount;
    private String language;
    @Column(name = "small_image_link")
    private String smallImageLink;
    @Column(name = "med_image_link")
    private String mediumImageLink;
    // Connection to the RECIPE table/class.  One cookbook can have several recipes.
    // Mapped by refers to instance variable on the ManyToOne on child class (Recipe in this case).
    @OneToMany(mappedBy = "cookbooks", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Recipe> recipes = new HashSet<>();

    @OneToMany(mappedBy = "cookbookWithUser", fetch = FetchType.EAGER)
    private Set<UserCookbooks> user = new HashSet<>();

    /**
     * No argument constructor
     * Instantiates a new Cookbook.
     */
    public Cookbook() {
    }

    /**
     * Constructor with arguments.
     * Instantiates a new Cookbook.
     *
     * @param title           the title
     * @param author          the author
     * @param publisher       the publisher
     * @param publishedDate   the published date
     * @param description     the description
     * @param isdnTen         the isdn ten
     * @param isdnThirteen    the isdn thirteen
     * @param pageCount       the page count
     * @param language        the language
     * @param smallImageLink  the small image link
     * @param mediumImageLink the medium image link
     */
    public Cookbook(String title, String author, String publisher, String publishedDate, String description, String isdnTen, String isdnThirteen, int pageCount, String language, String smallImageLink, String mediumImageLink) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.description = description;
        this.isdnTen = isdnTen;
        this.isdnThirteen = isdnThirteen;
        this.pageCount = pageCount;
        this.language = language;
        this.smallImageLink = smallImageLink;
        this.mediumImageLink = mediumImageLink;
    }

    /**
     * Add recipe associated with cookbook.
     *
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
     *
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
     * Gets author.
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets author.
     * @param author the author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets publisher.
     * @return the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Sets publisher.
     * @param publisher the publisher
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * Gets published date.
     * @return the published date
     */
    public String getPublishedDate() {
        return publishedDate;
    }

    /**
     * Sets published date.
     * @param publishedDate the published date
     */
    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
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
     * Gets isdn ten.
     * @return the isdn ten
     */
    public String getIsdnTen() {
        return isdnTen;
    }

    /**
     * Sets isdn ten.
     * @param isdnTen the isdn ten
     */
    public void setIsdnTen(String isdnTen) {
        this.isdnTen = isdnTen;
    }

    /**
     * Gets isdn thirteen.
     * @return the isdn thirteen
     */
    public String getIsdnThirteen() {
        return isdnThirteen;
    }

    /**
     * Sets isdn thirteen.
     * @param isdnThirteen the isdn thirteen
     */
    public void setIsdnThirteen(String isdnThirteen) {
        this.isdnThirteen = isdnThirteen;
    }

    /**
     * Gets page count.
     * @return the page count
     */
    public int getPageCount() {
        return pageCount;
    }

    /**
     * Sets page count.
     * @param pageCount the page count
     */
    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    /**
     * Gets language.
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets language.
     * @param language the language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Gets small image link.
     * @return the small image link
     */
    public String getSmallImageLink() {
        return smallImageLink;
    }

    /**
     * Sets small image link.
     * @param smallImageLink the small image link
     */
    public void setSmallImageLink(String smallImageLink) {
        this.smallImageLink = smallImageLink;
    }

    /**
     * Gets medium image link.
     * @return the medium image link
     */
    public String getMediumImageLink() {
        return mediumImageLink;
    }

    /**
     * Sets medium image link.
     * @param mediumImageLink the medium image link
     */
    public void setMediumImageLink(String mediumImageLink) {
        this.mediumImageLink = mediumImageLink;
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
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publishedDate='" + publishedDate + '\'' +
                ", description='" + description + '\'' +
                ", isdnTen='" + isdnTen + '\'' +
                ", isdnThirteen='" + isdnThirteen + '\'' +
                ", pageCount=" + pageCount +
                ", language='" + language + '\'' +
                ", smallImageLink='" + smallImageLink + '\'' +
                ", mediumImageLink='" + mediumImageLink + '\'' +
                ", recipes=" + recipes +
                '}';
    }
}
