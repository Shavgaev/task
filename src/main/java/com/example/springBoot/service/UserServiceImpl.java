package com.example.springBoot.service;

import com.example.springBoot.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.springBoot.dao.UserDao;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    @Transactional
    public void deleteUserById(int id) {
        userDao.deleteUserById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public User updateUser(int id, User user) {
        user.setId(id);
        return userDao.updateUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> getUserById(int id) {
        return userDao.getUserById(id);
    }
}