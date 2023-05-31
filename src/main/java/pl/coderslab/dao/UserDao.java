package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.User;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(User user) {
        entityManager.persist(user);
    }

    public void edit(User user) {
        entityManager.merge(user);
    }

    public User findById(long id) {
        return entityManager.find(User.class, id);
    }
    public User findByLogin(String login) {
        return entityManager.find(User.class, login);
    }

    public void delete(User user) {
        entityManager.remove(entityManager.contains(user) ?
                user : entityManager.merge(user));
    }

    public List<User> findAll() {
        return entityManager.createQuery("SELECT u FROM User u")
                .getResultList();
    }



}
