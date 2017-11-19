package cn.smbms.controller;

import cn.smbms.uttil.PageUtil;
import cn.smbms.entity.UserInfo;
import cn.smbms.service.IUserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserInfoController {

    @Resource(name ="userService" )
    IUserInfoService userInfoService;
    //登录
    @RequestMapping("/doLogin")
    public String doLogin(HttpSession session, UserInfo info,String userCode){
        UserInfo user=userInfoService.isLogin(info);
        if (user!=null && user.getUserName()!=null){
            session.setAttribute("userinfo",user.getUserName());
            session.setAttribute("userCode",userCode);
            return "welcome";
        }else {
            return "login";

        }
    }
    /*用户列表*/
//    @RequestMapping("/dolist/{pageIndex}")
//    public String dolist(HttpServletRequest request,@PathVariable Integer pageIndex) {
//       /* Page page=new Page();
//        int PageIndex=0;
//        if (PageIndex>0){
//            PageIndex=PageIndex;
//        }else{
//            PageIndex=1;
//        }
//        page.setPageIndex(PageIndex);
//        int PageSize=3;
//        page.setPageSize(PageSize);
//        int toatalPages=0;
//        int count=userInfoService.count();
//        if (count%PageSize==0)
//        {
//            toatalPages=count/PageSize;
//        }else{
//            toatalPages=count/PageSize+1;
//        }
//
//        page.setTotapages(toatalPages);
//
//        try {
//            List<UserInfo> list = userInfoService.GetAllUserList((page.getPageIndex()-1)*page.getPageSize(), page.getPageSize());
//            page.setBloglist(list);
//
//            request.setAttribute("list", list);
//            request.setAttribute("lists",page);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }*/
//        return "/userList";
//
//       /* List<UserInfo> list = userInfoService.list();
//        session.setAttribute("list",list);
//            return "userList";*/
//    }
    //用户列表+分页
    @RequestMapping("/dolist")
    public String dolist(@RequestParam(value ="pn",defaultValue = "1")Integer pn, Model model,UserInfo info){
        PageHelper.startPage(pn,3);
        List<UserInfo> list=userInfoService.list();
        PageInfo page=new PageInfo(list,3);
        model.addAttribute("page",page);
        return "userList";

    }

    //删除用户
    @ResponseBody
    @RequestMapping( "/dellUser")
    public Object delUser( int id) {
        int i = userInfoService.delId(id);
        return i;
    }
    //根据id查询
    @RequestMapping(value = "/doidlist/{id}",method = RequestMethod.GET)
    public String doidlist(HttpSession session,@PathVariable int id){
        List<UserInfo> useridlist = userInfoService.useridlist(id);
        session.setAttribute("useridlist",useridlist);
        return "userView";
    }

    //查询单个用户
    @RequestMapping("/getAll/{id}")
    public String getAll(HttpServletRequest request, @PathVariable int id){
        UserInfo getall = userInfoService.getall(id);
        request.setAttribute("list", getall);
        return "userUpdate";
    }

    //修改用户
    @RequestMapping(value = "/updateUser/{id}",method = RequestMethod.POST)
    public String updateUsers(String userName, int gender, Date birthday, String phone, String address, int userRole, @PathVariable int id){
        UserInfo user=new UserInfo();
        user.setUserName(userName);
        user.setGender(gender);
        user.setBirthday(new Date());
        user.setPhone(phone);
        user.setAddress(address);
        user.setUserRole(userRole);
        user.setId(id);
        int i = userInfoService.updateUser(user);
        if (i>0) {
            return "redirect:/user/dolist";
        }else{
            return "/userUpdate";
        }
    }
    //添加用户
    @RequestMapping(value = "/adduser",method = RequestMethod.POST)
    public String douseradd( UserInfo user){
        int useradd = userInfoService.useradd(user);
        if (useradd>0){
            return "redirect:/user/dolist";
        }else {
            return "userAdd";
        }
    }
    @RequestMapping("/showUserList")
    public String showUserList(){
        return "userList";
    }

    @RequestMapping(value = "/getUserInfo")
    @ResponseBody
    public Object getUserInfo(@RequestParam(defaultValue = "1") int pageIndex, @RequestParam(defaultValue = "2") int pageSize){
        return userInfoService.getOnePageData(pageIndex,pageSize);
    }
    @ResponseBody
    //获取单页用户数据
    @RequestMapping("/selectUser")
    public Object selectUser(@RequestParam(defaultValue = "1") int pageIndex,@RequestParam(defaultValue = "2") int pageSize,UserInfo info){
        return  userInfoService.getOnePageData(pageIndex,pageSize,info);
    }
    //退出用户
    @RequestMapping(value = "/exit")
    public String exits(){
        return "login";
    }
    //修改密码
    @RequestMapping(value = "/pwd")
    public String pwd(){
        return "password";
    }

    @RequestMapping(value = "/pwdupd/{userCode}",method = RequestMethod.POST)
    public String pwds(UserInfo id,@PathVariable String userCode){
        UserInfo user=new UserInfo();
        user.setUserCode(userCode);
        user.setUserPassword(id.getUserPassword());
        int i = userInfoService.updatePwd(user);
        if (i>0){
            return "login";
        }else {
            return "password";
        }
    }
    @RequestMapping(value = "/excelUser")
    public String pp(HttpServletRequest request){
        List<UserInfo> list = userInfoService.excelUser();
        request.setAttribute("list", list);
        return "regell";
    }

}
