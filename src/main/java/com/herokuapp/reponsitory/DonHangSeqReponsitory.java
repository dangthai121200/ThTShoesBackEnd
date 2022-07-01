package com.herokuapp.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.herokuapp.entity.Donhangseq;

public interface DonHangSeqReponsitory extends JpaRepository<Donhangseq, Integer> {

	@Query(value = "SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = 'donhangseq' and table_schema = database()", nativeQuery = true)
	int getIdNext();

}
