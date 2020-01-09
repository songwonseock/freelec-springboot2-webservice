package com.song.book.web.dto;

import com.song.book.domain.posts.Posts;
import java.time.LocalDateTime;
import lombok.Getter;

/**
 * @author wonseok.song
 * @since 2020-01-09
 */
@Getter
public class PostsListResponseDto {
  private Long id;
  private String title;
  private String author;
  private LocalDateTime modifiedDate;

  public PostsListResponseDto(Posts entity) {
    this.id = entity.getId();
    this.title = entity.getTitle();
    this.author = entity.getAuthor();
    this.modifiedDate = entity.getModifiedDate();
  }

}
