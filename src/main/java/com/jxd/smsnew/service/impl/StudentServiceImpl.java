package com.jxd.smsnew.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.smsnew.dao.ICourseDao;
import com.jxd.smsnew.dao.ISelectedCourseDao;
import com.jxd.smsnew.dao.IStudentDao;
import com.jxd.smsnew.model.SelectedCourse;
import com.jxd.smsnew.model.Student;
import com.jxd.smsnew.service.IStudentService;
import com.jxd.smsnew.vo.CourseVO;
import com.jxd.smsnew.vo.SelectedCourseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentServiceImpl extends ServiceImpl<IStudentDao, Student> implements IStudentService {

    @Autowired
    private ISelectedCourseDao selectedCourseDao;
    @Autowired
    private ICourseDao courseDao;

    @Override
    public IPage<CourseVO> getAllCoursesByPage(int pageNum, int pageSize, String courseName) {
        IPage<CourseVO> page = new Page<>(pageNum, pageSize);
        return courseDao.selectCoursesByPage(page, courseName);
    }

    @Override
    public boolean selectCourse(int studentId, int courseId) {
        // 检查该课程是否已被该学生选择
        QueryWrapper<SelectedCourse> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("studentId", studentId).eq("courseId", courseId);
        if (selectedCourseDao.selectOne(queryWrapper) != null) {
            return false;
        }
        SelectedCourse selectedCourse = new SelectedCourse();
        selectedCourse.setStudentId(studentId);
        selectedCourse.setCourseId(courseId);
        return selectedCourseDao.insert(selectedCourse) > 0;
    }

    @Override
    public boolean dropCourse(int studentId, int courseId) {
        QueryWrapper<SelectedCourse> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("studentId", studentId).eq("courseId", courseId);
        return selectedCourseDao.delete(queryWrapper) > 0;
    }

    @Override
    public IPage<SelectedCourseVO> getSelectedCoursesByPage(int pageNum, int pageSize, String username) {
        IPage<SelectedCourseVO> page = new Page<>(pageNum, pageSize);
        return selectedCourseDao.selectStudentSelectedCoursesByPage(page, username);
    }

    @Override
    public IPage<SelectedCourseVO> getFinishedCoursesByPage(int pageNum, int pageSize, String username) {
        IPage<SelectedCourseVO> page = new Page<>(pageNum, pageSize);
        return selectedCourseDao.selectStudentFinishedCoursesByPage(page, username);
    }
}