package com.shahroz.shahroz.ServiceInterface;

import com.shahroz.shahroz.Entity.Student;
import com.shahroz.shahroz.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface StudentServiceInterface {
    List<Student> getAllStudents();
    Optional<Student> getStudentById(Long id);
    List<Student> getStudentsByClass(Long classId);
    Student createStudent(Student student);
    Optional<Student> updateStudent(Long id, Student updated);
    boolean deleteStudent(Long id);
}
