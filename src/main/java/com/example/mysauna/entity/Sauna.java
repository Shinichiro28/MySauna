package com.example.mysauna.entity;

import java.time.DateTimeException;

import lombok.Data;

@Data
public class Sauna {

  // id
  private Long id;

  // user_id
  private Long userId;

  // 施設名
  private String name;

  // サウナ室温度
  public Integer saunaTemp;

  // サウナに入った回数
  private Integer saunaTime;

  // サウナの満足度
  public Integer saunaSatisfaction;

  // 水風呂温度
  public Integer waterTemp;

  // 水風呂に入った回数
  private Integer waterTime;

  // 水風呂の満足度
  public Integer waterSatisfaction;

  private DateTimeException createdAt;
}
