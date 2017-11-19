package cn.tenement.Controller;

import cn.tenement.Dao.IUserInfoDao;
import cn.tenement.Entity.*;
import cn.tenement.Service.IbillService;
import cn.tenement.Service.IhouseService;
import cn.tenement.Service.IproviderService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by sunbin on 2017/8/30.
 */
@Controller
public class houseController {
    @Autowired()
    IhouseService house;
    @Autowired()
    IbillService bill;
    @Autowired()
    IproviderService pro;
    @Autowired()
    IUserInfoDao userInfoDao;
    @ResponseBody
  @RequestMapping("/list.do")
      public Object list(String  page ,String rows ,HttpServletRequest request){

//当前页 
     int intPage = Integer.parseInt((page == null || page == "0"||"".equals(rows)) ? "1":page);
//每页显示条数 
    int number = Integer.parseInt((rows == null || rows == "0"||"".equals(rows)) ? "10":rows);
//每页的开始记录  第一页为1  第二页为number +1  
          int start = (intPage-1)*number;

             List<Provider> listpro=pro.list(0,10);
                List<bill>list=bill.list2(start,number);
        int num=bill.count(null);
      for (bill item:list
           ) {
                  if(item.getIsPayment()==0){
                      item.setP("未付款");
                  }else {
                      item.setP("已付款");
                  }
          item.setProName(item.getProviders().getProName());
          SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
         item.setData(sdf.format(item.getCreationDate()));
      }
        Map<String, Object> jsonMap = new HashMap<String, Object>();//定义map 
        jsonMap.put("total", bill.count(null));//total键 存放总记录数，必须的 
        jsonMap.put("rows", list);
        request.getSession().setAttribute("lists",listpro);
      return jsonMap;
  }
  @ResponseBody
    @RequestMapping("/lists.do")
    public Object lists(String  page ,String rows ,String typename ,HttpServletRequest request){
      List<bill>list=null;
      int intPage = Integer.parseInt((rows.equals("NaN")||page == null || page == "0"||"".equals(rows)) ? "1":page);
//每页显示条数 
      int number = Integer.parseInt(( rows.equals("NaN")|| rows == "0"||"".equals(rows)) ? "10":rows);
//每页的开始记录  第一页为1  第二页为number +1  
      int start = (intPage-1)*number;
      int num=0;
        if(("").equals(typename)||typename.equals(null)){
            list=bill.list2(start,number);
            num=bill.count(null);
        }else {
            list = bill.list(start,number,typename);
            num=bill.count(typename);
        }
      System.out.println(num);
            for (bill item : list
                    ) {
                if(item.getIsPayment()==0){
                    item.setP("未付款");
                }else {
                    item.setP("已付款");
                }
                item.setProName(item.getProviders().getProName());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                item.setData(sdf.format(item.getCreationDate()));
            }
      Map<String, Object> jsonMap = new HashMap<String, Object>();//定义map 
          jsonMap.put("total", bill.count(typename));//total键 存放总记录数，必须的 
      System.out.println(jsonMap.get("total"));
                jsonMap.put("rows", list);
      List<Provider> listpro=pro.list(0,10);
      request.getSession().setAttribute("lists",listpro);
        return jsonMap;
    }
    @ResponseBody
    @RequestMapping("/add.do")
    public Object insert(bill houseinfo ,HttpServletRequest request){
        houseinfo.setCreationDate(new Date());
        String  userId = (String)request.getSession().getAttribute("userId");
        int userid=Integer.parseInt(userId);
        houseinfo.setCreatedBy(userid);//需要修改
        System.out.println(1);
       bill.inserts(houseinfo);

          return bill.list2(0,5);
    }
    @ResponseBody
    @RequestMapping("/select.do")
    public Object select(String billCode,HttpServletRequest request){
        bill list=bill.selects(billCode);

            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            list.setData(sdf.format(list.getCreationDate()));
        list.getProvider();


        return list;
    }
    @ResponseBody
    @RequestMapping("/proselect.do")
    public Object proselect(String id,HttpServletRequest request){
        int ids=Integer.parseInt(id);
       Provider list=pro.provider(ids);

        return list;
    }
    @ResponseBody
    @RequestMapping("/userselect.do")
    public Object userselect(String id,HttpServletRequest request){
        int ids=Integer.parseInt(id);
        User list=userInfoDao.selects(ids);

        return list;
    }
    @ResponseBody
    @RequestMapping("/roleselect.do")
    public Object roleselect(String id,HttpServletRequest request){
        int ids=Integer.parseInt(id);
        role list=userInfoDao.roles(ids);

        return list;
    }
    @ResponseBody
    @RequestMapping("/rolelist.do")
    public Object role(){
             List<role>list= userInfoDao.rolelist();

        for (role item:list
             ) {
              String u= item.getRoleCode();
              if(u.length()>1){

                      String[] split = u.split(",");
                      int []ints=new int[split.length];
                      String name="";
                      for (int i=0;i<split.length;i++){
                          ints[i]=Integer.parseInt(split[i]);

                          List<category> lists=house.two(ints[i]);
                          for (category items:lists
                                  ) {
                            name+= items.getText()+",";
                          }

                      }
                      item.setStr(name);

              }
              else {
                  int ints=Integer.parseInt(u);
                  List<category> lists =house.two(ints);
                  for (category items:lists
                          ) {
                      item.setStr(items.getText());
                  }

              }
            System.out.println(item.getStr());
        }

        return list;
    }
    @ResponseBody
    @RequestMapping("/proupdate.do")
    public Object proupdates(Provider houseinfo ,HttpServletRequest request){
        houseinfo.setModifyDate(new Date());

        int userid=(Integer) request.getSession().getAttribute("userId");
        houseinfo.setModifyBy(userid);//需要修改
        System.out.println(2);
        pro.update(houseinfo);

        return pro.list(0,5);
    }
    @ResponseBody
    @RequestMapping("/userupdate.do")
    public Object proupdates(User houseinfo ,HttpServletRequest request){
        houseinfo.setModifyDate(new Date());
        System.out.println(houseinfo.getUserRole());
        int userid=(Integer) request.getSession().getAttribute("userId");
        houseinfo.setModifyBy(userid);//需要修改



        userInfoDao.updates(houseinfo);

        return userInfoDao.list2(0,5);
    }
    @ResponseBody
    @RequestMapping("/one.do")
    public Object one(HttpServletRequest request){
        role role = userInfoDao.select((Integer) request.getSession().getAttribute("userRole"));
        List<category> list=new ArrayList<category>();

         if(role.getRoleCode().length()>1){
             String[] split = role.getRoleCode().split(",");
             int []ints=new int[split.length];
             for (int i=0;i<split.length;i++){
                 ints[i]=Integer.parseInt(split[i]);
                 System.out.println(ints[i]);
                 List<category> lists=house.two(ints[i]);
                 for (category item:lists
                         ) {
                     item.setChildren(house.one(ints[i]));
                 }
                 list.addAll(lists);
             }
         }else {
             int ints=Integer.parseInt(role.getRoleCode());
             list =house.two(ints);
             for (category item:list
                     ) {
                 item.setChildren(house.one(ints));
             }

         }



        for (category item:list){
            for (category items:item.getChildren()){
                if(items.getChildren().size()>0) {
                    for (category itemss : items.getChildren()) {
                        two twos = new two();
                        twos.setUrl(itemss.getUrl());
                        itemss.setAttributes(twos);
                    }
                }else {
                    two twos = new two();
                    twos.setUrl(items.getUrl());
                    items.setAttributes(twos);
                }
            }
        }
        return list;
    }
    @ResponseBody
    @RequestMapping("/roleupdate.do")
    public Object roleupdates(role houseinfo ,HttpServletRequest request){
        houseinfo.setModifyDate(new Date());
   if(houseinfo.getRoleCode().indexOf("1")<0){

   }else{
       houseinfo.setRoleCode("1");
   }
        int userid=(Integer) request.getSession().getAttribute("userId");
        houseinfo.setModifyBy(userid);//需要修改

        userInfoDao.roleupdates(houseinfo);

        return userInfoDao.rolelist();
    }
    @ResponseBody
    @RequestMapping("/update.do")
    public Object updates(bill houseinfo ,HttpServletRequest request){
        houseinfo.setModifyDate(new Date());

        int userid=(Integer) request.getSession().getAttribute("userId");
        houseinfo.setModifyBy(userid);//需要修改
        System.out.println(2);
        bill.updates(houseinfo);

        return bill.list2(0,5);
    }
    @ResponseBody
    @RequestMapping("/delete.do")
  public Object deletes(String billCode){
        System.out.println(billCode);
        String[] split = billCode.split(",");
        for (int i=0;i<split.length;i++){
            int id= Integer.parseInt(split[i]);
            bill.deletes(id);
        }


        return  bill.list2(0,10);
    }
    @ResponseBody
    @RequestMapping("/userdelete.do")
    public Object userdeletes(String id){
        System.out.println(id);
        String[] split = id.split(",");
        for (int i=0;i<split.length;i++){
            int ids= Integer.parseInt(split[i]);
            userInfoDao.deletes(ids);
        }


        return  userInfoDao.list2(0,10);
    }
    @ResponseBody
    @RequestMapping("/prodelete.do")
    public Object delete(String id){
        System.out.println(1111);
        String[] split = id.split(",");
        for (int i=0;i<split.length;i++){
            int ids= Integer.parseInt(split[i]);
            pro.delect(ids);
        }


        return  pro.list(0,10);
    }
    @ResponseBody
    @RequestMapping("/roledelete.do")
    public Object rodelete(String id){
        System.out.println(1111);
        String[] split = id.split(",");
        for (int i=0;i<split.length;i++){
            int ids= Integer.parseInt(split[i]);
            userInfoDao.roledeletes(ids);
        }


        return  userInfoDao.rolelist();
    }

