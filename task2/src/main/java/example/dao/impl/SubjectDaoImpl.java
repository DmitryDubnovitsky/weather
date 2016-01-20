package example.dao.impl;

import example.dao.SubjectDao;
import example.domain.Sounds;
import example.domain.Subject;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ie.globalcom.Main;
import org.springframework.stereotype.Repository;


@Repository
public class SubjectDaoImpl implements SubjectDao {

    @PersistenceContext
    private EntityManager entityManager;

    private Integer subjectId;

    @Override
    public void add(Subject subject) {
        entityManager.persist(subject);
    }

    @Override
    public Collection<Subject> getAllSubjects() {
        return entityManager.createQuery("from Subject", Subject.class).getResultList();
    }

    @Override
    public void remove(Integer subjectId) {
        Subject subject = entityManager.find(Subject.class, subjectId);
        if (null != subject) {
            entityManager.remove(subject);
        }
    }

    @Override
    public void setId(Integer subjectId) {
        this.subjectId=subjectId;
    }

    @Override
    public Integer getId(){
        return subjectId;
    }


    @Override
    public Subject findSubjectBySound(Sounds sound) {

        Query q=  entityManager.createQuery
                       (String.format("select c from Subject as c where c.id in (select d.subject from Sounds as d where (d.keyword= :keyword))"));
        q.setParameter("keyword",sound.getKeyword());
                Subject sub=(Subject)q.getSingleResult();

        Class c = null;
        try {
            c = Class.forName(sub.getClassname());
            new Main().findClass(sub.getClassname());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return sub;


    }
}

