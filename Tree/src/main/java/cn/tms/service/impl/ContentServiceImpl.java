package cn.tms.service.impl;

import cn.tms.dao.IContentDAO;
import cn.tms.entity.Content;
import cn.tms.service.IContentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Happy on 2017-09-27.
 */
@Service("IContentService")
public class ContentServiceImpl implements IContentService {
    @Resource(name = "IContentDAO")
    private IContentDAO contentDAO;

    public List<Content> getCententList() {
        return contentDAO.getCententList();
    }

    public IContentDAO getContentDAO() {
        return contentDAO;
    }

    public void setContentDAO(IContentDAO contentDAO) {
        this.contentDAO = contentDAO;
    }
}
