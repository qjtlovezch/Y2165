package com.bdqn.controller;

import com.bdqn.pojo.Page;
import com.bdqn.pojo.User;
import com.bdqn.pojo.User_voew;
import com.bdqn.service.IUserService;

import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.Date;
import java.util.List;

/**
 * Created by 王 on 2017/8/14.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private Logger logger=Logger.getLogger(UserController.class);

   @Resource(name="userService")
   private IUserService userService;

    @RequestMapping(value = "/login.html")
    public String login(){
        logger.info("User  welcome");
        return "login";
    }
    //登陆
    @RequestMapping(value = "dologin.html",method = RequestMethod.POST)
    public String doLogin(HttpSession session,@RequestParam String userCode,
                          @RequestParam String userPassword) {
        logger.info("doLogin=====");

        //调用service
        int user = userService.Login(userCode,userPassword);
        System.out.println(user);
        if (user > 0) {
            session.setAttribute("userCode",userCode);
            return "welcome";
        } else {
          return "login";
        }
    }

    //查询用户列表
    @RequestMapping(value = "/setAll/{pageIndex}")
    public String setAll(HttpServletRequest request,@PathVariable Integer pageIndex){
         /*  List<User> list = userService.setUser();
            request.setAttribute("list", list);
             return "userList";*/
        Page page=new Page();
        int PagIndex=0;
        //String MyPageIndex=request.getParameter("PageIndex");
        if (pageIndex>0){
            PagIndex=pageIndex;
        }else{
            PagIndex=1;
        }
        page.setPageIndex(pageIndex);
        int PageSize=3;
        page.setPageSize(PageSize);
        int toatalPages=0;
        int count=userService.count();
        if (count%PageSize==0)
        {
            toatalPages=count/PageSize;
        }else{
            toatalPages=count/PageSize+1;
        }
        page.setTotapages(toatalPages);
        try {
            List<User> list = userService.GetAllUserList((page.getPageIndex()-1)*page.getPageSize(), page.getPageSize());
            page.setBloglist(list);
            request.setAttribute("list", list);
            request.setAttribute("lists",page);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/userList";
    }


    //删除用户
    @RequestMapping(value = "/dellUser/{id}",method =RequestMethod.GET)
    public String delUser(@PathVariable int id){
        System.out.println(id);
      userService.delId(id);
        return "userList";
    }

    //查询单个用户
    @RequestMapping("/getAll/{id}")
    public String getAll(HttpServletRequest request,@PathVariable int id){
        User getall = userService.getall(id);
        request.setAttribute("list", getall);
        return "userUpdate";

    }

    //修改用户
    @RequestMapping(value = "/updateUser/{id}",method = RequestMethod.POST)
    public String updateUsers(String userName, int gender, Date birthday, String phone, String address,int userRole, @PathVariable int id){

        User user=new User();
        user.setUserName(userName);
        System.out.println(userName);
        user.setGender(gender);
        user.setBirthday(birthday);
        System.out.println(birthday);
        user.setPhone(phone);
        user.setAddress(address);
        user.setUserRole(userRole);
        user.setId(id);

        int i = userService.updateUser(user);
        System.out.println(i);
        if (i>0) {
            return "userList";
        }else{
            return "/userUpdate";
        }
    }

    @RequestMapping(value = "main.html")
    public String main(){
        return "welcome";
    }

    //添加测试
   /* @RequestMapping(value = "/userAdds",method = RequestMethod.POST)
    public String userAddUser(User_voew user){
        System.out.println(user.getUserName());
        System.out.println(user.getGender());
        System.out.println(user.getBirthday());
        return "userList";
    }*/

         //添加
       @RequestMapping(value = "/userAdds",method = RequestMethod.POST)
       public String userAddUser(User_voew user){
           System.out.println("xxxx");
           user.setUserCode(user.getUserCode());
           user.setUserName(user.getUserName());
           System.out.println(user.getUserName());
           user.setUserPassword(user.getUserPassword());
           user.setGender(user.getGender());
           System.out.println(user.getId());
           user.setBirthday(user.getBirthday());
           user.setPhone(user.getPhone());
           user.setAddress(user.getAddress());
           user.setUserRole(user.getUserRole());
           int i = userService.addNewUser(user);
           if (i>0) {
               /*return "redirect:/user/setAll/1";*/
               return "userList";
           }else {
               return "userAdd";
           }
        }
    @ResponseBody
    @RequestMapping(value = "/userAddsss",method = RequestMethod.POST)
    public Object userAddUsers(User_voew user){
        System.out.println("xxxx");
        int i = userService.addNewUser(user);
        if (i>0) {
               /*return "redirect:/user/setAll/1";*/
            return true;
        }else {
            return false;
        }

    }

    @RequestMapping(value = "userAdd")
    public String add(){
           return "userAdd";
    }


//退出用户
    @RequestMapping(value = "/exit")
public String exits(){
        return "login";
    }



    //模糊查询用户列表

    @RequestMapping(value = "/setAllUser")
    public String setAlls(HttpServletRequest request ,String userName){
        List<User> list = userService.setUserAll(userName);
        request.setAttribute("list", list);
        return "userListss";
    }
    @RequestMapping(value = "/setAllUserss")
    public String setAllss(HttpServletRequest request ,String userName){

        return "userListss";
    }




    /*让用户看到该视图*/
    @RequestMapping("/showUserList")
    public String showUserList(){
        return "userList";
    }

    //获取用户数据

    /**
     *defaultValue = "1" 默认取值为1
     * defaultValue = "2" 默认取值为2
     * @param pageIndex  当前页码
     * @param pageSize
     * @return  Object 整个PageUtil对象
     */
    //将返回值直接作为输出流中的内用，不用程序员手动构建输出流
    @ResponseBody
    @RequestMapping("/getUserInfo")
    public Object getUserInfo(@RequestParam(defaultValue = "1") int pageIndex,@RequestParam(defaultValue = "2") int pageSize){
        return userService.getOnePageData(pageIndex,pageSize);
    }
    @ResponseBody
    //获取单页用户数据
    @RequestMapping("/selectUser")
    public Object selectUser(@RequestParam(defaultValue = "1") int pageIndex,@RequestParam(defaultValue = "2") int pageSize,User info){
        return  userService.getOnePageData(pageIndex,pageSize,info);
    }


    @RequestMapping(value = "/pwd")
    public String pwd(){
        return "password";
    }


    @RequestMapping(value = "/updatepwd/{userCode}")
    public String pwds(User id,@PathVariable String userCode){
      User user=new User();
      user.setUserCode(userCode);
      user.setUserPassword(id.getUserPassword());
        int i = userService.updatePwd(user);
        if (i>0){
            return "password";
         }else {
            return "";
        }

    }


    @RequestMapping(value = "/excelUser")
    public String pp(HttpServletRequest request){
        List<User> list = userService.excelUser();
        request.setAttribute("list", list);
        return "regell";
    }

}

