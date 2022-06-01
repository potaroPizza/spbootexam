package com.ez.exam.book.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ez.exam.book.model.BookDTO;
import com.ez.exam.book.model.BookService;
import com.ez.exam.common.PaginationInfo;
import com.ez.exam.common.SearchVO;
import com.ez.exam.common.Utility;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
	private static final Logger logger
		= LoggerFactory.getLogger(BookController.class);
	
	// @RequiredArgsConstructor 덕분에 final로 선언된 객체는 오토와이어링되고, 객체도 자동 주입됨
	private final BookService bookService;
	
	@GetMapping("/bookWrite.do")
	public String write_get() {
		logger.info("책 등록 페이지");
		
		return "/book/bookWrite";
		//=> http://localhost:9090/spboard/book/bookWrite.do
	}
	
	@PostMapping("/bookWrite.do")
	public String write_post(@ModelAttribute BookDTO bookDto) {
		logger.info("책 등록 처리, 매개변수 bookDto = {}", bookDto);
		
		int cnt = bookService.insertBook(bookDto);
		logger.info("책 등록 처리 결과, cnt = {}", cnt);
		
		// message.jsp로 보내도 상관없음.
		return "redirect:/book/bookList.do";
	}
	
	@RequestMapping("/bookList.do")
	public String list(@ModelAttribute SearchVO searchVo, Model model) {
		logger.info("책 목록 페이지, 파라미터 searchVo = {}", searchVo);
		
		//[1] PaginationInfo 생성
		PaginationInfo pagingInfo = new PaginationInfo();
		pagingInfo.setRecordCountPerPage(Utility.RECORD_COUNT);
		pagingInfo.setBlockSize(Utility.BLOCKSIZE);
		pagingInfo.setCurrentPage(searchVo.getCurrentPage());
		
		//[2] searchVo에 페이징 처리 관련 변수의 값 셋팅
		searchVo.setFirstRecordIndex(pagingInfo.getFirstRecordIndex());
		searchVo.setRecordCountPerPage(Utility.RECORD_COUNT);
		
		List<BookDTO> list = bookService.selectAll(searchVo);
		logger.info("책 목록 조회 결과, list.size={}", list.size());
		
		//totalRecord개수 구하기
		int totalRecord = bookService.getTotalRecord(searchVo);
		logger.info("책 목록 totalRecord={}", totalRecord);
		
		// 이거 빼먹으면, 다른거 계산이 안됨
		pagingInfo.setTotalRecord(totalRecord);
		
		// request객체, 모델앤뷰객체에 저장하는것과 똑같은 구조
		model.addAttribute("list", list);
		model.addAttribute("pagingInfo", pagingInfo);
		
		return "/book/bookList";
	}
	
	@RequestMapping("/bookDetail.do")
	public String detail(@RequestParam(defaultValue = "0") int no,
			Model model) {
		logger.info("책 상세보기 페이지, 파라미터 no = {}", no);
		
		if(no == 0) {
			model.addAttribute("msg", "잘못된 url입니다.");
			model.addAttribute("url", "/book/bookList.do");
			return "/common/message";
		}
		
		BookDTO dto = bookService.selectByNo(no);
		logger.info("책 상세보기 결과, dto = {}", dto);
		
		model.addAttribute("dto", dto);
		
		return "/book/bookDetail";
	}
	
	@GetMapping("/bookEdit.do")
	public String edit_get(@RequestParam(defaultValue = "0") int no,
			Model model) {
		logger.info("책 수정 페이지, 파라미터 no = {}", no);
		
		if(no == 0) {
			model.addAttribute("msg", "잘못된 url입니다.");
			model.addAttribute("url", "/book/bookList.do");
			return "/common/message";
		}
		
		BookDTO dto = bookService.selectByNo(no);
		logger.info("수정할 책 상세보기 결과, dto = {}", dto);
		
		model.addAttribute("dto", dto);
		
		return "/book/bookEdit";
	}
	
	@PostMapping("/bookEdit.do")
	public String edit_post(@ModelAttribute BookDTO dto,
			Model model) {
		logger.info("책 수정 처리, 파라미터 dto = {}", dto);
		
		String msg = "수정을 실패했습니다.", url = "/book/bookEdit.do?no="+dto.getNo();
		
		int cnt = bookService.updateBook(dto);
		
		if(cnt > 0) {
			msg = "수정을 성공했습니다.";
			url = "/book/bookDetail.do?no="+dto.getNo();
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		return "/common/message";
	}
	
	@RequestMapping("/bookDelete.do")
	public String delete(@RequestParam(defaultValue = "0") int no,
			Model model) {
		logger.info("책 삭제 처리, 파라미터 no = {}", no);
		
		String msg = "삭제를 실패했습니다.", url = "/book/bookDetail.do?no="+no;
		
		int cnt = bookService.deleteBook(no);
		
		if(cnt > 0) {
			msg = "삭제를 성공했습니다.";
			url = "/book/bookList.do";
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		return "/common/message";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
