package com.jxd.smsnew.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.smsnew.model.College;
import com.jxd.smsnew.model.Course;
import com.jxd.smsnew.model.Student;
import com.jxd.smsnew.model.Teacher;
import com.jxd.smsnew.service.IAdminService;
import com.jxd.smsnew.vo.CourseVO;
import com.jxd.smsnew.vo.StudentVO;
import com.jxd.smsnew.vo.TeacherVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    // 学生管理
    @GetMapping("/students")
    public IPage<StudentVO> listStudents(@RequestParam(defaultValue = "1") int pageNum,
                                         @RequestParam(defaultValue = "10") int pageSize,
                                         @RequestParam(required = false) String studentName,
                                         @RequestParam(required = false) Integer collegeId) {
        return adminService.getStudentsByPage(pageNum, pageSize, studentName, collegeId);
    }

    @PostMapping("/student/add")
    public boolean addStudent(@RequestBody Student student) {
        return adminService.addStudent(student);
    }

    @PostMapping("/student/update")
    public boolean updateStudent(@RequestBody Student student) {
        return adminService.updateStudent(student);
    }

    @DeleteMapping("/student/{studentId}")
    public boolean deleteStudent(@PathVariable int studentId) {
        return adminService.deleteStudent(studentId);
    }

    @DeleteMapping("/students")
    public boolean bulkDeleteStudents(@RequestBody List<Integer> studentIds) {
        return adminService.bulkDeleteStudents(studentIds);
    }

    // 教师管理
    @GetMapping("/teachers")
    public IPage<TeacherVO> listTeachers(@RequestParam(defaultValue = "1") int pageNum,
                                         @RequestParam(defaultValue = "10") int pageSize,
                                         @RequestParam(required = false) String teacherName,
                                         @RequestParam(required = false) Integer collegeId) {
        return adminService.getTeachersByPage(pageNum, pageSize, teacherName, collegeId);
    }

    @PostMapping("/teacher/add")
    public boolean addTeacher(@RequestBody Teacher teacher) {
        return adminService.addTeacher(teacher);
    }

    @PostMapping("/teacher/update")
    public boolean updateTeacher(@RequestBody Teacher teacher) {
        return adminService.updateTeacher(teacher);
    }

    @DeleteMapping("/teacher/{teacherId}")
    public boolean deleteTeacher(@PathVariable int teacherId) {
        return adminService.deleteTeacher(teacherId);
    }

    // 课程管理
    @GetMapping("/courses")
    public IPage<CourseVO> listCourses(@RequestParam(defaultValue = "1") int pageNum,
                                       @RequestParam(defaultValue = "10") int pageSize,
                                       @RequestParam(required = false) String courseName) {
        return adminService.getCoursesByPage(pageNum, pageSize, courseName);
    }

    @PostMapping("/course/add")
    public boolean addCourse(@RequestBody Course course) {
        return adminService.addCourse(course);
    }

    @PostMapping("/course/update")
    public boolean updateCourse(@RequestBody Course course) {
        return adminService.updateCourse(course);
    }

    @DeleteMapping("/course/{courseId}")
    public boolean deleteCourse(@PathVariable int courseId) {
        return adminService.deleteCourse(courseId);
    }

    // 其他
    @GetMapping("/colleges")
    public List<College> getAllColleges() {
        return adminService.getAllColleges();
    }

    @PostMapping("/password/reset")
    public boolean resetPassword(@RequestParam String username) {
        return adminService.resetUserPassword(username);
    }
}