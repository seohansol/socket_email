package com.kh.test.common.socket;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebSocketServer extends TextWebSocketHandler {
	
	/**
	 * - 클라이언트가 웹 소켓 서버에 접속을 하면 호출되는 메소드
	 * - session : 접속한 사용자의 웹 소켓 정보(HttpSession과는 아무런 연관없음
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) {
		System.out.println("여보세요?");
		System.out.println(session);
		
	}
	
	/**
	  * - 클라이언트로부터 메시지 수신 시 호출되는 메소드
	 * - session : 사용자(실제 메시지를 전송한 친구)의 소켓정보(HttpSession과는 정말 정말 연관성이 없음!!)
	 * - message : [ payload : 실제 전송 Data, byteCount : 보낸 메시지 크기(Byte단위), last : 메시지 종료 여부 ]
	 */
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("수신!");
		System.out.println(session);
		System.out.println(message);
		
		// 여기에 조건식 걸어서 경매 판매 물품등등 나오게 해야함
		
		session.sendMessage(message); // 이게 메시지임 서로간에
	}
	
	/**
	 * - 클라이언트가 소켓서버로부터 접속을 종료 했을 때 호출되는 메소드
	 * - session : 접속되어있던 사용자의 세션정보(Http 노상관!!!)
	 * - status : 접속이 종료된 원인과 관련된 정보
	 */
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
		System.out.println("뿅!");
		System.out.println(session);
		System.out.println(status);
	}
}
