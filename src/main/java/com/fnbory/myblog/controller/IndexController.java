package com.fnbory.myblog.controller;

import cn.hutool.core.util.StrUtil;
import com.fnbory.myblog.Service.ArticleService;
import com.fnbory.myblog.common.BlogConst;
import com.fnbory.myblog.common.enums.ArticleStatus;
import com.fnbory.myblog.common.enums.PageNumber;
import com.fnbory.myblog.common.enums.PostType;
import com.fnbory.myblog.entities.custom.ArchiveBo;
import com.fnbory.myblog.entities.custom.ArticleCustom;
import com.fnbory.myblog.utils.MaydayUtil;
import com.github.pagehelper.PageInfo;
import com.sun.syndication.io.FeedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping({"/index","/"})
public class IndexController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("")
    public String  index(Model model){

        return this.index(model,1);
    }

    /**
     * 首页分页
     *
     * @return 模板路径/themes/{theme}/index
     */
    @GetMapping(value = "page/{page}")
    public String index(Model model, @PathVariable(value = "page") Integer page) {
        page = page < 0 || page > BlogConst.MAX_PAGE ? 1 : page;
        // 默认显示条数
        Integer limit = StrUtil.isEmpty(BlogConst.OPTIONS.get("index_article")) ? PageNumber.POST_INDEX_lIMIT.getLimit()
                : Integer.parseInt(BlogConst.OPTIONS.get("index_article"));
        ArticleCustom articleCustom = new ArticleCustom();
        articleCustom.setArticleStatus(ArticleStatus.PUBLISH.getStatus());
        articleCustom.setArticlePost(PostType.POST_TYPE_POST.getValue());
        PageInfo<ArticleCustom> pageInfo = articleService.findPageArticle(page, limit, articleCustom);
        model.addAttribute("articles", pageInfo);
        return "themes/pinghsu/index";
    };

    /**
     * 文章页
     *
     * @param model
     * @param articleUrl
     *            文章url
     * @return
     */
    @GetMapping(value = { "post/{articleUrl}", "post/{articleUrl}.html" })
    public String post(Model model, @PathVariable(value = "articleUrl") String articleUrl, HttpServletRequest request) {
        ArticleCustom articleCustom = articleService.findByArticleUrl(articleUrl);
        if (articleCustom == null) {
            return "404";
        }
//        if (!checkRepeatIp(request, articleCustom.getId())) {
//            updateArticleViews(articleCustom.getId(), articleCustom.getArticleViews());
//        }
        model.addAttribute("article", articleCustom);
        return "themes/pinghsu/post";
    }

    /**
     * 归档 BY LHY
     *
     * @param model
     * @return
     * @throws Exception
     */
    @GetMapping(value = "archives")
    public String archives(Model model) throws Exception {
        List<ArchiveBo> archiveBos = articleService.archives();
        model.addAttribute("articleList", archiveBos);
        return "themes/pinghsu/archives";
    }


    /**
     * 文章rss
     *
     * @return
     * @throws FeedException
     */
    @GetMapping(value = { "feed", "feed.xml", "index.xml", "atom", "atom.xml" }, produces = "application/xml;charset=UTF-8")
    @ResponseBody
    public String rss() throws FeedException {
        String rssNumber = BlogConst.OPTIONS.get("rss_number");
        if (StrUtil.isBlank(rssNumber)) {
            rssNumber = "20";
        }
        ArticleCustom articleCustom = new ArticleCustom();
        articleCustom.setArticleStatus(ArticleStatus.PUBLISH.getStatus());
        articleCustom.setArticlePost(PostType.POST_TYPE_POST.getValue());
        PageInfo<ArticleCustom> pageInfo = articleService.findPageArticle(0, Integer.parseInt(rssNumber), articleCustom);
        List<ArticleCustom> articles=pageInfo.getList();
        return MaydayUtil.buildRss(articles);
    }
}
