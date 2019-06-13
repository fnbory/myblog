package com.fnbory.myblog.dao.customer;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface TagMapperCustom {

	List<Integer> selectByarticleId(Integer id);

	void delete(@Param(value = "list") List<Integer> tagList, @Param(value = "articleId") Integer articleId);

}
