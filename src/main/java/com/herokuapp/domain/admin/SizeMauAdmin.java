package com.herokuapp.domain.admin;

import java.util.Objects;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.herokuapp.util.ThtShoesMess;

public class SizeMauAdmin {

	@NotEmpty(message = ThtShoesMess.MA_SIZE)
	@Length(max = 10, message = ThtShoesMess.MAX_LENGHT + "của masize là 10")
	private String masize;

	@NotEmpty(message = ThtShoesMess.MA_MAU)
	@Length(max = 10, message = ThtShoesMess.MAX_LENGHT + "của mamau là 10")
	private String mamau;

	@NotNull
	@Min(value = 0L, message = ThtShoesMess.MIN_NUMBER + "là 0")
	@Max(value = 99999999999L, message = ThtShoesMess.MAX_NUMBER + "là 99999999999")
	private int soluong;

	public String getMasize() {
		return masize;
	}

	public void setMasize(String masize) {
		this.masize = masize;
	}

	public String getMamau() {
		return mamau;
	}

	public void setMamau(String mamau) {
		this.mamau = mamau;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	@Override
	public int hashCode() {
		return Objects.hash(mamau, masize);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SizeMauAdmin other = (SizeMauAdmin) obj;
		return Objects.equals(mamau, other.mamau) && Objects.equals(masize, other.masize);
	}

}
