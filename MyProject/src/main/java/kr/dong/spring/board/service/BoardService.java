package kr.dong.spring.board.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.dong.spring.board.dto.BoardDto;
import kr.dong.spring.board.dto.FileDto;

public interface BoardService {

	List<BoardDto> boardList();

	void boardInsert(BoardDto boardDto, MultipartHttpServletRequest multipartHttpServletRequest);

	BoardDto boardDetail(int boardIdx);

	void boardUpdate(BoardDto boardDto);

	void boardDelete(int boardIdx);

	FileDto selectFileInfo(int idx, int boardIdx);

}
