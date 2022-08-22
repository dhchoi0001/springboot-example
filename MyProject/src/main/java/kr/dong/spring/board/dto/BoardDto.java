package kr.dong.spring.board.dto;

import java.util.List;

import lombok.Data;

//DTO : Data Transfer Object
@Data
public class BoardDto {

	private int	boardIdx;
	private String title;
	private String contents;
	private int hitCnt;
	private String createDatetime;
	private String creatorId;
	//private String deleteYn;
	
	//파일처리를 위해 리스트 추가
	private List<FileDto> filelist;
	
	
}
