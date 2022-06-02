package com.mycompany.backend.security;

import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUserDetails extends User {
  //인증 정보로 추가로 저장하고 싶은 내용 정의
	private String mname;
	private String memail;
	
	public CustomUserDetails(
			String mid, 
			String mpassword, 
			boolean menabled, 
			List<GrantedAuthority> mauthorities,
			String mname,
			String memail) {
		super(mid, mpassword, menabled, true, true, true, mauthorities);
		this.mname = mname;
		this.memail = memail;
	}
	
	public String getMname() {
		return mname;
	}

	public String getMemail() {
		return memail;
	}
}

/*
spring security 에서 로그인한 뒤, 인증을 한 사용자가 있으면 이 객체를 얻을 수 있다. 이 객체 안에는 기본적으로 mid, mpassword, menabled(활성화), mauthorities(권한)만 알 수 있다.
이 정보 이외에 사용자의 이름, 이메일 등의 정보를 얻고 싶다면 database에서 요청해서 받는 방법이 아니라 인증을 이미 했으므로 인증된 정보 속에서 가져오려고 한다.
기본 정보를 가지고 있는 User를 상속 받아서 추가적으로 더 저장하고 싶은 것을 filed로 저장 한다. User는 User detail 객체를 가지고 있다.
생성자를 만들 때, 외부로부터 필수적으로 받아야 하는 4가지(mid, password, enabled. mauthorities)는 User가 요구 하고 있기 때문에 User 생성자로 넘긴다.
추가적으로 받고 싶은 정보는 필드에 저장을 해야 한다.

추가적으로 받은 정보는 getter를 만들어서 외부에서 읽을 있도록 만든다.
*/
