package com.ez.exam.comment2.controller;

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

import com.ez.exam.comment2.model.Comment2Service;
import com.ez.exam.comment2.model.Comment2VO;
import com.ez.exam.common.ConstUtil;
import com.ez.exam.common.PaginationInfo;
import com.ez.exam.common.SearchVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/comment2")
@RequiredArgsConstructor
public class Comment2Controller {
	public static final Logger logger
		= LoggerFactory.getLogger(Comment2Controller.class);
	
	public final Comment2Service service;
	
	@GetMapping("/write.do")
	public String write_get() {
		logger.info("코멘트 등록 페이지");
		
		return "/comment2/write";
		//=> http://localhost:9091/exam/comment2/write.do
	}
	
	@PostMapping("/write.do")
	public String write_post(@ModelAttribute Comment2VO vo,
			Model model) {
		logger.info("코멘트 등록 처리, 파라미터 Comment2VO = {}", vo);
		
		String msg = "등록에 실패했습니다.", url = "/comment2/write.do";
		
		int cnt = service.insertComment2(vo);
		
		if(cnt > 0) {
			msg = "등록에 성공했습니다.";
			url = "/comment2/list.do";
		}
	
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		return "common/message";
		
	}
	
	@RequestMapping("/list.do")
	public String list(@ModelAttribute SearchVO searchVo, Model model) {
		logger.info("코멘트 목록, 파라미터 searchVo={}", searchVo);
		
		//paginationInfo 객체 생성
		PaginationInfo pagingInfo = new PaginationInfo();
		pagingInfo.setRecordCountPerPage(ConstUtil.RECORD_COUNT);
		pagingInfo.setBlockSize(ConstUtil.BLOCKSIZE);
		pagingInfo.setCurrentPage(searchVo.getCurrentPage());
		
		//searchVo객체에 페이징 처리를 위한 값 세팅
		searchVo.setFirstRecordIndex(pagingInfo.getFirstRecordIndex());
		searchVo.setRecordCountPerPage(ConstUtil.RECORD_COUNT);
		
		List<Comment2VO> list = service.selectAll(searchVo);
		logger.info("코멘트 목록 조회 결과, list.size={}", list.size());
		
		int totalRecord = service.getTotalRecord(searchVo);
		logger.info("코멘트 목록 totalRecord={}", totalRecord);
		pagingInfo.setTotalRecord(totalRecord);
		
		model.addAttribute("list", list);
		model.addAttribute("pagingInfo", pagingInfo);
		
		return "/comment2/list";
	}
	
	@RequestMapping("/detail.do")
	public String detail(@RequestParam(defaultValue = "0") int commentNo,
			Model model) {
		logger.info("코멘트 상세보기 파라미터 commentNo = {}", commentNo);
		
		if(commentNo == 0) {
			model.addAttribute("msg", "잘못된 url입니다");
			model.addAttribute("url", "/comment2/list.do");
			return "/common/message";
		}
		
		Comment2VO vo = service.selectByNo(commentNo);
		logger.info("코멘트 상세보기 결과 vo = {}", vo);
		
		model.addAttribute("vo", vo);
		
		return "/comment2/detail";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
