package com.cseazeem.course_management.Database;

import com.cseazeem.course_management.Model.CourseInstance;
import com.cseazeem.course_management.Model.CourseInstanceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseInstanceDaoImpl {

    private final CourseInstanceDao courseInstanceDao;

    @Autowired
    public CourseInstanceDaoImpl(CourseInstanceDao courseInstanceDao) {
        this.courseInstanceDao = courseInstanceDao;
    }


    public Long insertCourseInstance(CourseInstance courseInstance) {
        return courseInstanceDao.insertCourseInstance(
                courseInstance.getCourseId(),
                courseInstance.getYear(),
                courseInstance.getSemester());
    }

    public List<CourseInstance> getCourseInstancesByYearAndSemester(Integer year, Integer semester) {
        return courseInstanceDao.getCourseInstancesByYearAndSemester(year, semester);
    }

    public List<CourseInstanceDTO> getCourseInstanceById(Integer year, Integer semester, Integer courseId) {
        return courseInstanceDao.getCourseInstanceById(year, semester, courseId);
    }

    public void deleteCourseInstanceById(Integer year, Integer semester, Long courseId) {
        courseInstanceDao.deleteCourseInstanceById(year, semester, courseId);
    }


}
