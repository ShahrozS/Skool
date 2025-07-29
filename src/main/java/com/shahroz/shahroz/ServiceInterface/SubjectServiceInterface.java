package com.shahroz.shahroz.ServiceInterface;

import com.shahroz.shahroz.Entity.Subject;
import com.shahroz.shahroz.Repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface SubjectServiceInterface {
    List<Subject> getAllSubjects();
    Optional<Subject> getSubjectById(Long id);
    Subject createSubject(Subject subject);
    Optional<Subject> updateSubject(Long id, Subject updated);
    boolean deleteSubject(Long id);
}
