package com.test.controller;

import com.test.entity.Wedding;
import com.test.mapper.WeddingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
//import org.springframework.web.bind.annotation.RestController;

@Controller
public class WeddingController {

    @Autowired
    private WeddingMapper weddingMapper;

    @RequestMapping("/weddingList")
    public ModelAndView weddingList(){
        List<Wedding> weddingList = weddingMapper.getAll();
        ModelAndView modelAndView = new ModelAndView("/weddingList");
        modelAndView.addObject("weddingList", weddingList);
        return modelAndView;
    }

    @RequestMapping("/delete/{weddingId}")
    public String delete(@PathVariable("weddingId") int weddingId){
        weddingMapper.delete(weddingId);
        return "redirect:/weddingList";
    }

    @RequestMapping("/weddingDetails/{weddingId}")
    public ModelAndView weddingDetails(@PathVariable("weddingId") int weddingId){
        Wedding wedding = weddingMapper.getOne(weddingId);
        ModelAndView modelAndView = new ModelAndView("/weddingDetails");
        modelAndView.addObject("wedding", wedding);
        return modelAndView;
    }

    @RequestMapping(value = "/addWedding",method = RequestMethod.GET)
    public String addWedding(Model model, HttpServletRequest request) {
        Wedding wedding = new Wedding();
        model.addAttribute("wedding", wedding);
        return "/addWedding";
    }

    @RequestMapping(value="/addWedding", method=RequestMethod.POST)
    public String addWedding(Model model, Wedding wedding, HttpServletRequest request) {
        weddingMapper.insert(wedding);
        return "redirect:/weddingList";
    }

    @RequestMapping(value="/updateWedding/{weddingId}", method=RequestMethod.GET)
    public String updateWedding(Model model, @PathVariable("weddingId") int weddingId, HttpServletRequest request) {
        Wedding wedding = weddingMapper.getOne(weddingId);
        model.addAttribute("wedding", wedding);
        return "/updateWedding";
    }

    @RequestMapping(value="/updateWedding/{weddingId}", method=RequestMethod.POST)
    public String updateWedding(Model model, @PathVariable("weddingId") int weddingId, Wedding wedding, HttpServletRequest request) {
            Wedding wed = weddingMapper.getOne(weddingId);
            wed.setWeddingName(wedding.getWeddingName());
            wed.setWeddingStyle(wedding.getWeddingStyle());
            wed.setWeddingPrice(wedding.getWeddingPrice());
            wed.setWeddingIntro(wedding.getWeddingIntro());
            wed.setWeddingHotel(wedding.getWeddingHotel());
            wed.setWeddingPic(wedding.getWeddingPic());
            weddingMapper.update(wed);
        return "redirect:/weddingList";
    }
}

