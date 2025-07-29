package com.shahroz.shahroz.ServiceInterface;

import com.shahroz.shahroz.Entity.ClassRoom;

import java.util.List;
import java.util.Optional;
public interface ClassRoomServiceInterface {
    List<ClassRoom> getAllClasses();
    Optional<ClassRoom> getClassById(Long id);
    List<ClassRoom> getClassesBySchool(Long schoolId);
    ClassRoom createClass(ClassRoom classRoom);
    Optional<ClassRoom> updateClass(Long id, ClassRoom updated);
    boolean deleteClass(Long id);
}

