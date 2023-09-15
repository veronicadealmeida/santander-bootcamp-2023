package edu.vda.Santander.dev3.service;

import edu.vda.Santander.dev3.domain.model.User;
import org.springframework.stereotype.Service;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate);


}
