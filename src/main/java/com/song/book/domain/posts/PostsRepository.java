package com.song.book.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wonseok.song
 * @since 2019-12-30
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
