package cn.tms.entity;
/**
 * Created by 123 on 2017/09/06.
 * @author 123
 * easyui    扩展属性实体类
 */
public class ScriptProperties {
    /**
     * 在页面上用来做url的存放
     */
    private String url;
    /**
     * 这个是用来放当前栏目的id
     */
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ScriptProperties{" +
                "url='" + url + '\'' +
                '}';
    }
}
