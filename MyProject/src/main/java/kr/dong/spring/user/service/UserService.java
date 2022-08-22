package kr.dong.spring.user.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.dong.spring.board.dto.BoardDto;
import kr.dong.spring.board.dto.FileDto;
import kr.dong.spring.user.entity.Users;

public interface UserService {

	List<Users> userList();

	void saveUser(Users user);

	Users userDetail(String id);
//	void userUpdate(Users users);
//	void userDelete(int id);

	void userDelete(String id);

}
