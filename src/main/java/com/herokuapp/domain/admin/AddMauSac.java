package com.herokuapp.domain.admin;

import java.util.HashSet;
import java.util.Set;

public class AddMauSac {
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
