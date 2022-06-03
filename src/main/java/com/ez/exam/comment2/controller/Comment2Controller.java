package com.ez.exam.comment2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ez.exam.comment2.model.Comment2Service;
import com.ez.exam.comment2.model.Comment2VO;

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
}
