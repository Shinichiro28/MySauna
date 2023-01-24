package com.example.mysauna.dto;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserNewForm {
  @NotBlank
  @Size(min = 4, max = 20)
  private String username;

  @NotBlank
  @Size
  private String password;

  @NotBlank
  @Size(min = 8, max = 20)
  private String confirmPassword;

  @AssertTrue
  public boolean isPasswordValid() {
    if (password == null || confirmPassword == null) {
      return false;
    }
    return password.equals(confirmPassword);
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getConfirmPassword() {
    return confirmPassword;
  }

  public void setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
  }
}