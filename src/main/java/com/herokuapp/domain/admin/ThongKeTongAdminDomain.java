package com.herokuapp.domain.admin;

public class ThongKeTongAdminDomain {
	public String tongDoanhThu;
	public String tongDonHangChuaDuyet;
	public String tongDonHangDaGiao;
	public String tongDonTuChoi;
	public String tongSoKhachHang;

	public ThongKeTongAdminDomain() {

	}

	public ThongKeTongAdminDomain(String tongDoanhThu, String tongDonHangChuaDuyet, String tongDonHangDaGiao,
			String tongDonTuChoi, String tongSoKhachHang) {
		super();
		this.tongDoanhThu = tongDoanhThu;
		this.tongDonHangChuaDuyet = tongDonHangChuaDuyet;
		this.tongDonHangDaGiao = tongDonHangDaGiao;
		this.tongDonTuChoi = tongDonTuChoi;
		this.tongSoKhachHang = tongSoKhachHang;
	}

	public String getTongDoanhThu() {
		return tongDoanhThu;
	}

	public void setTongDoanhThu(String tongDoanhThu) {
		this.tongDoanhThu = tongDoanhThu;
	}

	public String getTongDonHangChuaDuyet() {
		return tongDonHangChuaDuyet;
	}

	public void setTongDonHangChuaDuyet(String tongDonHangChuaDuyet) {
		this.tongDonHangChuaDuyet = tongDonHangChuaDuyet;
	}

	public String getTongDonHangDaGiao() {
		return tongDonHangDaGiao;
	}

	public void setTongDonHangDaGiao(String tongDonHangDaGiao) {
		this.tongDonHangDaGiao = tongDonHangDaGiao;
	}

	public String getTongDonTuChoi() {
		return tongDonTuChoi;
	}

	public void setTongDonTuChoi(String tongDonTuChoi) {
		this.tongDonTuChoi = tongDonTuChoi;
	}

	public String getTongSoKhachHang() {
		return tongSoKhachHang;
	}

	public void setTongSoKhachHang(String tongSoKhachHang) {
		this.tongSoKhachHang = tongSoKhachHang;
	}

}
