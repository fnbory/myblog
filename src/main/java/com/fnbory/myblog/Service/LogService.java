package com.fnbory.myblog.Service;

import com.fnbory.myblog.entities.Logs;
import com.github.pagehelper.PageInfo;



public interface LogService {
	/**
	 * 保存日志
	 * 
	 * @param log
	 */
	void save(Logs log);

	/**
	 * 分页查询日志
	 * 
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<Logs> findLogs(int page, int limit);

	/**
	 * 删除所有日志
	 */
	void clear();
}
