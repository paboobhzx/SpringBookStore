package com.portfolio.springbootbookstore.service;

import com.portfolio.springbootbookstore.model.Role;
import com.portfolio.springbootbookstore.model.User;
import com.portfolio.springbootbookstore.repository.IUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user){
        user.setPassWord(passwordEncoder.encode(user.getPassWord()));
        user.setRole(Role.USER);
        user.setCreationTime(LocalDateTime.now());
        return userRepository.save(user);

    }

    @Override
    public Optional<User> findByUsername(String userName){
        return userRepository.findByUserName(userName);
    }

    @Transactional
    @Override
    public void makeAdmin(String userName){
        userRepository.updateUserRole(userName, Role.ADMIN);
    }
}
