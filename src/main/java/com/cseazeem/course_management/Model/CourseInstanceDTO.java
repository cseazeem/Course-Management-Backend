package com.cseazeem.course_management.Model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseInstanceDTO {
    private String title;
    private String courseCode;
    private Long year;
    private Long semester;
}
