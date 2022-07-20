package com.herokuapp.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.entity.Giay;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface GiayReponsitory extends JpaRepository<Giay, String> {

	// public List<Giay> getListBestSell(int sum);

	@Query(value = "Select g.* from Giay g ORDER BY g.ngaythem DESC LIMIT :amount", nativeQuery = true)
	public List<Giay> getListLatest(@Param("amount") int amount);

}
