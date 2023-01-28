package com.example.mysauna.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.mysauna.UserDetailsImpl;
import com.example.mysauna.dao.UserRepository;
import com.example.mysauna.entity.User;

//ユーザー情報を取得する
//UserDetailsService：ユーザー情報を取得する為のインターフェース
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  // loadUserByUsername(String username)：ユーザー名をキーにユーザー情報を取得
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException("Not Found");
    }
    return new UserDetailsImpl(user);
  }
}
