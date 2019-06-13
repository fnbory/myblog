package com.fnbory.myblog.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.extra.servlet.ServletUtil;
import com.fnbory.myblog.Service.AttachmentService;
import com.fnbory.myblog.Service.UserService;
import com.fnbory.myblog.common.CommonResult;
import com.fnbory.myblog.common.enums.BlogEnums;
import com.fnbory.myblog.entities.Attachment;
import com.fnbory.myblog.entities.User;
import com.github.pagehelper.PageInfo;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@RequestMapping(value = "/admin/profile")
@Controller
public class UserController  {

	@Autowired
	private UserService userService;
	@Autowired
	private AttachmentService attachmentService;

	/**
	 * 
	 * @param model
	 * @param session
	 * @return 返回个人资料页面
	 */
	@GetMapping
	public String profile(Model model, HttpSession session) {
		// 单用户
		User users = userService.findUser();
		model.addAttribute("user", users);
		return "admin/admin_user";
	}

//	/**
//	 * 所有附件
//	 *
//	 * @param model
//	 * @param page
//	 * @param limit
//	 * @return
//	 */
//	@GetMapping(value = "/openChoice/{id}")
//	public String openChoice(Model model, @PathVariable String id,
//			@RequestParam(value = "page", defaultValue = "1") int page,
//			@RequestParam(value = "limit", defaultValue = "18") int limit) {
//		PageInfo<Attachment> lists = attachmentService.getAttachment(page, limit);
//		model.addAttribute("info", lists);
//		model.addAttribute("id", id);
//		return "admin/part/open_choice";
//	}
//
	/**
	 *
	 * @param user
	 * @return 修改个人资料结果
	 */
	@PostMapping(value = "/updateProfile")
	@ResponseBody
	public CommonResult updateProfile(User user, HttpSession session) {
		try {
			userService.updateDatum(user);
			session.invalidate();
		} catch (Exception e) {
			//log.error("修改资料", e);
			return new CommonResult(204, BlogEnums.ERROR.getMessage());
		}
		return new CommonResult(200, BlogEnums.PRESERVE_SUCCESS.getMessage());
	}

	/**
	 * 修改密码
	 *
	 * @param formerlyPwd
	 *            原密码
	 * @param nowPwd
	 *            新密码
	 * @param confirmPwd
	 *            确认新密码
	 * @param userId
	 *            用户id
	 * @return
	 */
	@PostMapping(value = "updatePwd")
	@ResponseBody
	public CommonResult updatePwd(@RequestParam(value = "formerlyPwd") String formerlyPwd,
			@RequestParam(value = "nowPwd") String nowPwd, @RequestParam(value = "confirmPwd") String confirmPwd,
			@RequestParam(value = "userId") Integer userId,HttpServletRequest request) {
		if (StringUtils.isBlank(formerlyPwd) || StringUtils.isBlank(formerlyPwd) || StringUtils.isBlank(confirmPwd)) {
			return new CommonResult(204, "请填写完整信息");
		}
		if (!nowPwd.equals(confirmPwd)) {
			return new CommonResult(204, "两次密码不一样");
		}
		try {
			User user = userService.findByUserIdAndUserPwd(userId, SecureUtil.md5(formerlyPwd));
			if (user != null) {
				user.setUserPassword(SecureUtil.md5(confirmPwd));
				userService.updateDatum(user);
			//	logService.save(new Log(LogConstant.UPDATE_PWD, LogConstant.LOGIN_SUCCES, ServletUtil.getClientIP(request),
						//DateUtil.date()));
			} else {
				return new CommonResult(204, "原密码错误");
			}
		} catch (Exception e) {
		//	log.error("修改密码",e);
			e.printStackTrace();
			return new CommonResult(204, "修改密码失败");
		}
		return new CommonResult(200, "修改密码成功");
	}
}
