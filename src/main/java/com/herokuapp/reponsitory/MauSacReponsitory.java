package com.herokuapp.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.entity.Mausac;
import com.herokuapp.entity.Size;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface MauSacReponsitory extends JpaRepository<Mausac, String> {
	
	String QUERY_GET_SIZE_BY_IDGIAY_IDSIZE = " Select ms.* from mausac ms join giay_mau_size gms"
			+ " on ms.mamau =  gms.mamau "
			+ " where  gms.magiay = :idGiay and gms.masize = :idSize ";
	
	@Query(value = QUERY_GET_SIZE_BY_IDGIAY_IDSIZE, nativeQuery = true)
	public List<Mausac> getMauSacByIdGiayAndIdSize(@Param("idGiay") String idGiay, @Param("idSize") String idSize);
	
}
