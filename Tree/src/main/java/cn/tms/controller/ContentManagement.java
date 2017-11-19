package cn.tms.controller;

import cn.tms.entity.PostingDetails;
import cn.tms.entity.ScriptProperties;
import cn.tms.entity.Content;
import cn.tms.entity.UserInfo;
import cn.tms.service.IContentService;
import cn.tms.service.IPostingDetailsService;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * 内容管理
 *
 * @author 123
 * @date 2017/11/07
 */
@Controller
@RequestMapping("/content")
public class ContentManagement {

    @Resource(name = "IContentService")
    private IContentService contentService;

    @Resource(name = "IPostingDetailsService")
    private IPostingDetailsService postingDetailsService;

    /**
     * 页面复用
     *
     * @param request
     * @param pageType
     * @param id
     * @return
     */
    @RequestMapping("/DomesticManage")
    public String DomesticManage(HttpServletRequest request, String pageType, Integer id) {
        System.out.println("pageType" + pageType + "id" + id);
        if ("add".equals(pageType)) {    //添加页面
            request.setAttribute("oper", "发布");
        } else {       //if ("modify".equals(pageType))
            request.setAttribute("oper", "修改");
            PostingDetails detail = postingDetailsService.getArticleByCondition(id);
            //  detail.setArticlePicture();
            request.setAttribute("id",id);
            request.setAttribute("detail", detail);
        }
        return "/page/DomesticManage";
    }


    /**
     * 保存
     *
     * @param request
     * @param context
     * @param title     标题
     * @param file      文件上传
     * @param summary   摘要
     * @param text      文章正文
     * @param operation
     * @return
     */
    @ResponseBody
    @RequestMapping("/addDetail")
    public String addDetail(HttpServletRequest request, String context, String title, MultipartFile file, String summary, String text, Integer operation, String execute) {
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userinfo");
        String path = request.getSession().getServletContext().getRealPath("upload/img");
        String fileName = null;
        if (file != null) {
            fileName = file.getOriginalFilename();
        }
        //文件上传
        File targetFile = new File(path, fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        try {
            file.transferTo(targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String paths = "/upload/img/" + fileName;



        PostingDetails details = new PostingDetails();

        details.setCreator(userInfo.getUsername());
        details.setModifyTime(new Date());
        details.setContents(text);
        details.setSysCode(context);
        details.setTitle(title);
        details.setPublish(operation);
        details.setArticlePicture(paths);
        details.setSummary(summary);
        int flag = 0;
        /**
         * i 就是insert 添加
         * m 就是modify 修改
         */
        if ("i".equals(execute)) {
            flag = postingDetailsService.saveArticle(details);
        } else {
            flag = postingDetailsService.modifyDetailByCondition(details);
        }

        if (flag == 0) {
            return "redirect:Domestic";
        }
        return "y";
    }

    /**
     * comboTree  下拉框树状图
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/getCombotList")
    public Object getCombotList() {
        System.out.println("/getCombotList");
        List<Content> list = contentService.getCententList();
        List<Content> rootMenus = new ArrayList<Content>();
        for (Content item : list) {
            Content childMenu = item;
            String pid = childMenu.getParentcode();
            if ("0".equals(pid)) {
                rootMenus.add(item);
            } else {
                for (Content innerMenu : list) {
                    String id = innerMenu.getSyscode();
                    if (id.equals(pid)) {
                        Content parentMenu = innerMenu;
                        parentMenu.getChildren().add(childMenu);
                        break;
                    }
                }
            }
        }
        Gson gson = new Gson();
        String str = gson.toJson(rootMenus);

        str = str.replace("parentcode", "pid");
        str = str.replace("columnname", "text");
        str = str.replace("syscode", "id");

        return str;
    }

    /**
     * 删除国内资讯
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/delDetail")
    public String delDetails(Integer id) {
        int flag = postingDetailsService.delDetailsByCondition(id);
        if (flag == 0) {
            return "n";
        }
        return "y";
    }


    /**
     * 文章分页列表
     *
     * @param columnCode 栏目id
     * @param page
     * @param rows
     * @return
     */
    @ResponseBody
    @RequestMapping("/Details")
    public Object Details(Integer columnCode, @RequestParam int page, @RequestParam int rows, String search) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (columnCode != null) {
            map.put("columnCode", columnCode);
        }
        if (search != null) {
            map.put("search", search);
        }
        /**
         * 因为publis   状态1是发布
         */
        map.put("publish", 1);
        map.put("page", (page - 1) * rows);
        map.put("rows", rows);

        List<PostingDetails> list = postingDetailsService.getDetailsListByCondition(map);
        int sum = postingDetailsService.getCountByCondition(map);
        map.put("rows", list);
        map.put("total", sum);
        return map;
    }

    /**
     * 跳转国内资讯
     *
     * @return
     */
    @RequestMapping("/Domestic")
    public String Domestic(Integer id, HttpServletRequest request) {
        if (id != null) {
            System.out.println("id" + id);
            request.setAttribute("id", id);
        }
        return "/page/Domestic";
    }

    /**
     * 加载内容发布中树状图
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/columnlist")
    public Object columnlist() {
        /**
         * 栏目列表
         */
        List<Content> list = contentService.getCententList();
        List<Content> rootMenus = new ArrayList<Content>();
        for (Content item : list) {
            Content childMenu = item;
            String pid = childMenu.getParentcode();
            if ("0".equals(pid)) {
                rootMenus.add(item);
            } else {
                for (Content innerMenu : list) {
                    String id = innerMenu.getSyscode();
                    if (id.equals(pid)) {
                        Content parentMenu = innerMenu;
                        if (childMenu.getUrl() != null) {
                            /**
                             *  这个我是看了easyUI API中有一个扩展属性
                             */
                            ScriptProperties sc = new ScriptProperties();
                            sc.setUrl(childMenu.getUrl());
                            sc.setId(childMenu.getColumncode());
                            childMenu.setAttributes(sc);
                            // System.out.println("url" + childMenu.getUrl() + "\n" + childMenu.getColumnname() + "\n" + parentMenu.getAttributes().getUrl() + "\n");
                        } else {
                            //System.out.println(parentMenu.getColumnname() + "parentMenu.getUrl() is null" + parentMenu.getUrl());
                        }
                        parentMenu.getChildren().add(childMenu);
                        break;
                    }
                }
            }
        }
        return rootMenus;
    }


    /**
     * 点击内容发布进行跳转物理视图的
     *
     * @return
     */
    @RequestMapping("/doContent")
    public String doContent() {
        //具体的jsp页面名称
        return "/page/LanmuList";
    }


    /**
     * 点击草稿箱进行跳转物理视图的
     *
     * @return
     */
    @RequestMapping("/docao")
    public String docao() {
        //具体的jsp页面名称
        return "/page/LanmuList";
    }

    public IContentService getContentService() {
        return contentService;
    }

    public void setContentService(IContentService contentService) {
        this.contentService = contentService;
    }

}
