package com.herokuapp.reponsitory;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.entity.Giay;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface GiayReponsitory extends JpaRepository<Giay, String> {

	String GIAY_BEST_SELL = " SELECT g.*, dh.tinhtrang, sum( gdh.soluong) as tongban FROM  giay g "
			+ " JOIN giay_mau_size gms ON g.magiay = gms.magiay "
			+ " JOIN giay_donhang gdh ON gdh.id_giay_mau_size = gms.id " + " JOIN donhang dh ON gdh.madon = dh.madon "
			+ " WHERE dh.tinhtrang = 'DAGIAO' " + " GROUP BY g.magiay " + " ORDER BY tongban DESC " + " LIMIT :amount ";

	@Query(value = GIAY_BEST_SELL, nativeQuery = true)
	public List<Giay> getListBestSell(@Param("amount") int amount);

	@Query(value = "Select g.* from Giay g ORDER BY g.ngaythem DESC LIMIT :amount", nativeQuery = true)
	public List<Giay> getListLatest(@Param("amount") int amount);

	@Modifying(clearAutomatically = true)
	@Query(value = "Update giay set urlanh = :urlanh where magiay = :magiay ", nativeQuery = true)
	public void setAvatar(@Param("urlanh") String urlanh, @Param("magiay") String magiay);

	List<Giay> findByngaythemBetween(Date ngaybd, Date ngaykt);
}
