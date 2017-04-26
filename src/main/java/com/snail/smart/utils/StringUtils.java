package com.snail.smart.utils;

import com.snail.smart.msg.ClientMsg;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author snail
 * @create 2017/04/24
 */
public class StringUtils {

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
