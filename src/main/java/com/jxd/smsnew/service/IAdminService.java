package com.jxd.smsnew.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.smsnew.model.College;
import com.jxd.smsnew.model.Course;
import com.jxd.smsnew.model.Student;
import com.jxd.smsnew.model.Teacher;
import com.jxd.smsnew.vo.CourseVO;
import com.jxd.smsnew.vo.StudentVO;
import com.jxd.smsnew.vo.TeacherVO;

import java.util.List;

public interface IAdminService extends IService<Student> {

    // 学生管理
    IPage<StudentVO> getStudentsByPage(int pageNum, int pageSize, String studentName, Integer collegeId);
    boolean addStudent(Student student);
    boolean updateStudent(Student student);
    boolean deleteStudent(int studentId);
    boolean bulkDeleteStudents(List<Integer> studentIds);
    Student getStudentById(int studentId);
    boolean resetStudentPassword(int studentId);

    // 教师管理
    IPage<TeacherVO> getTeachersByPage(int pageNum, int pageSize, String teacherName, Integer collegeId);
    boolean addTeacher(Teacher teacher);
    boolean updateTeacher(Teacher teacher);
    boolean deleteTeacher(int teacherId);
    Teacher getTeacherById(int teacherId);

    // 课程管理
    IPage<CourseVO> getCoursesByPage(int pageNum, int pageSize, String courseName);
    boolean addCourse(Course course);
    boolean updateCourse(Course course);
    boolean deleteCourse(int courseId);
    Course getCourseById(int courseId);

    // 其他
    List<College> getAllColleges();
    boolean resetUserPassword(String username);
}