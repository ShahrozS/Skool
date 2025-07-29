package com.shahroz.shahroz.Repository;

import com.shahroz.shahroz.Entity.School;
import com.shahroz.shahroz.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findBySchoolId(Long schoolId);
}
