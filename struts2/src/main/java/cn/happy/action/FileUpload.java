package cn.happy.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUpload extends ActionSupport {

    public String upload() throws IOException {
        byte[] bytes=new byte[1204];
        FileInputStream fis;
        fis = new FileInputStream(getUpload());
        FileOutputStream fos=new FileOutputStream(getPath()+"\\"+getFileFileName());
        int length=fis.read(bytes);
        while (length>0){
            fos.write(bytes,0,length);
            length=fis.read(bytes);
        }
        fos.flush();
        fos.close();
        fis.close();

        return SUCCESS;
    }
    private String path;

    //file并不是指前端jsp上传过来的文件本身，而是文件上传过来存放在临时文件夹下面的文件
    private File upload;

    //提交过来的file的名字     FileName固定语法
    private String fileFileName;

    //提交过来的file的类型     ContentType固定语法
    private String fileContentType;

    public String getPath() {
        return ServletActionContext.getServletContext().getRealPath(path);
    }

    public void setPath(String path) {
        this.path = path;
    }

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

   /* @Override
    public String execute() throws Exception
    {
        byte[] bytes=new byte[1204];
        FileInputStream fis=new FileInputStream(getUpload());
        FileOutputStream fos=new FileOutputStream(getPath()+"\\"+getFileFileName());
        int length=fis.read(bytes);
        while (length>0){
            fos.write(bytes,0,length);
            length=fis.read(bytes);
        }
        fos.flush();
        fos.close();
        fis.close();

        return SUCCESS;
    }*/
}