    @ResponseBody
    @RequestMapping("/prolist.do")
    public Object proList(String  page ,String rows ){
        int intPage = Integer.parseInt((page == null || page == "0"||"".equals(rows)) ? "1":page);
//每页显示条数 
        int number = Integer.parseInt((rows == null || rows == "0"||"".equals(rows)) ? "10":rows);
//每页的开始记录  第一页为1  第二页为number +1 
//

        int start = (intPage-1)*number;
        System.out.println(number+"-----"+start);
        List<Provider>list=pro.list(start,number);
        for (Provider item:list
                ) {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            item.setDate(sdf.format(item.getCreationDate()));
        }
       int num=pro.count(null);

        Map<String, Object> jsonMap = new HashMap<String, Object>();//定义map 
        jsonMap.put("total", pro.count(null));//total键 存放总记录数，必须的 
        jsonMap.put("rows", list);
        List<Provider> listpro=pro.list(0,10);


        return jsonMap;

    }
    @ResponseBody
    @RequestMapping("/userlist.do")
    public Object userList(String  page ,String rows ){
        int intPage = Integer.parseInt((page == null || page == "0"||"".equals(rows)) ? "1":page);
//每页显示条数 
        int number = Integer.parseInt((rows == null || rows == "0"||"".equals(rows)) ? "10":rows);
//每页的开始记录  第一页为1  第二页为number +1 
//

        int start = (intPage-1)*number;
        System.out.println(number+"-----"+start);
        List<User>list=userInfoDao.list2(start,number);
        for (User item:list
                ) {
               if(item.getGender()==1){
                   item.setGenders("男");
               }else {
                   item.setGenders("女");
               }
              item.setRoleName(item.getRole().getRoleName());
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            item.setDate(sdf.format(item.getBirthday()));

        }
        int num=userInfoDao.count(null);

        Map<String, Object> jsonMap = new HashMap<String, Object>();//定义map 
        jsonMap.put("total", userInfoDao.count(null));//total键 存放总记录数，必须的 
        jsonMap.put("rows", list);
        List<User> listpro=userInfoDao.list2(0,10);


        return jsonMap;

    }
    @RequestMapping("/exal.do")
    public void Show(String typename,HttpServletResponse response){
              List<bill>list=   bill.list(0,1000,typename);
        try {
            Reportderived(list,response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(222222);

    }
    @RequestMapping("/proexal.do")
    public void Shows(String typename,HttpServletResponse response){
        List<Provider>list=   pro.lists(0,1000,typename);
        try {
            Reportderiveds(list,response);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    @ResponseBody
    @RequestMapping("/roleinsert.do")
    public Object roleinsert(role provider,HttpServletRequest request){
        if(provider.getRoleCode().indexOf("1")<0){

        }else{
            provider.setRoleCode("1");
        }
        int userid=(Integer) request.getSession().getAttribute("userId");
        provider.setCreatedBy(userid);
        provider.setCreationDate(new Date());
        System.out.println(provider.getCreationDate());
        userInfoDao.insertrole(provider);
             request.getSession().setAttribute("role",userInfoDao.rolelist());
        return userInfoDao.rolelist();
    }
    @ResponseBody
    @RequestMapping("/proinsert.do")
    public Object proinsert(Provider provider,HttpServletRequest request){

        int userid=(Integer) request.getSession().getAttribute("userId");
        provider.setCreatedBy(userid);
        provider.setCreationDate(new Date());
        System.out.println(provider.getCreationDate());
        pro.inserts(provider);

        return pro.list(0,5);
    }
   @ResponseBody
    @RequestMapping("/uppwd.do")
    public Object pwd(String pwd, String pwds, HttpServletRequest request){
           int id=(Integer)   request.getSession().getAttribute("userId");


            return userInfoDao.uppwd(pwd,pwds,id)>0;


    }
    @ResponseBody
    @RequestMapping("/userinsert.do")
    public Object proinsert(User user,HttpServletRequest request){

        int userid=(Integer) request.getSession().getAttribute("userId");
        user.setCreatedBy(userid);
        user.setCreationDate(new Date());
        user.setUserRole(3);
        System.out.println(user.getCreationDate());

        System.out.println(user.getUserPassword());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            user.setBirthday(sdf.parse(user.getDate()));
            userInfoDao.inserts(user);
        } catch (ParseException e) {
            e.printStackTrace();
                request.getSession().setAttribute("success","false");
                return "false";
        }
        return userInfoDao.list2(0,5);
    }
    @ResponseBody
    @RequestMapping("/prolists.do")
    public Object listss(String  page ,String rows ,String typename ,HttpServletRequest request){
        List<Provider>list=null;
        System.out.println(typename);
        int intPage = Integer.parseInt((rows.equals("NaN")||page == null || page == "0"||"".equals(rows)) ? "1":page);
//每页显示条数 
        int number = Integer.parseInt(( rows.equals("NaN")|| rows == "0"||"".equals(rows)) ? "10":rows);
//每页的开始记录  第一页为1  第二页为number +1  
        int start = (intPage-1)*number;
        int num=0;
        if(("").equals(typename)||typename.equals(null)){
            list=pro.list(start,number);
            num=pro.count(null);
        }else {
            list = pro.lists(start,number,typename);
            num=pro.count(typename);
        }
        System.out.println(num);
        for (Provider item : list
                ) {


            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            item.setDate(sdf.format(item.getCreationDate()));
        }
        Map<String, Object> jsonMap = new HashMap<String, Object>();//定义map 
        jsonMap.put("total", pro.count(typename));//total键 存放总记录数，必须的 
        System.out.println(jsonMap.get("total"));
        jsonMap.put("rows", list);
        List<Provider> listpro=pro.list(0,10);
        request.getSession().setAttribute("lists",listpro);
        return jsonMap;
    }

    @ResponseBody
    @RequestMapping("/userlists.do")
    public Object userlistss(String  page ,String rows ,String typename ,HttpServletRequest request){
        List<User>list=null;
        System.out.println(typename);
        int intPage = Integer.parseInt((rows.equals("NaN")||page == null || page == "0"||"".equals(rows)) ? "1":page);
//每页显示条数 
        int number = Integer.parseInt(( rows.equals("NaN")|| rows == "0"||"".equals(rows)) ? "10":rows);
//每页的开始记录  第一页为1  第二页为number +1  
        int start = (intPage-1)*number;
        int num=0;
        if(("").equals(typename)||typename.equals(null)){
            list=userInfoDao.list2(start,number);
            num=userInfoDao.count(null);
        }else {
            list = userInfoDao.list(start,number,typename);
            num=userInfoDao.count(typename);
        }
        System.out.println(num);
        for (User item : list
                ) {
            System.out.println(item.getRole().getRoleName());
            item.setRoleName(item.getRole().getRoleName());
            if(item.getGender()==1){
                item.setGenders("男");
            }else {
                item.setGenders("女");
            }
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            item.setDate(sdf.format(item.getBirthday()));
        }
        Map<String, Object> jsonMap = new HashMap<String, Object>();//定义map 
        jsonMap.put("total", userInfoDao.count(typename));//total键 存放总记录数，必须的 
        System.out.println(jsonMap.get("total"));
        jsonMap.put("rows", list);

        return jsonMap;
    }
    public void Reportderived(List<bill> list, HttpServletResponse response) throws IOException {
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet=wb.createSheet("销售信息");
        HSSFRow row1=sheet.createRow(0);
        HSSFCell cell=row1.createCell(0);
        cell.setCellValue("商品销售一览表");
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,5));
        HSSFRow row2=sheet.createRow(1);
        row2.createCell(0).setCellValue("账单编码");
        row2.createCell(1).setCellValue("商品名称");
        row2.createCell(2).setCellValue("供应商");
        row2.createCell(3).setCellValue("账单金额");
        row2.createCell(4).setCellValue("是否付款");
        row2.createCell(5).setCellValue("创建时间");

        for (int i=0;i<list.size();i++){

            if(list.get(i).getIsPayment()==0){
                list.get(i).setP("未付款");
            }else {
                list.get(i).setP("已付款");
            }
            list.get(i).setProName(list.get(i).getProviders().getProName());
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            list.get(i).setData(sdf.format(list.get(i).getCreationDate()));
            HSSFRow row=sheet.createRow(i+2);

            row.createCell(0).setCellValue(list.get(i).getBillCode());
            row.createCell(1).setCellValue(list.get(i).getProductName());
            row.createCell(2).setCellValue(list.get(i).getProName());
            row.createCell(3).setCellValue(list.get(i).getTotalPrice());
            row.createCell(4).setCellValue(list.get(i).getP());
            row.createCell(5).setCellValue(list.get(i).getData());
        }
        OutputStream output=response.getOutputStream();
        response.reset();
        response.setHeader("Content-disposition", "attachment; filename=details.xls");
        response.setContentType("application/msexcel");
        wb.write(output);
        output.close();
    }
    public void Reportderiveds(List<Provider> list, HttpServletResponse response) throws IOException {
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet=wb.createSheet("销售信息");
        HSSFRow row1=sheet.createRow(0);
        HSSFCell cell=row1.createCell(0);
        cell.setCellValue("供应商一览表");
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,5));
        HSSFRow row2=sheet.createRow(1);
        row2.createCell(0).setCellValue("供应商编码");
        row2.createCell(1).setCellValue("供应商名称");
        row2.createCell(2).setCellValue("联系人");
        row2.createCell(3).setCellValue("联系电话");
        row2.createCell(4).setCellValue("地址");
        row2.createCell(5).setCellValue("传真");
        row2.createCell(6).setCellValue("创建时间");
        for (int i=0;i<list.size();i++){


            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            list.get(i).setDate(sdf.format(list.get(i).getCreationDate()));
            HSSFRow row=sheet.createRow(i+2);

            row.createCell(0).setCellValue(list.get(i).getProCode());
            row.createCell(1).setCellValue(list.get(i).getProName());
            row.createCell(2).setCellValue(list.get(i).getProContact());
            row.createCell(3).setCellValue(list.get(i).getProPhone());
            row.createCell(4).setCellValue(list.get(i).getProAddress());
            row.createCell(5).setCellValue(list.get(i).getProFax());
            row.createCell(6).setCellValue(list.get(i).getDate());
        }
        OutputStream output=response.getOutputStream();
        response.reset();
        response.setHeader("Content-disposition", "attachment; filename=detail.xls");
        response.setContentType("application/msexcel");
        wb.write(output);
        output.close();
    }


}
