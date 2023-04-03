package com.example.CrudWebApp.dao;

import com.example.CrudWebApp.model.User;

import java.util.List;

public interface UserDao {

    void deleteUser(long id);

    List<User> listUsers();

    void addUser(User user);

    User getUser(long id);

    void updateUser(long id, User user);
}
