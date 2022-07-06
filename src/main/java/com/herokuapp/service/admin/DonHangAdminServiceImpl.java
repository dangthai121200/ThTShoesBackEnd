package com.herokuapp.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.enums.TinhTrang;
import com.herokuapp.reponsitory.DonHangReponsitory;

@Service
public class DonHangAdminServiceImpl implements DonHangAdminService {

	@Autowired
	public DonHangReponsitory donHangReponsitory;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateStatusForDonhang(String madonghang, TinhTrang tinhtrang) {
		donHangReponsitory.updateStatusForDonhang(madonghang, tinhtrang.getValue());
	}

}
