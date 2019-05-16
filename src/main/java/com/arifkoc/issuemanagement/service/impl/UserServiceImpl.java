package com.arifkoc.issuemanagement.service.impl;

import com.arifkoc.issuemanagement.Entity.User;
import com.arifkoc.issuemanagement.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.arifkoc.issuemanagement.repo.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public User save(User user) {
        if(user.getEmail()==null){
            throw new IllegalArgumentException("e-mail can not be null");
        }
        return userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public Page<User> getAllPageable(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User getByUserName(String userName) {
        return null;
    }
}
