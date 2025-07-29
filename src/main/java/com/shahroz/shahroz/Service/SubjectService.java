package com.shahroz.shahroz.Service;

import com.shahroz.shahroz.Entity.Subject;
import com.shahroz.shahroz.Repository.SubjectRepository;
import com.shahroz.shahroz.ServiceInterface.SubjectServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService implements SubjectServiceInterface {

    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Optional<Subject> getSubjectById(Long id) {
        return subjectRepository.findById(id);
    }

    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public Optional<Subject> updateSubject(Long id, Subject updated) {
        return subjectRepository.findById(id).map(s -> {
            s.setName(updated.getName());
            return subjectRepository.save(s);
        });
    }

    public boolean deleteSubject(Long id) {
        if (!subjectRepository.existsById(id)) return false;
        subjectRepository.deleteById(id);
        return true;
    }
}

