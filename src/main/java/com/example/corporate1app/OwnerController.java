package com.example.corporate1app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.corporate1app.repositories.OwnerRepository;

@Controller
public class OwnerController {

  @Autowired
  OwnerRepository repository;

  @RequestMapping("/")
  public ModelAndView index(ModelAndView mav){
    mav.setViewName("index");
    mav.addObject("title", "CorporateSite_sample");
    mav.addObject("test","確認");
    return mav;
  }

  @RequestMapping("/owner")
  public ModelAndView owner(ModelAndView mav){
    mav.setViewName("owner");
    mav.addObject("title", "Owner_register");
    mav.addObject("msg", "Owner_登録＆リスト");
    Iterable<Owner> list = repository.findAll();
    mav.addObject("data",list);
    return mav;
  }
}
