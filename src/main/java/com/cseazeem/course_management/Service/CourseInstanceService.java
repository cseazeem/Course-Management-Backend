package com.cseazeem.course_management.Service;

import com.cseazeem.course_management.Database.CourseInstanceDaoImpl;
import com.cseazeem.course_management.Model.CourseInstance;
import com.cseazeem.course_management.Model.CourseInstanceDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class CourseInstanceService {

    private final CourseInstanceDaoImpl courseInstanceDaoImpl;

    public CourseInstanceService(CourseInstanceDaoImpl courseInstanceDaoImpl) {
        this.courseInstanceDaoImpl = courseInstanceDaoImpl;
    }

    public CourseInstance createCourseInstance(CourseInstance courseInstance) {
        Long instanceId = courseInstanceDaoImpl.insertCourseInstance(courseInstance);
        courseInstance.setId(instanceId);
        return courseInstance;
    }

    public List<CourseInstance> getCourseInstancesByYearAndSemester(Integer year, Integer semester) {
        return courseInstanceDaoImpl.getCourseInstancesByYearAndSemester(year, semester);
    }

    public List<CourseInstanceDTO> getCourseInstanceById(Integer year, Integer semester, Integer courseId) {
        return courseInstanceDaoImpl.getCourseInstanceById(year, semester, courseId);
    }

    public void deleteCourseInstanceById(Integer year, Integer semester, Long courseId) {
        courseInstanceDaoImpl.deleteCourseInstanceById(year, semester, courseId);
    }
}
