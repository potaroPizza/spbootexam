package com.ez.exam.book.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ez.exam.common.SearchVO;

@Service
public class BookServiceImpl implements BookService {
	private static final Logger logger
		= LoggerFactory.getLogger(BookServiceImpl.class);
	
	@Autowired
	private BookDAO bookDAO;
	
	public BookServiceImpl() {
		logger.info("생성자 호출 : BookServiceImpl");
	}

	@Override
	public int insertBook(BookDTO dto) {
		return bookDAO.insertBook(dto);
	}
	
	public List<BookDTO> selectAll(SearchVO searchVo) {
		return bookDAO.selectAll(searchVo);
	}
	
	public int getTotalRecord(SearchVO searchVo) {
		return bookDAO.getTotalRecord(searchVo);
	}
	
	public BookDTO selectByNo(int no) {
		return bookDAO.selectByNo(no);
	}
	
	public int updateCount(int no) {
		return bookDAO.updateCount(no);
	}

	@Override
	public int updateBook(BookDTO dto) {
		return bookDAO.updateBook(dto);
	}

	@Override
	public int deleteBook(int no) {
		return bookDAO.deleteBook(no);
	}

}
