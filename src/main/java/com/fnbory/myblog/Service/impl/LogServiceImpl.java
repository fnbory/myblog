package com.fnbory.myblog.Service.impl;

import com.fnbory.myblog.Service.LogService;
import com.fnbory.myblog.dao.LogsMapper;
import com.fnbory.myblog.dao.customer.LogMapperCustom;
import com.fnbory.myblog.entities.Logs;
import com.fnbory.myblog.entities.LogsExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogsMapper logsMapper;

    @Autowired
    private LogMapperCustom logMapperCustom;

    @Override

    public void save(Logs log) {
        logsMapper.insert(log);
    }

    @Override
    public PageInfo<Logs> findLogs(int page, int limit) {
        PageHelper.startPage(page, limit);
        LogsExample example = new LogsExample();
        example.setOrderByClause("log_id DESC ");
        List<Logs> logs = logsMapper.selectByExample(example);
        return new PageInfo<>(logs);
    }

    @Override

    public void clear() {
        logMapperCustom.clear();
    }
}
