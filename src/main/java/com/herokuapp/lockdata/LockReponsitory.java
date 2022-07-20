package com.herokuapp.lockdata;

import java.util.HashSet;
import java.util.Map;

public interface LockReponsitory {

	Map<String, HashSet<Lock>> getListTable();

	void lock(String nameTable, Lock lock);

	Lock checkLock(String nameTable, String idRecord, String username);
	
	void unLock(String nameTable, String idRecord, String username);
	
	void refresh();
}
