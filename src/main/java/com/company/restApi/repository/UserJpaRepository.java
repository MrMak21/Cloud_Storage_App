package com.company.restApi.repository;

import com.company.restApi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserJpaRepository extends JpaRepository<User,Long> {

    User findUserByLastname(String lastname);
    User  findUserByEmail(String email);
    User save(User user);



}
