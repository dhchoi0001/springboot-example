package kr.dong.spring.login.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.dong.spring.board.dto.BoardDto;
import kr.dong.spring.board.dto.FileDto;
import kr.dong.spring.board.service.BoardService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LoginController {
	
	
//	@Autowired
//	private BoardService boardService ;
	
	@GetMapping("/login/login")
	public void login() {
		System.out.println("=============> /login/login  : rrrrr");
	}	

//	@RequestMapping("/login/login?error")
//	public String loginError() {
//		System.out.println("=============> /login/login?error  : rrrrr");
//		return "/login/logout/";
//	}
	
	
	@RequestMapping("/login/accessDenied")
	public void accessDenied() {
	}

	@GetMapping("/login/logout")
	public void logout() {
		System.out.println("=============> /login/logout  eeee  : fdfdfdfdr");
	}
//	public String logout() {
//		System.out.println("=============> /login/logout  eeee  : fdfdfdfdr");
//		return "redirect:/";
//	}
//	
//	@RequestMapping("/board/boardList")
//	public String boardList(Model model) {
//		List<BoardDto> list = boardService.boardList();
//		//log.debug("===> List<BoardDto> size :" + list.size());
//		model.addAttribute("list", list);
//
//		return "board/boardList"; 
//	}
//	
//	@RequestMapping("/board/boardWrite")
//	public String boardWrite() {
//
//		return "board/boardWrite"; 
//	}
//
//	@RequestMapping("/board/boardInsert")
//	public String boardInsert(BoardDto boardDto, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
//		//System.out.println("=============> boardInsert :");
//		boardService.boardInsert(boardDto, multipartHttpServletRequest);
//		return "redirect:/board/boardList"; 
//	}
//	
//	@RequestMapping("/board/boardDetail")
//	public String boardDetail(@RequestParam("boardIdx") int boardIdx, Model model) {
//		log.debug("======> boardDetail boardIdx :" + boardIdx);
//		BoardDto boardDto = boardService.boardDetail(boardIdx);
//		log.debug("======> boardDetail boardIdx222 :" + boardIdx);
//		model.addAttribute("boardDto", boardDto);
//
//		return "board/boardDetail"; 
//	}
//
//	@RequestMapping("/board/boardUpdate")
//	public String boardUpdate(BoardDto boardDto) {
//		log.debug("===> boardUpdate boardDto.getBoardIdx() : "+boardDto.getBoardIdx());
//		log.debug("    | ===> boardUpdate boardDto.getTitle() : "+boardDto.getTitle());
//		boardService.boardUpdate(boardDto);
//		return "redirect:/board/boardList"; 
//	}
//	@RequestMapping("/board/boardDelete")
//	public String boardDelete(@RequestParam("boardIdx") int boardIdx) {
//		boardService.boardDelete(boardIdx);
//		return "redirect:/board/boardList"; 
//	}
//
//	@RequestMapping("/board/downloadBoardFile")
//	public void downloadBoardFile(
//			@RequestParam("idx") int idx, 
//			@RequestParam("boardIdx") int boardIdx,
//			HttpServletResponse response) throws Exception {
//		System.out.println("=========> downloadBoardFile" + boardIdx);
//		
//		FileDto fileDto = boardService.selectFileInfo(idx, boardIdx);
//		
//		if(ObjectUtils.isEmpty(fileDto) == false) {
//			String filName = fileDto.getOriginalFileName();
//			byte[] files = FileUtils.readFileToByteArray(new File(fileDto.getStoredFilePath()));
//			
//			//response 헤더에 설정
//			response.setContentType("application/octet-stream");
//			response.setContentLength(files.length);
//			response.setHeader("Content-Disposition", 
//					"attachment; filename=\"" + URLEncoder.encode(filName, "UTF-8") + "\";");
//			response.setHeader("Content-Transfer-Encoding", "binary");
//			response.getOutputStream().write(files);
//			response.getOutputStream().flush();
//			response.getOutputStream().close();
//
//		}
//		return; 
//	}
	
}
