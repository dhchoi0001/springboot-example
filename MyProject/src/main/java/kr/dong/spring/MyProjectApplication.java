package kr.dong.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;

//설정과 관련된 것들이 기타등등 정보가 있으면 여기에 기술
//첨부파일과 관련된 자동구성은 원래 기본으로 사용하도록 되어 있지만
// 그것을 사용하지 않고 즉 배제하고, 우리가 따로 만든 것을 사용하도록 설정
// (exclude = {MultipartAutoConfiguration.class})

//원래: @SpringBootApplication
@SpringBootApplication(exclude = {MultipartAutoConfiguration.class})
public class MyProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyProjectApplication.class, args);
	}

}
