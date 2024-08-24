package com.cseazeem.course_management.Controller;


import com.cseazeem.course_management.Model.CourseInstance;
import com.cseazeem.course_management.Model.CourseInstanceDTO;
import com.cseazeem.course_management.Service.CourseInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/instances")
public class CourseInstanceController {

    @Autowired
    private CourseInstanceService courseInstanceService;


    @PostMapping
    public ResponseEntity<CourseInstance> createCourseInstance(@RequestBody CourseInstance courseInstance) {
        CourseInstance createdInstance = courseInstanceService.createCourseInstance(courseInstance);
        return ResponseEntity.ok(createdInstance);
    }

    @GetMapping("/{year}/{semester}")
    public ResponseEntity<List<CourseInstance>> getCourseInstancesByYearAndSemester(
            @PathVariable Integer year,
            @PathVariable Integer semester) {
        List<CourseInstance> instances = courseInstanceService.getCourseInstancesByYearAndSemester(year, semester);
        return ResponseEntity.ok(instances);
    }

    @GetMapping("/course-instance")
    public List<CourseInstanceDTO> getCourseInstanceById(
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Integer semester,
            @RequestParam(required = false) Integer courseId) {
        List<CourseInstanceDTO> instance = courseInstanceService.getCourseInstanceById(year, semester, courseId);
        return instance;
    }

    @DeleteMapping("/{year}/{semester}/{courseId}")
    public ResponseEntity<Void> deleteCourseInstanceById(
            @PathVariable Integer year,
            @PathVariable Integer semester,
            @PathVariable Long courseId) {
        courseInstanceService.deleteCourseInstanceById(year, semester, courseId);
        return ResponseEntity.noContent().build();
    }
}
