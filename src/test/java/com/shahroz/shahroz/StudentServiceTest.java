package com.shahroz.shahroz;

import com.shahroz.shahroz.Entity.Student;
import com.shahroz.shahroz.Repository.StudentRepository;
import com.shahroz.shahroz.Service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {
    
    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        when(studentRepository.findAll()).thenReturn(List.of(new Student()));
        List<Student> result = studentService.getAllStudents();
        assertEquals(1, result.size());
    }

    @Test
    void testGetById() {
        Student obj = new Student();
        when(studentRepository.findById(1L)).thenReturn(Optional.of(obj));
        Optional<Student> result = studentService.getStudentById(1L);
        assertTrue(result.isPresent());
    }

    @Test
    void testCreate() {
        Student obj = new Student();
        when(studentRepository.save(obj)).thenReturn(obj);
        Student result = studentService.createStudent(obj);
        assertNotNull(result);
    }

    @Test
    void testDelete() {
        doNothing().when(studentRepository).deleteById(1L);
        assertDoesNotThrow(() -> studentService.deleteStudent(1L));
    }
}
