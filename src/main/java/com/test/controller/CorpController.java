package com.test.controller;

import com.test.entity.Corp;
import com.test.mapper.CorpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CorpController {

    @Autowired
    private CorpMapper corpMapper;

    @RequestMapping(value = "/updateCorp", method = RequestMethod.GET)
    public String updateCorp(Model model, HttpServletRequest request){
        Corp corp = corpMapper.get();
        model.addAttribute("corp",corp);
        return "/updateCorp";
    }

    @RequestMapping(value = "/updateCorp", method = RequestMethod.POST)
    public String updateCorp(Model model, Corp corp, HttpServletRequest request){
        Corp corp1 = corpMapper.get();
        corp1.setCorpName(corp.getCorpName());
        corp1.setCorpAddress(corp.getCorpAddress());
        corp1.setCorpContact(corp.getCorpContact());
        corp1.setCorpEmail(corp.getCorpEmail());
        corp1.setCorpIntro(corp.getCorpIntro());
        corpMapper.update(corp1);
        return "/updateCorp";
    }

}
