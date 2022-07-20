package com.herokuapp.lockdata;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import com.herokuapp.util.Table;

@ApplicationScope
@Component
public class LockReponsitoryImpl implements LockReponsitory {

	private Map<String, HashSet<Lock>> listTable = new HashMap<>();

	public Map<String, HashSet<Lock>> getListTable() {
		return listTable;
	}

	public LockReponsitoryImpl() {
		listTable.put(Table.DON_HANG, new HashSet<Lock>());
	}

	@Override
	public void lock(String nameTable, Lock lock) {
		listTable.get(nameTable).add(lock);
	}

	@Override
	public Lock checkLock(String nameTable, String idRecord, String username) {
		for (Lock lock : listTable.get(nameTable)) {
			if (lock.getIdReCord().equals(idRecord) && !lock.getUsername().equals(username)) {
				return lock;
			}
		}
		return null;
	}

	@Override
	public void unLock(String nameTable, String idRecord, String username) {
		for (Lock lock : listTable.get(nameTable)) {
			if (lock.getIdReCord().equals(idRecord) && lock.getUsername().equals(username)) {
				listTable.get(nameTable).remove(lock);
				break;
			}
		}
	}
}
