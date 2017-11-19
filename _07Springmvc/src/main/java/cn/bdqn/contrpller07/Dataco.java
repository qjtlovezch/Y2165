package cn.bdqn.contrpller07;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Created by QiuShao on 2017/8/27.
 */
public class Dataco implements Converter<String,Date>{
    public Date convert(String s) {
       // SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sd=new SimpleDateFormat(s);
        try {
            Date date = sd.parse(s);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private SimpleDateFormat getDate(String s){
        SimpleDateFormat sd=null;
        if(Pattern.matches("^\\d{4}-\\d{2}-\\d{2}$",s)){
            sd=new SimpleDateFormat("yyyy-MM-dd");
        }else if (Pattern.matches("^\\d{4}-\\d{2}-\\d{2}$",s)){
            sd=new SimpleDateFormat("yyyy/MM/dd");
        }else if (Pattern.matches("^\\d{4}-\\d{2}-\\d{2}$",s)){
            sd=new SimpleDateFormat("yyyyMMdd");
        }
        return sd;
    }
}
