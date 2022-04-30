package com.hyberlet.task_23.repository;

import com.hyberlet.task_23.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findAppUserByLogin(String login);
}
