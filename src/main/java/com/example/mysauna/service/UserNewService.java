package com.example.mysauna.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.mysauna.dao.UserRepository;
import com.example.mysauna.entity.User;

@Service
public class UserNewService {
  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private UserRepository userRepository;

  public void userNew(String username, String password) {
    // パスワードハッシュ化
    String hashedPassword = passwordEncoder.encode(password);
    userRepository.saveAndFlush(new User(username, hashedPassword, "GENERAL"));
  }
}
