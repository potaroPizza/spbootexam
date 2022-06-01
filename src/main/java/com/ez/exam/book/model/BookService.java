package com.ez.exam.book.model;

import java.util.List;

import com.ez.exam.common.SearchVO;

public interface BookService {
	public int insertBook(BookDTO dto);
	public List<BookDTO> selectAll(SearchVO searchVo);
	public int getTotalRecord(SearchVO searchVo);
	public BookDTO selectByNo(int no);
	public int updateCount(int no);
	public int updateBook(BookDTO dto);
	public int deleteBook(int no);
}
