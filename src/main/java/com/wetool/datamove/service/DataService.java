package com.wetool.datamove.service;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataService {


    void insertData(List list);


}
