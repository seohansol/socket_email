package com.kh.test.common.socket;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebSocketChattingServer extends TextWebSocketHandler {
	// 사용자 저장
	private Set<WebSocketSession> users = new CopyOnWriteArraySet();
	
	
	// 사용자 접속
	@Override
	public void afterConnectionEstablished(WebSocketSession session) {
		users.add(session);
		System.out.println("사용자 접속! 현재 접속자" + users.size() + "명 입니다!");
	}
	
	
	// 메시지
	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
			
		TextMessage newMessage = new TextMessage((CharSequence)message.getPayload());
		
		// 접속한 사용자를 알 수 없으므로, 저장소에 있는 만큼 반복해서 메시지 전송
		for(WebSocketSession ws : users) {
			ws.sendMessage(newMessage);
		}
	}
	
	
	// 사용자 종료
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
		users.remove(session);
		System.out.println("사용자 접속 종료! 현재 접속자 " + users.size() + "명 입니다.");
	}
	
}
