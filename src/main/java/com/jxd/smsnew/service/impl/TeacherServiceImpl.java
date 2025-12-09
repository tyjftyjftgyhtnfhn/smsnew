package com.jxd.smsnew.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.smsnew.dao.ICourseDao;
import com.jxd.smsnew.dao.ISelectedCourseDao;
import com.jxd.smsnew.dao.ITeacherDao;
import com.jxd.smsnew.model.Teacher;
import com.jxd.smsnew.service.ITeacherService;
import com.jxd.smsnew.vo.CourseVO;
import com.jxd.smsnew.vo.SelectedCourseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TeacherServiceImpl extends ServiceImpl<ITeacherDao, Teacher> implements ITeacherService {

    @Autowired
    private ICourseDao courseDao;
    @Autowired
    private ISelectedCourseDao selectedCourseDao;

    @Override
    public IPage<CourseVO> getTeacherCoursesByPage(int pageNum, int pageSize, String username) {
        IPage<CourseVO> page = new Page<>(pageNum, pageSize);
        return courseDao.selectCoursesByTeacherId(page, username);
    }

    @Override
    public IPage<SelectedCourseVO> getStudentsByCourseId(int pageNum, int pageSize, int courseId) {
        IPage<SelectedCourseVO> page = new Page<>(pageNum, pageSize);
        return selectedCourseDao.selectStudentsByCourseId(page, courseId);
    }

    @Override
    public boolean gradeStudent(int studentId, int courseId, int mark) {
        return selectedCourseDao.updateMark(studentId, courseId, mark) > 0;
    }
}