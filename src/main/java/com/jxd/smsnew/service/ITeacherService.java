package com.jxd.smsnew.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.smsnew.model.Teacher;
import com.jxd.smsnew.vo.CourseVO;
import com.jxd.smsnew.vo.SelectedCourseVO;

public interface ITeacherService extends IService<Teacher> {

    IPage<CourseVO> getTeacherCoursesByPage(int pageNum, int pageSize, String username);
    IPage<SelectedCourseVO> getStudentsByCourseId(int pageNum, int pageSize, int courseId);
    boolean gradeStudent(int studentId, int courseId, int mark);
}