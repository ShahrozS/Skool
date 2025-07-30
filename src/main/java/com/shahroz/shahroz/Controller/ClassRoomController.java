package com.shahroz.shahroz.Controller;

import com.shahroz.shahroz.Entity.ClassRoom;
import com.shahroz.shahroz.Service.ClassRoomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classes")
@Tag(name = "Classes", description = "Manage class records")
public class ClassRoomController {

    private final ClassRoomService classRoomService;

    public ClassRoomController(ClassRoomService classRoomService) {
        this.classRoomService = classRoomService;
    }


    @GetMapping
    @Operation(summary = "Get all classes")
    public List<ClassRoom> getAll() {
        return classRoomService.getAllClasses();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get class by ID")
    public ResponseEntity<ClassRoom> getById(@PathVariable Long id) {
        return classRoomService.getClassById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Create a new class")
    public ClassRoom create(@RequestBody ClassRoom classRoom) {
        return classRoomService.createClass(classRoom);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing class")
    public ResponseEntity<ClassRoom> update(@PathVariable Long id, @RequestBody ClassRoom updated) {
        return classRoomService.updateClass(id, updated)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a class")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return classRoomService.deleteClass(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}

