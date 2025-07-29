package com.shahroz.shahroz.Controller;


import com.shahroz.shahroz.Entity.Enrollment;
import com.shahroz.shahroz.Service.EnrollmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/enrollments")
@Tag(name = "Enrollments", description = "Manage student enrollments in subjects")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @GetMapping
    @Operation(summary = "Get all enrollments")
    public List<Enrollment> getAll() {
        return enrollmentService.getAllEnrollments();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get enrollment by ID")
    public ResponseEntity<Enrollment> getById(@PathVariable Long id) {
        return enrollmentService.getEnrollmentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Create a new enrollment")
    public Enrollment create(@RequestBody Enrollment enrollment) {
        return enrollmentService.createEnrollment(enrollment);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an enrollment")
    public ResponseEntity<Enrollment> update(@PathVariable Long id, @RequestBody Enrollment updated) {
        return enrollmentService.updateEnrollment(id, updated)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an enrollment")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return enrollmentService.deleteEnrollment(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
