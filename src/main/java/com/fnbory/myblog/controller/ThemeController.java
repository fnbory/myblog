package com.fnbory.myblog.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.extra.servlet.ServletUtil;
import com.fnbory.myblog.Service.ThemeService;
import com.fnbory.myblog.common.BlogConst;
import com.fnbory.myblog.common.CommonResult;
import com.fnbory.myblog.common.enums.BlogEnums;
import com.fnbory.myblog.entities.Theme;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/admin/theme")
public class ThemeController {
	@Autowired
	private ThemeService themeService;

	/**
	 * 查看所有主题
	 * 
	 * @param model
	 * @param page
	 * @param limit
	 * @return
	 */
	@GetMapping
	public String theme(Model model, @RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit) {
		PageInfo<Theme> info = themeService.findPageTheme(page, limit);
		model.addAttribute("info", info);
		return "admin/admin_theme";
	}

	/**
	 * 保存主题
	 *
	 * @param theme
	 * @param request
	 * @return
	 */
	@PostMapping("/saveTheme")
	@ResponseBody
	public CommonResult saveTheme(Theme theme, HttpServletRequest request) {
		try {
			Theme th = themeService.findByThemeName(theme.getThemeName());
			if (th != null) {
				return new CommonResult(204, "该主题已存在");
			}
			themeService.saveTheme(theme);
			// 添加日志
			//logService.save(new Log(LogConstant.PUBLISH_AN_THEME, LogConstant.SUCCESS, ServletUtil.getClientIP(request),
				//	DateUtil.date()));
		} catch (Exception e) {
			//log.error(e.getMessage());
			return new CommonResult(204, BlogEnums.PRESERVE_ERROR.getMessage());
		}
		return new CommonResult(200, BlogEnums.PRESERVE_SUCCESS.getMessage());
	}

	/**
	 * 删除主题
	 *
	 * @param id
	 * @param request
	 * @return
	 */
	@GetMapping("/remove")
	public String remove(int id, HttpServletRequest request) {
		try {
			themeService.remove(id);
			BlogConst.THEME_NAME=null;
			// 添加日志
			//logService.save(new Log(LogConstant.REMOVE_AN_THEME, LogConstant.SUCCESS, ServletUtil.getClientIP(request),
			//		DateUtil.date()));
		} catch (Exception e) {
			//log.error(e.getMessage());
		}
		return "redirect:/admin/theme";
	}

//	/**
//	 * 跳转主题设置页面
//	 * @param themeName
//	 * @param model
//	 * @return
//	 */
//	@GetMapping(value = "/{themeName}")
//	public String themeOption(@PathVariable String themeName, Model model) {
//		Theme theme = themeService.findByThemeName(themeName);
//		model.addAttribute("theme", theme);
//		return "themes/" + themeName + "/module/options";
//	}
//	/**
//	 * 启用主题
//	 * @param id
//	 * @return
//	 */
//	@PostMapping(value="themeEnabled")
//	@ResponseBody
//	public CommonResult themeEnabled(@RequestParam(value="id")int id) {
//		try {
//			themeService.themeEnabled(id);
//			MaydayConst.THEME_NAME=themeService.getEnabledTheme();
//		} catch (Exception e) {
//			log.error(e.getMessage());
//			return new CommonResult(BlogEnums.ERROR.isFlag(),BlogEnums.ERROR.getMessage());
//		}
//		return new CommonResult(BlogEnums.OPERATION_SUCCESS.isFlag(), BlogEnums.OPERATION_SUCCESS.getMessage());
//	}
	
}
