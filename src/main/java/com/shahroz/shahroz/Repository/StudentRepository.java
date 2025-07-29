package com.shahroz.shahroz.Repository;

import com.shahroz.shahroz.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByClassRoomId(Long classRoomId);
}
