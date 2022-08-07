package com.herokuapp.reponsitory;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.entity.Donhang;
import com.herokuapp.util.SqlReport;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface DonHangReponsitory extends JpaRepository<Donhang, String> {

	@Modifying(clearAutomatically = true)
	@Query(value = "Update donhang set tinhtrang = :tinhtrang where madon = :madon ", nativeQuery = true)
	public void updateStatusForDonhang(@Param(value = "madon") String madonghang,
			@Param(value = "tinhtrang") String tinhtrang);

	@Query(value = "Select count(*) from donhang where makm = :makm", nativeQuery = true)
	int countKhuyenMaiInDonHang(@Param(value = "makm") String makm);

	@Query(value = "Select * from donhang where madon= :madon and makh = :makh", nativeQuery = true)
	Donhang findByMadhAndMakh(@Param(value = "madon") String madon, @Param(value = "makh") String makh);

	List<Donhang> findByngaytaoBetween(Date ngaybd, Date ngaykt);

	@Query(value = SqlReport.THONG_KE_DOANHTHU_BYDATE, nativeQuery = true)
	BigDecimal thongKeDoanhThuByDate(@Param(value = "tinhtrang") String tinhtrang, @Param(value = "ngaybd") Date ngaybd,
			@Param(value = "ngaykt") Date ngaykt);

	@Query(value = "SELECT sum(dh.tonggia) as doanhthu FROM donhang dh", nativeQuery = true)
	BigDecimal thongKeDoanhThuAll();

	@Query(value = "SELECT count(*) as tong FROM donhang dh WHERE dh.tinhtrang = :tinhtrang ", nativeQuery = true)
	int countDongHangByStatus(@Param(value = "tinhtrang") String tinhtrang);
}
