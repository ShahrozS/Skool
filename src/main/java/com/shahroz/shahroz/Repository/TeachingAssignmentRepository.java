package com.shahroz.shahroz.Repository;
import com.shahroz.shahroz.Entity.School;
import com.shahroz.shahroz.Entity.TeachingAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeachingAssignmentRepository extends JpaRepository<TeachingAssignment, Long> {
    List<TeachingAssignment> findByTeacherId(Long teacherId);
    List<TeachingAssignment> findByClassRoomId(Long classRoomId);
}
