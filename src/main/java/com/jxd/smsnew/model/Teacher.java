package com.jxd.smsnew.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Teacher {
    @TableId(value = "teacher_id", type = IdType.AUTO)
    private int teacherId;
    private String teacherName;
    private String sex;
    private Date birthday;
    private String degree;
    private String title;
    private Date hireDate;
    private int collegeId;
}