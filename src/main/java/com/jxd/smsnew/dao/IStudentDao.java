package com.jxd.smsnew.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jxd.smsnew.model.Student;
import com.jxd.smsnew.vo.StudentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IStudentDao extends BaseMapper<Student> {

    IPage<StudentVO> selectStudentsByPage(IPage<StudentVO> page, @Param("studentName") String studentName, @Param("collegeId") Integer collegeId);

    int bulkDelete(List<Integer> studentIds);
}