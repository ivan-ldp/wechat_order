package com.kgc.wechatorder.mall.tools;



import java.util.Calendar;
import java.util.Date;

public class utils {
    public class addOrderNumber{
        Calendar calendar=Calendar.getInstance();
        String i = String.valueOf(calendar.get(Calendar.YEAR));
        String i1 = String.valueOf(calendar.get(Calendar.MONTH)+1);
        String i2 = String.valueOf(calendar.get(Calendar.DATE));
        String i3 = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
        String i4 = String.valueOf(calendar.get(Calendar.MINUTE));
        String i5 = String.valueOf(calendar.get(Calendar.SECOND));

        //获取年月日的数据
        String i6= i+i1+i2+i3+i4+i5;

        //获取当前时间戳
        String time = String.valueOf(new Date().getTime());

        //当前年月日+时间戳
        String i7=i6+time;
        //再加上4位随机数
        int i8=(int) (Math.random()*10000);
        String s1 = String.valueOf(i8);
        StringBuffer s=new StringBuffer(i7);
        StringBuffer append = s.append(s1);


    }




}
