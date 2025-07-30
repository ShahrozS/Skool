package com.shahroz.shahroz;

import com.shahroz.shahroz.Entity.ClassRoom;
import com.shahroz.shahroz.Repository.ClassRoomRepository;
import com.shahroz.shahroz.Service.ClassRoomService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClassRoomServiceTest {
    
    @Mock
    private ClassRoomRepository classroomRepository;

    @InjectMocks
    private ClassRoomService classroomService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        when(classroomRepository.findAll()).thenReturn(List.of(new ClassRoom()));
        List<ClassRoom> result = classroomService.getAllClasses();
        assertEquals(1, result.size());
    }

    @Test
    void testGetById() {
        ClassRoom obj = new ClassRoom();
        when(classroomRepository.findById(1L)).thenReturn(Optional.of(obj));
        Optional<ClassRoom> result = classroomService.getClassById(1L);
        assertTrue(result.isPresent());
    }

    @Test
    void testCreate() {
        ClassRoom obj = new ClassRoom();
        when(classroomRepository.save(obj)).thenReturn(obj);
        ClassRoom result = classroomService.createClass(obj);
        assertNotNull(result);
    }

    @Test
    void testDelete() {
        doNothing().when(classroomRepository).deleteById(1L);
        assertDoesNotThrow(() -> classroomService.deleteClass(1L));
    }
}
