package org.dongtian.chat.protocol;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.dongtian.chat.message.MessagePacket;
import org.dongtian.chat.utils.DataTypeUtils;

/***
 * 接到客户端数据时进行解码
 * @author gaoyuandong
 * @mailto 466862016@qq.com
 * @date   2015年8月12日 下午6:15:16
 */
public class MessageDecoder extends CumulativeProtocolDecoder {

	@Override
	protected boolean doDecode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
		
		
		if (in.prefixedDataAvailable(MessagePacket.MESSAGE_HEAD_CONTENT_LENGTH, Integer.MAX_VALUE)) { //是否是消息头
			return false;
		} else {
			// 标记开始位置，如果一条消息没传输完成则返回到这个位置
			in.mark();
			byte[] messageHead = new byte[MessagePacket.MESSAGE_HEAD_CONTENT_LENGTH];
			in.get(messageHead);
			int len = DataTypeUtils.bytes2Int(messageHead);
			byte[] bys = new byte[len];
				in.get(bys);
				//获取消息类型
				byte[] messageType = new byte[MessagePacket.MESSAGE_TYPE_LENGTH];
				System.arraycopy(bys, 0, messageType, 0, MessagePacket.MESSAGE_TYPE_LENGTH);
				
				//获取消息体
				byte[] messageBody = new byte[len - MessagePacket.MESSAGE_TYPE_LENGTH];
				System.arraycopy(bys, MessagePacket.MESSAGE_TYPE_LENGTH, messageBody, 0, len - MessagePacket.MESSAGE_TYPE_LENGTH);
				//解码成功
				MessagePacket messagePacket = new MessagePacket(session,messageBody,DataTypeUtils.bytes2Int(messageType));
				out.write(messagePacket);
				return true;
		}
	}

}
