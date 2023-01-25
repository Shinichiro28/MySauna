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

import com.example.mysauna.dto.SaunaAddRequest;
import com.example.mysauna.dto.SaunaUpdateRequest;
import com.example.mysauna.entity.Sauna;
import com.example.mysauna.service.SaunaService;

@Controller
public class SaunaController {

  @Autowired
  private SaunaService saunaService;

  // リスト一覧表示
  @GetMapping("/sauna/index")
  public String index(Model model) {
    // SaunaPostの全レコードを取得
    List<Sauna> saunaList = saunaService.findAll();
    // 取得したレコードをモデルにセット
    model.addAttribute("saunalist", saunaList);
    return "sauna/index";
  }

  // グラフ
  @GetMapping("/sauna/graph")
  public String graph(Model model) {
    List<Sauna> saunaList = saunaService.findAll();
    model.addAttribute("saunalist", saunaList);
    return "sauna/graph";
  }

  // 登録画面を表示
  @GetMapping("sauna/new")
  public String displayAdd(Model model) {
    // 登録情報をモデルにセット
    model.addAttribute("saunaAddRequest", new SaunaAddRequest());
    return "sauna/new";
  }

  // 登録する
  @RequestMapping(value = "/sauna/create", method = RequestMethod.POST)
  public String create(@Validated @ModelAttribute SaunaAddRequest saunaAddRequest, BindingResult result,
      Model model) {
    if (result.hasErrors()) {
      // 入力チェックエラー
      List<String> errorList = new ArrayList<String>();
      for (ObjectError error : result.getAllErrors()) {
        errorList.add(error.getDefaultMessage());
      }
      model.addAttribute("validationError", errorList);
      return "sauna/new";
    }

    // リスト登録
    saunaService.save(saunaAddRequest);
    return "redirect:/sauna/index";
  }

  // 編集画面表示
  @GetMapping("/sauna/{id}/edit")
  public String displayEdit(@PathVariable Long id, Model model) {
    Sauna sauna = saunaService.findById(id);
    SaunaUpdateRequest saunaUpdateRequest = new SaunaUpdateRequest();
    saunaUpdateRequest.setId(sauna.getId());
    saunaUpdateRequest.setName(sauna.getName());
    saunaUpdateRequest.setSaunaTemp(sauna.getSaunaTemp());
    saunaUpdateRequest.setSaunaTime(sauna.getSaunaTime());
    saunaUpdateRequest.setSaunaSatisfaction(sauna.getSaunaSatisfaction());
    saunaUpdateRequest.setWaterTemp(sauna.getWaterTemp());
    saunaUpdateRequest.setWaterTime(sauna.getWaterTime());
    saunaUpdateRequest.setWaterSatisfaction(sauna.getWaterSatisfaction());
    model.addAttribute("saunaUpdateRequest", saunaUpdateRequest);
    return "sauna/edit";
  }

  // 編集する
  @RequestMapping(value = "/sauna/update", method = RequestMethod.POST)
  public String update(@Validated @ModelAttribute SaunaUpdateRequest saunaUpdateRequest, BindingResult result,
      Model model) {
    if (result.hasErrors()) {
      List<String> errorList = new ArrayList<String>();
      for (ObjectError error : result.getAllErrors()) {
        errorList.add(error.getDefaultMessage());
      }
      model.addAttribute("validationError", errorList);
      return "sauna/edit";
    }
    saunaService.update(saunaUpdateRequest);
    return "redirect:/sauna/index";
  }

  // 削除する
  @GetMapping("/sauna/{id}/delete")
  public String delete(@PathVariable Long id, Model model) {
    saunaService.delete(id);
    return "redirect:/sauna/index";
  }
}
