package com.herokuapp.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.entity.PhukienDonhang;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface PhukienDonhangReponsitory extends JpaRepository<PhukienDonhang, String> {

	@Query(value = "Select count(*) from phukien_donhang where mapk = :mapk", nativeQuery = true)
	int countPhuKienByIdPk(@Param("mapk") String mapk);
}
