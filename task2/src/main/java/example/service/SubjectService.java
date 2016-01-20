package example.service;

import example.domain.Sounds;
import example.domain.Subject;
import java.util.Collection;


public interface SubjectService {

    Collection<Subject> getAllSubjects();

    void add(Subject subject);

    void remove(Integer subjectId);

    void setId(Integer subjectId);

    public Subject findSubjectBySound(Sounds sound);
}
