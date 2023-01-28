package com.example.mysauna;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.mysauna.entity.User;

//ユーザーとパスワードを入力しユーザーが存在した場合にチェックを行う
public class UserDetailsImpl implements UserDetails {
  private User user;

  public UserDetailsImpl(User user) {
    this.user = user;
  }

  // 権限情報を返却
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return AuthorityUtils.createAuthorityList("ROLE_" + this.user.getRolename());
  }

  // パスワードを返却
  @Override
  public String getPassword() {
    return user.getPassword();
  }

  // ユーザー名を返却
  @Override
  public String getUsername() {
    return user.getUsername();
  }

  // アカウントが有効期限ないかどうかを返却
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  // アカウントがロックかアンロックかどうかを返却
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  // 資格情報の有効期限内かどうかを返却
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  // アカウントが有効なユーザーかを返却
  @Override
  public boolean isEnabled() {
    return true;
  }
}
