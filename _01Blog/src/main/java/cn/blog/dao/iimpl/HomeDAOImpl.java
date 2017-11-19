package cn.blog.dao.iimpl;

import cn.blog.dao.BaseDao;
import cn.blog.dao.IhomeDAO;
import cn.blog.entity.home;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by QiuShao on 2017/7/7.
 */
public class HomeDAOImpl extends BaseDao implements IhomeDAO {
    public boolean addhome(home home) throws Exception {
        boolean flag=false;
        String sql="insert into HomeWork(homeGrade,homeTeacher,homeChapter,homeContent,homeTime)values(?,?,?,?,?)";
        Object[] para={home.getHomeGrade(),home.getHomeTeacher(),home.getHomeChapter(),home.getHomeContent(),home.getHomeTime()};
        int count = executeUpdate(sql, para);
        if (count>0){
            flag=true;
        }
        return flag;
    }
    public List<home> findAll() throws Exception {
        List<home> list=new ArrayList<home>();
        String sql="select * from homework";
        ResultSet rs = executeQuery(sql);
        while (rs.next()){
            home home=new home();
            home.setHomeGrade(rs.getString("homeGrade"));
            home.setHomeTeacher(rs.getString("homeTeacher"));
            home.setHomeChapter(rs.getString("homeChapter"));
            home.setHomeContent(rs.getString("homeContent"));
            home.setHomeTime(rs.getTime("homeTime"));
            list.add(home);
        }
        return list;
    }
}
