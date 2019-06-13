package com.fnbory.myblog.controller;

import com.fnbory.myblog.Service.OptionsService;
import com.fnbory.myblog.common.BlogConst;
import com.fnbory.myblog.common.CommonResult;
import com.fnbory.myblog.common.enums.BlogEnums;
import com.fnbory.myblog.entities.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Controller
@RequestMapping("/admin/option")
public class OptionsController {
	@Autowired
	private OptionsService optionsService;

	/**
	 * 所有设置选项
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping
	public String option(Model model) {
		Map<String,String> options=new HashMap<>(BlogConst.OPTIONS);
		model.addAttribute("options",options);
		return "admin/admin_options";
	}

	/**
	 * 保存设置
	 * 
	 * @param map
	 * @return
	 */
	@PostMapping(value = "/save")
	@ResponseBody
	public CommonResult save(@RequestParam Map<String, String> map) {
		try {
			optionsService.save(map);
			BlogConst.OPTIONS.clear();
			List<Options> listMap = optionsService.selectMap();
			for (Options options : listMap) {
				BlogConst.OPTIONS.put(options.getOptionName(), options.getOptionValue());
			}
		} catch (Exception e) {
			//log.error(e.getMessage());
			return new CommonResult(204, BlogEnums.PRESERVE_ERROR.getMessage());
		}
		return new CommonResult(200, BlogEnums.PRESERVE_SUCCESS.getMessage());
	}
}
