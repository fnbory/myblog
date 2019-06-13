package com.fnbory.myblog.config;


import com.fnbory.myblog.Service.MenuService;
import com.fnbory.myblog.Service.OptionsService;
import com.fnbory.myblog.Service.ThemeService;
import com.fnbory.myblog.common.BlogConst;
import com.fnbory.myblog.entities.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.List;


@Configuration
public class StartupConfig implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private OptionsService optionsService;

	@Autowired
	private MenuService menuService;

	@Autowired
	private ThemeService themeService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		this.loadOptions();
		this.loadMenus();
		this.loadThemeName();
	}

	/**
	 * 加载设置选项
	 */
	private void loadOptions() {
		List<Options> listMap = optionsService.selectMap();
		if (listMap.size() > 0 && !listMap.isEmpty()) {
			for (Options options : listMap) {
				BlogConst.OPTIONS.put(options.getOptionName(), options.getOptionValue());
				System.out.println(options.getOptionName()+"  "+options.getOptionValue());
			}
		}
	}

	/**
	 * 加载菜单
	 */
	private void loadMenus() {
		BlogConst.MENUS = menuService.findMenus();
	}
	/**
	 * 加载主题
	 */
	private void loadThemeName() {
		BlogConst.THEME_NAME=themeService.getEnabledTheme();
	}

}
