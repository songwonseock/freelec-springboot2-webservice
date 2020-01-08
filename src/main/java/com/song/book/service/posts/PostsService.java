package com.song.book.service.posts;

import com.song.book.domain.posts.Posts;
import com.song.book.domain.posts.PostsRepository;
import com.song.book.web.dto.PostsResponseDto;
import com.song.book.web.dto.PostsSaveRequestDto;
import com.song.book.web.dto.PostsUpdateRequestDto;
import java.beans.Transient;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author wonseok.song
 * @since 2020-01-01
 */

@RequiredArgsConstructor
@Service
public class PostsService {

  private final PostsRepository postsRepository;

  @Transactional
  public Long save(PostsSaveRequestDto requestDto) {
    return postsRepository.save(requestDto.toEntity()).getId();
  }

  @Transactional
  public Long update(Long id, PostsUpdateRequestDto requestDto) {
    Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id =" + id) );
    posts.update(requestDto.getTitle(), requestDto.getContent());
    return id;
  }

  public PostsResponseDto findById(Long id) {
    Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id =" + id) );
    return new PostsResponseDto(entity);
  }

}
