package cn.bdqn.entity;

import java.util.Date;

/**
 * Created by QiuShao on 2017/8/11.
 */
public class studentattendance {
    public Integer studentattendaneid;
    public Integer studentid;
    public Integer attendanceid;
    public Date attendancetime;
    public Attendance att;
    public Student stu;

    public Integer getStudentattendaneid() {
        return studentattendaneid;
    }

    public void setStudentattendaneid(Integer studentattendaneid) {
        this.studentattendaneid = studentattendaneid;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public Integer getAttendanceid() {
        return attendanceid;
    }

    public void setAttendanceid(Integer attendanceid) {
        this.attendanceid = attendanceid;
    }

    public Date getAttendancetime() {
        return attendancetime;
    }

    public void setAttendancetime(Date attendancetime) {
        this.attendancetime = attendancetime;
    }

    public Attendance getAtt() {
        return att;
    }

    public void setAtt(Attendance att) {
        this.att = att;
    }

    public Student getStu() {
        return stu;
    }

    public void setStu(Student stu) {
        this.stu = stu;
    }
}
