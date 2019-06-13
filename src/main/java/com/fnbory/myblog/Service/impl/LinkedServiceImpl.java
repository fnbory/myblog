package com.fnbory.myblog.Service.impl;

import com.fnbory.myblog.Service.LinkedService;
import com.fnbory.myblog.dao.LinkMapper;
import com.fnbory.myblog.entities.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LinkedServiceImpl implements LinkedService {

    @Autowired
    private LinkMapper linkMapper;

    @Override
    public List<Link> findLinks() {
        return linkMapper.selectByExample(null);
    }
}
