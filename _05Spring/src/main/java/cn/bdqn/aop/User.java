package cn.bdqn.aop;

import java.io.Serializable;

/**
 * Created by 王 on 2017/7/23.
 */
public class User implements Serializable {
// public static final long;
    private Integer id; //用户id
    private  String userName; //用户名
    private  String password; //密码
    private String email; //电子邮件

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
