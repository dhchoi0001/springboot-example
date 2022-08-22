package kr.dong.spring.user.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.dong.spring.user.entity.Users;
import kr.dong.spring.user.service.UserService;

@Controller
public class UserController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	
	
	@Autowired
	private UserService userService ;
	
	@Autowired
	private PasswordEncoder encoder ;
	
//	@RequestMapping("/")
//	public String hello() {
//		return "content";
//	}
	//GET(read), POST(create), PUT(update), DELETE(delete)
	@RequestMapping(value = "/user/userList", method = RequestMethod.GET)
	public String userList(Model model) {
		List<Users> list = userService.userList();
		//System.out.println("========> List<Users> size :" + list.size());
		//System.out.println("========> list.get(0) :" + list.get(0));
		model.addAttribute("list", list);

		return "user/userList"; 
	}
	
	@RequestMapping(value = "/user/userInsert", method = RequestMethod.GET)
	public String userWrite(Model model) {
		System.out.println("=============> userInsert by Get:");
		List<String> enabledList = new ArrayList<>();
		enabledList.add("가능");
		enabledList.add("불가능");
		List<String> authorityList = new ArrayList<>();
		authorityList.add("ROLE_GUEST");
		authorityList.add("ROLE_MEMBER");
		authorityList.add("ROLE_ADMIN");
		
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		map.put("enabledList", enabledList);
		map.put("authorityList", authorityList);
		model.addAttribute("map", map);	
		
		
		return "/user/userWrite"; 
	}

	@RequestMapping(value = "/user/userInsert", method = RequestMethod.POST)
	public String saveUser(Users user) throws Exception {
		System.out.println("=============> userInsert :");
		if(user != null) {
			System.out.println("======> /user/userInsert 변경전 :" + user.getPw());
			String pw = encoder.encode(user.getPw());
			System.out.println("======> /user/userInsert 변경후 :" + pw);
			user.setPw(pw);
			userService.saveUser(user);
		}
		return "redirect:/user/userList"; 
	}
	
	@RequestMapping(value = "/user/userDetail/{id}", method = RequestMethod.GET)
	public String userDetail(@PathVariable("id") String id, Model model) {
		log.debug("======> userDetail id :" + id);
		Users user = userService.userDetail(id);
		log.debug("======> userDetail id222 :" + id);
		model.addAttribute("user", user);

		return "user/userDetail"; 
	}

	@RequestMapping(value = "/user/userUpdate", method = RequestMethod.POST)
	public String userUpdate(Users user) throws Exception {
		System.out.println("=============> userUpdate :" + user);
		userService.saveUser(user);
		return "redirect:/user/userList"; 
	}

	
	
	@RequestMapping(value = "/user/userDelete/{id}", method = RequestMethod.POST)
	public String userDelete(@RequestParam("id") String id) {
		userService.userDelete(id);
		return "redirect:/user/userList"; 
	}

	
}
