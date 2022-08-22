package kr.dong.spring.board.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.dong.spring.board.dto.BoardDto;
import kr.dong.spring.board.dto.FileDto;
import kr.dong.spring.board.mapper.BoardMapper;
import kr.dong.spring.utils.FileUtils;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Autowired
	private FileUtils fileUtils ;

	@Override
	public List<BoardDto> boardList() {
		return boardMapper.boardList();
	}

	@Override
	public void boardInsert(BoardDto boardDto, MultipartHttpServletRequest multipartHttpServletRequest) {
		
		boardMapper.boardInsert(boardDto);
		
		//파일 업로드가 추가됨에 따라 해야할 일
		//1. 업로드되는 파일정보를 table에 넣어야 함
		//  그런데 client에서 업로드하는 파일(originalFileName)과 
		//  server에 저장하는 파일의 이름(storedFilePath)을 다르게 가져가기로 한 만큼
		//  이것을 처리해야 하고, 
		//  파일의 크기도 만들어 넣어야 한다.
		//  idx도 sequence를 만들어서 select해서 넣어야함
		//  나머지는 BoardDto에 있는 것들이므로 참고하면됨
		
		//2. 업로드되는 파일을 서버에 새이름으로 저장하기
		
		
		//처리순서
		//MultipartHttpServletRequest으로부터 MultipartFile의 List를 추출
		//
		//List로부터 MultipartFile을 꺼내서 처리
		//서버폴더명과 서버파일명을 날짜시간을 이용해 만들고
		//FileDto에 정보를 담은 후 이것을 List에 담고
		//파일을 저장
		
		//게시판 정보를 이용해 FileDto에 모자란 정보를 추가로 넣고
		//T_File Table에 저장
		
		List<FileDto> list = fileUtils.parseFileInfo(boardDto.getBoardIdx(), multipartHttpServletRequest) ;
		
		if(CollectionUtils.isEmpty(list) == false) {
			boardMapper.boardFileInsert(list);
		}
		
		return; 
	}
	
	@Override
	public 	BoardDto boardDetail(int boardIdx) {
		boardMapper.updateHit(boardIdx);
		
		//게시글 상세정보 가져오기
		BoardDto boardDto = boardMapper.boardDetail(boardIdx);
		
		//파일정보를 가져오기
		List<FileDto> fileList = boardMapper.selectBoardFileList(boardIdx);
		
		//BoardDto에 파일정보 넣기
		boardDto.setFilelist(fileList);
		
		return boardDto;
	}

	@Override
	public void boardUpdate(BoardDto boardDto) {
		boardMapper.boardUpdate(boardDto);

		return; 
	}

	@Override
	public void boardDelete(int boardIdx) {
		boardMapper.boardDelete(boardIdx);
		return; 
	}

	@Override
	public FileDto selectFileInfo(int idx, int boardIdx) {
		FileDto fileDto = boardMapper.selectFileInfo(idx, boardIdx);
		return fileDto;
	}
}
