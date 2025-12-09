package com.jxd.smsnew.vo;

import com.jxd.smsnew.model.Teacher;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TeacherVO extends Teacher {
    private String collegeName;
}