package com.jxd.smsnew.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Student {
    @TableId(value = "student_id", type = IdType.AUTO)
    private int studentId;
    private String studentName;
    private String sex;
    private Date birthday;
    private Date enrollmentDate;
    private int collegeId;
}