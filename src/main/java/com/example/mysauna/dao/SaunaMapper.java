package com.example.mysauna.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.mysauna.dto.SaunaAddRequest;
import com.example.mysauna.dto.SaunaUpdateRequest;
import com.example.mysauna.entity.Sauna;

@Mapper
public interface SaunaMapper {
  List<Sauna> findAll();

  Sauna findById(Long id);

  Sauna findBySaunaTemp(Integer sauna_temp);

  Sauna findBySaunaSatisfaction(Double sauna_satisfaction);

  void save(SaunaAddRequest saunaAddRequest);

  void update(SaunaUpdateRequest saunaUpdateRequest);

  void delete(Long id);
}
