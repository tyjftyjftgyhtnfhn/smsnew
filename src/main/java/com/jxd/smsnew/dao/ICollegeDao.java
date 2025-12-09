package com.jxd.smsnew.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxd.smsnew.model.College;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ICollegeDao extends BaseMapper<College> {
    List<College> selectAllColleges();
}