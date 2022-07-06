package com.herokuapp.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.entity.Donhang;
import com.herokuapp.enums.TinhTrang;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface DonHangReponsitory extends JpaRepository<Donhang, String> {

	@Modifying(clearAutomatically = true)
	@Query(value = "Update donhang set tinhtrang = :tinhtrang where madon = :madon ", nativeQuery = true)
	public void updateStatusForDonhang(@Param(value = "madon") String madonghang,
			@Param(value = "tinhtrang") String tinhtrang);
}
