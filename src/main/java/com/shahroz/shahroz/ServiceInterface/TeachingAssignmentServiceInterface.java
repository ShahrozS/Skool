package com.shahroz.shahroz.ServiceInterface;

import com.shahroz.shahroz.Entity.TeachingAssignment;

import java.util.List;
import java.util.Optional;
public interface TeachingAssignmentServiceInterface {
    List<TeachingAssignment> getAllAssignments();
    Optional<TeachingAssignment> getAssignmentById(Long id);
    List<TeachingAssignment> getByTeacher(Long teacherId);
    List<TeachingAssignment> getByClass(Long classId);
    TeachingAssignment createAssignment(TeachingAssignment assignment);
    Optional<TeachingAssignment> updateAssignment(Long id, TeachingAssignment updated);
    boolean deleteAssignment(Long id);
}
