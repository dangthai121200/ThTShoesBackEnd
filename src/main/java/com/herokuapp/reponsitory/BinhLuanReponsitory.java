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

	String BINH_LUAN_OF_KHACHHANG = "Select bl.*, kh.* from binhluan bl " + "left join giay g on bl.magiay = g.magiay "
			+ "left join phukien pk on bl.mapk = pk.mapk " + " join khachhang kh on kh.makh = bl.makh "
			+ "where bl.makh is not null";

	@Query(value = "Select * from binhluan where magiay = :magiay", nativeQuery = true)
	List<Binhluan> getAllBinhLuanByIdGiay(String magiay);

	@Query(value = "Select * from binhluan where mapk = :maphukien", nativeQuery = true)
	List<Binhluan> getAllBinhLuanByIdPhuKien(String maphukien);

	@Query(value = BINH_LUAN_OF_KHACHHANG, nativeQuery = true)
	List<Binhluan> getAllBinhLuanOfKhachHang();
	
	List<Binhluan> findBykhachhangIsNotNull();
}
