package com.herokuapp.domain.admin;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotEmpty.List;
import javax.validation.constraints.NotNull;

public class AddMauSac {

	@NotNull
	@List(value = @NotEmpty)
	private Set<String> mausacs = new HashSet<>();

	public AddMauSac() {

	}

	public Set<String> getMausacs() {
		return mausacs;
	}

	public void setMausacs(Set<String> mausacs) {
		this.mausacs = mausacs;
	}

}
