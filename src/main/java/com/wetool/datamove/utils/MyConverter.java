package com.wetool.datamove.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyConverter implements Converter<String,Date> {

    @Override
    public Date convert(String source) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try
        {
            Date date = format.parse(source);
            return date;
        } catch (ParseException e)
        {
            e.printStackTrace();
        }

        return null;
    }
}
