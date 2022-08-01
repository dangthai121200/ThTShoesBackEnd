package com.herokuapp.reponsitory;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.entity.Phukien;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface PhuKienReponsitory extends JpaRepository<Phukien, String> {

	@Query(value = "Select pk.* from Phukien pk ORDER BY pk.mapk DESC LIMIT :amount", nativeQuery = true)
	public List<Phukien> getListLatest(@Param("amount") int amount);

	@Modifying(clearAutomatically = true)
	@Query(value = "Update phukien set urlanh = :urlanh where mapk = :mapk ", nativeQuery = true)
	public void setAvatar(@Param("urlanh") String urlanh, @Param("mapk") String mapk);

	List<Phukien> findByngaythemBetween(Date ngaybd, Date ngaykt);

}
