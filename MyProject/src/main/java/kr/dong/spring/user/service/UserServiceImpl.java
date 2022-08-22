package kr.dong.spring.user.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.dong.spring.user.entity.Users;
import kr.dong.spring.user.repository.UserRepository;
import kr.dong.spring.utils.FileUtils;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<Users> userList() {
		List<Users> list = userRepository.findAllByOrderByIdDesc();
		return list;
	}
	
	@Override
	public void saveUser(Users user) {
		System.out.println("=============> saveUser :" + user.getName());
		
		userRepository.save(user);
		return ;
	}
	
	@Override
	public Users userDetail(String id) {
		Optional<Users> optional = userRepository.findById(id);
		if(optional.isPresent()) {
			Users user = optional.get();
			return user ;
		} else {
			throw new NullPointerException();
		}
	}
	
	@Override
	public void userDelete(String id) {
		System.out.println("=============> userDelete :" + id);
	
		userRepository.deleteById(id);
		return ;
	}
	
	
	
//
//	public void userInsert(Users users) {
//		
//		userRepository.save(users);
//			
//		return; 
//	}

}
