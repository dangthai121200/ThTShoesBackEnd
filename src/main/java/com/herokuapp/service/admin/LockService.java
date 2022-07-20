package com.herokuapp.service.admin;

import com.herokuapp.lockdata.Lock;

public interface LockService {
	void lock(String nameTable, Lock lock);

	Lock checkLock(String nameTable, String idRecord, String username);

	void unLock(String nameTable, String idRecord, String username);
}
