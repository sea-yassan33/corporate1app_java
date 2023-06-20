package com.example.corporate1app;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OwnerController {

  @RequestMapping("/")
  public ModelAndView index(ModelAndView mav){
    mav.setViewName("index");
    mav.addObject("title", "CorporateSite_sample");
    mav.addObject("test","確認");
    return mav;
  }
}
