package com.simple.demo.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        if (source == null) {
            throw new NullPointerException("数据为空");
        }
        DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return date.parse(source);
        } catch (ParseException e) {
            throw new NullPointerException("数据为空");
        }
    }
}
