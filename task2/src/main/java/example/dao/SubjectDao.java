package example.dao;

import example.domain.Sounds;
import example.domain.Subject;
import java.util.Collection;


public interface SubjectDao {

    Collection<Subject> getAllSubjects();

    void add(Subject subject);

    void remove(Integer subjectId);

    void setId(Integer subjectId);

    Integer getId();

    Subject findSubjectBySound(Sounds sound);
}
