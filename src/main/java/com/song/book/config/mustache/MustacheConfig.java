package com.song.book.config.mustache;

import com.samskivert.mustache.Mustache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author wonseok.song
 * @since 2020-01-10
 */
@Configuration
public class MustacheConfig {
  @Bean
  public Mustache.Compiler mustacheCompiler(Mustache.TemplateLoader templateLoader, Environment environment) {
    return Mustache.compiler().defaultValue("Not Mapping!!").withLoader(templateLoader).withCollector(new CustomMustacheColletor());
  }
}
