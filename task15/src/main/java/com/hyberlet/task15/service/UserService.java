package com.hyberlet.task15.service;

import com.hyberlet.task15.model.User;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
        System.out.println(user.toString());
        transaction.commit();
    }
}
