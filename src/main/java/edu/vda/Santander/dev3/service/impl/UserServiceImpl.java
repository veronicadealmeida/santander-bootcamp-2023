package edu.vda.Santander.dev3.service.impl;

import edu.vda.Santander.dev3.domain.model.User;
import edu.vda.Santander.dev3.domain.repository.UserRepository;
import edu.vda.Santander.dev3.service.UserService;

import java.util.NoSuchElementException;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if ( userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())){
            throw new IllegalArgumentException("This Account Number already exists.");
        }
        return userRepository.save(userToCreate);
    }
}
