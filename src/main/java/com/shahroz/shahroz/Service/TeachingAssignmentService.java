package com.shahroz.shahroz.Service;

import com.shahroz.shahroz.Entity.TeachingAssignment;
import com.shahroz.shahroz.Repository.TeachingAssignmentRepository;
import com.shahroz.shahroz.ServiceInterface.TeachingAssignmentServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeachingAssignmentService implements TeachingAssignmentServiceInterface {

    private final TeachingAssignmentRepository assignmentRepository;

    public TeachingAssignmentService(TeachingAssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    public List<TeachingAssignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    public Optional<TeachingAssignment> getAssignmentById(Long id) {
        return assignmentRepository.findById(id);
    }

    public List<TeachingAssignment> getByTeacher(Long teacherId) {
        return assignmentRepository.findByTeacherId(teacherId);
    }

    public List<TeachingAssignment> getByClass(Long classId) {
        return assignmentRepository.findByClassRoomId(classId);
    }

    public TeachingAssignment createAssignment(TeachingAssignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public Optional<TeachingAssignment> updateAssignment(Long id, TeachingAssignment updated) {
        return assignmentRepository.findById(id).map(a -> {
            a.setClassRoom(updated.getClassRoom());
            a.setSubject(updated.getSubject());
            a.setTeacher(updated.getTeacher());
            return assignmentRepository.save(a);
        });
    }

    public boolean deleteAssignment(Long id) {
        if (!assignmentRepository.existsById(id)) return false;
        assignmentRepository.deleteById(id);
        return true;
    }
}
