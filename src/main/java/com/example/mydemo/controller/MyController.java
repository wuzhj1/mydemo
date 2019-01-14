package com.example.mydemo.controller;

import com.example.mydemo.domain.CardVO;
import com.example.mydemo.mapper.CardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class MyController {

    @Autowired
    private CardMapper cardMapper;

    @RequestMapping("/sucess")
    public String hello(Map<String,Object> map){
        List<CardVO> cards=cardMapper.findAllCardByP(1,5);
        map.put("cards",cards);
        return "sucess";
    }
}
