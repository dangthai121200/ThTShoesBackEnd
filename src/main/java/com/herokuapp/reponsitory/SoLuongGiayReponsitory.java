package com.herokuapp.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.entity.SoluongGiay;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface SoLuongGiayReponsitory extends JpaRepository<SoluongGiay, Integer> {

	List<SoluongGiay> findByidGiaySizeMau(int idGiaySizeMau);

	List<SoluongGiay> findByidGiaySizeMauIn(List<Integer> idGiayMauSizes);
}
