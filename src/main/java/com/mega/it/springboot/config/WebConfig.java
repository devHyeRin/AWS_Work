package com.mega.it.springboot.config;

import com.mega.it.springboot.config.auth.LoginUserArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final LoginUserArgumentResolver loginUserArgumentResolver;
    //여기를 꼭 입력해야함!
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers){   // argument 추가
        argumentResolvers.add(loginUserArgumentResolver);
    }
}
