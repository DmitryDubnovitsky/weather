package example.controller;

import example.domain.Sounds;
import example.domain.Subject;
import example.service.SubjectService;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;


    @RequestMapping(method = RequestMethod.GET)
    public Collection<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @RequestMapping(value = "/find",method = RequestMethod.POST)
    public Subject find(@RequestBody Sounds sound) {
        return subjectService.findSubjectBySound(sound);
    }


    @RequestMapping(method = RequestMethod.POST)
    public Collection<Subject> add(@RequestBody Subject subject){
        subjectService.add(subject);
        return getAllSubjects();
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public Collection<Subject> remove(@RequestParam Integer subjectId) {
        subjectService.remove(subjectId);
        return getAllSubjects();
    }

    @RequestMapping(value = "/id",method = RequestMethod.GET)
    public void findId(@RequestParam Integer subjectId) {
       subjectService.setId(subjectId);
    }

}
