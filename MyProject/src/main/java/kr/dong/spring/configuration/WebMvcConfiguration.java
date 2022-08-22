package kr.dong.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;

//메모리에 미리 올려놓고 설정할 수 있도록 해야 함
//대부분의 오류는 첫번째 클래스를 만들고 @Configuration을 해주지 않아서 발생
//두번째는 메모리에 올려야 하는데 @Bean을 해주지 않아서

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer{

		//처리할 수 있는 파일크기 등 이런거를 설정할 수 있다.
	//원래는 서버나 이런데에서 설정해야되는데 이번에는 따로 설정하는 파트가 없기때문에
	//웹과 관련된 애들은 여기 WebMvcConfiguration에다가 만들어요
	
		@Bean
		public CommonsMultipartResolver multipartResolver() {
			CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
			commonsMultipartResolver.setDefaultEncoding("UTF-8");
			commonsMultipartResolver.setMaxUploadSizePerFile(5 * 1024 * 1024);//5MB
			return commonsMultipartResolver ;
		}
//파일 업로드를할 준비가 끝났음
	
		
}
