package com.fnbory.myblog.Service;



import com.fnbory.myblog.entities.Menu;

import java.util.List;

/**
 * @author : 宋浩志
 * @createDate : 2018年12月18日
 */
public interface MenuService {
	/**
	 * @return 所有菜单
	 */
	List<Menu> findMenus();

	/**
	 * 根据id查询
	 * 
	 * @param menuId
	 * @return
	 */
	Menu findByMenuId(Integer menuId);

	/**
	 * 添加
	 * 
	 * @param menu
	 */
	void save(Menu menu);

	/**
	 * 修改
	 * 
	 * @param menu
	 */
	void edit(Menu menu);

	/**
	 * 移除
	 * 
	 * @param menuId
	 */
	void remove(Integer menuId);

}
