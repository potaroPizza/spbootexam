package com.ez.exam.comment2.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Comment2DAO {
	int insertComment2(Comment2VO vo);
	//List<Comment2VO> selectAll();
	//Comment2VO selectByNo(int no);
}
