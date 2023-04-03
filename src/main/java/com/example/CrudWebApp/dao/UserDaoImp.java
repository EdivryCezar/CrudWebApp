package com.example.CrudWebApp.dao;

import org.springframework.stereotype.Repository;
import com.example.CrudWebApp.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;


    /*public UserDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }*/


    @Override
    public void deleteUser(long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public List<User> listUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUser(long id) {
        User user = entityManager.find(User.class, id);
        return user;
    }
    @Override
    public void updateUser(long id, User user) {
        entityManager.merge(user);
    }
}