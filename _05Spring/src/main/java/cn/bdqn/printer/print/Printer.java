package cn.bdqn.printer.print;

import cn.bdqn.printer.ink.Ink;
import cn.bdqn.printer.paper.Paper;

/**
 * Created by Happy on 2017-07-23.
 * 打印机
 *
 */
public class Printer {

    private Ink ink;

    private Paper paper;

    public void print(){
        System.out.println("用 "+ink.getColor()+" 颜色的墨盒在 "+paper.getPaper()+" 上打印出来 老原你敢下课吗???");
    }
    public Ink getInk() {
        return ink;
    }

    public void setInk(Ink ink) {
        this.ink = ink;
    }

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }
}
