package com.herokuapp.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.entity.Danhmuc;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface DanhMucReponsitory extends JpaRepository<Danhmuc, String> {
	
	@Query(value = "Select * from danhmuc where tendanhmuc = :tendanhmuc", nativeQuery = true)
	Danhmuc getDanhMucByTen(String tendanhmuc);

}
