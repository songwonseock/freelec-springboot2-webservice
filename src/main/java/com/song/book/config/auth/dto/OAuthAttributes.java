package com.song.book.config.auth.dto;

import com.song.book.domain.user.Role;
import com.song.book.domain.user.User;
import java.util.Map;
import lombok.Builder;
import lombok.Getter;

/**
 * @author wonseok.song
 * @since 2020-01-09
 */
@Getter
public class OAuthAttributes {

  private Map<String, Object> attributes;
  private String nameAttributeKey;
  private String name;
  private String email;
  private String picture;

  @Builder
  public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey,
      String name, String email, String picture) {
    this.attributes = attributes;
    this.nameAttributeKey = nameAttributeKey;
    this.name = name;
    this.email = email;
    this.picture = picture;
  }

  public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {

    if ("naver".equals(registrationId)) {
      return ofNaver("id", attributes);
    }

    return ofGoogle(userNameAttributeName, attributes);
  }

  private static OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes) {
    Map<String, Object> resposne = (Map<String, Object>) attributes.get("response");

    return OAuthAttributes.builder()
        .name((String) resposne.get("name"))
        .email((String) resposne.get("email"))
        .picture((String) resposne.get("profileImage"))
        .attributes(resposne)
        .nameAttributeKey(userNameAttributeName)
        .build();
  }

  public static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
    return OAuthAttributes.builder()
      .name((String) attributes.get("name"))
      .email((String) attributes.get("email"))
      .picture((String) attributes.get("picture"))
      .attributes(attributes)
      .nameAttributeKey(userNameAttributeName)
      .build();
  }

  public User toEntity() {
    return User.builder()
        .name(name)
        .email(email)
        .picture(picture)
        .role(Role.GUEST)
        .build();
  }

}
