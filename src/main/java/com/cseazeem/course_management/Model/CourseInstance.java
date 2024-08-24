package com.cseazeem.course_management.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseInstance {
    private Long id;
    private Integer year;
    private Integer semester;
    private Long courseId;
}
