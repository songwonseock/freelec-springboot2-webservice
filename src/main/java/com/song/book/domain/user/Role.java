package com.song.book.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author wonseok.song
 * @since 2020-01-09
 */
@Getter
@RequiredArgsConstructor
public enum Role {

  GUEST("ROLE_GUEST", "손님"),
  USER("ROLE_USER", "일반 사용자");

  private final String key;
  private final String title;

}
