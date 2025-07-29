package com.shahroz.shahroz.ServiceInterface;

import com.shahroz.shahroz.Entity.Enrollment;

import java.util.List;
import java.util.Optional;
public interface EnrollmentServiceInterface {
    List<Enrollment> getAllEnrollments();
    Optional<Enrollment> getEnrollmentById(Long id);
    List<Enrollment> getByStudent(Long studentId);
    List<Enrollment> getBySubject(Long subjectId);
    Enrollment createEnrollment(Enrollment enrollment);
    Optional<Enrollment> updateEnrollment(Long id, Enrollment updated);
    boolean deleteEnrollment(Long id);
}
