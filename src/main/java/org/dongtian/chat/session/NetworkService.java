package org.dongtian.chat.session;

import org.apache.mina.core.session.IoSession;
import org.dongtian.chat.exception.NoIpException;

/**
 * @author gaoyuandong
 * @mailto 466862016@qq.com
 * @date   2015年8月13日 下午3:24:36
 */
public interface NetworkService {

	/**
	 * 添加用户到在线用户列表
	 * @param session
	 */
	void addClientUser(IoSession session) throws NoIpException;
	
}
