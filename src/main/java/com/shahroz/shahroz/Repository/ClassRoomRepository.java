package com.shahroz.shahroz.Repository;

import com.shahroz.shahroz.Entity.ClassRoom;
import com.shahroz.shahroz.Entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ClassRoomRepository extends JpaRepository<ClassRoom, Long> {
    List<ClassRoom> findBySchoolId(Long schoolId);
}

