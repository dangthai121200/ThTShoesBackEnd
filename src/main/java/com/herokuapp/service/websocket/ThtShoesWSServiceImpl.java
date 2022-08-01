package com.herokuapp.service.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.herokuapp.domain.admin.ThongBaoAdminDomain;
import com.herokuapp.util.URL;

@Service
public class ThtShoesWSServiceImpl implements ThtShoesWSService {

	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;

	@Override
	public void guiTongBaoCoDonHangMoi(String tieude, String noidung) {
		ThongBaoAdminDomain thongBaoAdminDomain = new ThongBaoAdminDomain(tieude, noidung);
		simpMessagingTemplate.convertAndSend(URL.THONGBAO + URL.DON_HANG, thongBaoAdminDomain);
	}

}