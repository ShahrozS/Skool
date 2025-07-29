package com.shahroz.shahroz.Controller;


import com.shahroz.shahroz.Entity.School;
import com.shahroz.shahroz.Service.SchoolService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schools")
@Tag(name = "Schools", description = "Manage schools")
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping
    @Operation(summary = "Get all schools")
    public List<School> getAll() {
        return schoolService.getAllSchools();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get school by ID")
    public ResponseEntity<School> getById(@PathVariable Long id) {
        return schoolService.getSchoolById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Create a new school")
    public School create(@RequestBody School school) {
        return schoolService.createSchool(school);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing school")
    public ResponseEntity<School> update(@PathVariable Long id, @RequestBody School updated) {
        return schoolService.updateSchool(id, updated)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a school")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return schoolService.deleteSchool(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}

