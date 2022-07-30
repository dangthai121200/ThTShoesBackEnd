package com.herokuapp.domain.khachhang;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Khachhang;
import com.herokuapp.util.ThtShoesMess;

public class KhachHangDomain extends AbstractsDomain<Khachhang> {

	private String makh;

	@NotEmpty(message = ThtShoesMess.DIACHI)
	private String diachi;

	@NotEmpty(message = ThtShoesMess.HO)
	@Length(max = 10, message = ThtShoesMess.MAX_LENGHT + "của họ là 10")
	private String ho;

	@NotEmpty(message = ThtShoesMess.TEN)
	@Length(max = 30, message = ThtShoesMess.MAX_LENGHT + "của tên là 30")
	private String ten;

	@NotEmpty(message = ThtShoesMess.SDT)
	@Length(min = 10, max = 10, message = ThtShoesMess.SDT_SAI)
	private String sdt;

	public KhachHangDomain() {
	}

	public String getMakh() {
		return makh;
	}

	public void setMakh(String makh) {
		this.makh = makh;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	@Override
	public void converToDomain(Khachhang khachhang) {
		this.makh = khachhang.getMakh();
		this.ho = khachhang.getHo();
		this.ten = khachhang.getTen();
		this.diachi = (String) khachhang.getDiachi();
		this.sdt = khachhang.getSdt();
	}

	@Override
	public Khachhang converToEntity() {
		Khachhang khachang = new Khachhang();
		khachang.setMakh(this.makh);
		khachang.setHo(this.ho);
		khachang.setTen(this.ten);
		khachang.setDiachi(this.diachi);
		khachang.setSdt(this.sdt);
		return khachang;
	}

}
