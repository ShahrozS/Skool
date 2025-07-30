package com.shahroz.shahroz;

import com.shahroz.shahroz.Entity.Subject;
import com.shahroz.shahroz.Repository.SubjectRepository;
import com.shahroz.shahroz.Service.SubjectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SubjectServiceTest {
    
    @Mock
    private SubjectRepository subjectRepository;

    @InjectMocks
    private SubjectService subjectService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        when(subjectRepository.findAll()).thenReturn(List.of(new Subject()));
        List<Subject> result = subjectService.getAllSubjects();
        assertEquals(1, result.size());
    }

    @Test
    void testGetById() {
        Subject obj = new Subject();
        when(subjectRepository.findById(1L)).thenReturn(Optional.of(obj));
        Optional<Subject> result = subjectService.getSubjectById(1L);
        assertTrue(result.isPresent());
    }

    @Test
    void testCreate() {
        Subject obj = new Subject();
        when(subjectRepository.save(obj)).thenReturn(obj);
        Subject result = subjectService.createSubject(obj);
        assertNotNull(result);
    }

    @Test
    void testDelete() {
        doNothing().when(subjectRepository).deleteById(1L);
        assertDoesNotThrow(() -> subjectService.deleteSubject(1L));
    }
}
