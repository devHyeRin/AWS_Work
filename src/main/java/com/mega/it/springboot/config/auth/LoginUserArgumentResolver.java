package com.mega.it.springboot.config.auth;

import com.mega.it.springboot.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Component
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {
    private final HttpSession httpSession;

    @Override //컨트롤러 메소드
    public boolean supportsParameter(MethodParameter parameter){
        boolean isLoginUserAnnotation = parameter.getParameterAnnotation(LoginUser.class) != null;    //아니면 null을 주고 맞으면 loginuser를 줌
        boolean isUserClass = SessionUser.class.equals(parameter.getParameterType());
        return isLoginUserAnnotation && isUserClass;   // sessionuser가 넘어온게 아니면 에러 발생
    }

    @Override  //파라미터 전달 메소드
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception{
        return httpSession.getAttribute("user");  // 현재 로그인 된 이름 -> 로그인 하는 기능 -> 컨트롤러에 있는 부분을 여기로 빼서 여기서 동작하게됨
    }

}
