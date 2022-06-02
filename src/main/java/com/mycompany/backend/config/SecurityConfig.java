package com.mycompany.backend.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.mycompany.backend.security.JwtAuthenticationFilter;

import lombok.extern.log4j.Log4j2;

@Log4j2
@EnableWebSecurity //@EnableWebSecurity를 추가하면 자동으로 security config가 실행된다. web security 활성화.
public class SecurityConfig extends WebSecurityConfigurerAdapter{
  @Resource
  private RedisTemplate redisTemplate;
  
  @Override
  protected void configure(HttpSecurity http) throws Exception { //HttpSecurity를 매개변수로 갖는 메소드는 security 필터와 관련된 설정을 한다. 필터체인. 
    log.info("실행");
    //서버 세션 비활성화
    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); //jsessionid가 생성되지 않는다
    //폼 로그인 비활성화
    http.formLogin().disable();
    //사이트간 요청 위조 방지 비활성화
    http.csrf().disable();
    //요청 경로 권한 설정
    http.authorizeRequests()
      .antMatchers("/board/**").authenticated() //board 아래로는 인증한 사람만 접근할 수 있다. 로그인 한 사람만 접근 가능
      .antMatchers("/**").permitAll(); //board를 제외한 모든 경로는 인증하지 않아도 접근할 수 있다. 로그인 하지 않아도 접근 가능
    //CORS 설정(다른 도메인의 JavaScript로 접근을 할 수 있도록 허용) -> 반드시 제공해야 한다. front가 다른 도메인, REST API가 다른 도메인이라면 무조건 CORS설정을 해야 한다. 다른 도메인에서 js 접근을 가능하도록 해줘야 한다.
    http.cors(); //구체적인 cors 설정이 필요. 
    //JWT 인증 필터 추가. 외부에서 하나 끼어넣는다.
    http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class); //두번째 파라미터는 폼 인증 비활성화로 인해서 사용되지 않는다. 사용하기를 바란다면 폼 인증을 활성화 시켜야 한다. 두번째 파라미터가 사용되지 않기 때문에 첫번째 파라미터에 Jwt 인증을 사용을 파라미터로 넣는다.
  }
  
  // @Bean //관리 객체로 만드는 이유는 다른 곳에서도 사용을 하기 위해서이다. 하지만 다른 곳에서 사용을 하지 않을 경우 굳이 관리 객체로 만들지 않아도 된다
  public JwtAuthenticationFilter jwtAuthenticationFilter() {
    JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter();
    jwtAuthenticationFilter.setRedisTemplate(redisTemplate);
    return jwtAuthenticationFilter;
  }
  
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception { //데이터베이스에서 무엇을 가져올 것인지 결정하고, passwordEncoder 결정을 하는 메소드
    log.info("실행"); //DB에 있는 것과 비교 작업을 해야 한다
    
    //MPA폼 인증 방식에서 사용(JWT 인증 방식에서는 사용하지 않음)
    /*DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setUserDetailsService(new CustomUserDetailsService());
    provider.setPasswordEncoder(passwordEncoder());
    auth.authenticationProvider(provider);*/
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    log.info("실행");
    log.info("configure(WebSecurity web) 실행");
    DefaultWebSecurityExpressionHandler defaultWebSecurityExpressionHandler = new DefaultWebSecurityExpressionHandler();
    defaultWebSecurityExpressionHandler.setRoleHierarchy(roleHierarchyImpl());   
    web.expressionHandler(defaultWebSecurityExpressionHandler);
    
    //MPA에서 시큐리티를 적용하지 않는 경로 설정 
    /*web.ignoring()
    .antMatchers("/images/**")
    .antMatchers("/css/**")
    .antMatchers("/js/**")
    .antMatchers("/bootstrap/**")
    .antMatchers("/jquery/**")
    .antMatchers("/favicon.ico");*/
  }
  
  @Bean //관리 객체로 만드는 이유는 다른 곳에서 또 쓰일 수 있기 때문. Bean은 메소드 이름으로 관리 객체로 만든다. Bean은 Configuration annotation이 붙어 있는 경우에만 쓸 수 있는데, @EnableWebSecurity 의 open declaration 을 확인하면 @Configuration이 붙어 있는 것을 확인할 수 있다 
  public PasswordEncoder passwordEncoder() {
    return PasswordEncoderFactories.createDelegatingPasswordEncoder(); //암호화 알고리즘이 다 다르기 때문에 암호화 알고리즘을 같이 표시하면서 데이터베이스에 저장한다
    //return new BCryptPasswordEncoder(); //암호화 알고리즘의 변경이 필요 없다면 이 방법을 쓴다. 
  }
  
  @Bean
  public RoleHierarchyImpl roleHierarchyImpl() {
     log.info("실행");
     RoleHierarchyImpl roleHierarchyImpl = new RoleHierarchyImpl();
     roleHierarchyImpl.setHierarchy("ROLE_ADMIN > ROLE_MANAGER > ROLE_USER");
     return roleHierarchyImpl;
  }
  
  //REST API에서만 사용
  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    log.info("실행");
    CorsConfiguration configuration = new CorsConfiguration();
    //모든 요청 사이트 허용
    configuration.addAllowedOrigin("*"); //*는 프론트엔드를 어디에서 다운 받든지 back이 js의 연결을 허용하게 한다.
    //모든 요청 방식 허용
    configuration.addAllowedMethod("*");
    //모든 요청 헤더 허용
    configuration.addAllowedHeader("*");
    //모든 URL 요청에 대해서 위 내용을 적용
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration); //모든 요청경로에 대해서 허용
    return source;
  }
}
