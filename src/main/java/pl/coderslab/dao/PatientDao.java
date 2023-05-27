package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Patient;
import pl.coderslab.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PatientDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Patient patient) {
        entityManager.persist(patient);
    }

    public void edit(Patient patient) {
        entityManager.merge(patient);
    }

    public Patient findById(long id) {
        return entityManager.find(Patient.class, id);
    }

    public void delete(Patient patient) {
        entityManager.remove(entityManager.contains(patient) ?
                patient : entityManager.merge(patient));
    }

    public List<Patient> findAll() {
        return entityManager.createQuery("SELECT p FROM Patient p")
                .getResultList();
    }
}
