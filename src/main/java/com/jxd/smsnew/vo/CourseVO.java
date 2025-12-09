package com.jxd.smsnew.vo;

import com.jxd.smsnew.model.Course;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CourseVO extends Course {
    private String teacherName;
    private String collegeName;
}