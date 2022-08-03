package com.herokuapp.domain.admin;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotEmpty.List;
import javax.validation.constraints.NotNull;

public class AddSizeAdmin {
	
	@NotNull
	@List(@NotEmpty)
	private Set<String> listSize = new HashSet<>();

	public AddSizeAdmin() {

	}

	public Set<String> getListSize() {
		return listSize;
	}

	public void setListSize(Set<String> listSize) {
		this.listSize = listSize;
	}

}
