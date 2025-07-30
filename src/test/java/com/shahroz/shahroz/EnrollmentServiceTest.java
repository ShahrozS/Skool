package com.shahroz.shahroz;

import com.shahroz.shahroz.Entity.Enrollment;
import com.shahroz.shahroz.Repository.EnrollmentRepository;
import com.shahroz.shahroz.Service.EnrollmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EnrollmentServiceTest {
    
    @Mock
    private EnrollmentRepository enrollmentRepository;

    @InjectMocks
    private EnrollmentService enrollmentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        when(enrollmentRepository.findAll()).thenReturn(List.of(new Enrollment()));
        List<Enrollment> result = enrollmentService.getAllEnrollments();
        assertEquals(1, result.size());
    }

    @Test
    void testGetById() {
        Enrollment obj = new Enrollment();
        when(enrollmentRepository.findById(1L)).thenReturn(Optional.of(obj));
        Optional<Enrollment> result = enrollmentService.getEnrollmentById(1L);
        assertTrue(result.isPresent());
    }

    @Test
    void testCreate() {
        Enrollment obj = new Enrollment();
        when(enrollmentRepository.save(obj)).thenReturn(obj);
        Enrollment result = enrollmentService.createEnrollment(obj);
        assertNotNull(result);
    }

    @Test
    void testDelete() {
        doNothing().when(enrollmentRepository).deleteById(1L);
        assertDoesNotThrow(() -> enrollmentService.deleteEnrollment(1L));
    }
}
