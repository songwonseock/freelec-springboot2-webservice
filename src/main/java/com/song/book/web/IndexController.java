package com.song.book.web;

import com.song.book.config.auth.LoginUser;
import com.song.book.config.auth.dto.SessionUser;
import com.song.book.domain.user.User;
import com.song.book.service.posts.PostsService;
import com.song.book.web.dto.PostsResponseDto;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wonseok.song
 * @since 2020-01-08
 */
@RequiredArgsConstructor
@Controller
public class IndexController {

  private final PostsService postsService;
  private final HttpSession httpSession;

  @GetMapping("/")
  public String index(Model model, @LoginUser SessionUser user) {

    model.addAttribute("posts", postsService.findAllDesc());

    if (user != null) {
      model.addAttribute("userName", user.getName());
    }

    return "index";
  }

  @GetMapping("/posts/save")
  public String postsSave() {

//    if (user != null) {
//      model.addAttribute("userName", user.getName());
//    }

    return "posts-save";
  }

  @GetMapping("/posts/update/{id}")
  public String postsUpdate(@PathVariable Long id, Model model) {

    PostsResponseDto dto = postsService.findById(id);
    model.addAttribute("post", dto);

//    if (user != null) {
//      model.addAttribute("userName", user.getName());
//    }

    return "posts-update";

  }

}
