package com.jxd.smsnew.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.smsnew.model.SelectedCourse;
import com.jxd.smsnew.vo.SelectedCourseVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ISelectedCourseDao extends BaseMapper<SelectedCourse> {

    IPage<SelectedCourseVO> selectStudentSelectedCoursesByPage(IPage<SelectedCourseVO> page, @Param("username") String username);

    IPage<SelectedCourseVO> selectStudentFinishedCoursesByPage(IPage<SelectedCourseVO> page, @Param("username") String username);

    IPage<SelectedCourseVO> selectStudentsByCourseId(IPage<SelectedCourseVO> page, @Param("courseId") int courseId);

    int updateMark(@Param("studentId") int studentId, @Param("courseId") int courseId, @Param("mark") int mark);
}