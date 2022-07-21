package com.herokuapp.service.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.domain.admin.AddSizeAdmin;
import com.herokuapp.domain.admin.SizeAdminDomain;
import com.herokuapp.domain.admin.list.ListSizeAdmin;
import com.herokuapp.entity.Size;
import com.herokuapp.reponsitory.SizeReponsitory;

@Service
public class SizeAdminServiceImpl implements SizeAdminService {

	@Autowired
	public SizeReponsitory sizeReponsitory;

	@Override
	public ListSizeAdmin getAllSize() {
		ListSizeAdmin listSizeAdmin = new ListSizeAdmin();
		List<SizeAdminDomain> sizeAdminDomains = new ArrayList<>();
		List<Size> sizes = sizeReponsitory.findAll();
		sizes.forEach(size -> {
			SizeAdminDomain sizeAdminDomain = new SizeAdminDomain();
			sizeAdminDomain.converToDomain(size);
			sizeAdminDomains.add(sizeAdminDomain);
		});
		listSizeAdmin.setSizes(sizeAdminDomains);
		return listSizeAdmin;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public StringBuilder addSize(AddSizeAdmin addSizeAdmin) throws NumberFormatException {
		StringBuilder message = new StringBuilder();
		for (String tensize : addSizeAdmin.getListSize()) {
			Integer.parseInt(tensize);
			Size size = sizeReponsitory.getSizeByTenSize(tensize);
			if (size == null) {
				Size sizeAdd = new Size();
				sizeAdd.setTensize(tensize);
				sizeReponsitory.save(sizeAdd);
				message.append("Thêm thành công size " + tensize + ", ");
			} else {
				message.append("size "+tensize + " tồn tại, ");
			}
		}
		return message;
	}

}
