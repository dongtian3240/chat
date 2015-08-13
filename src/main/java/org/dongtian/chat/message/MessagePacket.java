package org.dongtian.chat.message;

import org.apache.mina.core.session.IoSession;
/***
 * 消息格式
 * 1111          2222                3333333333.....
 * xxxx  代表消息头 消息类型 和消息体的大小 4字节 
 * 2222  代表消息类型  占4个字节
 * 3333......        消息内容不定长度
 * 
 * @author gaoyuandong
 * @mailto 466862016@qq.com
 * @date   2015年8月12日 下午6:31:02
 */
public class MessagePacket {
	
	//消息头长度 4个字节
	public static final int MESSAGE_HEAD_CONTENT_LENGTH = 4;
	//消息类型长度  4个字节
	public static final int MESSAGE_TYPE_LENGTH = 4;
	
	public IoSession ioSession;
	//消息内容
	public byte[] messageBodyContent;
	
	public int messageType;
	
	public int getMessageBodySize() {
		return messageBodyContent.length;
	}

	public MessagePacket(IoSession ioSession, byte[] messageBodyContent) {
		super();
		this.ioSession = ioSession;
		this.messageBodyContent = messageBodyContent;
	}

	public MessagePacket(IoSession ioSession, byte[] messageBodyContent, int messageType) {
		super();
		this.ioSession = ioSession;
		this.messageBodyContent = messageBodyContent;
		this.messageType = messageType;
	}

	public MessagePacket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getMessageType() {
		return messageType;
	}

	public void setMessageType(int messageType) {
		this.messageType = messageType;
	}

	public byte[] getMessageBodyContent() {
		return messageBodyContent;
	}

	public void setMessageBodyContent(byte[] messageBodyContent) {
		this.messageBodyContent = messageBodyContent;
	}
	
	
	
}
