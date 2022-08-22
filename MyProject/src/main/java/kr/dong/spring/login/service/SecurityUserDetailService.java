package kr.dong.spring.login.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.dong.spring.login.security.SecurityUser;
import kr.dong.spring.user.entity.Users;
import kr.dong.spring.user.repository.UserRepository;

@Service
public class SecurityUserDetailService implements UserDetailsService{

	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Users> optional = userRepo.findById(username);
		System.out.println("===============> loadUserByUsername :");
		if(optional.isPresent()) {
			Users user = optional.get();
			System.out.println("===============>loadUserByUsername user :" + user);
			return new SecurityUser(user);
		} else {
			System.out.println("===============> UsernameNotFoundException :");
			throw new UsernameNotFoundException(username + " 사용자 없음!!!");
		}
	}
}
