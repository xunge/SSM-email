package com.xunge.springemp.dao;

import com.xunge.springemp.pojo.Msg;

/**
 * Created by xunge on 2017/7/13.
 */
public interface MsgDao {
    public int insert(Msg msg);

    public boolean delete(Integer id);

    public Msg get(Integer id);
}
