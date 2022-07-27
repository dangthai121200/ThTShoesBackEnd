package com.herokuapp.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.entity.GiayMauSize;
import com.herokuapp.entity.GiayMauSizePK;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface GiaySizeMauReponsitory extends JpaRepository<GiayMauSize, GiayMauSizePK> {

	@Query(value = "select soluong from giay_mau_size where magiay = :idGiay and masize = :idSize and mamau = :idMau", nativeQuery = true)
	int getSoLuongByIdGiayIdSizeIdMau(@Param(value = "idGiay") String idGiay, @Param(value = "idSize") String idSize,
			@Param(value = "idMau") String idMau);
	
	@Query(value = "select id from giay_mau_size where magiay = :idGiay and masize = :idSize and mamau = :idMau", nativeQuery = true)
	String getIdByIdGiayIdSizeIdMau(@Param(value = "idGiay") String idGiay, @Param(value = "idSize") String idSize,
			@Param(value = "idMau") String idMau);
	
	
	@Query(value = "select * from giay_mau_size where id = :id", nativeQuery = true)
	GiayMauSize getGiayMauSizeById(@Param(value = "id") String idGiayMauSize);
	
	@Query(value = "select * from giay_mau_size where magiay = :magiay", nativeQuery = true)
	List<GiayMauSize> getGiayMauSizeByMaGiay(@Param(value = "magiay") String idGiayMauSize);
	
	@Query(value = "SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = 'giay_mau_size' and table_schema = database()", nativeQuery = true)
	int getIdNext();
	

}
