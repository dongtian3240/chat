package org.dongtian.chat.protocol;

import java.nio.ByteBuffer;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.dongtian.chat.message.MessagePacket;

/**
 * 消息编码
 * @author gaoyuandong
 * @mailto 466862016@qq.com
 * @date   2015年8月13日 下午2:41:33
 */
public class MessageEncoder extends ProtocolEncoderAdapter {

	/* (non-Javadoc)
	 * @see org.apache.mina.filter.codec.ProtocolEncoder#encode(org.apache.mina.core.session.IoSession, java.lang.Object, org.apache.mina.filter.codec.ProtocolEncoderOutput)
	 */
	public void encode(IoSession session, Object message, ProtocolEncoderOutput out) throws Exception {
		
		MessagePacket messagePacket = null;
		if (message instanceof MessagePacket) {
			messagePacket = (MessagePacket) message;
			IoBuffer buffer = IoBuffer.allocate(((MessagePacket) message).getMessageBodySize() + MessagePacket.MESSAGE_HEAD_CONTENT_LENGTH + MessagePacket.MESSAGE_TYPE_LENGTH);
			buffer.setAutoExpand(true);
			buffer.putInt(messagePacket.getMessageBodySize());
			buffer.putInt(messagePacket.getMessageType());
			buffer.put(messagePacket.getMessageBodyContent());
			buffer.flip();
			out.write(buffer);
		}
	}

}
