package com.herokuapp.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.entity.NhanvienDonhang;
import com.herokuapp.entity.NhanvienDonhangPK;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface NhanVienDonHangReponsitory extends JpaRepository<NhanvienDonhang, NhanvienDonhangPK> {

	@Query(value = "Select * from nhanvien_donhang where madon = :madon", nativeQuery = true)
	List<NhanvienDonhang> getAllNhanVienDonhangByMaDon(@Param(value = "madon") String madon);
}
