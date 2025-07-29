package com.shahroz.shahroz.Controller;

import com.shahroz.shahroz.Entity.Teacher;
import com.shahroz.shahroz.Service.TeacherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
@Tag(name = "Teachers", description = "Manage teacher records")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    @Operation(summary = "Get all teachers")
    public List<Teacher> getAll() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get teacher by ID")
    public ResponseEntity<Teacher> getById(@PathVariable Long id) {
        return teacherService.getTeacherById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Create a new teacher")
    public Teacher create(@RequestBody Teacher teacher) {
        return teacherService.createTeacher(teacher);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing teacher")
    public ResponseEntity<Teacher> update(@PathVariable Long id, @RequestBody Teacher updated) {
        return teacherService.updateTeacher(id, updated)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a teacher")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return teacherService.deleteTeacher(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
