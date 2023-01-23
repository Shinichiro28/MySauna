package com.example.mysauna.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.mysauna.dto.SaunaPostAddRequest;
import com.example.mysauna.dto.SaunaPostUpdateRequest;
import com.example.mysauna.entity.SaunaPost;
import com.example.mysauna.service.SaunaPostService;

@Controller
public class SaunaPostController {

  @Autowired
  private SaunaPostService saunaPostService;

  // リスト一覧表示
  @GetMapping(value = "/saunaPost/index")
  public String index(Model model) {
    List<SaunaPost> saunaPostList = saunaPostService.findAll();
    model.addAttribute("saunapostlist", saunaPostList);
    return "saunaPost/index";
  }

  // 登録画面を表示
  @GetMapping(value = "saunaPost/new")
  public String displayAdd(Model model) {
    model.addAttribute("saunaPostAddRequest", new SaunaPostAddRequest());
    return "saunaPost/new";
  }

  // 登録する
  @RequestMapping(value = "/saunaPost/create", method = RequestMethod.POST)
  public String create(@Validated @ModelAttribute SaunaPostAddRequest saunaPostAddRequest, BindingResult result,
      Model model) {
    if (result.hasErrors()) {
      // 入力チェックエラー
      List<String> errorList = new ArrayList<String>();
      for (ObjectError error : result.getAllErrors()) {
        errorList.add(error.getDefaultMessage());
      }
      model.addAttribute("validationError", errorList);
      return "saunaPost/new";
    }

    // リスト登録
    saunaPostService.save(saunaPostAddRequest);
    return "redirect:/saunaPost/index";
  }

  // 編集画面表示
  @GetMapping("/saunaPost/{id}/edit")
  public String displayEdit(@PathVariable Long id, Model model) {
    SaunaPost saunaPost = saunaPostService.findById(id);
    SaunaPostUpdateRequest saunaPostUpdateRequest = new SaunaPostUpdateRequest();
    saunaPostUpdateRequest.setId(saunaPost.getId());
    saunaPostUpdateRequest.setName(saunaPost.getName());
    saunaPostUpdateRequest.setSauna_temp(saunaPost.getSauna_temp());
    saunaPostUpdateRequest.setSauna_time(saunaPost.getSauna_time());
    saunaPostUpdateRequest.setSauna_satisfaction(saunaPost.getSauna_satisfaction());
    saunaPostUpdateRequest.setWater_temp(saunaPost.getWater_temp());
    saunaPostUpdateRequest.setWater_time(saunaPost.getWater_time());
    saunaPostUpdateRequest.setWater_satisfaction(saunaPost.getWater_satisfaction());
    model.addAttribute("saunaPostUpdateRequest", saunaPostUpdateRequest);
    return "saunaPost/edit";
  }

  // 編集する
  @RequestMapping(value = "/saunaPost/update", method = RequestMethod.POST)
  public String update(@Validated @ModelAttribute SaunaPostUpdateRequest saunaPostUpdateRequest, BindingResult result,
      Model model) {
    if (result.hasErrors()) {
      List<String> errorList = new ArrayList<String>();
      for (ObjectError error : result.getAllErrors()) {
        errorList.add(error.getDefaultMessage());
      }
      model.addAttribute("validationError", errorList);
      return "saunaPost/edit";
    }
    saunaPostService.update(saunaPostUpdateRequest);
    return "redirect:/saunaPost/index";
  }
}
