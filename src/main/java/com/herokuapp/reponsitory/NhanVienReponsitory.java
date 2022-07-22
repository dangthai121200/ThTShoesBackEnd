package com.herokuapp.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.entity.Nhanvien;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface NhanVienReponsitory extends JpaRepository<Nhanvien, String> {

	@Query(value = "Select * from nhanvien where sdt = :sdt", nativeQuery = true)
	Nhanvien getNhanVienBySdt(Long sdt);
}
