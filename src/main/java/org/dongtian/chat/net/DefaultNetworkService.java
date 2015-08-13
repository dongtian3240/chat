package org.dongtian.chat.net;

import java.net.InetSocketAddress;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.mina.core.session.IoSession;
import org.dongtian.chat.entity.ClientUser;
import org.dongtian.chat.exception.NoIpException;


/**
 * @author gaoyuandong
 * @mailto 466862016@qq.com
 * @date   2015年8月13日 下午3:25:09
 */
public final  class DefaultNetworkService implements NetworkService {

	private ConcurrentHashMap<String, ClientUser> clientUsers = new ConcurrentHashMap<String, ClientUser>();
	
	/***
	 * 获取唯一的一个key
	 * @param ioSession
	 * @return
	 * @throws NoIpException
	 */
	public static String getIoSessionKey(IoSession ioSession) throws NoIpException  {
		// System.err.println("1.2  " + (ioSession.getRemoteAddress() == null));
		if (ioSession.getRemoteAddress() == null)
			throw new NoIpException();
		
		return ((InetSocketAddress) ioSession.getRemoteAddress()).getAddress().toString() + ":"
				+ ((InetSocketAddress) ioSession.getRemoteAddress()).getPort();
	}

	
	public void addClientUser(IoSession session) throws NoIpException {
		
		if (clientUsers.get(getIoSessionKey(session)) != null) {
			return ;
		}
		ClientUser clientUser = new ClientUser();
		clientUser.setIoSession(session);
		clientUser.setOnline(true);
		clientUsers.put(getIoSessionKey(session), clientUser);
	}


	public void removeClientUser(IoSession session) throws NoIpException {
		String ioSessionKey = getIoSessionKey(session);
		if (ioSessionKey != null && !"".equals(ioSessionKey)) {
			clientUsers.remove(ioSessionKey);
		}
	}
	
}
