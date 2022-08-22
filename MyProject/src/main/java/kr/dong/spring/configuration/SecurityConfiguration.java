package kr.dong.spring.configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
 
@Configuration
public class SecurityConfiguration {
 
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new ShopmeUserDetailsService();
//    }
// 
//    암호화하지 않은 비밀번호인 경우에 이 함수를 넣으면 에러가 발생
	  //[ WARN] [org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder] Encoded password does not look like BCrypt
	  // [DEBUG] [org.springframework.security.authentication.dao.DaoAuthenticationProvider] Failed to authenticate since password does not match stored value
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
 
//  이렇게 함수를 만드니 비밀번호를 암호화 하지 않고 {noop}비밀번호 상태로 되니 에러가 나지 않음
	@Bean
  public PasswordEncoder passwordEncoder() {
      return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }
	/**
	 *패스워드에 암호화 처리
	 */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {

    	
    	
     	security.authorizeRequests().antMatchers("/").permitAll();
     	security.authorizeRequests().antMatchers("/user/**").hasAnyRole("ADMIN", "MEMBER");
     	security.authorizeRequests().antMatchers("/board/**").hasRole("ADMIN");
    	//security.formLogin();
    	
    	security.formLogin().loginPage("/login/login").defaultSuccessUrl("/", true);
    	 //security.formLogin().loginProcessingUrl("/login/login"); //post
    	//로그인 실패시
    	security.exceptionHandling().accessDeniedPage("/login/accessDenied") ;
    	//로그아웃이 세션 날림
    	security.logout().logoutUrl("/login/logout").invalidateHttpSession(true).logoutSuccessUrl("/");
//
    	security.csrf().disable(); //이거 굉장히 중요한 포인트. 이 문장 안넣었다가 몇시간 동안 에러 잡는데 고생했슴
    	
//        http.authorizeRequests()
//            .antMatchers("/","/user/**", "/image/**", "/subscribe/**", "/comment/**").authenticated() //이런 주소로 시작하게 되면 인증이 필요 -> 403 코드가 나옴 
//                .anyRequest().permitAll()
//                .and()
//                .formLogin()
//                .loginPage("/auth/signin") //get
//                .loginProcessingUrl("/auth/signin") //post
//                .defaultSuccessUrl("/"); // 그게 아니면 허용하겠다.
   	
    	
    	
    	
//        http.authorizeRequests().antMatchers("/").permitAll()
//                .antMatchers("/user/**").hasAuthority("MEMBER")
//                .hasAnyAuthority("Admin", "Editor", "Salesperson")
//                .hasAnyAuthority("Admin", "Editor", "Salesperson", "Shipper")
//                .anyRequest().authenticated()
//                .and().formLogin()
//                .loginPage("/login")
//                    .usernameParameter("email")
//                    .permitAll()
//                .and()
//                .rememberMe().key("AbcdEfghIjklmNopQrsTuvXyz_0123456789")
//                .and()
//                .logout().permitAll();
 
//    	security.headers().frameOptions().sameOrigin();
//    	security.csrf().disable();
    	
//    	http
//        .cors().disable()      // cors 비활성화
//        .csrf().disable()      // csrf 비활성화
//        .formLogin().disable() //기본 로그인 페이지 없애기
//        .headers().frameOptions().disable();    	
 
        return security.build();
    }
 
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/css/**", "/webjars/**");
//    }
 
}