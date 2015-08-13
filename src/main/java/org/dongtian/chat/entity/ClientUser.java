package org.dongtian.chat.entity;

import org.apache.mina.core.session.IoSession;

public class ClientUser {

	private String userId;
	private IoSession ioSession;
	private boolean online = true;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public IoSession getIoSession() {
		return ioSession;
	}
	public void setIoSession(IoSession ioSession) {
		this.ioSession = ioSession;
	}
	public boolean isOnline() {
		return online;
	}
	public void setOnline(boolean online) {
		this.online = online;
	}
	
	
}
