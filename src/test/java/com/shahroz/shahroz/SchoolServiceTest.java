package com.shahroz.shahroz;

import com.shahroz.shahroz.Entity.School;
import com.shahroz.shahroz.Repository.SchoolRepository;
import com.shahroz.shahroz.Service.SchoolService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SchoolServiceTest {
    
    @Mock
    private SchoolRepository schoolRepository;

    @InjectMocks
    private SchoolService schoolService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        when(schoolRepository.findAll()).thenReturn(List.of(new School()));
        List<School> result = schoolService.getAllSchools();
        assertEquals(1, result.size());
    }

    @Test
    void testGetById() {
        School obj = new School();
        when(schoolRepository.findById(1L)).thenReturn(Optional.of(obj));
        Optional<School> result = schoolService.getSchoolById(1L);
        assertTrue(result.isPresent());
    }

    @Test
    void testCreate() {
        School obj = new School();
        when(schoolRepository.save(obj)).thenReturn(obj);
        School result = schoolService.createSchool(obj);
        assertNotNull(result);
    }

    @Test
    void testDelete() {
        doNothing().when(schoolRepository).deleteById(1L);
        assertDoesNotThrow(() -> schoolService.deleteSchool(1L));
    }
}
