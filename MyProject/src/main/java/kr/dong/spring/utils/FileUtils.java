package kr.dong.spring.utils;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.dong.spring.board.dto.FileDto;

@Component
public class FileUtils {

	
	public List<FileDto> parseFileInfo(int boardIdx, MultipartHttpServletRequest multipartHttpServletRequest) {
		if(ObjectUtils.isEmpty(multipartHttpServletRequest)) {
			return null;
		}
		
		List<FileDto> fileList = new ArrayList<FileDto>() ;
		
		// 파일이 업로드될 폴더 생성
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		ZonedDateTime currentDateTime = ZonedDateTime.now();
		String path = "images/" + currentDateTime.format(formatter);
		
		File file = new File(path);
		
		if(file.exists() == false) file.mkdirs();
		
		Iterator<String> iter = multipartHttpServletRequest.getFileNames();
		String orginalFileExtension = null;
		int i = 0 ;
		while(iter.hasNext() ) {
			++i ;
			List<MultipartFile> list = multipartHttpServletRequest.getFiles(iter.next());
			int j = 0 ;
			for (MultipartFile multipartFile : list) {
				
				if(multipartFile.isEmpty() == false) {
					String contentType = multipartFile.getContentType() ;
					if(ObjectUtils.isEmpty(contentType)) {
						break;
					}else {
						if(contentType.contains("image/jpeg")){
							orginalFileExtension = ".jpg";
						} else if(contentType.contains("image/png")){
							orginalFileExtension = ".png";
						} else if(contentType.contains("image/gif")){
							orginalFileExtension = ".gif";
						} else if(contentType.contains("image/bmp")){
							orginalFileExtension = ".bmp";
						} else{
							break;
						}
//						System.out.println("=============> " + i + "-"+ ++j + " | " + "original filename in the client's filesystem : " + multipartFile.getOriginalFilename());
//						System.out.println("=============> " + i + "-"+ ++j + " | " + "the size of the file in bytes : " + multipartFile.getSize());
//						System.out.println("=============> " + i + "-"+ ++j + " | " + "the content type of the file : " + multipartFile.getContentType());
						
						//서버에 저장될 파일 이름을 생성 파일명 중복을 막기위해 나노초까지 사용
						//또다른 중복방지 방법은 UUID.randomUUID().toString() 이것을 파일명에 추가
						String newFileName = Long.toString(System.nanoTime()) + orginalFileExtension ;
						
						//FileDto 하나 생성하여 업로드된 파일 한개에 대한 정보들을 넣고 FileDto를 list에 추가
						FileDto fileDto = new FileDto();
						fileDto.setBoardIdx(boardIdx);
						fileDto.setFileSize(multipartFile.getSize());
						fileDto.setOriginalFileName(multipartFile.getOriginalFilename());
						fileDto.setStoredFilePath(path + "/" + newFileName);
						
						fileList.add(fileDto);
						
						//파일을 서버에 저장
						file = new File(path + "/" + newFileName);
						try {
							multipartFile.transferTo(file);
						} catch (IllegalStateException | IOException e) {
							e.printStackTrace();
						}
						
					}
			
				}
			}
		}
		
		
		return fileList ;
	}
}
