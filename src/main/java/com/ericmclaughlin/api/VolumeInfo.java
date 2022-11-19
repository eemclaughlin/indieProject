package com.ericmclaughlin.api;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Volume info.
 */
public class VolumeInfo{

	@JsonProperty("industryIdentifiers")
	private List<IndustryIdentifiersItem> industryIdentifiers;

	@JsonProperty("pageCount")
	private int pageCount;

	@JsonProperty("publisher")
	private String publisher;

	@JsonProperty("description")
	private String description;

	@JsonProperty("language")
	private String language;

	@JsonProperty("publishedDate")
	private String publishedDate;

	@JsonProperty("categories")
	private List<String> categories;

	@JsonProperty("title")
	private String title;

	@JsonProperty("maturityRating")
	private String maturityRating;

	@JsonProperty("imageLinks")
	private ImageLinks imageLinks;

	@JsonProperty("authors")
	private List<String> authors;

	/**
	 * Set industry identifiers.
	 *
	 * @param industryIdentifiers the industry identifiers
	 */
	public void setIndustryIdentifiers(List<IndustryIdentifiersItem> industryIdentifiers){
		this.industryIdentifiers = industryIdentifiers;
	}

	/**
	 * Get industry identifiers list.
	 *
	 * @return the list
	 */
	public List<IndustryIdentifiersItem> getIndustryIdentifiers(){
		return industryIdentifiers;
	}

	/**
	 * Set page count.
	 *
	 * @param pageCount the page count
	 */
	public void setPageCount(int pageCount){
		this.pageCount = pageCount;
	}

	/**
	 * Get page count int.
	 *
	 * @return the int
	 */
	public int getPageCount(){
		return pageCount;
	}

	/**
	 * Set publisher.
	 *
	 * @param publisher the publisher
	 */
	public void setPublisher(String publisher){
		this.publisher = publisher;
	}

	/**
	 * Get publisher string.
	 *
	 * @return the string
	 */
	public String getPublisher(){
		return publisher;
	}

	/**
	 * Set description.
	 *
	 * @param description the description
	 */
	public void setDescription(String description){
		this.description = description;
	}

	/**
	 * Get description string.
	 *
	 * @return the string
	 */
	public String getDescription(){
		return description;
	}

	/**
	 * Set language.
	 *
	 * @param language the language
	 */
	public void setLanguage(String language){
		this.language = language;
	}

	/**
	 * Get language string.
	 *
	 * @return the string
	 */
	public String getLanguage(){
		return language;
	}

	/**
	 * Set published date.
	 *
	 * @param publishedDate the published date
	 */
	public void setPublishedDate(String publishedDate){
		this.publishedDate = publishedDate;
	}

	/**
	 * Get published date string.
	 *
	 * @return the string
	 */
	public String getPublishedDate(){
		return publishedDate;
	}

	/**
	 * Set categories.
	 *
	 * @param categories the categories
	 */
	public void setCategories(List<String> categories){
		this.categories = categories;
	}

	/**
	 * Get categories list.
	 *
	 * @return the list
	 */
	public List<String> getCategories(){
		return categories;
	}

	/**
	 * Set title.
	 *
	 * @param title the title
	 */
	public void setTitle(String title){
		this.title = title;
	}

	/**
	 * Get title string.
	 *
	 * @return the string
	 */
	public String getTitle(){
		return title;
	}

	/**
	 * Set maturity rating.
	 *
	 * @param maturityRating the maturity rating
	 */
	public void setMaturityRating(String maturityRating){
		this.maturityRating = maturityRating;
	}

	/**
	 * Get maturity rating string.
	 *
	 * @return the string
	 */
	public String getMaturityRating(){
		return maturityRating;
	}

	/**
	 * Set image links.
	 *
	 * @param imageLinks the image links
	 */
	public void setImageLinks(ImageLinks imageLinks){
		this.imageLinks = imageLinks;
	}

	/**
	 * Get image links image links.
	 *
	 * @return the image links
	 */
	public ImageLinks getImageLinks(){
		return imageLinks;
	}

	/**
	 * Set authors.
	 *
	 * @param authors the authors
	 */
	public void setAuthors(List<String> authors){
		this.authors = authors;
	}

	/**
	 * Get authors list.
	 *
	 * @return the list
	 */
	public List<String> getAuthors(){
		return authors;
	}
}