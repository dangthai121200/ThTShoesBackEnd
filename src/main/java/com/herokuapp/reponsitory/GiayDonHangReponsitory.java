package com.herokuapp.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.entity.GiayDonhang;
import com.herokuapp.entity.GiayDonhangPK;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface GiayDonHangReponsitory extends JpaRepository<GiayDonhang, GiayDonhangPK> {
	
	
	@Query(value = "select * from giay_donhang where madon= :madonhang", nativeQuery = true)
	List<GiayDonhang> getAllGiayDonHangByIdDonHang(@Param("madonhang") String madonhang);
}
