package com.herokuapp.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.entity.Phukien;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface PhuKienReponsitory extends CrudRepository<Phukien, String> {

	@Query(value = "Select pk.* from Phukien pk ORDER BY pk.mapk DESC LIMIT :amount", nativeQuery = true)
	public List<Phukien> getListLatest(@Param("amount") int amount);
}
