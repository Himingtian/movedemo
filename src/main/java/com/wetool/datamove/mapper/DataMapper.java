package com.wetool.datamove.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataMapper {

    void insertData(List list);
}
