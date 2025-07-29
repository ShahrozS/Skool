package com.shahroz.shahroz.Service;

import com.shahroz.shahroz.Entity.Teacher;
import com.shahroz.shahroz.Repository.TeacherRepository;
import com.shahroz.shahroz.ServiceInterface.TeacherServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService implements TeacherServiceInterface {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Optional<Teacher> getTeacherById(Long id) {
        return teacherRepository.findById(id);
    }

    public List<Teacher> getTeachersBySchool(Long schoolId) {
        return teacherRepository.findBySchoolId(schoolId);
    }

    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Optional<Teacher> updateTeacher(Long id, Teacher updated) {
        return teacherRepository.findById(id).map(t -> {
            t.setFirstName(updated.getFirstName());
            t.setLastName(updated.getLastName());
            t.setSchool(updated.getSchool());
            return teacherRepository.save(t);
        });
    }

    public boolean deleteTeacher(Long id) {
        if (!teacherRepository.existsById(id)) return false;
        teacherRepository.deleteById(id);
        return true;
    }
}
