package com.example.mysauna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mysauna.dao.SaunaMapper;
import com.example.mysauna.dto.SaunaAddRequest;
import com.example.mysauna.dto.SaunaUpdateRequest;
import com.example.mysauna.entity.Sauna;

@Service
public class SaunaService {

  @Autowired
  private SaunaMapper saunaMapper;

  public List<Sauna> findAll() {
    return saunaMapper.findAll();
  }

  public Sauna findById(Long id) {
    return saunaMapper.findById(id);
  }

  public void save(SaunaAddRequest saunaAddRequest) {
    saunaMapper.save(saunaAddRequest);
  }

  public void update(SaunaUpdateRequest saunaUpdateRequest) {
    saunaMapper.update(saunaUpdateRequest);
  }

  public void delete(Long id) {
    saunaMapper.delete(id);
  }
}
