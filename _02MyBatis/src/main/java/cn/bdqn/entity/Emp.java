package cn.bdqn.entity;

/**
 * Created by QiuShao on 2017/7/13.
 */
public class Emp {

    private  Integer empNo;
    private String empName;
    private Integer deptNo;
    private deptt dept;

    public deptt getDept() {
        return dept;
    }

    public void setDept(deptt dept) {
        this.dept = dept;
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }
}
