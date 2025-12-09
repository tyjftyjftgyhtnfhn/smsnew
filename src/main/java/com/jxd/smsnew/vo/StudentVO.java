package com.jxd.smsnew.vo;

import com.jxd.smsnew.model.Student;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class StudentVO extends Student {
    private String collegeName;
}