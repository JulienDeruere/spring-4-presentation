package com.presentation.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public abstract class GenericDao<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    protected Class<T> clazz;

    protected GenericDao() {}

    public GenericDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T findById(long id) {
        return entityManager.find(clazz, id);
    }

    public void persist(T transientInstance) {
        entityManager.persist(transientInstance);
    }

    public void remove(T transientInstance) {
        entityManager.remove(transientInstance);
    }

    public T merge(T transientInstance) {
        return entityManager.merge(transientInstance);
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return entityManager.createQuery("Select t From " + clazz.getName() + " t").getResultList();
    }
}