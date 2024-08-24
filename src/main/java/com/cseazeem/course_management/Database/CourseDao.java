package com.cseazeem.course_management.Database;


import com.cseazeem.course_management.Model.Course;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.*;

import java.util.List;
public interface CourseDao {

    @SqlUpdate("INSERT INTO courses (title, course_code, description) VALUES (:title, :courseCode, :description)")
    @GetGeneratedKeys
    Long insertCourse(@Bind("title") String title, @Bind("courseCode") String courseCode, @Bind("description") String description);

    @SqlQuery("SELECT * FROM courses")
    @RegisterBeanMapper(Course.class)
    List<Course> getAllCourses();

    @SqlQuery("SELECT * FROM courses WHERE id = :id")
    @RegisterBeanMapper(Course.class)
    Course getCourseById(@Bind("id") Long id);

    @SqlQuery("SELECT * FROM courses WHERE course_code = :courseCode")
    @RegisterBeanMapper(Course.class)
    Course getCourseBycourseCode(@Bind("courseCode") String courseCode);

    @SqlUpdate("DELETE FROM courses WHERE id = :id")
    void deleteCourseById(@Bind("id") Long id);
}
