package com.shahroz.shahroz.Service;

import com.shahroz.shahroz.Entity.ClassRoom;
import com.shahroz.shahroz.Repository.ClassRoomRepository;
import com.shahroz.shahroz.ServiceInterface.ClassRoomServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class ClassRoomService implements ClassRoomServiceInterface {

    private final ClassRoomRepository classRoomRepository;


    public List<ClassRoom> getAllClasses() {
        return classRoomRepository.findAll();
    }

    public Optional<ClassRoom> getClassById(Long id) {
        return classRoomRepository.findById(id);
    }

    public List<ClassRoom> getClassesBySchool(Long schoolId) {
        return classRoomRepository.findBySchoolId(schoolId);
    }

    public ClassRoom createClass(ClassRoom classRoom) {
        return classRoomRepository.save(classRoom);
    }

    public Optional<ClassRoom> updateClass(Long id, ClassRoom updated) {
        return classRoomRepository.findById(id).map(c -> {
            c.setName(updated.getName());
            c.setSchool(updated.getSchool());
            return classRoomRepository.save(c);
        });
    }

    public boolean deleteClass(Long id) {
        if (!classRoomRepository.existsById(id)) return false;
        classRoomRepository.deleteById(id);
        return true;
    }
}
