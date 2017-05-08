package com.snail.smart.utils;

import com.snail.smart.msg.ClientMsg;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author snail
 * @create 2017/04/24
 */
public class StringUtils {

    //md5加密
    public final static String md5(String s) {
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str).toLowerCase();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //to low integer
    public static byte[] getByte(String data){
        ByteArrayOutputStream boutput = new ByteArrayOutputStream();
        DataOutputStream doutput = new DataOutputStream(boutput);

        try{
            boutput.reset();
            doutput.write(FormatTransfer.toLH(data.length() + 8), 0, 4);        // 4 bytes packet length
            doutput.write(FormatTransfer.toLH(data.length() + 8), 0, 4);        // 4 bytes packet length
            doutput.write(FormatTransfer.toLH(ClientMsg.MSG_HEADER), 0, 2);   // 2 bytes message type
            doutput.writeByte(0);                                               // 1 bytes encrypt
            doutput.writeByte(0);                                               // 1 bytes reserve
            doutput.writeBytes(data);
        }catch(Exception e){
            e.printStackTrace();
        }

        return boutput.toByteArray();
    }

    //message escape
    public static String escape(String text){
        if(text==null)
            return "";

        return text.replaceAll("/","@S").replaceAll("@","@A");
    }

    //message unescape
    public static String unescape(String text){
        if(text==null)
            return "";

        return text.replaceAll("@S","/").replaceAll("@A","@");
    }

    public static boolean isEmpty(String text){
        return text==null || text.length()==0;
    }

    public static boolean isNotEmpty(String text){
        return text!=null && text.length()>0;
    }

    //unicode to utf
    public static String decodeUnicode(String str) {
        Charset set = Charset.forName("UTF-16");
        Pattern p = Pattern.compile("\\\\u([0-9a-fA-F]{4})");
        Matcher m = p.matcher( str );
        int start = 0 ;
        int start2 = 0 ;
        StringBuffer sb = new StringBuffer();
        while( m.find( start ) ) {
            start2 = m.start() ;
            if( start2 > start ){
                String seg = str.substring(start, start2) ;
                sb.append( seg );
            }
            String code = m.group( 1 );
            int i = Integer.valueOf( code , 16 );
            byte[] bb = new byte[ 4 ] ;
            bb[ 0 ] = (byte) ((i >> 8) & 0xFF );
            bb[ 1 ] = (byte) ( i & 0xFF ) ;
            ByteBuffer b = ByteBuffer.wrap(bb);
            sb.append( String.valueOf( set.decode(b) ).trim() );
            start = m.end() ;
        }
        start2 = str.length() ;
        if( start2 > start ){
            String seg = str.substring(start, start2) ;
            sb.append( seg );
        }
        return sb.toString() ;
    }
}
