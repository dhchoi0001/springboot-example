package kr.dong.spring.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.dong.spring.board.dto.BoardDto;
import kr.dong.spring.board.dto.FileDto;

@Mapper
public interface BoardMapper {
	
	//메소드의 이름과쿼리의 이름을 동일하게 처리
	List<BoardDto> boardList();
	void boardInsert(BoardDto boardDto);
	BoardDto boardDetail(int boardIdx);
	void boardUpdate(BoardDto boardDto);
	void boardDelete(int boardIdx);
	void updateHit(int boardIdx);
	void boardFileInsert(List<FileDto> list);
	List<FileDto> selectBoardFileList(int boardIdx);
	FileDto selectFileInfo(int idx, int boardIdx);

}
