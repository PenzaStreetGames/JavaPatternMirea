package com.hyberlet.study_1.repository;

import com.hyberlet.study_1.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.login = :login")
    Optional<User> findByLogin(@Param("login") String login);
}
