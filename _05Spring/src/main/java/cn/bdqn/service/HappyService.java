package cn.bdqn.service;

/**
 * Created by QiuShao on 2017/7/23.
 */
public class HappyService {

    private String info;

    public void work(){
        System.out.println("Hello "+info);
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
