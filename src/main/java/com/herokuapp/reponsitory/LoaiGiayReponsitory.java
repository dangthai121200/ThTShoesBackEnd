package com.herokuapp.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.herokuapp.entity.Loaigiay;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface LoaiGiayReponsitory extends JpaRepository<Loaigiay, String> {

	@Query(value = "Select * from loaigiay where tenloai = :tenloai", nativeQuery = true)
	Loaigiay findByTenloai(@PathVariable(name = "tenloai") String tenloai);
}
