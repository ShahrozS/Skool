package com.shahroz.shahroz.Service;

import com.shahroz.shahroz.Entity.School;
import com.shahroz.shahroz.Repository.SchoolRepository;
import com.shahroz.shahroz.ServiceInterface.SchoolServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolService implements SchoolServiceInterface {

    private final SchoolRepository schoolRepository;

    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    public Optional<School> getSchoolById(Long id) {
        return schoolRepository.findById(id);
    }

    public School createSchool(School school) {
        return schoolRepository.save(school);
    }

    public Optional<School> updateSchool(Long id, School updated) {
        return schoolRepository.findById(id).map(school -> {
            school.setName(updated.getName());
            school.setAddress(updated.getAddress());
            return schoolRepository.save(school);
        });
    }

    public boolean deleteSchool(Long id) {
        if (!schoolRepository.existsById(id)) return false;
        schoolRepository.deleteById(id);
        return true;
    }
}
