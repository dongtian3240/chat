package org.dongtian.chat.request;

import org.dongtian.chat.message.MessagePacket;

/***
 * 请求分发
 * @author gaoyuandong
 * @mailto 466862016@qq.com
 * @date   2015年8月13日 下午2:53:58
 */
public interface RequestDispatcher {

	/***
	 * 请求分发
	 * @param messagePacket 请求的消息
	 */
	void dispatcher(MessagePacket messagePacket);
	
}
