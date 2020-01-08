package com.song.book.web.dto;

import com.song.book.domain.posts.Posts;
import lombok.Getter;

/**
 * @author wonseok.song
 * @since 2020-01-07
 */
@Getter
public class PostsResponseDto {
  private Long id;
  private String title;
  private String content;
  private String author;

  public PostsResponseDto(Posts entity) {
    this.id = entity.getId();
    this.title = entity.getTitle();
    this.content = entity.getContent();
    this.author = entity.getAuthor();
  }

}
