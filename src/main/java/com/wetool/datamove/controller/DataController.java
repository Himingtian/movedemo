package com.wetool.datamove.controller;

import com.wetool.datamove.po.Data;
import com.wetool.datamove.service.DataService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DataController {

    @Resource(name = "dataServiceImpl")
    private DataService dataService;

    @RequestMapping("/login")
    public String  login(){

        System.out.println("dd");
        List<Data> list = new ArrayList<>();

        for (int i = 10;i<10000;i++){
            Data data = new Data();
            data.setId(i+"");
            data.setUsername(i+"");
            data.setPassword(i+"");

            list.add(data);
        }


        dataService.insertData(list);


        return "login";

    }
}
