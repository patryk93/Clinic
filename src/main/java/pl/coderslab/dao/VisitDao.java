package pl.coderslab.dao;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Patient;
import pl.coderslab.model.User;
import pl.coderslab.model.Visit;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@Getter
@Setter
public class VisitDao {

    @PersistenceContext
    EntityManager entityManager;

    private long patientId;
    public void save(Visit visit) {entityManager.persist(visit);
    }

    public void edit(Visit visit) {
        entityManager.merge(visit);
    }

    public Visit findById(long id) {
        return entityManager.find(Visit.class, id);
    }

    public User findUserById(long id) {
        return entityManager.find(User.class, id);
    }

    public void delete(Visit visit) {
        entityManager.remove(entityManager.contains(visit) ?
                visit : entityManager.merge(visit));
    }

    public void delete(Long id) {
        entityManager.createQuery("DELETE FROM Visit v WHERE v.user.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    public List<Visit> findAll() {
        return entityManager.createQuery("SELECT v FROM Visit v")
                .getResultList();
    }

    public List<Visit> findAllByUserID(long id) {
        return entityManager.createQuery("SELECT v FROM Visit v WHERE v.user.id = :id")
                .setParameter("id", id)
                .getResultList();
    }
}
