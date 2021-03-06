package com.ez.exam.comment2.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ez.exam.common.SearchVO;

@Service
public class Comment2ServiceImpl implements Comment2Service{
	private static final Logger logger
	= LoggerFactory.getLogger(Comment2ServiceImpl.class);
	
	@Autowired
	private Comment2DAO dao;
	
	public Comment2ServiceImpl() {
		logger.info("생성자 호출 : Comment2ServiceImpl");
	}

	@Override
	public int insertComment2(Comment2VO vo) {
		return dao.insertComment2(vo); 
	}

	@Override
	public List<Comment2VO> selectAll(SearchVO searchVo) {
		return dao.selectAll(searchVo);
	}

	@Override
	public int getTotalRecord(SearchVO searchVo) {
		return dao.getTotalRecord(searchVo);
	}

	@Override
	public Comment2VO selectByNo(int no) {
		return dao.selectByNo(no);
	}

}
