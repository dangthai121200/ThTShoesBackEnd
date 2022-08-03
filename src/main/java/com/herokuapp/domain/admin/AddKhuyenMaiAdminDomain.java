package com.herokuapp.domain.admin;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.util.StringUtils;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Dskhuyenmai;
import com.herokuapp.util.ThtShoesMess;

public class AddKhuyenMaiAdminDomain extends AbstractsDomain<Dskhuyenmai> {

	@Length(max = 10, message = ThtShoesMess.MAX_LENGHT + "của makm là 10")
	private String makm;

	@NotNull(message = ThtShoesMess.GIAY_GIA)
	@Min(value = 0L, message = ThtShoesMess.MIN_NUMBER + "của soluong là 0")
	@Max(value = 99999999999L, message = ThtShoesMess.MAX_NUMBER + "của soluong là 99999999999")
	private int soluong;

	@NotEmpty(message = ThtShoesMess.KHUYEN_MAI_NGAY_BD)
	private Date ngaybd;

	private Date ngaykt;

	private String mota;

	@NotEmpty(message = ThtShoesMess.KHUYEN_MAI_GIA_TRI_GIAM)
	private int giatrigiam;

	@NotEmpty(message = ThtShoesMess.KHUYEN_MAI_TIEU_DE)
	@Length(max = 100, message = ThtShoesMess.MAX_LENGHT + "của tieude là 100")
	private String tieude;

	public AddKhuyenMaiAdminDomain() {

	}

	public String getMakm() {
		return makm;
	}

	public void setMakm(String makm) {
		this.makm = makm;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public Date getNgaybd() {
		return ngaybd;
	}

	public void setNgaybd(Date ngaybd) {
		this.ngaybd = ngaybd;
	}

	public Date getNgaykt() {
		return ngaykt;
	}

	public void setNgaykt(Date ngaykt) {
		this.ngaykt = ngaykt;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public int getGiatrigiam() {
		return giatrigiam;
	}

	public void setGiatrigiam(int giatrigiam) {
		this.giatrigiam = giatrigiam;
	}

	public String getTieude() {
		return tieude;
	}

	public void setTieude(String tieude) {
		this.tieude = tieude;
	}

	@Override
	public void converToDomain(Dskhuyenmai object) {
		// TODO Auto-generated method stub

	}

	@Override
	public Dskhuyenmai converToEntity() {
		Dskhuyenmai dskhuyenmai = new Dskhuyenmai();
		if (!StringUtils.isEmpty(this.makm)) {
			dskhuyenmai.setMakm(this.makm);
		}
		dskhuyenmai.setSoluong(this.soluong);
		dskhuyenmai.setNgaybd(this.ngaybd);
		if (this.ngaykt != null) {
			dskhuyenmai.setNgaykt(this.ngaykt);
		}
		dskhuyenmai.setMota(this.mota);
		dskhuyenmai.setGiatrigiam(this.giatrigiam);
		dskhuyenmai.setTieude(this.tieude);
		return dskhuyenmai;
	}

}
