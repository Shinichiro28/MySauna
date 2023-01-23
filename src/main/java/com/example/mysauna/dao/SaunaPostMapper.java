package com.example.mysauna.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.mysauna.dto.SaunaPostAddRequest;
import com.example.mysauna.entity.SaunaPost;

@Mapper
public interface SaunaPostMapper {
  List<SaunaPost> findAll();

  void save(SaunaPostAddRequest saunaPostAddRequest);
}
