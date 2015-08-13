package org.dongtian.chat.protocol;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

/**
 * 
 * @author gaoyuandong
 * @mailto 466862016@qq.com
 * @date   2015年8月13日 下午4:27:20
 */
public class MessageProtocolCodecFactory implements ProtocolCodecFactory {

	private MessageDecoder decoder;
	private MessageEncoder encoder;
	
	
	public MessageProtocolCodecFactory() {
		
		this.decoder = new MessageDecoder();
		this.encoder = new MessageEncoder();
	}

	public ProtocolEncoder getEncoder(IoSession session) throws Exception {
		return encoder;
	}

	public ProtocolDecoder getDecoder(IoSession session) throws Exception {
		return decoder;
	}

}
