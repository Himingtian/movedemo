package com.wetool.datamove.service.impl;

import com.wetool.datamove.mapper.DataMapper;
import com.wetool.datamove.service.DataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DataServiceImpl implements DataService {

    @Resource(name = "dataMapper")
    private DataMapper dataMapper;


    @Override
    public void insertData(List list) {
        dataMapper.insertData(list);
    }
}
