package com.herokuapp.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.entity.Giayseq;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface GiaySeqReponsitory extends JpaRepository<Giayseq, Integer> {
	
	@Query(value = "SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = 'giayseq' and table_schema = database()", nativeQuery = true)
	int getIdNext();
}
