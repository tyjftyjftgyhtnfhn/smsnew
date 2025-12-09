package com.jxd.smsnew.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.smsnew.model.Teacher;
import com.jxd.smsnew.vo.TeacherVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ITeacherDao extends BaseMapper<Teacher> {

    IPage<TeacherVO> selectTeachersByPage(IPage<TeacherVO> page, @Param("teacherName") String teacherName, @Param("collegeId") Integer collegeId);
}