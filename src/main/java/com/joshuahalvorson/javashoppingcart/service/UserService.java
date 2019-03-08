package com.joshuahalvorson.javashoppingcart.service;

import com.joshuahalvorson.javashoppingcart.model.User;
import java.util.List;

public interface UserService {
    User save(User user);

    List<User> findAll();

    void delete(long id);
}
