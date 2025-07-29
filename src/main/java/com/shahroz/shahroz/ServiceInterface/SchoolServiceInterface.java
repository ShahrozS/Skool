package com.shahroz.shahroz.ServiceInterface;

import com.shahroz.shahroz.Entity.School;

import java.util.List;
import java.util.Optional;

public interface SchoolServiceInterface {
    List<School> getAllSchools();
    Optional<School> getSchoolById(Long id);
    School createSchool(School school);
    Optional<School> updateSchool(Long id, School updated);
    boolean deleteSchool(Long id);
}
