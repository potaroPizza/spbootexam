package com.ez.exam.book.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class BookDTO {
	private int no;
	private String title;
	private String publisher;
	private int price;
	private Timestamp joindate;
	
	//자료실 추가
	private String fileName;
	private long fileSize; 
	private int downCount;
    private String originalFileName;
}
