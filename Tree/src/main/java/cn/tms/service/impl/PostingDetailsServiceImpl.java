package cn.tms.service.impl;

import cn.tms.dao.IPostingDetailsDAO;
import cn.tms.entity.PostingDetails;
import cn.tms.service.IPostingDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 2017-9-27 09:42:36
 */
@Service("IPostingDetailsService")
public class PostingDetailsServiceImpl implements IPostingDetailsService {
    //植入dao对象
    @Resource(name = "IPostingDetailsDAO")
    private IPostingDetailsDAO postingDetailsDAO;



    public int modifyDetailByCondition(PostingDetails details) {
        return postingDetailsDAO.modifyDetailByCondition(details);
    }


    public PostingDetails getArticleByCondition(Integer id) {
        return postingDetailsDAO.getArticleByCondition(id);
    }


    public int saveArticle(PostingDetails details) {
        return postingDetailsDAO.saveArticle(details);
    }

    public int delDetailsByCondition(Integer id) {
        return postingDetailsDAO.delDetailsByCondition(id);
    }

    public List<PostingDetails> getDetailsListByCondition(Map<String, Object> map) {
        return postingDetailsDAO.getDetailsListByCondition(map);
    }

    public int getCountByCondition(Map<String, Object> map) {
        return postingDetailsDAO.getCountByCondition(map);
    }
}
