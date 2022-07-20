package com.herokuapp.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.herokuapp.lockdata.Lock;
import com.herokuapp.lockdata.LockReponsitory;

@Service
public class LockServiceImpl implements LockService {

	@Autowired
	public LockReponsitory lockReponsitory;

	@Override
	public void lock(String nameTable, Lock lock) {
		lockReponsitory.lock(nameTable, lock);
	}

	@Override
	public Lock checkLock(String nameTable, String idRecord, String username) {
		return lockReponsitory.checkLock(nameTable, idRecord, username);
	}

	@Override
	public void unLock(String nameTable, String idRecord, String username) {
		lockReponsitory.unLock(nameTable, idRecord, username);
	}

}
