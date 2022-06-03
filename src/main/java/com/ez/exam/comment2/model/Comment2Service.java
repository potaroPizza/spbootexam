package com.ez.exam.comment2.model;

import java.util.List;

import com.ez.exam.common.SearchVO;

public interface Comment2Service {
	int insertComment2(Comment2VO vo);
	List<Comment2VO> selectAll(SearchVO searchVo);
	int getTotalRecord(SearchVO searchVo);
	Comment2VO selectByNo(int no);
}
