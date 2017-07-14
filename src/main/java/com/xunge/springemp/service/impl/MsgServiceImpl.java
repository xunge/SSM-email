package com.xunge.springemp.service.impl;

import com.xunge.springemp.dao.MsgDao;
import com.xunge.springemp.pojo.Msg;
import com.xunge.springemp.service.IMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xunge on 2017/7/13.
 */

@Service
public class MsgServiceImpl implements IMsgService{

    @Autowired
    private MsgDao msgDao;

    public int add(Msg msg){
        return msgDao.insert(msg);
    }

    public boolean remove(Integer id){
        return msgDao.delete(id);
    }

    public Msg get(Integer id){
        return msgDao.get(id);
    }
}
