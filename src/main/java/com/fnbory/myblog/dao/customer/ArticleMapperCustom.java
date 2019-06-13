package com.fnbory.myblog.dao.customer;


import com.fnbory.myblog.entities.Category;
import com.fnbory.myblog.entities.Tag;
import com.fnbory.myblog.entities.custom.ArchiveBo;
import com.fnbory.myblog.entities.custom.ArticleCustom;
import org.apache.ibatis.annotations.Param;

import java.util.List;



public interface ArticleMapperCustom {

	List<ArticleCustom> articleMapperCustom(@Param(value = "status") int status);

	List<ArticleCustom> findAllArticle(@Param(value = "status") int status, @Param(value = "post") String post);

	Integer countByStatus(@Param(value = "status") Integer status, @Param(value = "post") String post);

	void updateStatus(@Param(value = "id") int id, @Param(value = "status") int status);

	ArticleCustom findByArticleId(@Param(value = "id") Integer article_id);

	List<ArchiveBo> findDateAndCount();

	List<ArticleCustom> findPageArticle(ArticleCustom articleCustom);

	int findRepeatByUrl(@Param(value = "articleUrl") String articleUrl);

	ArticleCustom findByArticleUrl(@Param(value = "articleUrl") String articleUrl);

	List<ArticleCustom> findArtileByCategory(@Param("category") Category category, @Param(value = "status") int status);

	List<ArticleCustom> findArtileByTag(@Param("tag") Tag tag, @Param(value = "status") int status);
}
