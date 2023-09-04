package com.borges.Rotininha.repository;

import com.borges.Rotininha.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    UserModel findUserByUsername(String username);
}
