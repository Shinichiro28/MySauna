package com.example.mysauna.entity;

import java.time.DateTimeException;

import lombok.Data;

@Data
public class Sauna {

  // id
  private Long id;

  // ユーザid
  private Integer userId;

  // 施設名
  private String name;

  // サウナ室温度
  public Integer sauna_temp;

  // サウナに入った回数
  private Integer sauna_time;

  // サウナの満足度
  public Integer sauna_satisfaction;

  // 水風呂温度
  public Integer water_temp;

  // 水風呂に入った回数
  private Integer water_time;

  // 水風呂の満足度
  public Integer water_satisfaction;

  private DateTimeException created_at;
}
