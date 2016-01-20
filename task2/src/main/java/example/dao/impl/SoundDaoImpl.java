package example.dao.impl;

import example.dao.SoundDao;
import example.dao.SubjectDao;
import example.domain.Sounds;
import example.domain.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;


@Repository
public class SoundDaoImpl implements SoundDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private SubjectDao subjectDao;

    @Override
    public void add(Sounds sound) {

        Subject subject = entityManager.find(Subject.class, subjectDao.getId());
        sound.setSubject(subject);
        entityManager.persist(sound);
    }

    @Override
    public Collection<Sounds> getAllSounds() {
        return entityManager.createQuery("from Sounds", Sounds.class).getResultList();
    }

    @Override
    public void remove(Integer soundId) {
        Sounds sound = entityManager.find(Sounds.class, soundId);
        if (null != sound) {
            entityManager.remove(sound);
        }
    }
}
