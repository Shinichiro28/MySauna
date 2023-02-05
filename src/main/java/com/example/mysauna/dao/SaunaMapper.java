package com.example.mysauna.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.mysauna.dto.SaunaAddRequest;
import com.example.mysauna.dto.SaunaUpdateRequest;
import com.example.mysauna.entity.Sauna;

//Mapper：MyBatisがクラス内の情報を自動的にスキャンして登録
@Mapper
public interface SaunaMapper {
  List<Sauna> findAll();

  Sauna findById(Long id);

  Sauna findBySaunaTemp(Integer saunaTemp);

  Sauna findBySaunaSatisfaction(Double saunaSatisfaction);

  void save(SaunaAddRequest saunaAddRequest);

  void update(SaunaUpdateRequest saunaUpdateRequest);

  void delete(Long id);
}
