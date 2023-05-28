package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Patient;
import pl.coderslab.model.Visit;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class VisitDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Visit visit) {entityManager.persist(visit);
    }

    public void edit(Visit visit) {
        entityManager.merge(visit);
    }

    public Visit findById(long id) {
        return entityManager.find(Visit.class, id);
    }

    public void delete(Visit visit) {
        entityManager.remove(entityManager.contains(visit) ?
                visit : entityManager.merge(visit));
    }

    public List<Visit> findAll() {
        return entityManager.createQuery("SELECT v FROM Visit v")
                .getResultList();
    }
}
