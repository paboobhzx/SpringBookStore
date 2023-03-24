package com.portfolio.springbootbookstore.service;

import com.portfolio.springbootbookstore.model.User;
import jakarta.transaction.Transactional;

import java.util.Optional;

public interface IUserService {
    User saveUser(User user);

    Optional<User> findByUsername(String userName);

    @Transactional
    void makeAdmin(String userName);
}
