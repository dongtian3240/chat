package org.dongtian.chat.utils;

import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 数据类型之间的转换
 * @author gaoyuandong
 * @mailto 466862016@qq.com
 * @date   2015年8月12日 下午6:41:35
 */
public class DataTypeUtils {

	
	
	
	/***
	 * 整型转换成字节数组
	 * @param dat
	 * @return
	 */
	public static  byte[] int2Bytes(int dat) {
		
		byte[] byteNum = new byte[4];  
		
        for (int ix = 0; ix < 4; ++ix) {  
            int offset = 32 - (ix + 1) * 8;  
            byteNum[ix] = (byte) ((dat >> offset) & 0xff);  
        }  
        return byteNum;  
	}
	
	
	/***
	 * 字节数组转成 整型
	 * @param byteNum
	 * @return
	 */
   public static int bytes2Int(byte[] byteNum) {  
        int num = 0;  
        for (int ix = 0; ix < 4; ++ix) {  
            num <<= 8;  
            num |= (byteNum[ix] & 0xff);  
        }  
        return num;  
    }  
	
   /***
    * 截取字节数组
    * @param bys 要截取的字符数组
    * @param start 截取的开始位置
    * @param end   截取的结束位置
    * @return
    */
   public static byte[] subByte(byte[] bys,int start,int end) {
	   
	   byte[] subBy = new byte[end - start];
	   System.arraycopy(bys, start, subBy, 0, end - start);
	   return subBy;
   }
   
   
   /***
    * 字节数组转成String
    * @param bys
    * @return
    */
   public static String bytes2String(byte[] bys) {
	   
	   BASE64Encoder encoder = new BASE64Encoder();
	   String result = encoder.encodeBuffer(bys);
	   return result;
   }
	   
	/***
	 * String 转字节数组
	 * @return
	 */
   public static byte[] String2Bytes(String dat) {
	   BASE64Decoder decoder = new BASE64Decoder();
	   try {
		return decoder.decodeBuffer(dat);
	} catch (IOException e) {
		e.printStackTrace();
	}
	   return null;
   }
}
