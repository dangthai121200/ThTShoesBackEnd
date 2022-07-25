package com.herokuapp.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.herokuapp.entity.Hang;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface HangReponsitory extends JpaRepository<Hang, String> {

	@Query(value = "Select * from hang where tenhang = :tenhang", nativeQuery = true)
	Hang getHangByTenHang(@PathVariable(name = "tenhang") String tenhang);

}
