package com.hyberlet.task_15.service;

import com.hyberlet.task_15.model.User;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@Repository
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final SessionFactory sessionFactory;
    private Session session;

    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }

    public List<User> getUsers() {
        return session.createQuery("select u from User u", User.class).getResultList();
    }

    public void saveUser(User user) {
        var transaction = session.beginTransaction();
        session.saveOrUpdate(user);
        transaction.commit();
    }

    public void deleteUserById(Long id) {
        var transaction = session.beginTransaction();
        session.createQuery("delete from User u where u.id = :id")
                .setParameter("id", id).executeUpdate();
        transaction.commit();
    }
}
