package kr.dong.spring.board.dto;

import lombok.Data;

//DTO : Data Transfer Object
@Data
public class FileDto {
	private int idx;
	private int boardIdx;
	private String originalFileName;
	private String storedFilePath;
	private long fileSize;
	private String creatorId;
	private String createDatetime;
	private String deletedYn;
}
