package com.example.mysauna.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)

public class SaunaUpdateRequest implements Serializable {
  @NotNull
  private Long id;

  @NotEmpty(message = "施設名を入れてください")
  private String name;

  @NotNull(message = "サウナ室の温度を入力して下さい")
  private Integer saunaTemp;

  private Integer saunaTime;

  @NotNull(message = "サウナの満足度を入力して下さい")
  private Integer saunaSatisfaction;

  @NotNull(message = "水風呂の温度を入力して下さい")
  private Integer waterTemp;

  private Integer waterTime;

  @NotNull(message = "水風呂の満足度を入力して下さい")
  private Integer waterSatisfaction;
}
