package com.herokuapp.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.entity.Khachhang;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface KhachHangReponsitory extends JpaRepository<Khachhang, String> {

	@Query("Select kh from Khachhang kh where kh.sdt = :sdt")
	Khachhang getKhachHangBySdt(@Param("sdt") String sdt);

}
