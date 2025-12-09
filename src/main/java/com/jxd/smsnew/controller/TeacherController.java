package com.jxd.smsnew.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.smsnew.model.UserLogin;
import com.jxd.smsnew.service.ITeacherService;
import com.jxd.smsnew.vo.CourseVO;
import com.jxd.smsnew.vo.SelectedCourseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private ITeacherService teacherService;

    // 教师所教课程列表
    @GetMapping("/courses")
    public IPage<CourseVO> listTeacherCourses(@RequestParam(defaultValue = "1") int pageNum,
                                              @RequestParam(defaultValue = "10") int pageSize,
                                              HttpSession session) {
        UserLogin user = (UserLogin) session.getAttribute("currentUser");
        if (user != null) {
            return teacherService.getTeacherCoursesByPage(pageNum, pageSize, user.getUsername());
        }
        return null;
    }

    // 查看选课学生列表
    @GetMapping("/students")
    public IPage<SelectedCourseVO> listStudentsByCourse(@RequestParam(defaultValue = "1") int pageNum,
                                                        @RequestParam(defaultValue = "10") int pageSize,
                                                        int courseId) {
        return teacherService.getStudentsByCourseId(pageNum, pageSize, courseId);
    }

    // 录入成绩
    @PostMapping("/grade")
    public boolean gradeStudent(@RequestParam int studentId, @RequestParam int courseId, @RequestParam int mark) {
        return teacherService.gradeStudent(studentId, courseId, mark);
    }
}