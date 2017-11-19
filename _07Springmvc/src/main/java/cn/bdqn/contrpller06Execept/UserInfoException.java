package cn.bdqn.contrpller06Execept;

/**
 * Created by Happy on 2017-08-20.
 * 用户信息异常
 */

/**
 * Exception:编译异常  Spring  提交的
 * RunTimeException：运行时异常  Spring 回滚的
 */
public class UserInfoException extends Exception{
    public UserInfoException() {
        super();
    }

    public UserInfoException(String message) {
        super(message);
    }
}
