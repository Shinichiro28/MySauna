package com.example.mysauna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mysauna.dao.SaunaPostMapper;
import com.example.mysauna.dto.SaunaPostAddRequest;
import com.example.mysauna.dto.SaunaPostUpdateRequest;
import com.example.mysauna.entity.SaunaPost;

@Service
public class SaunaPostService {

  @Autowired
  private SaunaPostMapper saunaPostMapper;

  public List<SaunaPost> findAll() {
    return saunaPostMapper.findAll();
  }

  public SaunaPost findById(Long id) {
    return saunaPostMapper.findById(id);
  }

  public void save(SaunaPostAddRequest saunaPostAddRequest) {
    saunaPostMapper.save(saunaPostAddRequest);
  }

  public void update(SaunaPostUpdateRequest saunaPostUpdateRequest) {
    saunaPostMapper.update(saunaPostUpdateRequest);
  }
}
