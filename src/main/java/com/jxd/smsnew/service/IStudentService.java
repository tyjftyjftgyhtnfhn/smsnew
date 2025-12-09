package com.jxd.smsnew.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.smsnew.model.SelectedCourse;
import com.jxd.smsnew.model.Student;
import com.jxd.smsnew.vo.CourseVO;
import com.jxd.smsnew.vo.SelectedCourseVO;

public interface IStudentService extends IService<Student> {

    IPage<CourseVO> getAllCoursesByPage(int pageNum, int pageSize, String courseName);
    boolean selectCourse(int studentId, int courseId);
    boolean dropCourse(int studentId, int courseId);
    IPage<SelectedCourseVO> getSelectedCoursesByPage(int pageNum, int pageSize, String username);
    IPage<SelectedCourseVO> getFinishedCoursesByPage(int pageNum, int pageSize, String username);
}