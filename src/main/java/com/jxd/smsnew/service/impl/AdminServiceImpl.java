package com.jxd.smsnew.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.smsnew.dao.*;
import com.jxd.smsnew.model.*;
import com.jxd.smsnew.service.IAdminService;
import com.jxd.smsnew.vo.CourseVO;
import com.jxd.smsnew.vo.StudentVO;
import com.jxd.smsnew.vo.TeacherVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AdminServiceImpl extends ServiceImpl<IStudentDao, Student> implements IAdminService {

    @Autowired
    private IStudentDao studentDao;
    @Autowired
    private ITeacherDao teacherDao;
    @Autowired
    private ICourseDao courseDao;
    @Autowired
    private ICollegeDao collegeDao;
    @Autowired
    private IUserLoginDao userLoginDao;

    // 学生管理
    @Override
    public IPage<StudentVO> getStudentsByPage(int pageNum, int pageSize, String studentName, Integer collegeId) {
        IPage<StudentVO> page = new Page<>(pageNum, pageSize);
        return studentDao.selectStudentsByPage(page, studentName, collegeId);
    }

    @Override
    public boolean addStudent(Student student) {
        if (studentDao.insert(student) > 0) {
            UserLogin userLogin = new UserLogin();
            userLogin.setUsername(String.valueOf(student.getStudentId()));
            userLogin.setPassword("123456"); // 不使用加密
            userLogin.setRole(3); // 学生角色
            userLogin.setUserId(student.getStudentId());
            return userLoginDao.insert(userLogin) > 0;
        }
        return false;
    }

    @Override
    public boolean updateStudent(Student student) {
        return studentDao.updateById(student) > 0;
    }

    @Override
    public boolean deleteStudent(int studentId) {
        // 删除学生信息
        int studentDelete = studentDao.deleteById(studentId);
        // 删除用户登录信息
        int userLoginDelete = userLoginDao.deleteById(studentId);
        return studentDelete > 0 && userLoginDelete > 0;
    }

    @Override
    public boolean bulkDeleteStudents(List<Integer> studentIds) {
        List<String> usernames = new ArrayList<>();
        for (Integer id : studentIds) {
            usernames.add(String.valueOf(id));
        }

        // 批量删除学生信息
        int studentDelete = studentDao.bulkDelete(studentIds);
        // 批量删除用户登录信息
        int userLoginDelete = userLoginDao.bulkDelete(usernames);

        return studentDelete > 0 && userLoginDelete > 0;
    }

    @Override
    public Student getStudentById(int studentId) {
        return studentDao.selectById(studentId);
    }

    @Override
    public boolean resetStudentPassword(int studentId) {
        UserLogin user = userLoginDao.selectByUsername(String.valueOf(studentId));
        if (user != null) {
            user.setPassword("123456"); // 不使用加密
            return userLoginDao.updateById(user) > 0;
        }
        return false;
    }

    // 教师管理
    @Override
    public IPage<TeacherVO> getTeachersByPage(int pageNum, int pageSize, String teacherName, Integer collegeId) {
        IPage<TeacherVO> page = new Page<>(pageNum, pageSize);
        return teacherDao.selectTeachersByPage(page, teacherName, collegeId);
    }

    @Override
    public boolean addTeacher(Teacher teacher) {
        if (teacherDao.insert(teacher) > 0) {
            UserLogin userLogin = new UserLogin();
            userLogin.setUsername(String.valueOf(teacher.getTeacherId()));
            userLogin.setPassword("123456"); // 不使用加密
            userLogin.setRole(2); // 教师角色
            userLogin.setUserId(teacher.getTeacherId());
            return userLoginDao.insert(userLogin) > 0;
        }
        return false;
    }

    @Override
    public boolean updateTeacher(Teacher teacher) {
        return teacherDao.updateById(teacher) > 0;
    }

    @Override
    public boolean deleteTeacher(int teacherId) {
        // 删除教师信息
        int teacherDelete = teacherDao.deleteById(teacherId);
        // 删除用户登录信息
        int userLoginDelete = userLoginDao.deleteById(teacherId);
        return teacherDelete > 0 && userLoginDelete > 0;
    }

    @Override
    public Teacher getTeacherById(int teacherId) {
        return teacherDao.selectById(teacherId);
    }

    // 课程管理
    @Override
    public IPage<CourseVO> getCoursesByPage(int pageNum, int pageSize, String courseName) {
        IPage<CourseVO> page = new Page<>(pageNum, pageSize);
        return courseDao.selectCoursesByPage(page, courseName);
    }

    @Override
    public boolean addCourse(Course course) {
        return courseDao.insert(course) > 0;
    }

    @Override
    public boolean updateCourse(Course course) {
        return courseDao.updateById(course) > 0;
    }

    @Override
    public boolean deleteCourse(int courseId) {
        return courseDao.deleteById(courseId) > 0;
    }

    @Override
    public Course getCourseById(int courseId) {
        return courseDao.selectById(courseId);
    }

    // 其他
    @Override
    public List<College> getAllColleges() {
        return collegeDao.selectAllColleges();
    }

    @Override
    public boolean resetUserPassword(String username) {
        UserLogin user = userLoginDao.selectByUsername(username);
        if (user != null) {
            user.setPassword("123456"); // 不使用加密
            return userLoginDao.updateById(user) > 0;
        }
        return false;
    }
}