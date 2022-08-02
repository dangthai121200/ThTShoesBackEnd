package com.herokuapp.controller.khachhang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.herokuapp.service.khachhang.DangKyService;
import com.herokuapp.util.PrefixId;
import com.herokuapp.util.URL;

@Controller
@RequestMapping(URL.KHACH_HANG)
public class XacThucKhachHangController {

	@Autowired
	private DangKyService dangKyService;

	@RequestMapping(value = URL.DANG_KY + "/{manguoidung}", method = RequestMethod.GET)
	public ModelAndView authencationTaiKhoan(@PathVariable(name = "manguoidung") String manguoidung) {
		ModelAndView modelAndView = new ModelAndView("xacthuc.jsp");
		try {
			if (manguoidung.contains(PrefixId.KHACHHANG)) {
				dangKyService.authencationTaiKhoan(manguoidung);
				modelAndView.addObject("lableSuccess", "KÍCH HOẠT TÀI KHOẢN THÀNH CÔNG");
				return modelAndView;
			} else {
				modelAndView.addObject("lableError", "KHÔNG CÓ QUYỀN TRUY CẬP");
				return modelAndView;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			modelAndView.addObject("lableError", "KÍCH HOẠT TÀI KHOẢN THẤT BẠI");
			return modelAndView;
		}

	}
}
