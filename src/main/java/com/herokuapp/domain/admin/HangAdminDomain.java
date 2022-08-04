package com.herokuapp.domain.admin;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.herokuapp.abstracts.AbstractsDomain;
import com.herokuapp.entity.Hang;
import com.herokuapp.util.ThtShoesMess;

public class HangAdminDomain extends AbstractsDomain<Hang> {

	private String mahang;
	
	@Length(max = 50, message = ThtShoesMess.MAX_LENGHT + "của tenhang là 50")
	private String tenhang;

	public HangAdminDomain() {
		super();

	}

	public String getMahang() {
		return mahang;
	}

	public void setMahang(String mahang) {
		this.mahang = mahang;
	}

	public String getTenhang() {
		return tenhang;
	}

	public void setTenhang(String tenhang) {
		this.tenhang = tenhang;
	}

	@Override
	public void converToDomain(Hang hang) {
		this.mahang = hang.getMahang();
		this.tenhang = hang.getTenhang();
	}

	@Override
	public Hang converToEntity() {
		// TODO Auto-generated method stub
		return null;
	}

}
