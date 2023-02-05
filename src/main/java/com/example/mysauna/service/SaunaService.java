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

//Entityインスタンスを取得し、実際の操作を行うクラス
//Sauna情報の取得や保存、更新、削除
@Service
public class SaunaService {

  @Autowired
  private SaunaMapper saunaMapper;

  // Sauna全てのレコードを取得し、返す
  public List<Sauna> findAll() {
    return saunaMapper.findAll();
  }

  // Saunaのidに該当するレコードを取得し、返す
  public Sauna findById(Long id) {
    return saunaMapper.findById(id);
  }

  // SaunaのsaunaTempに該当するレコードを取得し、返す
  public Sauna findBySaunaTemp(Integer saunaTemp) {
    return saunaMapper.findBySaunaTemp(saunaTemp);
  }

  // Saunaのsauna_satisfactionに該当するレコードを取得し、返す
  public Sauna findBySatisfaction(Double saunaSatisfaction) {
    return saunaMapper.findBySaunaSatisfaction(saunaSatisfaction);
  }

  // SaunaAddRequestに該当するレコードを保存
  public void save(SaunaAddRequest saunaAddRequest) {
    saunaMapper.save(saunaAddRequest);
  }

  // SaunaAddRequestに該当するレコードを更新
  public void update(SaunaUpdateRequest saunaUpdateRequest) {
    saunaMapper.update(saunaUpdateRequest);
  }

  // idに該当するレコードを削除
  public void delete(Long id) {
    saunaMapper.delete(id);
  }

  public List<Sauna> findBysauna(Map<String, String> saunaSatisfaction, Sort sort) {
    return null;
  }
}
