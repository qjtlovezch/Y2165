package cn.bdqn.entity;

import java.util.List;

/**
 * Created by QiuShao on 2017/8/11.
 */
public class Attendance {
    public Integer attendanceid;
    public String attendancename;

    public List<studentattendance> getAttendancelist() {
        return attendancelist;
    }

    public void setAttendancelist(List<studentattendance> attendancelist) {
        this.attendancelist = attendancelist;
    }

    private List<studentattendance> attendancelist;
    public Integer getAttendanceid() {
        return attendanceid;
    }

    public void setAttendanceid(Integer attendanceid) {
        this.attendanceid = attendanceid;
    }

    public String getAttendancename() {
        return attendancename;
    }

    public void setAttendancename(String attendancename) {
        this.attendancename = attendancename;
    }
}
