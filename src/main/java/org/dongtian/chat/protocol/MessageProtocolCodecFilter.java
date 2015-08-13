package org.dongtian.chat.protocol;

import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

public class MessageProtocolCodecFilter extends ProtocolCodecFilter {

	public MessageProtocolCodecFilter(ProtocolEncoder encoder, ProtocolDecoder decoder) {
		super(encoder, decoder);
	}

}
