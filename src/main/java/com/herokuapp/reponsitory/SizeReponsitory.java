package com.herokuapp.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.entity.Size;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface SizeReponsitory extends JpaRepository<Size, String> {

	@Query(value = "select * from size where tensize = :tensize", nativeQuery = true)
	Size getSizeByTenSize(String tensize);
}
