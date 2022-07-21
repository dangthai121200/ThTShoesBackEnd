package com.herokuapp.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.entity.Hinh;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface HinhReponsitory extends JpaRepository<Hinh, String> {

	@Modifying
	@Query(value = "insert into hinh (duongdan, magiay) values (:duongdan, :magiay)", nativeQuery = true)
	public void insertHinhOfGiay(@Param(value = "duongdan") String duongdan, @Param(value = "magiay") String magiay);
}
