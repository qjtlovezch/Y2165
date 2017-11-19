package cn.bdqn.contrpller08;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.constraints.*;

/**
 * Created by QiuShao on 2017/8/30.
 */
public class User {

    @Min(value = 0,message = "最小{value}")
    @Max(value = 100,message = "最大{value}")
    private Integer score;

    @NotEmpty(message = "不为空")
    @Pattern(regexp = "^1[3,4,5,6,7,8,9]\\d{9}$",message = "手机号不真确")
    private String phone;

    @NotEmpty(message = "用户名不为空")
    @Size(min = 3,message = "最少3字符")
    private String name;

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
