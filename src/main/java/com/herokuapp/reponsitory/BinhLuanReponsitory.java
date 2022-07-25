package com.herokuapp.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.entity.Binhluan;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface BinhLuanReponsitory extends JpaRepository<Binhluan, String> {

	@Query(value = "Select * from binhluan where magiay = :magiay", nativeQuery = true)
	List<Binhluan> getAllBinhLuanByIdGiay(String magiay);
}
