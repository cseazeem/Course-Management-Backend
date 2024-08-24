package com.cseazeem.course_management.Database;

import com.cseazeem.course_management.Model.Course;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseDaoImpl {

    private final CourseDao courseDao;

    public CourseDaoImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    public Course createCourse(Course course) {
        Long id = courseDao.insertCourse(course.getTitle(), course.getCourseCode(), course.getDescription());
        course.setId(id);
        return course;
    }

    public List<Course> getAllCourses() {
        return courseDao.getAllCourses();
    }

    public Optional<Course> getCourseById(Long id) {
        return Optional.ofNullable(courseDao.getCourseById(id));
    }

    public Course getCourseBycourseCode(String courseCode) {
        return courseDao.getCourseBycourseCode(courseCode);
    }


    public void deleteCourseById(Long id) {
        courseDao.deleteCourseById(id);
    }

}
