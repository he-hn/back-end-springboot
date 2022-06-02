package com.mycompany.backend.security;

import java.io.IOException;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class JwtAuthenticationFilter extends OncePerRequestFilter { //요청할 때 딱 한번 실행하는 필터. security 안에 넣어준다.
  private RedisTemplate redisTemplate;
  public void setRedisTemplate(RedisTemplate redisTemplate) {
    this.redisTemplate = redisTemplate;
  }
  
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
      log.info("실행");
      
      //요청 헤더로부터 Authorization 헤더 값 얻기
      String authorization = request.getHeader("Authorization");
      
      //AccessToken 추출
      String accessToken = Jwt.getAccessToken(authorization);
      
      //검증 작업
      if(accessToken != null && Jwt.validateToken(accessToken)) { //true 가 나와야지 인증 작업을 할 수 있다. 인증토큰이 유효하다 -> 인증이 된 상태이다.
        //Redis에 존재 여부 확인 -> 로그아웃 됐음에도 불구하고 accessToken이 날아오는 문제 발생. 로그아웃하면 redis에서도 사라지니깐 검증 작업을 거친다
        ValueOperations<String, String> vo = redisTemplate.opsForValue();
        String redisRefreshToken = vo.get(accessToken);
        
        if(redisRefreshToken != null) {
          //인증 처리
          Map<String, String> userInfo = Jwt.getUserInfo(accessToken); //accessToken을 만들 때, mid 와 authority(권한 (ROLE_XXX))정보를 추가 했다. getUserInfo 메소드를 이용해서 mid 와 authority를 map 에 저장 
          String mid = userInfo.get("mid");
          String authority = userInfo.get("authority");
          UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(mid, null, AuthorityUtils.createAuthorityList(authority));
          SecurityContext securityContext = SecurityContextHolder.getContext();
          securityContext.setAuthentication(authentication);
        }
      }
      
      //다음 필터 실행
      filterChain.doFilter(request, response);
  }
}