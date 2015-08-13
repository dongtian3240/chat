package org.dongtian.chat.handler;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.dongtian.chat.entity.ClientUser;
import org.dongtian.chat.message.MessagePacket;
import org.dongtian.chat.net.NetworkService;
import org.dongtian.chat.request.RequestDispatcher;

/**
 * 
 * @author gaoyuandong
 * @mailto 466862016@qq.com
 * @date   2015年8月13日 下午3:05:07
 */
public class MessageHandler extends IoHandlerAdapter {

	//消息请求分发器
	private RequestDispatcher dispatcher;
	
	private NetworkService networkService;
	
	public MessageHandler(RequestDispatcher dispatcher,NetworkService networkService) {
		this.dispatcher = dispatcher;
		this.networkService = networkService;
	}

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.sessionCreated(session);
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		//TODO 已经创建  将当前用户添加到在线用户列表
		this.networkService.addClientUser(session);
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		// TODO Auto-generated method stub
		super.sessionClosed(session);
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		// TODO Auto-generated method stub
		super.sessionIdle(session, status);
	}

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		
		if (cause.toString().equals("java.io.IOException: 远程主机强迫关闭了一个现有的连接。")) {
			try {
				session.close();
			} catch (Exception e) {}
			return;
		}
	}

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		
		MessagePacket packet = (MessagePacket) message;
		dispatcher.dispatcher(packet);
	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		// TODO Auto-generated method stub
		super.messageSent(session, message);
	}
	
}
