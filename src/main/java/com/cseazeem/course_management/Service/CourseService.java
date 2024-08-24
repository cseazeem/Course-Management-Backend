package com.cseazeem.course_management.Service;

import com.cseazeem.course_management.Database.CourseDaoImpl;
import com.cseazeem.course_management.Exceptions.CourseAlreadyExistsException;
import com.cseazeem.course_management.Model.Course;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CourseService {
    private final CourseDaoImpl courseDaoImpl;

    public CourseService(CourseDaoImpl courseDaoImpl) {
        this.courseDaoImpl = courseDaoImpl;
    }

    public Course createCourse(Course course) {
        Course existingCourse = courseDaoImpl.getCourseBycourseCode(course.getCourseCode());

        if (existingCourse != null) {
            // Throw the custom exception when the course already exists
            throw new CourseAlreadyExistsException("Course with code " + course.getCourseCode() + " already exists.");
        }

        try {
            return courseDaoImpl.createCourse(course);
        } catch (Exception e) {
            // Log the error and rethrow it as a generic RuntimeException
            System.err.println("Error creating course: " + e.getMessage());
            throw new RuntimeException("Failed to create course", e);
        }
    }



    public List<Course> getAllCourses() {
        return courseDaoImpl.getAllCourses();
    }

    public Optional<Course> getCourseById(Long id) {
        return courseDaoImpl.getCourseById(id);
    }

    public void deleteCourseById(Long id) {
        courseDaoImpl.deleteCourseById(id);
    }
}
