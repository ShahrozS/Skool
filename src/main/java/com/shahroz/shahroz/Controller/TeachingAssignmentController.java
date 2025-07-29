package com.shahroz.shahroz.Controller;

import com.shahroz.shahroz.Entity.TeachingAssignment;
import com.shahroz.shahroz.Service.TeachingAssignmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/assignments")
@Tag(name = "Teaching Assignments", description = "Assign subjects to teachers for specific classes")
public class TeachingAssignmentController {

    private final TeachingAssignmentService assignmentService;


    @GetMapping
    @Operation(summary = "Get all teaching assignments")
    public List<TeachingAssignment> getAll() {
        return assignmentService.getAllAssignments();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get teaching assignment by ID")
    public ResponseEntity<TeachingAssignment> getById(@PathVariable Long id) {
        return assignmentService.getAssignmentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Create a new teaching assignment")
    public TeachingAssignment create(@RequestBody TeachingAssignment assignment) {
        return assignmentService.createAssignment(assignment);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a teaching assignment")
    public ResponseEntity<TeachingAssignment> update(@PathVariable Long id, @RequestBody TeachingAssignment updated) {
        return assignmentService.updateAssignment(id, updated)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a teaching assignment")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return assignmentService.deleteAssignment(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}

