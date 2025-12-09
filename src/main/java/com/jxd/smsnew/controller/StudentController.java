package com.jxd.smsnew.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.smsnew.model.UserLogin;
import com.jxd.smsnew.service.IStudentService;
import com.jxd.smsnew.vo.CourseVO;
import com.jxd.smsnew.vo.SelectedCourseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    // 可选课程列表
    @GetMapping("/courses")
    public IPage<CourseVO> listAllCourses(@RequestParam(defaultValue = "1") int pageNum,
                                          @RequestParam(defaultValue = "10") int pageSize,
                                          @RequestParam(required = false) String courseName) {
        return studentService.getAllCoursesByPage(pageNum, pageSize, courseName);
    }

    // 选课
    @PostMapping("/course/select")
    public boolean selectCourse(@RequestParam int courseId, HttpSession session) {
        UserLogin user = (UserLogin) session.getAttribute("currentUser");
        if (user != null) {
            return studentService.selectCourse(user.getUserId(), courseId);
        }
        return false;
    }

    // 退课
    @PostMapping("/course/drop")
    public boolean dropCourse(@RequestParam int courseId, HttpSession session) {
        UserLogin user = (UserLogin) session.getAttribute("currentUser");
        if (user != null) {
            return studentService.dropCourse(user.getUserId(), courseId);
        }
        return false;
    }

    // 已选课程列表
    @GetMapping("/selectedCourses")
    public IPage<SelectedCourseVO> listSelectedCourses(@RequestParam(defaultValue = "1") int pageNum,
                                                       @RequestParam(defaultValue = "10") int pageSize,
                                                       HttpSession session) {
        UserLogin user = (UserLogin) session.getAttribute("currentUser");
        if (user != null) {
            return studentService.getSelectedCoursesByPage(pageNum, pageSize, user.getUsername());
        }
        return null;
    }

    // 已修课程列表
    @GetMapping("/finishedCourses")
    public IPage<SelectedCourseVO> listFinishedCourses(@RequestParam(defaultValue = "1") int pageNum,
                                                       @RequestParam(defaultValue = "10") int pageSize,
                                                       HttpSession session) {
        UserLogin user = (UserLogin) session.getAttribute("currentUser");
        if (user != null) {
            return studentService.getFinishedCoursesByPage(pageNum, pageSize, user.getUsername());
        }
        return null;
    }
}