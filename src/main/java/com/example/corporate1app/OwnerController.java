package com.example.corporate1app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.transaction.annotation.Transactional;

import com.example.corporate1app.repositories.OwnerRepository;

@Controller
public class OwnerController {

  @Autowired
  private OwnerRepository repository;

  @RequestMapping("/")
  public ModelAndView index(ModelAndView mav){
    mav.setViewName("index");
    mav.addObject("title", "CorporateSite_sample");
    mav.addObject("test","確認");
    return mav;
  }

  @RequestMapping("/owner")
  public ModelAndView showOwner(
          @ModelAttribute("formModel") Owner Owner,
          ModelAndView mav){
    mav.setViewName("owner");
    mav.addObject("title", "Owner_register");
    mav.addObject("msg", "Owner_登録＆リスト");
    List<Owner> list = repository.findAll();
    mav.addObject("data",list);
    return mav;
  }

  @RequestMapping(value = "/register", method = RequestMethod.POST)
  @Transactional
  public ModelAndView registerOwner(
          @ModelAttribute("formModel") Owner owner,
          ModelAndView mav){
    repository.saveAndFlush(owner);
    return new ModelAndView("redirect:/owner");
  }

  @RequestMapping(value = "/owner/{id}/delete", method = RequestMethod.POST)
  @Transactional
  public ModelAndView remove(@PathVariable("id") long id, ModelAndView mav){
    repository.deleteById(id);
    return new ModelAndView("redirect:/owner");
  }
}
