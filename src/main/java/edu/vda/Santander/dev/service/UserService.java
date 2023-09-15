package edu.vda.Santander.dev.service;

import edu.vda.Santander.dev.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate);


}
