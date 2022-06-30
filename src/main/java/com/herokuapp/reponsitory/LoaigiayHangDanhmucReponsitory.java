package com.herokuapp.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.entity.LoaigiayHangDanhmuc;
import com.herokuapp.entity.LoaigiayHangDanhmucPK;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface LoaigiayHangDanhmucReponsitory extends JpaRepository<LoaigiayHangDanhmuc, LoaigiayHangDanhmucPK> {

	@Query(value = "Select lghd.* from loaigiay_hang_danhmuc lghd where lghd.ma_lgiay_hang= :maLgiayHang", nativeQuery = true)
	LoaigiayHangDanhmuc findByMaLgiayHang(@Param("maLgiayHang") int maLgiayHang);

}
