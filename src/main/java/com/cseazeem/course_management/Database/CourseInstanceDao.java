package com.cseazeem.course_management.Database;

import com.cseazeem.course_management.Model.CourseInstance;
import com.cseazeem.course_management.Model.CourseInstanceDTO;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.*;

import java.util.List;

public interface CourseInstanceDao {
    @SqlUpdate("INSERT INTO course_instances (course_id, year, semester) VALUES (:courseId, :year, :semester)")
    @GetGeneratedKeys
    Long insertCourseInstance(@Bind("courseId") Long courseId, @Bind("year") Integer year, @Bind("semester") Integer semester);

    @SqlQuery("SELECT * FROM course_instances WHERE year = :year AND semester = :semester")
    @RegisterBeanMapper(CourseInstance.class)
    List<CourseInstance> getCourseInstancesByYearAndSemester(@Bind("year") Integer year, @Bind("semester") Integer semester);

    @SqlQuery("SELECT c.title, c.course_code, ci.year, ci.semester " +
            "FROM courses c " +
            "JOIN course_instances ci ON c.id = ci.course_id " +
            "WHERE (ci.year = :year OR :year IS NULL) " +
            "AND (ci.semester = :semester OR :semester IS NULL) " +
            "AND (ci.course_id = :courseId OR :courseId IS NULL)")
    @RegisterBeanMapper(CourseInstanceDTO.class)
    List<CourseInstanceDTO> getCourseInstanceById(@Bind("year") Integer year, @Bind("semester") Integer semester, @Bind("courseId") Integer courseId);

    @SqlUpdate("DELETE FROM course_instances WHERE year = :year AND semester = :semester AND course_id = :courseId")
    void deleteCourseInstanceById(@Bind("year") Integer year, @Bind("semester") Integer semester, @Bind("courseId") Long courseId);
}
