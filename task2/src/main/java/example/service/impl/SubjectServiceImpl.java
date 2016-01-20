package example.service.impl;

import example.dao.SubjectDao;
import example.domain.Sounds;
import example.domain.Subject;

import java.util.Collection;
import javax.transaction.Transactional;

import example.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Transactional
@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectDao subjectDao;

    @Override
    public Collection<Subject> getAllSubjects() {
        return subjectDao.getAllSubjects();
    }

    @Override
    public void add(Subject subject) {subjectDao.add(subject);
    }

    @Override
    public void remove(Integer subjectId) {subjectDao.remove(subjectId);}

    @Override
    public void setId(Integer subjectId) {
         subjectDao.setId(subjectId);
    }

    @Override
    public Subject findSubjectBySound(Sounds sound) {return subjectDao.findSubjectBySound(sound);}
}
