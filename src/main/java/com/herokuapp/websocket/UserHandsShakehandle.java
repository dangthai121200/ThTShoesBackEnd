package com.herokuapp.websocket;

import java.security.Principal;
import java.util.Map;
import java.util.UUID;

import org.apache.http.auth.BasicUserPrincipal;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

public class UserHandsShakehandle extends DefaultHandshakeHandler {

	@Override
	protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler,
			Map<String, Object> attributes) {
		String randomId = UUID.randomUUID().toString();
		return new BasicUserPrincipal(randomId);
	}

}
