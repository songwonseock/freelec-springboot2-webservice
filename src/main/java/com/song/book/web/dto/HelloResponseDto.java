package com.song.book.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author wonseok.song
 * @since 2019-12-30
 */
@Getter
@RequiredArgsConstructor
public class HelloResponseDto {
  private final String name;
  private final int amount;
}
