package cn.bdqn.servlet;

import cn.bdqn.entity.Student;
import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.sf.json.JSONObject;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by QiuShao on 2017/7/17.
 */
public class FirstServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       /* String uname=request.getParameter("uname");
        if (uname.equals("admin")){
            response.getWriter().write("true");
        }else {
            response.getWriter().write("false");
        }*/

        List<Student> list=new ArrayList<Student>();
        Student stu=new Student();
        stu.setStuId(1);
        stu.setStuName("hehe");

        Student stu1=new Student();
        stu1.setStuId(2);
        stu1.setStuName("aaa");
        list.add(stu);
        list.add(stu1);

        /*jackson*/
       /* ObjectMapper mapper=new ObjectMapper();
        String json =mapper.writeValueAsString(list);
        System.out.println(json);*/
      /*  ObjectMapper mapper=new ObjectMapper();
        String json=mapper.writeValueAsString(list);
        List<Student>beanList=mapper.readValue(json,new TypeReference<List<Student>>(){});
        for (Student stus:beanList
                ) {
            System.out.println(stus.getStuName());
        }
        System.out.println(json);*/




        /*fastJson*/
       /* String string = JSON.toJSONString(list);
        System.out.println(string);*/

       /*fastJson*/
        /*String result= JSON.toJSONString(list);
        List<Student> mylist = JSON.parseArray(result, Student.class);
        for (Student item: mylist) {
            System.out.println(item.getStuName());
        }*/


        /*google gson*/
       /* Gson tool=new Gson();
        String resout = tool.toJson(list);
        List<Student> mylist= tool.fromJson(resout,new TypeToken<List<Student>>(){}.getType());
        for (Student ss:mylist) {
            System.out.println(ss.getStuName());
        }*/
        //System.out.println(resout);
        /*json*/
       /* JSONObject json = JSONObject.fromObject(stu);
        System.out.println(json.toString());*/
        JSONObject jsonStu = JSONObject.fromObject(stu);

       Student stu2 = (Student) JSONObject.toBean(jsonStu, Student.class);

        System.out.println(stu2.getStuName());




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
