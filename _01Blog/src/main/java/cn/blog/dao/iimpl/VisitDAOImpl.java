package cn.blog.dao.iimpl;

import cn.blog.dao.BaseDao;
import cn.blog.dao.IvisitDAO;
import cn.blog.entity.Visit;

/**
 * Created by QiuShao on 2017/7/5.
 */
public class VisitDAOImpl extends BaseDao implements IvisitDAO {
    public boolean addlog(Visit vs) throws Exception {
        boolean flag=false;
    String sql="insert into visitlog(IpAddress,VisitTime) values(?,?)";
        Object[] para={vs.getIpAddress(),vs.getVisitTime()};
        int count = executeUpdate(sql, para);
        if (count>0){
            flag = true;
        }
        return flag;
    }
}
