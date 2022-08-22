package kr.dong.spring.login.security;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import kr.dong.spring.user.entity.Users;

public class SecurityUser extends User {

	/**
	 * 
	 */
	//private static final long serialVersionUID = 8856896500383108034L;
	
	
	private Users user;
	public SecurityUser(Users user) {

//		super(user.getId(),
//				//암호화처리전까지는 패스워드 앞에 {noop} 추가
//				"{noop}"+user.getPw(), 
//				//AuthorityUtils.createAuthorityList(String... authorities)
//					//Converts authorities into a List of GrantedAuthority objects.
//					//Parameters: authorities the authorities to convert
//					//Returns: a List of GrantedAuthority objects
//				AuthorityUtils.createAuthorityList(user.getRole()));
		
		super(user.getId(), user.getPw(), AuthorityUtils.createAuthorityList(user.getRole()));
		
//		super(user.getId(), "{noop}"+user.getPw(), AuthorityUtils.createAuthorityList(user.getRole()));

		this.user = user;
		System.out.println("===============>SecurityUser this.user :" + this.user);
	}

}
