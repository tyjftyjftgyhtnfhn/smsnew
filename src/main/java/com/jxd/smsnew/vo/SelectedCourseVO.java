package com.jxd.smsnew.vo;

import com.jxd.smsnew.model.SelectedCourse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SelectedCourseVO extends SelectedCourse {
    private String studentName;
    private String courseName;
    private String teacherName;
}