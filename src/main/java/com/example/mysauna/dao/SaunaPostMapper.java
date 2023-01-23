package com.example.mysauna.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.mysauna.dto.SaunaPostAddRequest;
import com.example.mysauna.dto.SaunaPostUpdateRequest;
import com.example.mysauna.entity.SaunaPost;

@Mapper
public interface SaunaPostMapper {
  List<SaunaPost> findAll();

  SaunaPost findById(Long id);

  void save(SaunaPostAddRequest saunaPostAddRequest);

  void update(SaunaPostUpdateRequest saunaPostUpdateRequest);

  void delete(Long id);
}
