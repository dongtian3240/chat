package org.dongtian.chat.request;

import org.dongtian.chat.constant.MessageTypeConstant;
import org.dongtian.chat.message.MessagePacket;

/**
 * 默认请求分发器
 * @author gaoyuandong
 * @mailto 466862016@qq.com
 * @date   2015年8月13日 下午2:56:46
 */
public class DefaultRequestDispatcher implements RequestDispatcher {

	/* 
	 * 请求分发默认处理逻辑
	 * @see org.dongtian.chat.request.RequestDispatcher#dispatcher(org.dongtian.chat.message.MessagePacket)
	 */
	public void dispatcher(MessagePacket messagePacket) {
		
		switch (messagePacket.getMessageType()) {
		
		case MessageTypeConstant.MESSAGE_TYPE_KEEP_ALIVE:
			
			break;
		case MessageTypeConstant.MESSAGE_TYPE_LOGIN:
			
			break;
			
		}
	}

}
