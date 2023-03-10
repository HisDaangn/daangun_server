package com.daangun.clonecode.repository;

import com.daangun.clonecode.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.googleId = :googleId")
    User findUserByGoogleId(String googleId);
}
