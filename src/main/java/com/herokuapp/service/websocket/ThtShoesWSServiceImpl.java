package com.herokuapp.service.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.herokuapp.util.URL;

@Service
public class ThtShoesWSServiceImpl implements ThtShoesWSService {

	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;

	@Override
	public void guiTongBaoCoDonHangMoi(String message) {
		simpMessagingTemplate.convertAndSend(URL.THTSHOES_APP + URL.THONGBAO, message);
	}

}