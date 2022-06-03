package com.ez.exam.comment2.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

//	@Override
//	public List<Comment2VO> selectAll() {
//		return dao.selectAll();
//	}
//
//	@Override
//	public Comment2VO selectByNo(int no) {
//		return dao.selectByNo(no); 
//	}

}
