package com.mega.it.springboot.web;

import com.mega.it.springboot.config.auth.LoginUser;
import com.mega.it.springboot.config.auth.dto.SessionUser;
import com.mega.it.springboot.service.posts.PostsService;
import com.mega.it.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class indexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping(value = "/")
    public String index(Model model, @LoginUser SessionUser user){
        model.addAttribute("posts", postsService.findAllDesc());
//        SessionUser user = (SessionUser) httpSession.getAttribute("user");    // 위에 sessionuser 어노테이션 처리했기 때문에 주석처리
        if(user != null){
            model.addAttribute("userName1", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }
}
