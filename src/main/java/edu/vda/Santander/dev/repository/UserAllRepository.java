package edu.vda.Santander.dev.repository;

import edu.vda.Santander.dev.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAllRepository extends JpaRepository<User, Long> {
}
