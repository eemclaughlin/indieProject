package com.ericmclaughlin.persistence;

import com.ericmclaughlin.entity.Recipe;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import java.util.List;

public class RecipeDao {
    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets all recipes
     * @return all the recipes
     */
    public List<Recipe> getAllRecipes() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Recipe> query = builder.createQuery(Recipe.class);
        Root<Recipe> root = query.from(Recipe.class);
        List<Recipe> recipes = session.createQuery(query).getResultList();
        session.close();
        return recipes;
    }

    /**
     * Gets a single recipe by id
     * @param id Recipe ID to search by
     * @return a single recipe
     */
    public Recipe getById(int id) {
        Session session = sessionFactory.openSession();
        Recipe recipe = session.get(Recipe.class, id);
        session.close();
        return recipe;
    }

    /**
     * update order
     * @param recipe  Recipe to be updated
     */
    public void saveOrUpdate(Recipe recipe) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(recipe);
        transaction.commit();
        session.close();
    }

    /**
     * Insert new order
     * @param recipe  Recipe to be inserted or updated
     * @return id of the inserted recipe
     */
    public int insert(Recipe recipe) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(recipe);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a recipe
     * @param recipe Recipe to be deleted
     */
    public void delete(Recipe recipe) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(recipe);
        transaction.commit();
        session.close();
    }

    /**
     * Get recipe by property (exact match)
     * sample usage: getByPropertyEqual("recipeName", "Carrot Cake")
     *
     * @param propertyName entity property to search by
     * @param value value of the property to search for
     * @return list of orders meeting the criteria search
     */
    public List<Recipe> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for recipe with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Recipe> query = builder.createQuery( Recipe.class );
        Root<Recipe> root = query.from( Recipe.class );
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<Recipe> recipes = session.createQuery( query ).getResultList();

        session.close();
        return recipes;
    }

    /**
     * Get order by property (like)
     * sample usage: getByPropertyLike("recipeName", "Carrot Cake")
     *
     * @param propertyName entity property to search by
     * @param value value of the property to search for
     * @return list of orders meeting the criteria search
     */
    public List<Recipe> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for order with {} = {}",  propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Recipe> query = builder.createQuery( Recipe.class );
        Root<Recipe> root = query.from( Recipe.class );
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<Recipe> recipes = session.createQuery( query ).getResultList();
        session.close();
        return recipes;
    }
}