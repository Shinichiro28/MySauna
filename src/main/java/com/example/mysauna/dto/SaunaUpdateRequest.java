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

  private Long user_id;

  @NotEmpty(message = "施設名を入れてください")
  private String name;

  @NotNull(message = "サウナ室の温度を入力して下さい")
  private Integer sauna_temp;

  private Integer sauna_time;

  @NotNull(message = "サウナの満足度を入力して下さい")
  private Integer sauna_satisfaction;

  @NotNull(message = "水風呂の温度を入力して下さい")
  private Integer water_temp;

  private Integer water_time;

  @NotNull(message = "水風呂の満足度を入力して下さい")
  private Integer water_satisfaction;
}
