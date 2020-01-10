package com.song.book.config.mustache;

import com.samskivert.mustache.DefaultCollector;
import com.samskivert.mustache.Mustache.VariableFetcher;
import java.util.Map;

/**
 * @author wonseok.song
 * @since 2020-01-10
 */
public class CustomMustacheColletor extends DefaultCollector {

  @Override
  public VariableFetcher createFetcher(Object ctx, String name) {
    VariableFetcher fetcher = super.createFetcher(ctx, name);
    if (fetcher != null ) {
      return fetcher;
    }

    return null;
  }
}
