package com.kgc.wechatorder.tools;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created By Ivan_ldp@163.com on 2019/9/19 11:24
 * MD5加密工具类
 */
public class MD5Utils {
    /**
     * 对字符串进行MD5编码，生成32为md5码
     * @param inStr
     * @return
     */
    public static String mad5Encode(String inStr){
        MessageDigest md5=null;
        byte[] byteArray=null;
        try {
            md5=MessageDigest.getInstance("MD5");
            byteArray=inStr.getBytes("UTF-8");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue=new StringBuffer();
        for (int i=0;i<md5Bytes.length;i++){
            int val=((int)md5Bytes[i])&0xff;
            if (val<16){
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    /**
     * 对字符串进行MD5编码，返回32位字符串，第二种方法
     * @param inStr
     * @return
     */
    public static String string2MD5(String inStr){
        MessageDigest md5=null;
        try {
            md5=MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
        char[] charArray=inStr.toCharArray();
        byte[] byteArray=new byte[charArray.length];

        for (int i=0;i<charArray.length;i++)
            byteArray[i]=(byte) charArray[i];
        byte[] md5Bytes=md5.digest(byteArray);
        StringBuffer hexValue=new StringBuffer();
        for (int i=0;i<md5Bytes.length;i++){
            int val=((int)md5Bytes[i])&0xff;
            if (val<16){
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    /**
     * 加密解密算法 执行一次是加密，两次是解密
     * @param inStr
     * @return
     */
    public static String converMD5(String inStr){
        char[] a=inStr.toCharArray();
        for (int i=0;i<a.length;i++){
            a[i]=(char)(a[i] ^ 't');
        }
        String s=new String(a);
        return s;
    }
}
