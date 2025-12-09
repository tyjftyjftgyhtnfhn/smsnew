package com.jxd.smsnew.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Course {
    @TableId(value = "course_id", type = IdType.AUTO)
    private int courseId;
    private String courseName;
    private int teacherId;
    private String courseTime;
    private String classroom;
    private int classWeek;
    private String courseType;
    private int collegeId;
    private int score;
}