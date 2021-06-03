package com.link.auto.dao.impl;

import com.link.auto.dao.User;
import com.link.auto.dao.UserDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public boolean save(String firstName, String lastName, String email, String password, String phone) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);

        entityManager.persist(user);

        return true;
    }

    @Override
    public User getByEmailAndPassword(String email, String password) {
        // verificam ca exista un user cu email si password
        String userQuery = "SELECT * FROM `auto`.`user` WHERE email = '" + email + "' AND password = '" + password + "'";
        Query query = entityManager.createNativeQuery(userQuery, User.class);
        return (User) query.getSingleResult();
    }

    @Override
    public List<User> getAll() {
        String userQuery = "SELECT * FROM `auto`.`user`";
        Query query = entityManager.createNativeQuery(userQuery, User.class);
        return query.getResultList();
    }

    @Override
    public User getByEmail(String email) {
        // verificam ca exista un user cu email si password
        String userQuery = "SELECT * FROM `auto`.`user` WHERE email = '" + email + "';";
        Query query = entityManager.createNamedQuery(userQuery, User.class);
        return (User) query.getSingleResult();
    }

    @Override
    public User getById(Integer id) {
        return entityManager.find(User.class, id);
    }
}
