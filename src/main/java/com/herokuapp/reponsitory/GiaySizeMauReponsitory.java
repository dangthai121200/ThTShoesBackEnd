package com.herokuapp.reponsitory;

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

}
