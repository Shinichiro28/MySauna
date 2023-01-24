package com.example.mysauna.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
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

  public Sauna findBySaunaTemp(Integer sauna_temp){
    return saunaMapper.findBySaunaTemp(sauna_temp);
  }
  
  public Sauna findBySatisfaction(Double sauna_satisfaction){
    return saunaMapper.findBySaunaSatisfaction(sauna_satisfaction);
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

  public List<Sauna> findBysauna(Map<String, String> sauna_satisfaction, Sort sort){
    return null;
  }
}
