package com.example.mysauna.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)

public class SaunaPostUpdateRequest extends SaunaPostAddRequest implements Serializable {
  @NotNull
  private Long id;
}
