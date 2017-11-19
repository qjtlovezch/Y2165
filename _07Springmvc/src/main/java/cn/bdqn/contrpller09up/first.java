package cn.bdqn.contrpller09up;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * Created by QiuShao on 2017/8/30.
 */
@Controller
public class first {
    @RequestMapping("/two")
    public String dofirst(@RequestParam MultipartFile[] upload, HttpSession session){
        for (MultipartFile item:upload){
            if (item.getSize()>0){
                String originalFilename = item.getOriginalFilename();

                if (originalFilename.endsWith("jpg")||originalFilename.endsWith("png")||originalFilename.endsWith("gif")){
                    String realPath = session.getServletContext().getRealPath("/upload");
                    File file=new File(realPath,originalFilename);
                    try {
                        item.transferTo(file);

                    } catch (IOException e) {
                        e.printStackTrace();
                        return "/upload.jsp";
                    }
                }else {

                    return "/upload.jsp";
                }

            }
          return "/upload.jsp";
        }
        return "/index.jsp";

    }
    @RequestMapping("/two2")
    public String dofirst2(MultipartFile upload, HttpSession session){
        if (upload.getSize()>0){
            String originalFilename = upload.getOriginalFilename();

            if (originalFilename.endsWith("jpg")||originalFilename.endsWith("png")||originalFilename.endsWith("gif")){
                String realPath = session.getServletContext().getRealPath("/upload");
                File file=new File(realPath,originalFilename);
                try {
                    upload.transferTo(file);
                    return "/index.jsp";
                } catch (IOException e) {
                    e.printStackTrace();
                    return "/upload.jsp";
                }
            }else {

                return "/upload.jsp";
            }

        }
           return "/upload.jsp";

    }
}
