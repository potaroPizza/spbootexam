package com.ez.exam.comment2.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Comment2VO {
	private int commentNo;
	private String userId;                
	private Timestamp regDate;
	private String commentContent;
}
