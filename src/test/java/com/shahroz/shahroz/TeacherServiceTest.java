package com.shahroz.shahroz;

import com.shahroz.shahroz.Entity.Teacher;
import com.shahroz.shahroz.Repository.TeacherRepository;
import com.shahroz.shahroz.Service.TeacherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TeacherServiceTest {
    
    @Mock
    private TeacherRepository teacherRepository;

    @InjectMocks
    private TeacherService teacherService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        when(teacherRepository.findAll()).thenReturn(List.of(new Teacher()));
        List<Teacher> result = teacherService.getAllTeachers();
        assertEquals(1, result.size());
    }

    @Test
    void testGetById() {
        Teacher obj = new Teacher();
        when(teacherRepository.findById(1L)).thenReturn(Optional.of(obj));
        Optional<Teacher> result = teacherService.getTeacherById(1L);
        assertTrue(result.isPresent());
    }

    @Test
    void testCreate() {
        Teacher obj = new Teacher();
        when(teacherRepository.save(obj)).thenReturn(obj);
        Teacher result = teacherService.createTeacher(obj);
        assertNotNull(result);
    }

    @Test
    void testDelete() {
        doNothing().when(teacherRepository).deleteById(1L);
        assertDoesNotThrow(() -> teacherService.deleteTeacher(1L));
    }
}
