package com.presentation.dao;

import com.presentation.model.User;
import org.springframework.stereotype.Repository;

/**
 * @author jderuere
 */
@Repository
public class UserDao extends GenericDao<User> {

    public UserDao() {
        super(User.class);
    }
}
