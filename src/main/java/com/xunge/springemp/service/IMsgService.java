package com.xunge.springemp.service;

import com.xunge.springemp.pojo.Msg;

/**
 * Created by xunge on 2017/7/13.
 */
public interface IMsgService {
    public int add(Msg msg) throws Exception;

    public boolean remove(Integer id) throws Exception;

    public Msg get(Integer id) throws Exception;
}
