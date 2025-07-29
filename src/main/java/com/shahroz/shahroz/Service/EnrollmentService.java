package com.shahroz.shahroz.Service;

import com.shahroz.shahroz.Entity.Enrollment;
import com.shahroz.shahroz.Repository.EnrollmentRepository;
import com.shahroz.shahroz.ServiceInterface.EnrollmentServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService  implements EnrollmentServiceInterface {

    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    public Optional<Enrollment> getEnrollmentById(Long id) {
        return enrollmentRepository.findById(id);
    }

    public List<Enrollment> getByStudent(Long studentId) {
        return enrollmentRepository.findByStudentId(studentId);
    }

    public List<Enrollment> getBySubject(Long subjectId) {
        return enrollmentRepository.findBySubjectId(subjectId);
    }

    public Enrollment createEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    public Optional<Enrollment> updateEnrollment(Long id, Enrollment updated) {
        return enrollmentRepository.findById(id).map(e -> {
            e.setStudent(updated.getStudent());
            e.setSubject(updated.getSubject());
            e.setEnrolledOn(updated.getEnrolledOn());
            return enrollmentRepository.save(e);
        });
    }

    public boolean deleteEnrollment(Long id) {
        if (!enrollmentRepository.existsById(id)) return false;
        enrollmentRepository.deleteById(id);
        return true;
    }
}
