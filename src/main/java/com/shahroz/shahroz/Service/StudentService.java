package com.shahroz.shahroz.Service;

import com.shahroz.shahroz.Entity.Student;
import com.shahroz.shahroz.Repository.StudentRepository;
import com.shahroz.shahroz.ServiceInterface.StudentServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements StudentServiceInterface {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public List<Student> getStudentsByClass(Long classId) {
        return studentRepository.findByClassRoomId(classId);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Optional<Student> updateStudent(Long id, Student updated) {
        return studentRepository.findById(id).map(s -> {
            s.setFirstName(updated.getFirstName());
            s.setLastName(updated.getLastName());
            s.setClassRoom(updated.getClassRoom());
            return studentRepository.save(s);
        });
    }

    public boolean deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) return false;
        studentRepository.deleteById(id);
        return true;
    }
}

