package org.dongtian.chat.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.dongtian.chat.utils.DataTypeUtils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


public class MyTest {

	
	
	public static void main(String[] args) throws Exception {
		BASE64Encoder base64Encoder = new BASE64Encoder();
		int a = 1002;
		String str = base64Encoder.encode(DataTypeUtils.int2Bytes(a));
		System.err.println(str);
		BASE64Decoder base64Decoder = new BASE64Decoder();
		 byte[] buf = base64Decoder.decodeBuffer(str);
		 int dat = DataTypeUtils.bytes2Int(buf);
		 System.err.println(dat);
	}
}
