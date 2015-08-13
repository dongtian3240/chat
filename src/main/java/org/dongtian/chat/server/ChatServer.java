package org.dongtian.chat.server;

import java.net.InetSocketAddress;

import org.apache.log4j.Logger;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.dongtian.chat.handler.MessageHandler;
import org.dongtian.chat.net.DefaultNetworkService;
import org.dongtian.chat.protocol.MessageProtocolCodecFactory;
import org.dongtian.chat.request.DefaultRequestDispatcher;

public class ChatServer {

	private static Logger logger = Logger.getLogger(ChatServer.class);
	
	public static void main(String[] args) throws Exception {
		logger.info("start init.....");
		NioSocketAcceptor acceptor = new NioSocketAcceptor();
		acceptor.getFilterChain().addLast("logger", new LoggingFilter());
		acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new MessageProtocolCodecFactory()));
		acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 3000);
		acceptor.getSessionConfig().setMaxReadBufferSize(4096);
		acceptor.getSessionConfig().setWriteTimeout(10000);
		acceptor.setHandler(new MessageHandler(new DefaultRequestDispatcher(), new DefaultNetworkService()));
		acceptor.bind(new InetSocketAddress("localhost", 9999));
	}
}
