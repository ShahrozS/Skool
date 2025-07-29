package com.shahroz.shahroz.ServiceInterface;

import com.shahroz.shahroz.Entity.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherServiceInterface {
    List<Teacher> getAllTeachers();
    Optional<Teacher> getTeacherById(Long id);
    List<Teacher> getTeachersBySchool(Long schoolId);
    Teacher createTeacher(Teacher teacher);
    Optional<Teacher> updateTeacher(Long id, Teacher updated);
    boolean deleteTeacher(Long id);
}
