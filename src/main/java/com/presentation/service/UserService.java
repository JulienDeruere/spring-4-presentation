package com.presentation.service;

import com.presentation.dao.GenericDao;
import com.presentation.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Transactional
@Service("patientService")
public class UserService {

    @Inject
    private GenericDao<User> userDao;

    public User getUser(long id) {
        return userDao.findById(id);
    }

    public void add(User user) {
        userDao.persist(user);
    }

    public List<User> getUsers() {
        return userDao.findAll();
    }
}