package cn.tms.dao;

import cn.tms.entity.Content;
import cn.tms.entity.PostingDetails;

import java.util.List;
import java.util.Map;

/**
 * Created by 123 on 2017/11/07.
 */
public interface IPostingDetailsDAO {
    /**
     *  修改文章
     * @param details
     * @return  int
     */
    public int modifyDetailByCondition(PostingDetails details);

    /**
     *  修改 文章：根据id查询整个实体
     * @param id    文章id
     * @return
     */
    public PostingDetails getArticleByCondition(Integer id);
    /**
     * 保存文章
     * @param details   文章实体
     * @return
     */
    public int saveArticle(PostingDetails details);


    /**
     * 删除某条资讯
     * @param id    文章id
     * @return
     */
    public int delDetailsByCondition(Integer id);

    /**
     * 根据栏目id拿到所有的发布列表
     *
     * @param map    id 栏目下的数据        rows 每页数据量         page   起始位置
     * @return
     */
    public List<PostingDetails> getDetailsListByCondition(Map<String, Object> map);

    /**
     * 用来获取当前栏目下的总条数和条件下
     * @param map   id 栏目下的数据        rows 每页数据量         page   起始位置
     * @return
     */
    public int getCountByCondition(Map<String, Object> map);

}