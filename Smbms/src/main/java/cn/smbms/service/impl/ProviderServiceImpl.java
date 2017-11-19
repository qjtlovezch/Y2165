package cn.smbms.service.impl;

import cn.smbms.dao.IProviderDAO;
import cn.smbms.entity.Provider;
import cn.smbms.service.IProviderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by QiuShao on 2017/8/25.
 */
@Service("providerservice")
public class ProviderServiceImpl implements IProviderService {
    @Resource(name="IProviderDAO")
    IProviderDAO providerDAO;
    public List<Provider> prolist() {
        return providerDAO.prolist();
    }

    public int prodel(int id) {
        return providerDAO.prodel(id);
    }

    public List<Provider> idlist(int id) {
        return providerDAO.idlist(id);
    }

    public List<Provider> prolike(Provider provider) {
        return providerDAO.prolike(provider);
    }

    public int proadd(Provider provider) {
        return providerDAO.proadd(provider);
    }

    public int update(Provider id) {
        return providerDAO.update(id);
    }

    public Provider Pupdate(int id) {
        return providerDAO.Pupdate(id);
    }


    public IProviderDAO getProviderDAO() {
        return providerDAO;
    }

    public void setProviderDAO(IProviderDAO providerDAO) {
        this.providerDAO = providerDAO;
    }
}
