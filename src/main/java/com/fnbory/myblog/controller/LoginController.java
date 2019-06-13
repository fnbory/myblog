package com.fnbory.myblog.controller;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.fnbory.myblog.Service.*;
import com.fnbory.myblog.common.BlogConst;
import com.fnbory.myblog.common.CommonResult;
import com.fnbory.myblog.common.enums.LoginEnum;
import com.fnbory.myblog.common.enums.PostType;
import com.fnbory.myblog.entities.Link;
import com.fnbory.myblog.entities.Logs;
import com.fnbory.myblog.entities.custom.ArticleCustom;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private LinkedService linkedService;

    @Autowired
    private AttachmentService attachmentService;

    @Autowired
    private LogService logService;

     /*
     登陆
      */
    @RequestMapping("/login1")
    public String login(String name,String psw){
//        if(loginService.login(name,psw)) return new CommonResult(200,LoginEnum.SUCCESS.getMessage());
//        else  return  new CommonResult(200,LoginEnum.FALSE.getMessage());
        return "admin/admin_login";
    }

    @RequestMapping(value = "/getLogin",method = RequestMethod.POST)
    @ResponseBody
    public  CommonResult getLogin(@RequestParam("userName") String username,@RequestParam("userPwd") String userPsw){
        if(loginService.login(username,userPsw)) {
            System.out.println("fff");
            return new CommonResult(200, LoginEnum.SUCCESS.getMessage());
        }  System.out.println("wef");
        return  new CommonResult(202,LoginEnum.FALSE.getMessage());
    }

    @RequestMapping("/toMain")
    public  String toMain(Model model){
        // 查询已发布文章数
        Integer countPublish = articleService.countByStatus(null, PostType.POST_TYPE_POST.getValue());
        System.out.println("countPublish"+":"+countPublish);
        model.addAttribute("countPublish", countPublish);
        // 友链总数
        List<Link> lists = linkedService.findLinks();
        model.addAttribute("countLinks", lists.size());
        // 附件总数
        int countAttachment = attachmentService.countAttachment().size();
        model.addAttribute("countAttachment", countAttachment);
        // 成立天数
//        Date blogStart= DateUtil.parse(BlogConst.OPTIONS.get("blog_start").toString());
//        model.addAttribute("establishDate", DateUtil.between(blogStart, DateUtil.date(), DateUnit.DAY));
        // 查询最新的文章
        ArticleCustom articleCustom = new ArticleCustom();
        System.out.println(articleCustom.toString());
        articleCustom.setArticlePost(PostType.POST_TYPE_POST.getValue());
        PageInfo<ArticleCustom> pageInfo = articleService.findPageArticle(1, 5, articleCustom);
        System.out.println("articles"+pageInfo.getList().get(0).getArticleTitle());
        model.addAttribute("articles", pageInfo.getList());
        // 查询最新的日志
        PageInfo<Logs> info = logService.findLogs(1, 5);
        model.addAttribute("logs", info.getList());
        return "admin/admin_index";
    }

}
