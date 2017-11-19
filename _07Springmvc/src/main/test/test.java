

import cn.bdqn.poi.entity.Student;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by QiuShao on 2017/8/28.
 */
public class test {
    @Test
    public void aa() throws IOException {

        HSSFWorkbook wb=new HSSFWorkbook();

        HSSFSheet sheet = wb.createSheet("成绩表");

        HSSFRow row = sheet.createRow(0);

        HSSFCell cell=row.createCell(0);

        cell.setCellValue("学员考试成绩表");

        sheet.addMergedRegion(new CellRangeAddress(0,0,0,3));

        HSSFRow row1=sheet.createRow(1);

        row1.createCell(0).setCellValue("姓名");
        row1.createCell(1).setCellValue("班级");
        row1.createCell(2).setCellValue("笔试成绩");

        HSSFRow row2=sheet.createRow(2);

        row2.createCell(0).setCellValue("黎明");
        row2.createCell(1).setCellValue("s2");
        row2.createCell(2).setCellValue("100");

        FileOutputStream output=new FileOutputStream("f:\\workbook.xls");
        wb.write(output);
        output.flush();

    }


    @Test
    public void ss() throws IOException {
        HSSFWorkbook wb=new HSSFWorkbook();
        HSSFSheet sheet=wb.createSheet("成绩表");

        HSSFRow row1=sheet.createRow(0);

        HSSFCell cell1 = row1.createCell((short) 0);
        cell1.setCellValue("学生编号");
        cell1=row1.createCell( (short) 1);
        cell1.setCellValue("学生姓名");
        cell1 = row1.createCell((short) 2);
        cell1.setCellValue("学生性别");

        List<Student>list=new ArrayList<Student>();

        Student studnets=new Student();
        studnets.setId(1);
        studnets.setName("啊");
        Student studnet=new Student();
        studnet.setId(1);
        studnet.setName("啊啊");
        list.add(studnet);
        list.add(studnets);




        for (short i = 0; i < list.size(); i++) {
            row1 = sheet.createRow(i + 1);
            row1.createCell(0).setCellValue(list.get(i).getId());
            row1.createCell(1).setCellValue(list.get(i).getName());
        }
        FileOutputStream output=new FileOutputStream("f:\\workbooks.xls");
        wb.write(output);
        output.flush();

    }









}
