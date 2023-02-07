package com.cos.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//dto 사용예시를 위한 클래스
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplySaveRequestDto {
	
	private int userId;
	private int boardId;
	private String content;

}
