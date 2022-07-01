package com.herokuapp.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.herokuapp.entity.Loaigiay;

@Repository
@Transactional(rollbackFor = Exception.class)
public interface LoaiGiayReponsitory extends JpaRepository<Loaigiay, String> {

}
