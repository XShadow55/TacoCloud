package com.example.Taco_Cloud.repository;

import com.example.Taco_Cloud.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReposiroty extends CrudRepository<User,Long> {
    User findByUsername(String username);
}
