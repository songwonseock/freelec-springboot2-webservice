package com.song.book.config.auth.dto;

import com.song.book.domain.user.User;
import java.io.Serializable;
import lombok.Getter;

/**
 * @author wonseok.song
 * @since 2020-01-09
 */
@Getter
public class SessionUser implements Serializable {

  private String name;
  private String email;
  private String picture;

  public SessionUser(User user) {
    this.name = user.getName();
    this.email = user.getEmail();
    this.picture = user.getPicture();
  }

}
