package com.jxd.smsnew.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.smsnew.model.Course;
import com.jxd.smsnew.vo.CourseVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ICourseDao extends BaseMapper<Course> {
    IPage<CourseVO> selectCoursesByPage(IPage<CourseVO> page, @Param("courseName") String courseName);

    // 修改后的方法签名
    IPage<CourseVO> selectCoursesByTeacherId(IPage<CourseVO> page, @Param("username") String username);
}